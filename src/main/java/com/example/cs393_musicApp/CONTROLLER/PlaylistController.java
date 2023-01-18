package com.example.cs393_musicApp.CONTROLLER;

import com.example.cs393_musicApp.DTO.PlaylistDTO;
import com.example.cs393_musicApp.DTO.SongDTO;
import com.example.cs393_musicApp.SERVICE.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
@CrossOrigin
public class PlaylistController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    public List<PlaylistDTO> getPlaylists(){
        return playerService.getPlaylists();
    }

    @PostMapping
    public void createPlaylist(@RequestBody PlaylistDTO playlistDto) {
        playerService.createPlaylist(playlistDto);
    }

}