package com.example.myapplication;

public class Songs {
    private String path;
    private String name;
    private String duration;
    private String artist;
    private String album;

    public Songs(String path,String name, String duration, String artist, String album) {
        this.path = path;
        this.name= name;
        this.duration=duration;
        this.album=album;
        this.artist=artist;
    }

    public Songs() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

}
