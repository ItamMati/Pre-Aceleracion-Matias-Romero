package com.preAceleracionAlkemy.preAceleracion.service.Impl;

import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.mapper.MovieMapper;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoList;
import com.preAceleracionAlkemy.preAceleracion.repository.specification.dto.MovieDtoSpecification;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import com.preAceleracionAlkemy.preAceleracion.exception.ParamNotFound;
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
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieSpecification movieSpecification;

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
    public MovieDtoDetails editMovieById(Long id, MovieDtoDetails movieToEdit) {
        MovieEntity savedMovie = this.handleFindById(id);

        savedMovie.setImage(movieToEdit.getImage());
        savedMovie.setTitle(movieToEdit.getTitle());
        savedMovie.setCalification(movieToEdit.getCalification());
        savedMovie.setDateOfCreation(movieToEdit.getDateOfCreation());
        MovieEntity editedMovie = movieRepository.save(savedMovie);
        MovieDtoDetails resultDTO = movieMapper.movieEntityToMovieDetailsDto(editedMovie);
        return resultDTO;
    }

    @Override
    public MovieDtoDetails save(MovieDtoDetails movieDto) {

        MovieEntity newMovie = movieMapper.movieDetailsDtoToEntity(movieDto);

        MovieEntity entitySaved = movieRepository.save(newMovie);

        MovieDtoDetails response = movieMapper.movieEntityToMovieDetailsDto(entitySaved);

        return response;

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
