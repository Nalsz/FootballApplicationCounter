package com.example.android.footballapplicationcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.chelsea_score) TextView scoreA;
    @BindView(R.id.man_u_score) TextView scoreB;
    @BindView(R.id.chelsea_goal) Button chelsea;
    @BindView(R.id.manu_goal)  Button manu;
    @BindView(R.id.chelsea_yellow_card) ImageView yellowA;
    @BindView(R.id.chelsea_red_card) ImageView redA;
    @BindView(R.id.manu_yellow_card) ImageView yellowB;
    @BindView(R.id.manu_red_card) ImageView redB;
    @BindView(R.id.reset) Button reset;

    int goalA = 0;
    int goalB = 0;

    RecyclerView left_action, right_action;
    List<ActionsAdapter.Holder> Lholder = new ArrayList<>();
    List<ActionsAdapter.Holder> Rholder = new ArrayList<>();
    ActionsAdapter Ladapter = new ActionsAdapter(Lholder, this);
    ActionsAdapter Radapter = new ActionsAdapter(Rholder, this);
    ActionsAdapter.Holder left_holder;
    ActionsAdapter.Holder right_holder;

    public void addLeftAction(int type) {
        switch (type) {
            case 1:
                left_holder = new ActionsAdapter.Holder("Goal", R.drawable.football);
                Lholder.add(left_holder);
                left_action.setAdapter(Ladapter);
                left_action.setLayoutManager(new LinearLayoutManager(this));
                break;
            case 2:
                left_holder = new ActionsAdapter.Holder("Yellow Card", R.drawable.ic_yellowcard);
                Lholder.add(left_holder);
                left_action.setAdapter(Ladapter);
                left_action.setLayoutManager(new LinearLayoutManager(this));
                break;
            case 3:
                left_holder = new ActionsAdapter.Holder("Red Card", R.drawable.ic_redcard);
                Lholder.add(left_holder);
                left_action.setAdapter(Ladapter);
                left_action.setLayoutManager(new LinearLayoutManager(this));
                break;
        }
        /*if (Lholder.size() > 3) {
            Lholder.remove(1);
        }*/
    }

    public void addRightAction(int type) {
            switch (type) {
                case 1:
                    right_holder = new ActionsAdapter.Holder("Goal", R.drawable.football);
                    Rholder.add(right_holder);
                    right_action.setAdapter(Radapter);
                    right_action.setLayoutManager(new LinearLayoutManager(this));
                    break;
                case 2:
                    right_holder = new ActionsAdapter.Holder("Yellow Card", R.drawable.ic_yellowcard);
                    Rholder.add(right_holder);
                    right_action.setAdapter(Radapter);
                    right_action.setLayoutManager(new LinearLayoutManager(this));
                    break;
                case 3:
                    right_holder = new ActionsAdapter.Holder("Red Card", R.drawable.ic_redcard);
                    Rholder.add(right_holder);
                    right_action.setAdapter(Radapter);
                    right_action.setLayoutManager(new LinearLayoutManager(this));
                    break;
            }
        /*if (Rholder.size() > 3) {
            Rholder.remove(1);
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        left_action = findViewById(R.id.l_s);
        right_action = findViewById(R.id.r_s);

        chelsea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goalA += 1;
                scoreA.setText(String.valueOf(goalA));
                addLeftAction(1);
            }
        });

        manu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goalB += 1;
                scoreB.setText(String.valueOf(goalB));
                addRightAction(1);
            }
        });

        yellowA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLeftAction(2);

            }
        });

        redA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLeftAction(3);

            }
        });

        yellowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRightAction(2);
            }
        });

        redB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRightAction(3);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goalB = 0;
                goalA = 0;
                scoreB.setText(String.valueOf(goalB));
                scoreA.setText(String.valueOf(goalA));
                Rholder.clear();
                Lholder.clear();
                left_action.setAdapter(Ladapter);
                //left_action.setLayoutManager(new LinearLayoutManager(this));
                right_action.setAdapter(Radapter);
                //right_action.setLayoutManager(new LinearLayoutManager(this));
            }
        });
    }



}
