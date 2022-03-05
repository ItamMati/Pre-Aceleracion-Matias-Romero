package com.preAceleracionAlkemy.preAceleracion.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE movies SET deleted = true WHERE id_movies=?")
@Where(clause = "deleted=false")
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_movies")
    Long id;
    private String image;
    private String title;
    @Column(name = "date_of_creation")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfCreation;
    private String calification; //1 a 5

    private boolean deleted = Boolean.FALSE; 


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})


    @JoinTable(
            name = "movies_characters",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_character"))
    private Set<CharacterEntity> movieCharacters;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "genreId", insertable = false, updatable = false)
    private GenreEntity movieGenres;

    private Long genreId;

    @Override
    public boolean equals(Object object) {

        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        final MovieEntity other = (MovieEntity) object;

        return Objects.equals(other.id, this.id);

    }

    public void addCharacterToMovie(CharacterEntity charToBeAdded) {
        this.movieCharacters.add(charToBeAdded);
    }

    public void removeCharacterFromMovie(CharacterEntity charToBeRemoved) {
        this.movieCharacters.remove(charToBeRemoved);
    }

}

