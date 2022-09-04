package com.moulehi.mymusicplayer;

import java.io.Serializable;

public class AudioModel implements Serializable{
    String title;
    String duration;
    String path ;

    public AudioModel(String title, String duration, String path) {
        this.title = title;
        this.duration = duration;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
