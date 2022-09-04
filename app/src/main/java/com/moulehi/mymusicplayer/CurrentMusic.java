package com.moulehi.mymusicplayer;

public class CurrentMusic {
    private int position = -1;
    public static CurrentMusic instance;

    public static CurrentMusic getInstance() {
        if(instance == null){
            instance = new CurrentMusic();
        }
        return instance;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
