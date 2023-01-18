package com.example.cs393_musicApp.DTO;

public class PlaylistDTO {


    private int id;
    private String name;
    private int plLength;
    private int songCount;


    public PlaylistDTO(){
        super();
    }

    public PlaylistDTO(int id, String name, int plLength, int songCount) {
        this.id = id;
        this.name = name;
        this.plLength = plLength;
        this.songCount = songCount;
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

    public int getPlLength() {
        return plLength;
    }

    public void setPlLength(int plLength) {
        this.plLength = plLength;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }
}
