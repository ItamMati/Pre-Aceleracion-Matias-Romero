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
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CharacterMapper.class, GenreMapper.class})
public interface MovieMapper {

 

    List<MovieEntity> listMovieDtoToListMovieEntity(List<MovieDtoList> movieDto);

    @InheritInverseConfiguration
    List<MovieDtoList> listMovieEntityToListMovieDto(List<MovieEntity> movie);


    MovieEntity movieDetailsDtoToEntity(MovieDtoDetails movieDetailsDto);

    @InheritInverseConfiguration
    MovieDtoDetails movieEntityToMovieDetailsDto(MovieEntity movie);


    @Mapping(target = "movieGenres", ignore = true)
    MovieEntity movieDtoReqToEntity(MovieGenreDtoReq movieDtoSave);

    @InheritInverseConfiguration
    @Mapping(source = "movieGenres", target = "movieGenres")
    MovieGenreDtoRes movieEntityToMovieDtoRes(MovieEntity movie);
    
      ///////////////////////////////////////EDIT///////////////////////////////////////////
  
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movieGenres", ignore = true)
    MovieEntity movieDtoEditToMovieEntity(@MappingTarget MovieEntity movieEntity, MovieGenreDtoReq movieToEdit);

    @InheritInverseConfiguration
     MovieGenreDtoRes movieEntityToMovieDtoEdit(MovieEntity movie);
     
      ///////////////////////////////////////EDIT///////////////////////////////////////////
}



