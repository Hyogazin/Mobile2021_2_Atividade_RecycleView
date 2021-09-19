package com.example.mobile2021_2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mobile2021_2.R;
import com.example.mobile2021_2.model.ToDo;


public class ToDoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        Intent intent =  getIntent();
        TextView tv = findViewById(R.id.tvId);
        ToDo todo = intent.getParcelableExtra("obj");
        tv.setText(""+todo.getId());
        tv = findViewById(R.id.tvTitulo);
        tv.setText(todo.getTitle());

    }
}