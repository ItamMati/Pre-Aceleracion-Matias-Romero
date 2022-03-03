package com.preAceleracionAlkemy.preAceleracion.service;

import com.preAceleracionAlkemy.preAceleracion.dto.request.CharacterDtoReq;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoEdit;

import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoList;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoRes;
import java.util.List;
import java.util.Set;


public interface CharacterService {

//    List<CharacterDto> getCharacterList();
//    List<CharacterDto> getCharacterList();
    CharacterDtoDetails getCharacterDetails(Long id);

   CharacterDtoRes save(CharacterDtoReq characterDtoReq);

    void deleteCharacterById(Long id);

    CharacterDtoEdit editCharacterById(Long id, CharacterDtoDetails charToEdit);

    List<CharacterDtoList> getByFilters(String name, Integer age, Double weight, Set<Long> idMovie);

}
