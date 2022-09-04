package com.moulehi.mymusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.moulehi.mymusicplayer.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding ;
    private AccessStorageRequestPermission storageRequestPermission;
    private AccessStorageCheckPermission storageCheckPermission;
    private SongLoader songLoader;
    private ArrayList<AudioModel> songs;
    private SongListAdapter songListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        storageCheckPermission = new AccessStorageCheckPermission();
        storageRequestPermission = new AccessStorageRequestPermission();
        songLoader = new SongLoader();

        //check access storage permission
        if(!storageCheckPermission.checkPermission(getApplicationContext())){
            storageRequestPermission.requestPermission(this);
            return;
        }

        //load all songs in the user phone
        songs = songLoader.load(this);
        if(songs.size() == 0){
            binding.songAvailability.setVisibility(View.VISIBLE);
        }else{
            binding.songsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            songListAdapter = new SongListAdapter(songs,this);
            binding.songsRecyclerView.setAdapter(songListAdapter);
            songListAdapter.notifyDataSetChanged();

        }



    }
}