package com.preAceleracionAlkemy.preAceleracion.repository;

import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>, JpaSpecificationExecutor<MovieEntity> {
    
    List<MovieEntity> findAll(Specification<MovieEntity> spec);
    
}
