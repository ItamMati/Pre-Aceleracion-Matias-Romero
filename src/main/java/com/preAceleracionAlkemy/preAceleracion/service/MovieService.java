package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoList;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface MovieService {

    MovieDtoDetails save(MovieDtoDetails dto);

    List<MovieDtoList> getByFilter(String name, String genre, String order, Date date);

    MovieDtoDetails getMovieDetails(Long id);

    void deleteMovieById(Long id);

    MovieDtoDetails editMovieById(Long id, MovieDtoDetails movieToEdit);
    
   MovieEntity handleFindById(Long id);

}
