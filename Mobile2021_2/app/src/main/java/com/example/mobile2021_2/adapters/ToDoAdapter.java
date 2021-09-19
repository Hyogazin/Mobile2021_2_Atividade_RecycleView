package com.example.mobile2021_2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile2021_2.R;
import com.example.mobile2021_2.model.ToDo;

import java.util.List;


public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private List<ToDo> toDoList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }


    public ToDoAdapter(List<ToDo> todos) {
        this.toDoList = todos;
    }

    @NonNull
    @Override
    public ToDoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoAdapter.ViewHolder holder, int position) {
        ToDo todo = toDoList.get(position);
        TextView tv = holder.view.findViewById(R.id.tvTodoTitulo);
        tv.setText(todo.getTitle());
        tv = holder.view.findViewById(R.id.tvTodoIdUser);
        tv.setText(""+todo.getUser_id());
        tv= holder.view.findViewById(R.id.tvTodoCompleted);
        tv.setText(""+todo.isCompleted());
        tv= holder.view.findViewById(R.id.tvTodoId);
        tv.setText(""+todo.getId());

    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}