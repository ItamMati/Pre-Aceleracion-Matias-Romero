package com.preAceleracionAlkemy.preAceleracion.mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.request.CharacterDtoReq;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoEdit;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoForMovie;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoList;

import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoRes;
import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import java.util.List;
import java.util.Set;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {MovieMapper.class})
public interface CharacterMapper {
    
    
    List<CharacterDtoList> characterEntityToCharacterDtoList(List<CharacterEntity> characterEntity);

    ///////////////////////////////////////EDIT///////////////////////////////////////////
    @Mapping(source = "charToEdit.imageUrl", target = "imageUrl")
    @Mapping(source = "charToEdit.name", target = "name")
    @Mapping(source = "charToEdit.age", target = "age")
    @Mapping(source = "charToEdit.weight", target = "weight")
    @Mapping(source = "charToEdit.history", target = "history")
    @Mapping(target = "id", ignore = true)
    CharacterEntity characterDtoEdiToCharacterEntity(@MappingTarget CharacterEntity characterEntity, CharacterDtoDetails charToEdit);

    @InheritInverseConfiguration
    CharacterDtoEdit characterEntityToCharacterDtoEdit(CharacterEntity character);
 ///////////////////////////////////////EDIT///////////////////////////////////////////
    
     ///////////////////////////////////////REQUEST///////////////////////////////////////////
    CharacterEntity characterDtoReqToEntity(CharacterDtoReq characterDto);
    ///////////////////////////////////////REQUEST///////////////////////////////////////////
    @InheritInverseConfiguration
    CharacterDtoRes characterEntityToCharacterDtoRes(CharacterEntity characterEntity);
    
    

    Set<CharacterEntity> characterDtoForMovieToEntityCharacter(Set<CharacterDtoForMovie> characterDto);

    CharacterDtoDetails characterEntityToCharacterDtoDetails(CharacterEntity characterEntity);
    
    
     ///////////////////////////////////////lIST///////////////////////////////////////////
    
   
}




