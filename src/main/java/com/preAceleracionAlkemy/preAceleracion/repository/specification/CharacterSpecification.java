package com.preAceleracionAlkemy.preAceleracion.repository.specification;

import com.preAceleracionAlkemy.preAceleracion.repository.specification.dto.CharacterDtoSpecification;
import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CharacterSpecification {

    public Specification<CharacterEntity> getByName(CharacterDtoSpecification characterFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (characterFilterDto.getName() == null) {

                return criteriaBuilder.conjunction();

            }

            return criteriaBuilder.like(root.get("name"), "%" + characterFilterDto.getName() + "%");

        };

    }

    public Specification<CharacterEntity> getByAge(CharacterDtoSpecification characterFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (characterFilterDto.getAge() == null) {

                return criteriaBuilder.conjunction();

            }
            return criteriaBuilder.equal(root.get("age"), characterFilterDto.getAge());

        };

    }

    public Specification<CharacterEntity> getByWeight(CharacterDtoSpecification characterFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (characterFilterDto.getWeight() == null) {

                return criteriaBuilder.conjunction();

            }

            return criteriaBuilder.equal(root.get("weight"), characterFilterDto.getWeight());

        };

    }

    public Specification<CharacterEntity> getByMovieId(CharacterDtoSpecification characterFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (characterFilterDto.getMovies() == null) {

                return criteriaBuilder.conjunction();

            }

            Join<MovieEntity, CharacterEntity> join = root.join("movies", JoinType.INNER);
            Expression<String> idMovies = join.get("id");
            return idMovies.in(characterFilterDto.getMovies());

//            return criteriaBuilder.like(characterEntity.getCharacterMovies(), movieFilterDto.getGenre());
        };

    }

}
