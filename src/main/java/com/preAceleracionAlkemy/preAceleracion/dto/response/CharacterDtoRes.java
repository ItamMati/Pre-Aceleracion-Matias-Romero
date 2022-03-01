package com.preAceleracionAlkemy.preAceleracion.dto.response;

import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDtoRes {
    
     private Long id;

    private String imageUrl;

    private String name;

    private int age;

    private Double weight;

    private String history;

    private Set<MovieEntity> movieCharacters;
    
    
}
