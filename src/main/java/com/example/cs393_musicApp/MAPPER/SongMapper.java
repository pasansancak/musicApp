package com.example.cs393_musicApp.MAPPER;

import com.example.cs393_musicApp.DTO.SongDTO;
import com.example.cs393_musicApp.MODEL.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SongMapper {

    SongMapper INSTANCE = Mappers.getMapper( SongMapper.class );

    @Mapping(target = "artist", expression = "java(song.getArtist().getName())")
    @Mapping(target = "album", expression = "java(song.getAlbum().getName())")
    SongDTO songToSongDto(Song song);

}