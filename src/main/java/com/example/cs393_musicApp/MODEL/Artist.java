package com.example.cs393_musicApp.MODEL;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "T_ARTIST")
public class Artist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(length = 64)
    private String name;

    @OneToMany (mappedBy = "artist")
    private List<Song> songs;

    @OneToMany (mappedBy = "artist")
    private List<Album> albums;

    public Artist(){
        super();
    }

    public Artist(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songs=" + songs +
                ", albums=" + albums +
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
