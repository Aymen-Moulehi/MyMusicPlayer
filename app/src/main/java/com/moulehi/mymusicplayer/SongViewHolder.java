package com.moulehi.mymusicplayer;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongViewHolder extends RecyclerView.ViewHolder{
    TextView songName;
    TextView duration;
    public SongViewHolder(@NonNull View itemView, Activity activity, ArrayList<AudioModel> songs) {
        super(itemView);
        songName = itemView.findViewById(R.id.songName);
        duration = itemView.findViewById(R.id.duration);
    }

}
