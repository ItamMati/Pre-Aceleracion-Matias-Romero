package com.preAceleracionAlkemy.preAceleracion.mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.request.CharacterDtoReq;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoEdit;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoList;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoRes;
import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MovieMapper.class})

public interface CharacterMapper {

//    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);
//
//    @Mappings({
//        @Mapping(target = "imageUrl", source = "character.imageUrl"),
//        @Mapping(target = "name", source = "character.name"),
//        @Mapping(target = "age", source = "character.age"),
//        @Mapping(target = "weight", source = "character.weight"),
//        @Mapping(target = "history", source = "character.history"),
//        @Mapping(target = "id", source = "character.id"),
//        @Mapping(target = "characterMovies",  ignore = true),
//        @Mapping(target = "idMovie",  ignore = true)
//    })
//    CharacterEntity toDto(CharacterEntity character, CharacterDtoDetails newCharacter);
    @Mappings({
        @Mapping(source = "imageUrl", target = "imageUrl"),
        @Mapping(source = "name", target = "name")
    })
//    CharacterEntity characterDtoToEntity(CharacterDtoList characterDto);
//    @InheritInverseConfiguration
//    CharacterDtoList characterEntityToDto(CharacterEntity characterEntity);
    List<CharacterEntity> listCharacterDtoToListCharacterEntity(List<CharacterDtoList> characterDto);

    @InheritInverseConfiguration
    List<CharacterDtoList> listCharacterEntityToListCharacterDto(List<CharacterEntity> character);

    @Mappings({
        @Mapping(source = "imageUrl", target = "imageUrl"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "age", target = "age"),
        @Mapping(source = "weight", target = "weight"),
        @Mapping(source = "history", target = "history"),
        @Mapping(source = "idMovie", target = "idMovie")})

    CharacterEntity characterDtoReqToEntity(CharacterDtoReq characterDto);

    @InheritInverseConfiguration
    @Mapping(source = "movieCharacters", target = "movieCharacters")
    CharacterDtoRes characterEntityToCharacterDtoRes(CharacterEntity characterEntity);

    /////////////////////////////////////EDIT///////////////////////////////////////////
    CharacterDtoEdit characterEntityToCharacterDtoEdit(CharacterEntity character);

    @InheritInverseConfiguration
    CharacterDtoEdit characterDtoEditoCharacterEntity(CharacterEntity character);

//    List<CharacterEntity> listCharacterDetailsDtoToListCharacterEntity(List<CharacterDtoDetails> characterDto);
//
//    @InheritInverseConfiguration
//    List<CharacterDtoDetails> listCharacterEntityToListCharacterDetailsDto(List<CharacterEntity> character);
//    
}
