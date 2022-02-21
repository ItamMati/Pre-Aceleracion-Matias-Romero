package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDto;
import java.util.List;
import java.util.Set;

public interface CharacterService {

//    List<CharacterDto> getCharacterList();
    
//    List<CharacterDto> getCharacterList();

    CharacterDetailsDto getCharacterDetails(Long id);
    
    CharacterDetailsDto save(CharacterDetailsDto characterDetailsDto);
    
    void deleteCharacterById(Long id);
    
    CharacterDetailsDto editCharacterById(Long id, CharacterDetailsDto charToEdit);
   
    List<CharacterDto> getByFilters(String name, Integer age, Double weight , Set<Long> idMovie);

}
