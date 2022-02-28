
package com.preAceleracionAlkemy.preAceleracion.mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.response.GenreDto;
import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
import java.util.Optional;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    
    
     @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "imageUrl", target = "imageUrl")
       
    })
    GenreEntity GenreDtoToGenreEntity(GenreDto genreDeto);
    
    @InheritInverseConfiguration   
    GenreDto GenreEntityToGenreDto(GenreEntity genreEntity);
    
    
    GenreDto GenreOptionalToGenreDto(Optional<GenreEntity> optionalGenre);
    
}
