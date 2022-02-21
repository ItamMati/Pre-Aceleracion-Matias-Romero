package com.preAceleracionAlkemy.preAceleracion.dto;

import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.HashSet;
import java.util.Set;
import lombok.*;


@Getter
@Setter
public class CharacterDetailsDto {
    
    

    private Long id;

    private String imageUrl;

    private String name;

    private int age;

    private double weight;

    private String history;
    
    private Set<MovieEntity> characterMovies = new HashSet();
    
}
