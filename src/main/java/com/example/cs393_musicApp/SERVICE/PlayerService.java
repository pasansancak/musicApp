package com.example.cs393_musicApp.SERVICE;

import com.example.cs393_musicApp.DTO.PlaylistDTO;
import com.example.cs393_musicApp.DTO.SongDTO;
import com.example.cs393_musicApp.MAPPER.PlaylistMapper;
import com.example.cs393_musicApp.MAPPER.SongMapper;
import com.example.cs393_musicApp.MODEL.Playlist;
import com.example.cs393_musicApp.MODEL.Song;
import com.example.cs393_musicApp.MODEL.Album;
import com.example.cs393_musicApp.REPO.AlbumRepo;
import com.example.cs393_musicApp.REPO.PlaylistRepo;
import com.example.cs393_musicApp.REPO.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.cs393_musicApp.REPO.ArtistRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PlayerService {

    @Autowired
    ArtistRepo artistRepo;
    @Autowired
    SongRepo songRepo;
    @Autowired
    PlaylistRepo playlistRepo;
    @Autowired
    AlbumRepo albumRepo;


    public void saveAlbum(Album album) {
        albumRepo.save(album);
    }

    public void addSongToAlbum(int albumId, Song song) {

        Album a = albumRepo.findById(albumId);

        try {
            if (Objects.equals(song.getArtist().getName(), a.getArtist().getName())) {
                a.getSongs().add(song);
                song.setAlbum(a);
            } else
                System.out.println("This song doesn't belongs this artist.");

        } catch (Exception e) {
            System.out.println("This song doesn't have an artist therefore song didn't added to the album");
        }

        songRepo.save(song);
    }

    public void assignArtistToAlbum(int albumId, int artistId) {
        albumRepo.findById(albumId).setArtist(artistRepo.findById(artistId));
    }

    public void deleteAlbum(int albumId) {
        List<Song> songs = albumRepo.findById(albumId).getSongs();
        albumRepo.deleteById(albumId);
        songRepo.saveAll(songs);
    }

    public List<SongDTO> getSongs() {
        List<Song> songs = songRepo.findAll();
        List<SongDTO> songDTOS = new ArrayList<>();
        for (Song s : songs)
            songDTOS.add(SongMapper.INSTANCE.songToSongDto(s));
        return songDTOS;
    }

    public List<PlaylistDTO> getPlaylists() {
        List<Playlist> playlists = playlistRepo.findAll();
        List<PlaylistDTO> playlistDTOS = new ArrayList<>();
        PlaylistDTO pdto = new PlaylistDTO();
        int length = 0;
        int songCount = 0;
        for (Playlist p : playlists) {
            for (Song s : p.getSongs()) {
                length += (((int) (s.getLength())) * 60) + ((s.getLength() % 1) * 100);
                songCount++;
            }
            pdto = PlaylistMapper.INSTANCE.playlistToPlaylistDto(p);
            pdto.setSongCount(songCount);
            pdto.setPlLength(length);
            playlistDTOS.add(pdto);
            length = 0;
            songCount = 0;
        }
        return playlistDTOS;
    }

    public List<SongDTO> findSongsByArtist_NameOrName(String input) {
        List<Song> songs1 = songRepo.findSongsByName(input);
        List<Song> songs2 = songRepo.findSongsByArtist_Name(input);
        List<SongDTO> songDTOS = new ArrayList<>();

        for (Song x : songs1) {
            if (!songs2.contains(x))
                songDTOS.add(SongMapper.INSTANCE.songToSongDto(x));
        }
        for (Song x : songs2) {
            songDTOS.add(SongMapper.INSTANCE.songToSongDto(x));
        }

        return songDTOS;
    }


    public void deleteSong(int songId) {
        songRepo.deleteById(songId);
    }

    public List<Song> findSongsWithArtistId(int id) {
        return artistRepo.findById(id).getSongs();
    }


    public ArtistRepo getArtistRepo() {
        return artistRepo;
    }

    public void setArtistRepo(ArtistRepo artistRepo) {
        this.artistRepo = artistRepo;
    }

    public SongRepo getSongRepo() {
        return songRepo;
    }

    public void setSongRepo(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    public PlaylistRepo getPlaylistRepo() {
        return playlistRepo;
    }

    public void setPlaylistRepo(PlaylistRepo playlistRepo) {
        this.playlistRepo = playlistRepo;
    }

    public AlbumRepo getAlbumRepo() {
        return albumRepo;
    }

    public void setAlbumRepo(AlbumRepo albumRepo) {
        this.albumRepo = albumRepo;
    }

    public void createPlaylist(PlaylistDTO playlistDTO) {
        Playlist pl = new Playlist();
        pl = PlaylistMapper.INSTANCE.playlistDTOToPlaylist(playlistDTO);
        playlistRepo.save(pl);

    }

}
