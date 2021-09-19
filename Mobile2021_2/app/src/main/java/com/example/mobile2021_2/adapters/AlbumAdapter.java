package com.example.mobile2021_2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile2021_2.R;
import com.example.mobile2021_2.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> albumList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }


    public AlbumAdapter(List<Album> albumList) {
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_layout, parent, false);
        return new AlbumAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        Album album = albumList.get(position);
        TextView tv = holder.view.findViewById(R.id.tvAlbumTitulo);
        tv.setText(album.getTitle());
        tv = holder.view.findViewById(R.id.tvAlbumIdUser);
        tv.setText(""+album.getUser_id());
        tv = holder.view.findViewById(R.id.tvAlbumId);
        tv.setText(""+album.getId());


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}