package com.example.cs393_musicApp.CONTROLLER;

import com.example.cs393_musicApp.DTO.SongDTO;
import com.example.cs393_musicApp.SERVICE.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@CrossOrigin
public class SongController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    public List<SongDTO> getSongs(){
        return playerService.getSongs();
    }

    @GetMapping(value = "/songs")
    public List<SongDTO> getSongsBySearch(@RequestParam(value = "search") String search) {
        return playerService.findSongsByArtist_NameOrName(search);
    }


}
