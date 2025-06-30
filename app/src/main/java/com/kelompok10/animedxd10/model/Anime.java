package com.kelompok10.animedxd10.model;

public class Anime {
    private String title;
    private String genre;
    private String description;
    private int imageresId;

    public Anime(String title, String genre, String description, int imageresId){
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.imageresId = imageresId;
    }

    public String getTitle(){ return  title;}
    public String getGenre(){ return  genre;}
    public String getDescription(){ return  description;}

    public int getImageResId(){ return  imageresId;}
}
