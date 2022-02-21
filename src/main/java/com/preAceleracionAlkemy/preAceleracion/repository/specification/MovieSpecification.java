package com.preAceleracionAlkemy.preAceleracion.repository.specification;

import com.preAceleracionAlkemy.preAceleracion.dto.MovieFilterDto;
import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import javax.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MovieSpecification {

    public Specification<MovieEntity> getByTitle(MovieFilterDto movieFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (movieFilterDto.getTitle() == null) {

                return criteriaBuilder.conjunction();

            }

            return criteriaBuilder.like(root.get("title"), "%" + movieFilterDto.getTitle() + "%");

        };

    }

    public Specification<MovieEntity> getByGenre(MovieFilterDto movieFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (movieFilterDto.getGenre() == null) {

                return criteriaBuilder.conjunction();

            }

            Join<MovieEntity, GenreEntity> genreMovie = root.join("movieGenres");

            return criteriaBuilder.like(genreMovie.get("name"), movieFilterDto.getGenre());

        };

    }

    public Specification<MovieEntity> getByDate(MovieFilterDto movieFilterDto) {

        return (root, query, criteriaBuilder) -> {

            if (movieFilterDto.getFechaDeCreacion() == null) {

                return criteriaBuilder.conjunction();

            }

            return criteriaBuilder.like(root.get("dateOfCreation"), "%" + movieFilterDto.getFechaDeCreacion() + "%");

        };

    }

    public Specification<MovieEntity> getByOrder(MovieFilterDto movieFilterDto) {

        String orderByField = "dateOfCreation";

        return (root, query, criteriaBuilder) -> {

            if (movieFilterDto == null) {

                return criteriaBuilder.conjunction();

            }
            query.orderBy(movieFilterDto.isASC() ? criteriaBuilder.asc(root.get(orderByField)) : criteriaBuilder.desc(root.get(orderByField)));

            return null;

        };

    }
}
