package com.example.cs393_musicApp.MODEL;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "T_PLAYLIST")
public class Playlist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToMany()
    @JoinTable(name = "REL_PLAYLIST_SONG",
            joinColumns = @JoinColumn(name = "PL_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "SONG_ID",
                    referencedColumnName = "ID"))
    private List<Song> songs;

    @ManyToMany()
    @JoinTable(name = "REL_PLAYLIST",
            joinColumns = @JoinColumn(name = "PARENT_PL_ID",
                    referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_PL_ID",
                    referencedColumnName = "ID"))
    private List<Playlist> playlists;

    public Playlist(){
        super();
    }

    public Playlist(String name, List<Song> songs, List<Playlist> playlists) {
        super();
        this.name = name;
        this.songs = songs;
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songs=" + songs +
                ", playlists=" + playlists +
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

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
