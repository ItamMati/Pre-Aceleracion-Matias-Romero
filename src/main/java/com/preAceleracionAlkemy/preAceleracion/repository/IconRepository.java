package com.preAceleracionAlkemy.preAceleracion.repository;

import com.preAceleracionAlkemy.preAceleracion.Entity.ContinentEntity;
import com.preAceleracionAlkemy.preAceleracion.Entity.IconEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long>{
    
    
    
}
