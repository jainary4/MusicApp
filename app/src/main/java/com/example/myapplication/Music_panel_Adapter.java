package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Music_panel_Adapter extends RecyclerView.Adapter<Music_panel_Adapter.ViewHolder> {
 private Context context;
 private ArrayList<Songs> Music;
 Music_panel_Adapter(Context context, ArrayList<Songs> song){
     this.context= context;
     this.Music = song;
 }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView music_image;
        public TextView song_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            music_image = itemView.findViewById(R.id.image_container);
            song_name = itemView.findViewById(R.id.music_name);

        }
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.music_panel,parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.song_name.setText(Music.get(position).toString());
    }

    public int getItemCount() {
        return Music.size();
    }
}
