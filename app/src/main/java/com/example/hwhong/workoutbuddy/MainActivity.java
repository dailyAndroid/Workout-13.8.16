package com.example.hwhong.workoutbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText name, reps;
    private Button add, next;

    private ArrayList<String> nameList;
    private ArrayList<String> repsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameList = new ArrayList<>();
        repsList = new ArrayList<>();

        name = (EditText) findViewById(R.id.name);
        reps = (EditText) findViewById(R.id.rep);

        add = (Button) findViewById(R.id.addButton);
        next = (Button) findViewById(R.id.nextBut);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameList.add(name.getText().toString());
                repsList.add(reps.getText().toString());

                name.setText(" ");
                reps.setText(" ");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Display.class);

                intent.putStringArrayListExtra("name", nameList);
                intent.putStringArrayListExtra("reps", repsList);

                startActivity(intent);
            }
        });
    }
}
