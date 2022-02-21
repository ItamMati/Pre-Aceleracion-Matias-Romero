/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preAceleracionAlkemy.preAceleracion.mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.MovieDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieDetailsDtoResponse;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieDto;
import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {GenreEntity.class})
public interface MovieMapper {

    @Mappings({
        @Mapping(source = "image", target = "image"),
        @Mapping(source = "title", target = "title"),
        @Mapping(source = "dateOfCreation", target = "dateOfCreation"),})
    MovieEntity movieDtoToEntity(MovieDto movieDto);

    @InheritInverseConfiguration
    MovieDto movieEntityToMovieDto(MovieEntity movie);

    List<MovieEntity> listMovieDtoToListMovieEntity(List<MovieDto> movieDto);

    @InheritInverseConfiguration
    List<MovieDto> listMovieEntityToListMovieDto(List<MovieEntity> movie);

    @Mappings({
        @Mapping(source = "image", target = "image"),
        @Mapping(source = "title", target = "title"),
        @Mapping(source = "dateOfCreation", target = "dateOfCreation"),
        @Mapping(source = "calification", target = "calification"),
        @Mapping(source = "genreId", target = "genreId")

    })
    MovieEntity movieDetailsDtoToEntity(MovieDetailsDto movieDetailsDto);

    @InheritInverseConfiguration
    MovieDetailsDto movieEntityToMovieDetailsDto(MovieEntity movie);

    List<MovieEntity> listMovieDetailsDtoToListMovieEntity(List<MovieDetailsDto> movieDetailsDto);

    @InheritInverseConfiguration
    List<MovieDetailsDto> listMovieEntityToListMovieDetailsDto(List<MovieEntity> movie);

    @Mappings({
        @Mapping(source = "image", target = "image"),
        @Mapping(source = "title", target = "title"),
        @Mapping(source = "dateOfCreation", target = "dateOfCreation"),
        @Mapping(source = "calification", target = "calification"),
        @Mapping(source = "movieGenres", target = "movieGenres")

    })

    MovieDetailsDtoResponse movieEntityToMovieDetailsDtoResponse(MovieEntity movie);

//    @InheritInverseConfiguration      
//    MovieEntity movieDetailsDtoResponseToEntity(MovieDetailsDtoResponse movieDetailsDto);
//    List<MovieEntity> listMovieDetailsDtoResponseToListMovieEntity(List<MovieDetailsDtoResponse> movieDetailsDtoResponse);

//    @InheritInverseConfiguration
//    List<MovieDetailsDtoResponse> listMovieEntityToListMovieDetailsDtoResponse(List<MovieEntity> movie);
}
