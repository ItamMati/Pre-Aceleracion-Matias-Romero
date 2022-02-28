package com.preAceleracionAlkemy.preAceleracion.dto.response;

import java.util.HashSet;
import java.util.Set;
import lombok.*;


@Getter
@Setter
public class CharacterDtoDetails {
    

    private Long id;

    private String imageUrl;

    private String name;

    private int age;

    private Double weight;

    private String history;
    
    private Set<MovieDtoCharacter> characterMovies = new HashSet();
    
    private Long idMovie;
    
    
}
