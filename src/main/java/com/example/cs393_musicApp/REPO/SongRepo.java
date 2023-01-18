package com.example.cs393_musicApp.REPO;

import com.example.cs393_musicApp.MODEL.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
    Song findById(int id);

    List<Song> findSongsByArtist_Name(String name);
    List<Song> findSongsByName(String name);

}
