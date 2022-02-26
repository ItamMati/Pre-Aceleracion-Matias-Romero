package com.preAceleracionAlkemy.preAceleracion.dto;

import java.time.LocalDate;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class MovieDetailsDtoResponse {

    private Long id;
    private String image;
    private String title;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfCreation;
    private String calification; //1 a 5
     private Set<CharacterDetailsDto> movieCharacters;

}
