/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preAceleracionAlkemy.preAceleracion.dto;

import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDetailsDtoResponse {
    
    
    private Long id;

    private String imageUrl;

    private String name;

    private int age;

    private Double weight;

    private String history;

   
    private Set<MovieEntity> characterMovies;
    
}
