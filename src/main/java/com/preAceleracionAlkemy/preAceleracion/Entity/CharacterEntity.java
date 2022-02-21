package com.preAceleracionAlkemy.preAceleracion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "characters")
@Getter
@Setter
@SQLDelete(sql = "UPDATE movies SET deleted = true WHERE id=?")// Se debe declarar para aplicar el SoftDelete
@Where(clause = "deleted=false")// Esta etiqueta sirve para que no liste los objetos a los cuales se les aplico el softDelete
public class CharacterEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imageUrl;

    private String name;

    private int age;

    private Double weight;

    private String history;
    
    private boolean deleted = Boolean.FALSE; //atributo que se agrega para trabajar con el softDelete

    //OneToMany: Peliculas
    @ManyToMany(mappedBy = "movieCharacters", cascade = CascadeType.ALL)//Por default es LAZY
    @JsonIgnore
    private Set<MovieEntity> characterMovies = new HashSet();
    
  
     
       
}
