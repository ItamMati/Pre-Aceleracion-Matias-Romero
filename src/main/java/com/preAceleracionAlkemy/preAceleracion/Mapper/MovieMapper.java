package com.preAceleracionAlkemy.preAceleracion.mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoList;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {CharacterMapper.class})
public interface MovieMapper {

    @Mappings({
        @Mapping(source = "image", target = "image"),
        @Mapping(source = "title", target = "title"),
        @Mapping(source = "dateOfCreation", target = "dateOfCreation"),})
//    MovieEntity movieDtoToEntity(MovieDtoList movieDto);
//
//    @InheritInverseConfiguration
//    MovieDtoList movieEntityToMovieDto(MovieEntity movie);

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

//    List<MovieEntity> listMovieDetailsDtoToListMovieEntity(List<MovieDtoDetails> movieDetailsDto);
//
//    @InheritInverseConfiguration
//    List<MovieDtoDetails> listMovieEntityToListMovieDetailsDto(List<MovieEntity> movie);
//    @Mappings({
//        @Mapping(source = "image", target = "image"),
//        @Mapping(source = "title", target = "title"),
//        @Mapping(source = "dateOfCreation", target = "dateOfCreation"),
//        @Mapping(source = "calification", target = "calification"),
//        @Mapping(source = "movieCharacters", target = "movieCharacters")
//
//    })
//
//    MovieDtoDetails movieEntityToMovieDetailsDtoResponse(MovieEntity movie);
//    @InheritInverseConfiguration      
//    MovieEntity movieDetailsDtoResponseToEntity(MovieDtoDetails movieDetailsDto);
//    List<MovieEntity> listMovieDetailsDtoResponseToListMovieEntity(List<MovieDetailsDtoResponse> movieDetailsDtoResponse);
//    @InheritInverseConfiguration
//    List<MovieDetailsDtoResponse> listMovieEntityToListMovieDetailsDtoResponse(List<MovieEntity> movie);
}
