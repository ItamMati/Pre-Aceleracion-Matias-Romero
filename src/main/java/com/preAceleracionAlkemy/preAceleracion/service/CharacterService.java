package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDtoResponse;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDto;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.PathVariable;

public interface CharacterService {

//    List<CharacterDto> getCharacterList();
    
//    List<CharacterDto> getCharacterList();

    CharacterDetailsDtoResponse getCharacterDetails(Long id);
    
    CharacterDetailsDto save(CharacterDetailsDto characterDetailsDto);
    
    void deleteCharacterById(Long id);
    
    CharacterDetailsDto editCharacterById(Long id, CharacterDetailsDto charToEdit);
   
    List<CharacterDto> getByFilters(String name, Integer age, Double weight , Set<Long> idMovie);

}
