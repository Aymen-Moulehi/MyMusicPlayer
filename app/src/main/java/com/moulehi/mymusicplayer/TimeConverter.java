package com.moulehi.mymusicplayer;

import android.annotation.SuppressLint;

import java.util.concurrent.TimeUnit;

public class TimeConverter {
    @SuppressLint("DefaultLocale")
    public String millisecondsToMinutes(String millisecondsString){

        long millis;

        try{
            millis = Long.parseLong(millisecondsString);
        }catch(NumberFormatException e){
            return "00:00";
        }

        return String.format(
                "%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1)

        );


    }
}
