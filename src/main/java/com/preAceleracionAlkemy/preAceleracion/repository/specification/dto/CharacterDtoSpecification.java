package com.preAceleracionAlkemy.preAceleracion.repository.specification.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDtoSpecification {
    
    private String name;
    private Integer age;
    private Double weight;
    private Set<Long> movies;

    public CharacterDtoSpecification() {
    }

    public CharacterDtoSpecification(String name, Integer age, Double weight, Set<Long> movies) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
    }

   
    
    
    
    
    
    
}
