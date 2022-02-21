package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.MovieDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieDto;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface MovieService {

    MovieDetailsDto save(MovieDetailsDto dto);

    List<MovieDto> getByFilter(String name, String genre, String order, Date date);

    MovieDetailsDto getMovieDetails(Long id);

    void deleteMovieById(Long id);

    MovieDetailsDto editMovieById(Long id, MovieDetailsDto movieToEdit);
    
    

}
