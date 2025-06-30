package com.kelompok10.animedxd10.model;

import android.graphics.drawable.Drawable;

public class MovieCard {
    private String title;
    private String desc;
    private Drawable cover;

    public MovieCard() {
    }

    public MovieCard(String title, String desc, Drawable cover) {
        this.title = title;
        this.desc = desc;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public Drawable getCover() {
        return cover;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public void setCover(Drawable cover){
        this.cover = cover;
    }
}
