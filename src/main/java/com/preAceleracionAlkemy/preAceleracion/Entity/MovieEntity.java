package com.preAceleracionAlkemy.preAceleracion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

//////////CHALLENGE A ENTREGAR 
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE movies SET deleted = true WHERE id_movies=?")// Se debe declarar para aplicar el SoftDelete
@Where(clause = "deleted=false")// Esta etiqueta sirve para que no liste los objetos a los cuales se les aplico el softDelete
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_movies")
    private Long id;
    private String image;
    private String title;
    @Column(name = "date_of_creation")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfCreation;
    private String calification; //1 a 5

    private boolean deleted = Boolean.FALSE; //atributo que se agrega para trabajar con el softDelete

    @Column(name = "character_id")
    @ManyToMany(// Una pelicula tiene muchos actores, y un actor está en muchas peliculas.
            cascade = {
                CascadeType.PERSIST,// Hace que la persitencia sea tanto de la duena como de las hijas.
                //                                       Si persiste las peliculas, persiste a los personajes.
                CascadeType.MERGE,}//Entiendo que actualiza los estados de los atributos de la tabla, en donde este se repite,
    //                                      y los devuelve siempre y cuando existan.  
    //                                      Y sino existe, los crea y entiendo que devuelve.  
    )// Carga perezosa, la carga solo cuando es requerida/Por default un ManyToMany es LAZY, no haria falta en este caso

//      Personaliza la creacion de la tabla intermedia.
    @JoinTable(
            name = "movies_characters",// Define el nombre de la tabla
            joinColumns = @JoinColumn(name = "id_movie"),// El id que relaciona a entidad en la que estamos con la tabla
            inverseJoinColumns = @JoinColumn(name = "id_character"))//El id que relaciona a la otra entidad con la tabla
    @JsonIgnore
    private Set<CharacterEntity> movieCharacters;// Este atributo es el que le indica con que tabla es la relacion.

    @ManyToOne(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE,})//Por defecto la carga es Eager, no hace falta colocarla al no ser tantos generos lo que existen.
    @JoinColumn(name = "genreId", insertable = false, updatable = false)//La tabla movie va a tener una FK "genre_id:" por eso en está relación es la dueña.

    private GenreEntity movieGenres;

    @Column(name = "genreId", nullable = false)
    private Long genreId;

    // :::: Methods ::::	
    // Characters:
    public void addCharacterToMovie(CharacterEntity charToBeAdded) {
        this.movieCharacters.add(charToBeAdded);
    }

    public void removeCharacterFromMovie(CharacterEntity charToBeRemoved) {
        this.movieCharacters.remove(charToBeRemoved);
    }

}

//}
////APUNTES////
//CascadeType.PERSIST: Cuando una entidad es persistida, su entidad relacionada debe ser persistida también. 
//
//CascadeType.REMOVE: Cuando una entidad es removida, su entidad relacionada debe ser removida también. 
//
//CascadeType.REFRESH: Cuando una entidad es refrescada, su entidad relacionada debe ser refrescada también. 
//
//CascadeType.MERGE: Cuando una entidad es actualizada, su entidad relacionada debe ser actualizada también. 
//
//*Encuentre un objeto adjunto con la misma identificación y actualícelo.
//-->Si existe, actualice y devuelva el objeto ya adjunto.
//-->Si no existe inserte el nuevo registro en la base de datos.
////
//CascadeType.ALL: Cuando una entidad es persistida, removida, refrescada o actualizada,
//su entidad relacionada debe ser persistida, removida, refrescada o actualizada también. 

