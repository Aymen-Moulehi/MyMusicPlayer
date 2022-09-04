package com.moulehi.mymusicplayer;



import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class OnSongClickListener implements View.OnClickListener {
    private Activity activity;
    private int songPosition;
    private ArrayList<AudioModel> songs;

    public OnSongClickListener(Activity activity, int songPosition, ArrayList<AudioModel> songs) {
        this.activity = activity;
        this.songPosition = songPosition;
        this.songs = songs;
    }

    @Override
    public void onClick(View view) {
        CurrentMusic.getInstance().setPosition(songPosition);
        Intent intent = new Intent(activity.getApplicationContext(),MusicPlayerActivity.class);
        intent.putExtra("SONG_LIST",songs);
        activity.startActivity(intent);
    }
}
