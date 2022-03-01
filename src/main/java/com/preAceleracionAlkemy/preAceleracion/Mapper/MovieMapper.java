package com.preAceleracionAlkemy.preAceleracion.mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.request.MovieGenreDtoReq;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoList;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieGenreDtoRes;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CharacterMapper.class, GenreMapper.class})
public interface MovieMapper {

    @Mappings({
        @Mapping(source = "image", target = "image"),
        @Mapping(source = "title", target = "title"),
        @Mapping(source = "dateOfCreation", target = "dateOfCreation"),})

    List<MovieEntity> listMovieDtoToListMovieEntity(List<MovieDtoList> movieDto);

    @InheritInverseConfiguration
    List<MovieDtoList> listMovieEntityToListMovieDto(List<MovieEntity> movie);

    @Mappings({
        @Mapping(source = "image", target = "image"),
        @Mapping(source = "title", target = "title"),
        @Mapping(source = "dateOfCreation", target = "dateOfCreation"),
        @Mapping(source = "calification", target = "calification"),
        @Mapping(source = "movieCharacters", target = "movieCharacters")

    })

    MovieEntity movieDetailsDtoToEntity(MovieDtoDetails movieDetailsDto);

    @InheritInverseConfiguration
    MovieDtoDetails movieEntityToMovieDetailsDto(MovieEntity movie);

    /////////////////////////////////MovieDtoReq and MovieDtoRes/////////////////////////
    @Mappings({
        @Mapping(source = "image", target = "image"),
        @Mapping(source = "title", target = "title"),
        @Mapping(source = "dateOfCreation", target = "dateOfCreation"),
        @Mapping(source = "calification", target = "calification"),
        @Mapping(source = "genreId", target = "genreId"),
       })

    @Mapping(target = "movieGenres", ignore = true)
    MovieEntity movieDtoReqToEntity(MovieGenreDtoReq movieDtoSave);

    @InheritInverseConfiguration
    @Mapping(source = "movieGenres", target = "movieGenres")
    MovieGenreDtoRes movieEntityToMovieDtoRes(MovieEntity movie);
}

 /////////////////////////////////MovieDtoReq and MovieDtoRes/////////////////////////
