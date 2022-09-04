package com.moulehi.mymusicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongListAdapter extends RecyclerView.Adapter<SongViewHolder> {

    private ArrayList<AudioModel> songs;
    private TimeConverter timeConverter;
    private Activity activity;
    OnSongClickListener onSongClickListener;

    public SongListAdapter(ArrayList<AudioModel> songs, Activity activity) {
        this.songs = songs;
        timeConverter = new TimeConverter();
        this.activity = activity;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);
        return new SongViewHolder(view,activity,songs);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.songName.setText(songs.get(position).getTitle());
        holder.duration.setText(
                timeConverter.millisecondsToMinutes(songs.get(position).getDuration())
        );

        onSongClickListener = new OnSongClickListener(activity, position, songs);
        holder.itemView.setOnClickListener(onSongClickListener);

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

}
