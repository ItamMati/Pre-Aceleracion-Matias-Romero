package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.MovieDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieDetailsDtoResponse;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieDto;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface MovieService {

    MovieDetailsDto save(MovieDetailsDto dto);

    List<MovieDto> getByFilter(String name, String genre, String order, Date date);

    MovieDetailsDtoResponse getMovieDetails(Long id);

    void deleteMovieById(Long id);

    MovieDetailsDto editMovieById(Long id, MovieDetailsDto movieToEdit);
    
   MovieEntity handleFindById(Long id);

}
