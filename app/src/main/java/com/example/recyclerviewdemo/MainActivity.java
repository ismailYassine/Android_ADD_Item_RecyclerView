package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomDialog.OnClickListener {

    Button addPerson;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter customAdapter;
    ArrayList<Person> studentsList = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setSupportActionBar(findViewById(R.id.toolbar));

//        for(int i=1; i<=5; i++){
//            Person students = new Person("First name", "Last name");
//            studentsList.add(students);
//        }
       addPerson = findViewById(R.id.btnAddStudent);
        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment dialog = new CustomDialog();
                dialog.show(getSupportFragmentManager(), "CustomDialog");
            }
        });

        recyclerView = findViewById(R.id.myRView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        customAdapter = new CustomAdapter(studentsList, getResources().getDrawable(R.drawable.ic_profile));
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void addStudent(String firstName, String lastName){
        Person person = new Person(firstName, lastName);
        studentsList.add(0, person);
        customAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(String firstNAme, String lastName) {
        addStudent(firstNAme, lastName);

    }
}