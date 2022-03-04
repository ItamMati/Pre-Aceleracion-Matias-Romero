
package com.preAceleracionAlkemy.preAceleracion.mapper;

import com.preAceleracionAlkemy.preAceleracion.dto.response.GenreDto;
import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
import java.util.Optional;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface GenreMapper {
    

    GenreEntity GenreDtoToGenreEntity(GenreDto genreDeto);
    
    @InheritInverseConfiguration   
    GenreDto GenreEntityToGenreDto(GenreEntity genreEntity);
    
    
    GenreDto GenreOptionalToGenreDto(Optional<GenreEntity> optionalGenre);
    
}
