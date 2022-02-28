package com.preAceleracionAlkemy.preAceleracion.controller;

import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.MovieDtoList;
import com.preAceleracionAlkemy.preAceleracion.service.MovieService;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    //EndPoint GET//
    @GetMapping()
    public ResponseEntity<List<MovieDtoList>> findAll(@RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false, defaultValue = "ASC") String order,
            @RequestParam(required = false) Date date) {

        List<MovieDtoList> movies = movieService.getByFilter(title, genre, order, date);

        return ResponseEntity.ok(movies);

    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDtoDetails> getMovieDetailsDtoById(@PathVariable Long id) {
        MovieDtoDetails movieDetailsResponse = movieService.getMovieDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsResponse);
    }

    @PostMapping()
    public ResponseEntity<MovieDtoDetails> save(@Valid @RequestBody MovieDtoDetails movie) {

        MovieDtoDetails newMovie = movieService.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
//        continente guardado

    }

    // == PUT ==	
    @PutMapping("/{id}")
    public ResponseEntity<MovieDtoDetails> editCharacter(@PathVariable Long id,@Valid @RequestBody MovieDtoDetails charToEdit) {
        MovieDtoDetails editedChar = movieService.editMovieById(id, charToEdit);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedChar);
    }

    // == DELETE ==	
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
