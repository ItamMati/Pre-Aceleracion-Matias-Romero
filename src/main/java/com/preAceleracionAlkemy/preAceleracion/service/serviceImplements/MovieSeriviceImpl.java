/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preAceleracionAlkemy.preAceleracion.service.serviceImplements;

import com.preAceleracionAlkemy.preAceleracion.mapper.GenreMapper;
import com.preAceleracionAlkemy.preAceleracion.mapper.MovieMapper;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieDto;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieFilterDto;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import com.preAceleracionAlkemy.preAceleracion.repository.MovieRepository;
import com.preAceleracionAlkemy.preAceleracion.repository.specification.MovieSpecification;
import com.preAceleracionAlkemy.preAceleracion.service.GenreService;
import com.preAceleracionAlkemy.preAceleracion.service.MovieService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.Specification.where;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MovieSeriviceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreService genreService;

    @Autowired
    private MovieSpecification movieSpecification;

    public MovieDto save(MovieDto dto) {

        MovieEntity newMovie = movieMapper.movieDtoToEntity(dto);

        newMovie.setMovieGenres(genreMapper.GenreDtoToGenreEntity(dto.getMovieGenres()));

        MovieEntity entitySaved = movieRepository.save(newMovie);

        MovieDto response = movieMapper.movieEntityToMovieDto(entitySaved);

        return response;

    }

    @Override
    public void delete(@PathVariable Long id) {

        movieRepository.deleteById(id);

    }

    @Override
    public List<MovieEntity> findAll() {
        return null;
    }

    @Override
    public List<MovieDto> getByFilter(String name,String  genre, String order, Date date) {

        MovieFilterDto filterDto = new MovieFilterDto(name, genre, order, date);
        
        List<MovieEntity> entity = movieRepository.findAll(
                where((movieSpecification.getByTitle(filterDto)).
                and(movieSpecification.getByGenre(filterDto)).
                and(movieSpecification.getByOrder(filterDto))));
        
   

        return movieMapper.listMovieEntityToListMovieDto(entity);

    }
}
