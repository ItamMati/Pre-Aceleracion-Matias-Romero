package com.preAceleracionAlkemy.preAceleracion.repository.specification;

import com.preAceleracionAlkemy.preAceleracion.dto.CharacterFilterDto;
import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CharacterSpecification {

    public Specification<CharacterEntity> getByName(CharacterFilterDto characterFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (characterFilterDto.getName() == null) {

                return criteriaBuilder.conjunction();

            }

            return criteriaBuilder.like(root.get("name"), "%" + characterFilterDto.getName() + "%");

        };

    }

    public Specification<CharacterEntity> getByAge(CharacterFilterDto characterFilterDto) {//DEBO INTENTAR ENCONTRAR COMO UNIR DOS TABLAS DENTRO DE LAS ESPECIFICACIONES

        return (root, query, criteriaBuilder) -> {

            if (characterFilterDto.getAge() == null) {

                return criteriaBuilder.conjunction();

            }
            return criteriaBuilder.equal(root.get("age"), characterFilterDto.getAge());

        };

    }

    public Specification<CharacterEntity> getByWeight(CharacterFilterDto characterFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (characterFilterDto.getWeight() == null) {

                return criteriaBuilder.conjunction();

            }

            return criteriaBuilder.equal(root.get("weight"), characterFilterDto.getWeight());

        };

    }

    public Specification<CharacterEntity> getByMovieId(CharacterFilterDto characterFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (characterFilterDto.getMovies().isEmpty()) {

                return criteriaBuilder.conjunction();

            }

            Join<MovieEntity, CharacterEntity> join = root.join("movies", JoinType.INNER);
            Expression<String> idMovies = join.get("id");
            return idMovies.in(characterFilterDto.getMovies());

//            return criteriaBuilder.like(characterEntity.getCharacterMovies(), movieFilterDto.getGenre());
        };

    }

}
