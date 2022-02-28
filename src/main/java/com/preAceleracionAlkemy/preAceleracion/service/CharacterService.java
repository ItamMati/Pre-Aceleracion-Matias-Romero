package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoEdit;

import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoList;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.PathVariable;

public interface CharacterService {

//    List<CharacterDto> getCharacterList();
//    List<CharacterDto> getCharacterList();
    CharacterDtoDetails getCharacterDetails(Long id);

    CharacterDtoDetails save(CharacterDtoDetails characterDetailsDto);

    void deleteCharacterById(Long id);

    CharacterDtoEdit editCharacterById(Long id, CharacterDtoDetails charToEdit);

    List<CharacterDtoList> getByFilters(String name, Integer age, Double weight, Set<Long> idMovie);

}
