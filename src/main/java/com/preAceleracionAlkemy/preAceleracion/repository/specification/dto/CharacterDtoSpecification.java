package com.preAceleracionAlkemy.preAceleracion.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterFilterDto {
    
    private String name;
    private Integer age;
    private Double weight;
    private Set<Long> movies;

    public CharacterFilterDto() {
    }

    public CharacterFilterDto(String name, Integer age, Double weight, Set<Long> movies) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
    }

   
    
    
    
    
    
    
}
