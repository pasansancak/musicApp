package com.example.cs393_musicApp.MAPPER;

import com.example.cs393_musicApp.DTO.PlaylistDTO;
import com.example.cs393_musicApp.MODEL.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlaylistMapper {

    PlaylistMapper INSTANCE = Mappers.getMapper( PlaylistMapper.class );


    @Mapping(target = "plLength", constant="0")
    @Mapping(target = "songCount", constant="0")
    PlaylistDTO playlistToPlaylistDto(Playlist Playlist);


    Playlist playlistDTOToPlaylist(PlaylistDTO dto);
}