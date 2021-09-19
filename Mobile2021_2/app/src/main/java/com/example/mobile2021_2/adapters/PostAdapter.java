package com.example.mobile2021_2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile2021_2.R;
import com.example.mobile2021_2.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> postList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }


    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Post post = postList.get(position);
        TextView tv = holder.view.findViewById(R.id.tvPostTitulo);
        tv.setText(post.getTitle());
        tv = holder.view.findViewById(R.id.tvPostUserId);
        tv.setText(""+post.getUser_id());
        tv = holder.view.findViewById(R.id.tvPostBody);
        tv.setText(""+post.getBody());
        tv = holder.view.findViewById(R.id.tvPostId);
        tv.setText(""+post.getId());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}