package com.example.cs393_musicApp.REPO;

import com.example.cs393_musicApp.MODEL.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends JpaRepository <Album, Integer> {
    Album findById(int id);

}
