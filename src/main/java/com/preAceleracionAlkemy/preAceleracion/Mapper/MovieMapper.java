/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preAceleracionAlkemy.preAceleracion.Mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.MovieDto;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.time.LocalDate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mappings({
        @Mapping(source = "imagen", target = "imagen"),
        @Mapping(source = "titulo", target = "titulo"),
        @Mapping(source = "fechaDeCreacion", target = "fechaDeCreacion"),
        @Mapping(source = "calificacion", target = "calificacion")

    })
    MovieEntity movieDtoToEntity(MovieDto movieDto);

    @Mappings({
        @Mapping(source = "imagen", target = "imagen"),
        @Mapping(source = "titulo", target = "titulo"),
        @Mapping(source = "fechaDeCreacion", target = "fechaDeCreacion"),
        @Mapping(source = "calificacion", target = "calificacion")})
    MovieDto movieEntityToMovieDto(MovieEntity movie);

}
