package com.preAceleracionAlkemy.preAceleracion.mapper.Impl;

import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoEdit;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoList;
import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import com.preAceleracionAlkemy.preAceleracion.mapper.CharacterMapper;
import java.util.List;


public class CharacterMapperImpl implements CharacterMapper {

    @Override
    public List<CharacterEntity> listCharacterDtoToListCharacterEntity(List<CharacterDtoList> characterDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CharacterDtoList> listCharacterEntityToListCharacterDto(List<CharacterEntity> character) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CharacterEntity characterDetailsDtoToEntity(CharacterDtoDetails characterDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CharacterDtoDetails characterEntityToCharacterDetailsDto(CharacterEntity characterEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CharacterDtoEdit characterEntityToCharacterDtoEdit(CharacterEntity character) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CharacterDtoEdit characterDtoEditoCharacterEntity(CharacterEntity character) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CharacterEntity toDto(CharacterEntity character, CharacterDtoDetails newCharacter) {
       
        character.setAge(newCharacter.getAge());
        character.setName(newCharacter.getName());
        character.setHistory(newCharacter.getHistory());
        character.setImageUrl(newCharacter.getImageUrl());
        character.setWeight(newCharacter.getWeight());
        
        return character;
    }


    
}
