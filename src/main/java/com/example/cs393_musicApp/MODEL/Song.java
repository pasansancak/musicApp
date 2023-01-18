package com.example.cs393_musicApp.MODEL;

import jakarta.persistence.*;

@Entity
@Table(name = "T_SONG")
public class Song {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(length = 64)
    private String name;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID")
    private Artist artist;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ALBUM_ID")
    private Album album;

    @Column
    private double length;

    public Song(){
        super();
    }

    public Song(String name, double length) {
        super();
        this.name = name;
        this.length = length;
    }

    public Song(String name, Artist artist, double length) {
        super();
        this.name = name;
        this.artist = artist;
        this.length = length;
    }

    public Song(String name, Artist artist, Album album,double length) {
        super();
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist=" + artist +
                ", album=" + album +
                ", length=" + length +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
