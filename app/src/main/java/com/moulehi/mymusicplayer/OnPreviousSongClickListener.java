package com.moulehi.mymusicplayer;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class OnPreviousSongClickListener implements View.OnClickListener {
    private ImageView playPauseButton;
    private boolean isSongPlayed;
    private MediaPlayer mediaPlayer;
    private ArrayList<AudioModel> songs;
    private SeekBar seekBar;
    private TextView songName;

    public OnPreviousSongClickListener(ImageView playPauseButton,
                                       boolean isSongPlayed,
                                       MediaPlayer mediaPlayer,
                                       ArrayList<AudioModel> songs,
                                       SeekBar seekBar,
                                       TextView songName) {
        this.playPauseButton = playPauseButton;
        this.isSongPlayed = isSongPlayed;
        this.mediaPlayer = mediaPlayer;
        this.songs = songs;
        this.seekBar = seekBar;
        this.songName = songName;
    }
    @Override
    public void onClick(View view) {
        if(CurrentMusic.getInstance().getPosition() == 0){
            CurrentMusic.getInstance().setPosition(songs.size()-1);
        }else {
            CurrentMusic.getInstance().setPosition(CurrentMusic.getInstance().getPosition() - 1);
        }
        isSongPlayed = true;
        playPauseButton.setImageResource(R.drawable.ic_baseline_pause_circle_24);
        songName.setText(songs.get(CurrentMusic.instance.getPosition()).getTitle());
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(songs.get(CurrentMusic.instance.getPosition()).getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            seekBar.setProgress(0);
            seekBar.setMax(mediaPlayer.getDuration());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
