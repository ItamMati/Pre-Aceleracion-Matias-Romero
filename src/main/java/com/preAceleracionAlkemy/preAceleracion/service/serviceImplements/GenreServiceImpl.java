package com.preAceleracionAlkemy.preAceleracion.service.serviceImplements;

import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
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
    
}
