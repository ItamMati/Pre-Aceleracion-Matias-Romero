package com.preAceleracionAlkemy.preAceleracion.dto.request;

import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoForMovie;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter

public class MovieGenreDtoReq {

    @NotEmpty
    @NotNull
    private String image;

    @Size(min = 2, max = 30)
    @NotNull
    private String title;

    @NotNull
    @DateTimeFormat(style="yyyy/MM/dd")
    private LocalDate dateOfCreation;

    @NotNull
    @Min(1)
    @Max(5)
    @NotEmpty
    private String calification; //1 a 5

    @NotNull(message = "Debe asociar la pelicula a un genero")
    private Long genreId;

//    private Set<CharacterDtoForMovie> characters;

}
