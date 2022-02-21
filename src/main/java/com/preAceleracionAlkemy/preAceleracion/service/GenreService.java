
package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
import java.util.Optional;


public interface GenreService {
    
       
    
    public Optional<GenreEntity> findById(Long id);
    
}
