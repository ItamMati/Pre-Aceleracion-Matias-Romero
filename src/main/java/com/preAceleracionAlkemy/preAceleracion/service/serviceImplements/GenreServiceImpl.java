package com.preAceleracionAlkemy.preAceleracion.service.serviceImplements;

import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
import com.preAceleracionAlkemy.preAceleracion.exception.ParamNotFound;
import com.preAceleracionAlkemy.preAceleracion.repository.GenreRepository;
import com.preAceleracionAlkemy.preAceleracion.service.GenreService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {
    
    @Autowired
    private GenreRepository genreRepository;
    
    
    @Override
    public Optional<GenreEntity> findById(Long id){
        
        
        return genreRepository.findById(id);
    }
    
     public GenreEntity handleFindById(Long id) {
        Optional<GenreEntity> toBeFound = genreRepository.findById(id);
        if (!toBeFound.isPresent()) {
            throw new ParamNotFound("No Character for id: " + id);
        }
        return toBeFound.get();
    }
    
}
