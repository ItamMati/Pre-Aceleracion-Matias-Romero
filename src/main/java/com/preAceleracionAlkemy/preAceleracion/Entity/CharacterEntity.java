package com.preAceleracionAlkemy.preAceleracion.entity;

import java.util.HashSet;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "characters")
@Getter
@Setter
@SQLDelete(sql = "UPDATE characters SET deleted = true WHERE id=?")// Se debe declarar para aplicar el SoftDelete
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

    @ManyToMany(mappedBy = "movieCharacters")//Por default es LAZY
    private Set<MovieEntity> movieCharacters = new HashSet();

    private Long idMovie;

    @Override
    public boolean equals(Object object) {

        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        final CharacterEntity other = (CharacterEntity) object;

        return Objects.equals(other.id, this.id);

    }

}
