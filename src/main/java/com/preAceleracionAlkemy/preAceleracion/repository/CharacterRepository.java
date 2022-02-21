package com.preAceleracionAlkemy.preAceleracion.repository;

import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long>{
    
}
