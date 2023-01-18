package com.example.cs393_musicApp.MODEL;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "T_ALBUM")
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(length = 64)
    private String name;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID")
    private Artist artist;

    @OneToMany(mappedBy = "album",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Song> songs;

    public Album(){
        super();
    }

    public Album(String name, Artist artist, List<Song> songs) {
        super();
        this.name = name;
        this.artist = artist;
        this.songs = songs;
    }
    public Album(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist=" + artist +
                ", songs=" + songs +
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

}
