package com.preAceleracionAlkemy.preAceleracion.dto.response;

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

//    Existen pero no van  //
//    private Set<MovieEntity> movieCharacters = new HashSet();
//
//    private Long idMovie;
}