package com.preAceleracionAlkemy.preAceleracion.service.Impl;

import com.preAceleracionAlkemy.preAceleracion.dto.request.MovieGenreDtoReq;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoForMovie;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.mapper.MovieMapper;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoList;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieGenreDtoRes;
import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
import com.preAceleracionAlkemy.preAceleracion.repository.specification.dto.MovieDtoSpecification;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import com.preAceleracionAlkemy.preAceleracion.exception.ParamNotFound;
import com.preAceleracionAlkemy.preAceleracion.mapper.CharacterMapper;
import com.preAceleracionAlkemy.preAceleracion.repository.GenreRepository;
import com.preAceleracionAlkemy.preAceleracion.repository.MovieRepository;
import com.preAceleracionAlkemy.preAceleracion.repository.specification.MovieSpecification;
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
    private GenreRepository genreRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieSpecification movieSpecification;


    @Override
    public MovieGenreDtoRes save(MovieGenreDtoReq movieDto) {

        Optional<MovieEntity> matchingMovie = movieRepository.findByTitle(movieDto.getTitle());
        if (matchingMovie.isPresent()) {
            throw new IllegalArgumentException("La pelicula ya existe");
        }

        MovieEntity newMovie = movieMapper.movieDtoReqToEntity(movieDto);

        Optional<GenreEntity> genre = genreRepository.findById(movieDto.getGenreId());

        newMovie.setMovieGenres(genre.get());

        MovieEntity entitySaved = movieRepository.save(newMovie);

        MovieGenreDtoRes response = movieMapper.movieEntityToMovieDtoRes(entitySaved);

        return response;

    }

    @Override
    public List<MovieDtoList> getByFilter(String name, String genre, String order, Date date) {

        MovieDtoSpecification filterDto = new MovieDtoSpecification(name, genre, order, date);

        List<MovieEntity> entity = movieRepository.findAll(
                where((movieSpecification.getByTitle(filterDto)).
                        and(movieSpecification.getByGenre(filterDto)).
                        and(movieSpecification.getByOrder(filterDto))));

        return movieMapper.listMovieEntityToListMovieDto(entity);

    }

    @Override
    public MovieDtoDetails getMovieDetails(Long id) {
        MovieEntity dbMovie = this.handleFindById(id);
        MovieDtoDetails resultDTO = movieMapper.movieEntityToMovieDetailsDto(dbMovie);
        return resultDTO;
    }

    // == PUT ==
    @Override
    public MovieGenreDtoRes editMovieById(Long id, MovieGenreDtoReq movieToEdit) {

        MovieEntity movieEntity = this.handleFindById(id);

        MovieEntity editMovie = movieRepository.save(movieMapper.movieDtoEditToMovieEntity(movieEntity, movieToEdit));

        return movieMapper.movieEntityToMovieDtoEdit(editMovie);

    }

    @Override
    public void deleteMovieById(Long id) {

        MovieEntity exist = this.handleFindById(id);
        movieRepository.deleteById(exist.getId());
    }

    // == ERROR HANDLING ==
    @Override
    public MovieEntity handleFindById(Long id) {
        Optional<MovieEntity> toBeFound = movieRepository.findById(id);
        if (!toBeFound.isPresent()) {
            throw new ParamNotFound("No Movie for id: " + id);
        }
        return toBeFound.get();
    }

}
