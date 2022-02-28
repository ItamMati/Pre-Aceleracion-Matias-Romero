package com.preAceleracionAlkemy.preAceleracion.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovieDtoDetails {

    private Long id;
    @NotEmpty 
    private String image;
    @Size(min=2, max=30)
    @NotNull
    private String title;
    @NotNull
    private LocalDate dateOfCreation;
    @NotNull @Min(1) @Max(5)
    private String calification; //1 a 5
    private Set<CharacterDtoMovie> movieCharacters;

}
