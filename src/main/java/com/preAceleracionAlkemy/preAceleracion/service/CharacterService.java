package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDto;
import java.util.List;
import java.util.Set;

public interface CharacterService {

    List<CharacterDto> getCharacterList();

    CharacterDto getCharacterDetails(Long id);
    
    CharacterDto saveNewCharacter(CharacterDto characterDto);
    
    void deleteCharacterById(Long id);
    
    CharacterDetailsDto editCharacterById(Long id, CharacterDetailsDto charToEdit);
   
//    List<CharacterDto> getByFilters(String name, Integer age, Set<Long> movies);

}
