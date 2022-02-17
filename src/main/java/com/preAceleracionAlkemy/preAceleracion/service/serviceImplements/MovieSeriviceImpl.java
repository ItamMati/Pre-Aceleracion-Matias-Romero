/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preAceleracionAlkemy.preAceleracion.service.serviceImplements;

import com.preAceleracionAlkemy.preAceleracion.Mapper.MovieMapper;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieDto;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import com.preAceleracionAlkemy.preAceleracion.repository.MovieRepository;
import com.preAceleracionAlkemy.preAceleracion.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieSeriviceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;
    
    @Autowired
    private MovieRepository movieRepository;

    public MovieDto save(MovieDto dto) {

        MovieEntity newMovie = movieMapper.movieDtoToEntity(dto);

        MovieEntity entitySaved = movieRepository.save(newMovie);

        MovieDto response = movieMapper.movieEntityToMovieDto(entitySaved);
        
        return response;

    }
}
