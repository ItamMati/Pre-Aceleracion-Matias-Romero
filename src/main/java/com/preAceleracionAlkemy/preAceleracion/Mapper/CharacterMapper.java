package com.preAceleracionAlkemy.preAceleracion.mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDtoResponse;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDto;
import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses={MovieMapper.class})
public interface CharacterMapper {

    @Mappings({
        @Mapping(source = "imageUrl", target = "imageUrl"),
        @Mapping(source = "name", target = "name")

    })
    CharacterEntity characterDtoToEntity(CharacterDto characterDto);

    @InheritInverseConfiguration
    CharacterDto characterEntityToDto(CharacterEntity characterEntity);

    List<CharacterEntity> listCharacterDtoToListCharacterEntity(List<CharacterDto> characterDto);

    @InheritInverseConfiguration
    List<CharacterDto> listCharacterEntityToListCharacterDto(List<CharacterEntity> character);

    @Mappings({
        @Mapping(source = "imageUrl", target = "imageUrl"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "age", target = "age"),
        @Mapping(source = "weight", target = "weight"),
        @Mapping(source = "history", target = "history"),
        @Mapping(source = "characterMovies", target = "characterMovies")

    })

    CharacterEntity characterDetailsDtoToEntity(CharacterDetailsDto characterDto);

    @InheritInverseConfiguration
    CharacterDetailsDto characterEntityToCharacterDetailsDto(CharacterEntity characterEntity);

    List<CharacterEntity> listCharacterDetailsDtoToListCharacterEntity(List<CharacterDetailsDto> characterDto);

    @InheritInverseConfiguration
    List<CharacterDetailsDto> listCharacterEntityToListCharacterDetailsDto(List<CharacterEntity> character);

    
    
        @Mappings({
        @Mapping(source = "imageUrl", target = "imageUrl"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "age", target = "age"),
        @Mapping(source = "weight", target = "weight"),
        @Mapping(source = "history", target = "history"),
        @Mapping(source = "characterMovies", target = "characterMovies")

    })
        
         CharacterDetailsDtoResponse characterEntityToCharacterDetailsDtoResponse(CharacterEntity character);
}
