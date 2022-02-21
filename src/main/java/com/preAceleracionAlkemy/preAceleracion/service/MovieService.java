package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.MovieDto;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface MovieService {

    MovieDto save(MovieDto dto);

    void delete(Long id);
    
     public List<MovieEntity> findAll();

    public List<MovieDto> getByFilter(String name, String genre, String order, Date date);

}
