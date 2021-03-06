/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preAceleracionAlkemy.preAceleracion.service.serviceImplements;

import com.preAceleracionAlkemy.preAceleracion.dto.MovieDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.mapper.GenreMapper;
import com.preAceleracionAlkemy.preAceleracion.mapper.MovieMapper;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieDto;
import com.preAceleracionAlkemy.preAceleracion.dto.MovieFilterDto;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import com.preAceleracionAlkemy.preAceleracion.exception.ParamNotFound;
import com.preAceleracionAlkemy.preAceleracion.repository.MovieRepository;
import com.preAceleracionAlkemy.preAceleracion.repository.specification.MovieSpecification;
import com.preAceleracionAlkemy.preAceleracion.service.GenreService;
import com.preAceleracionAlkemy.preAceleracion.service.MovieService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.Specification.where;
import org.springframework.stereotype.Service;

@Service
public class MovieSeriviceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private GenreMapper genreMapper;
    
    @Autowired
    private GenreService genreService;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieSpecification movieSpecification;

    @Override
    public List<MovieDto> getByFilter(String name, String genre, String order, Date date) {

        MovieFilterDto filterDto = new MovieFilterDto(name, genre, order, date);

        List<MovieEntity> entity = movieRepository.findAll(
                where((movieSpecification.getByTitle(filterDto)).
                        and(movieSpecification.getByGenre(filterDto)).
                        and(movieSpecification.getByOrder(filterDto))));

        return movieMapper.listMovieEntityToListMovieDto(entity);

    }

    @Override
    public MovieDetailsDto getMovieDetails(Long id) {
        MovieEntity dbMovie = this.handleFindById(id);
        MovieDetailsDto resultDTO = movieMapper.movieEntityToMovieDetailsDto(dbMovie);
        return resultDTO;
    }

    @Override
    public MovieDetailsDto save(MovieDetailsDto movieDto) {

        MovieEntity newMovie = movieMapper.movieDetailsDtoToEntity(movieDto);
      
        newMovie.setMovieGenres(genreMapper.GenreDtoToGenreEntity(movieDto.getMovieGenres()));

        MovieEntity entitySaved = movieRepository.save(newMovie);

        MovieDetailsDto response = movieMapper.movieEntityToMovieDetailsDto(entitySaved);

        return response;

    }

    // == PUT ==
    @Override
    public MovieDetailsDto editMovieById(Long id, MovieDetailsDto movieToEdit) {
        MovieEntity savedMovie = this.handleFindById(id);
        savedMovie.setImage(movieToEdit.getImage());
        savedMovie.setTitle(movieToEdit.getTitle());
        savedMovie.setCalification(movieToEdit.getCalification());
        savedMovie.setDateOfCreation(movieToEdit.getDateOfCreation());
        MovieEntity editedMovie = movieRepository.save(savedMovie);
        MovieDetailsDto resultDTO = movieMapper.movieEntityToMovieDetailsDto(editedMovie);
        return resultDTO;
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    // == ERROR HANDLING ==
    public MovieEntity handleFindById(Long id) {
        Optional<MovieEntity> toBeFound = movieRepository.findById(id);
        if (!toBeFound.isPresent()) {
            throw new ParamNotFound("No Character for id: " + id);
        }
        return toBeFound.get();
    }

}
