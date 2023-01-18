package com.example.cs393_musicApp.MAPPER;

import com.example.cs393_musicApp.DTO.SongDTO;
import com.example.cs393_musicApp.MODEL.Song;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T08:37:09+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
public class SongMapperImpl implements SongMapper {

    @Override
    public SongDTO songToSongDto(Song song) {
        if ( song == null ) {
            return null;
        }

        SongDTO songDTO = new SongDTO();

        songDTO.setId( song.getId() );
        songDTO.setName( song.getName() );
        songDTO.setLength( song.getLength() );

        songDTO.setArtist( song.getArtist().getName() );
        songDTO.setAlbum( song.getAlbum().getName() );

        return songDTO;
    }
}
