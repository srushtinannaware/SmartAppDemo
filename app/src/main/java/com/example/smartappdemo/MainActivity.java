package com.example.smartappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerviewid);


        titles = new ArrayList<>();
        images = new ArrayList<>();

        images.add(R.drawable.chair);
        images.add(R.drawable.bed);
        images.add(R.drawable.shower);
        images.add(R.drawable.sofa);


        titles.add("Living Room 1");
        titles.add("Bedroom");
        titles.add("Bathroom");
        titles.add("Living Room 2");

        adapter = new Adapter(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);

    }
}