package com.moulehi.mymusicplayer;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.IOException;
import java.util.ArrayList;

public class OnPlayPauseClickListener implements View.OnClickListener{

    private ImageView playPauseButton;
    private boolean isSongPlayed;
    private MediaPlayer mediaPlayer;
    private ArrayList<AudioModel> songs;
    private SeekBar seekBar;

    public OnPlayPauseClickListener(ImageView playPauseButton, boolean isSongPlayed,
            MediaPlayer mediaPlayer, ArrayList<AudioModel> songs, SeekBar seekBar) {
        this.playPauseButton = playPauseButton;
        this.isSongPlayed = isSongPlayed;
        this.mediaPlayer = mediaPlayer;
        this.songs = songs;
        this.seekBar = seekBar;
    }

    @Override
    public void onClick(View view) {
        if(isSongPlayed){
            isSongPlayed = false;
            playPauseButton.setImageResource(R.drawable.ic_baseline_play_circle_24);
            mediaPlayer.pause();
        }else{
            isSongPlayed = true;
            playPauseButton.setImageResource(R.drawable.ic_baseline_pause_circle_24);
            try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(songs.get(CurrentMusic.instance.getPosition()).getPath());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    mediaPlayer.seekTo(seekBar.getProgress());
                    seekBar.setMax(mediaPlayer.getDuration());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
