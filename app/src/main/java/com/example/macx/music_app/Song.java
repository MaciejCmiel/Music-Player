package com.example.macx.music_app;


/**
 * Created by MacX on 2018-03-23.
 * {@link Song}
 */

public class Song {

    private String name;
    private String author;
    private int rawId;
    private int imageId;

    public Song(String name, String author, int rawId, int imageId) {
        this.name = name;
        this.author = author;
        this.rawId = rawId;
        this.imageId = imageId;
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getRawId() {
        return rawId;
    }

    public int getImageId() {
        return imageId;
    }
}
