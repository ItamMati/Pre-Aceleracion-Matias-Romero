package com.preAceleracionAlkemy.preAceleracion.controller;

import com.preAceleracionAlkemy.preAceleracion.dto.MovieDto;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import com.preAceleracionAlkemy.preAceleracion.service.MovieService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/list")
    public ResponseEntity<List<MovieDto>> findAll(@RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false, defaultValue = "ASC") String order,
            @RequestParam(required = false) Date date) {

        List<MovieDto> movies = movieService.getByFilter(title, genre, order, date);

        return ResponseEntity.ok(movies);

    }

    @PostMapping("/save")
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto movie) {

        MovieDto newMovie = movieService.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
//        continente guardado

    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
