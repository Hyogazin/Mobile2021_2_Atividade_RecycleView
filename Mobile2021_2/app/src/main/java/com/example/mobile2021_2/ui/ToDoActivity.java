package com.example.mobile2021_2.ui;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mobile2021_2.R;
import com.example.mobile2021_2.adapters.ToDoAdapter;
import com.example.mobile2021_2.model.ToDo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class ToDoActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    private List<ToDo> toDoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        buscaJsons();

        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView rv = findViewById(R.id.rvTodos);
                ToDoAdapter adapter = new ToDoAdapter(toDoList);
                LinearLayoutManager llm =  new LinearLayoutManager(getApplicationContext());
                rv.setLayoutManager(llm);
                rv.setAdapter(adapter);
            }
        });


    }

    private void buscaJsons() {
        //Aqui começa o uso do Volley
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        //https://jsonplaceholder.typicode.com/todos

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos",null,
                this,this);
        queue.add(requisicao);
    }

    @Override
    public void onResponse(JSONArray response) {
        toDoList.clear();

        try {
            for (int x = 0; x <30; x++) {
                for (int i = 0; i < response.length(); i++) {
                    toDoList.add(new ToDo(response.getJSONObject(i)));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}