package com.preAceleracionAlkemy.preAceleracion.mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoList;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoMovie;
import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {MovieMapper.class})

public interface CharacterMapper {

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
        @Mapping(source = "characterMovies", target = "characterMovies"),
        @Mapping(source = "idMovie", target = "idMovie")
    })

    CharacterEntity characterDetailsDtoToEntity(CharacterDtoDetails characterDto);

    @InheritInverseConfiguration
    @Named("idMovie")
    @Mapping(target = "idMovie", ignore = true)
    CharacterDtoDetails characterEntityToCharacterDetailsDto(CharacterEntity characterEntity);

//    List<CharacterEntity> listCharacterDetailsDtoToListCharacterEntity(List<CharacterDtoDetails> characterDto);
//
//    @InheritInverseConfiguration
//    List<CharacterDtoDetails> listCharacterEntityToListCharacterDetailsDto(List<CharacterEntity> character);
//    
//        @Mappings({
//        @Mapping(source = "imageUrl", target = "imageUrl"),
//        @Mapping(source = "name", target = "name"),
//        @Mapping(source = "age", target = "age"),
//        @Mapping(source = "weight", target = "weight"),
//        @Mapping(source = "history", target = "history"),
//        @Mapping(source = "characterMovies", target = "characterMovies")
//
//    })
//        
//         CharacterDtoDetails characterEntityToCharacterDetailsDtoResponse(CharacterEntity character);
}
