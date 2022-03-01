package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.request.MovieGenreDtoReq;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoList;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieGenreDtoRes;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.Date;
import java.util.List;

public interface MovieService {

    MovieGenreDtoRes save(MovieGenreDtoReq dto);

    List<MovieDtoList> getByFilter(String name, String genre, String order, Date date);

    MovieDtoDetails getMovieDetails(Long id);

    void deleteMovieById(Long id);

    MovieGenreDtoRes editMovieById(Long id, MovieGenreDtoReq movieToEdit);

    MovieEntity handleFindById(Long id);

}
