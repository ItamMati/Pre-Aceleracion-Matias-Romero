package com.preAceleracionAlkemy.preAceleracion.entity;

import java.util.HashSet;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
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
@SQLDelete(sql = "UPDATE characters SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imageUrl;

    private String name;

    private int age;

    private Double weight;

    private String history;

    private boolean deleted = Boolean.FALSE; 

    @ManyToMany(mappedBy = "movieCharacters", cascade = {CascadeType.PERSIST, CascadeType.MERGE})//Por default es LAZY
    private Set<MovieEntity> movieCharacters = new HashSet();

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
