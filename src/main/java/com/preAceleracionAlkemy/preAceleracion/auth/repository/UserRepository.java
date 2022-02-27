package com.preAceleracionAlkemy.preAceleracion.auth.repository;

import com.preAceleracionAlkemy.preAceleracion.auth.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    
    Optional<UserEntity> findByUsername(String username);
    
}
