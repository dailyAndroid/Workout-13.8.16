package com.example.hwhong.workoutbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by hwhong on 8/13/16.
 */
public class Display extends AppCompatActivity {

    private ArrayList<String> workoutList;
    private ArrayList<String> repsList;

    private ArrayList<String> finalArray;

    private ListView listView;

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        Intent intent = getIntent();

        finalArray = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listView);

        workoutList = intent.getStringArrayListExtra("name");
        repsList = intent.getStringArrayListExtra("reps");

        for (int i = 0; i < workoutList.size(); i++) {
            finalArray.add(workoutList.get(i) + " with " + repsList.get(i) + " repetitions. ");
        }

        adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, finalArray);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                finalArray.remove(i);
                adapter.remove(i);

                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}
