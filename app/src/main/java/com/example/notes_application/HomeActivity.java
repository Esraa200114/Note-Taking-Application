package com.example.notes_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Calendar calender = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
        String dateTime = simpleDateFormat.format(calender.getTime());

        recyclerView = findViewById(R.id.main_recycler);

        ArrayList<Note>  Notes = new ArrayList();
        MyAdapter My_Adapter = new MyAdapter(Notes);

        Notes.add(new Note("Reading a book","Created: " + dateTime, R.id.delete_btn));
        Notes.add(new Note("Coding","Created: " + dateTime, R.id.delete_btn));
        Notes.add(new Note("Studying mathematics","Created: " + dateTime, R.id.delete_btn));
        Notes.add(new Note("Exercising outside","Created: " + dateTime, R.id.delete_btn));
        Notes.add(new Note("Playing chess","Created: " + dateTime, R.id.delete_btn));
        Notes.add(new Note("Travelling","Created: " + dateTime, R.id.delete_btn));

        recyclerView.setAdapter(My_Adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fbtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }
}