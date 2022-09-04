package com.moulehi.mymusicplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarTimeUpdater {
    MusicPlayerActivity activity;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private TextView songCurrentTime;
    private TimeConverter timeConverter;

    public SeekBarTimeUpdater(MusicPlayerActivity activity,
                              MediaPlayer mediaPlayer,
                              SeekBar seekBar,
                              TextView songCurrentTime,
                              TimeConverter timeConverter) {
        this.activity = activity;
        this.mediaPlayer = mediaPlayer;
        this.seekBar = seekBar;
        this.songCurrentTime = songCurrentTime;
        this.timeConverter = timeConverter;
    }

    public void run(){
       activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null){
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    songCurrentTime.setText(String.valueOf(
                                    timeConverter.millisecondsToMinutes(
                                            String.valueOf(mediaPlayer.getCurrentPosition())
                                    )
                            )
                    );

                }
                new Handler().postDelayed(this, 100);
            }
        });
    }
}
