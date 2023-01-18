package com.example.cs393_musicApp.REPO;

import com.example.cs393_musicApp.MODEL.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepo extends JpaRepository<Playlist, Integer> {
    Playlist findById(int id);

    Playlist save (Playlist playlist);
}