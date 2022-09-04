package com.moulehi.mymusicplayer;

import android.media.MediaPlayer;
import android.widget.SeekBar;

public class MusicSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
    private MediaPlayer mediaPlayer;

    public MusicSeekBarChangeListener(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(mediaPlayer != null && b){
            mediaPlayer.seekTo(i);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
