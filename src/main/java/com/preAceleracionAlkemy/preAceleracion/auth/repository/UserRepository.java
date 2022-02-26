package com.preAceleracionAlkemy.preAceleracion.auth.repository;

import com.preAceleracionAlkemy.preAceleracion.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    
    UserEntity findByUsername(String username);
    
}
