package com.moulehi.mymusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Bundle;
import java.io.IOException;
import java.util.ArrayList;

public class MusicPlayerActivity extends AppCompatActivity {

    private final MediaPlayer mediaPlayer = MediaPlayerSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        com.moulehi.mymusicplayer.databinding.ActivityMusicPlayerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_music_player);

        //Retrieve song list from the previous activity
        ArrayList<AudioModel> songs = (ArrayList<AudioModel>) getIntent().getSerializableExtra("SONG_LIST");

        //set the song Name Title
        binding.songName.setText(
                songs.get(CurrentMusic.getInstance().getPosition()).getTitle()
        );

        //set the song duration
        TimeConverter timeConverter = new TimeConverter();
        binding.songDuration.setText(timeConverter.millisecondsToMinutes(
                songs.get(CurrentMusic.getInstance().getPosition()).getDuration()
        ));

        boolean isSongPlayed = true;
        OnPlayPauseClickListener playPauseClickListener = new OnPlayPauseClickListener(
                binding.startPauseButton,
                isSongPlayed,
                mediaPlayer,
                songs,
                binding.seekBar
        );
        OnPreviousSongClickListener previousSongClickListener = new OnPreviousSongClickListener(
                binding.startPauseButton,
                isSongPlayed,
                mediaPlayer,
                songs,
                binding.seekBar,
                binding.songName
        );
        OnNextSongClickListener nextSongClickListener = new OnNextSongClickListener(
                binding.startPauseButton,
                isSongPlayed,
                mediaPlayer,
                songs,
                binding.seekBar,
                binding.songName
        );
        binding.startPauseButton.setOnClickListener(playPauseClickListener);
        binding.previous.setOnClickListener(previousSongClickListener);
        binding.next.setOnClickListener(nextSongClickListener);

        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(songs.get(CurrentMusic.instance.getPosition()).getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            binding.seekBar.setProgress(0);
            binding.seekBar.setMax(mediaPlayer.getDuration());

        } catch (IOException e) {
            e.printStackTrace();
        }

        SeekBarTimeUpdater seekBarTimeUpdater = new SeekBarTimeUpdater(
                this,
                mediaPlayer,
                binding.seekBar,
                binding.songCurrentTime,
                timeConverter
        );
        seekBarTimeUpdater.run();

        MusicSeekBarChangeListener musicSeekBarChangeListener = new MusicSeekBarChangeListener(mediaPlayer);
        binding.seekBar.setOnSeekBarChangeListener(musicSeekBarChangeListener);

    }
}