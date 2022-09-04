package com.moulehi.mymusicplayer;

import android.app.Activity;
import android.database.Cursor;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;

public class SongLoader {

    ArrayList<AudioModel> load(Activity activity){

        ArrayList<AudioModel> songs = new ArrayList<>();

        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC + "!=0" ;

        Cursor cursor = activity.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                null
        );
        while (cursor.moveToNext()){
            AudioModel song = new AudioModel(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );

            // check if the file of the exist
            if(new File(song.getPath()).exists())
                songs.add(song);
        }
        return songs ;
    }
}
