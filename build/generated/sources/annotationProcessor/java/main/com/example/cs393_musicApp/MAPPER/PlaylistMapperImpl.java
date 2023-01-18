package com.example.cs393_musicApp.MAPPER;

import com.example.cs393_musicApp.DTO.PlaylistDTO;
import com.example.cs393_musicApp.MODEL.Playlist;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T08:11:54+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
public class PlaylistMapperImpl implements PlaylistMapper {

    @Override
    public PlaylistDTO playlistToPlaylistDto(Playlist Playlist) {
        if ( Playlist == null ) {
            return null;
        }

        PlaylistDTO playlistDTO = new PlaylistDTO();

        playlistDTO.setId( Playlist.getId() );
        playlistDTO.setName( Playlist.getName() );

        playlistDTO.setPlLength( 0 );
        playlistDTO.setSongCount( 0 );

        return playlistDTO;
    }

    @Override
    public Playlist playlistDTOToPlaylist(PlaylistDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Playlist playlist = new Playlist();

        playlist.setId( dto.getId() );
        playlist.setName( dto.getName() );

        return playlist;
    }
}
