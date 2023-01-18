package com.example.cs393_musicApp.REPO;

import com.example.cs393_musicApp.MODEL.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Integer> {
    Artist findById(int id);

}
