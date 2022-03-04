package com.preAceleracionAlkemy.preAceleracion.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CharacterDtoReq {
    
    @NotNull(message = "El atributo no puede ser null")
    private String imageUrl;
    @NotNull(message = "El atributo no puede ser null")
    private String name;
    @NotNull(message = "El atributo no puede ser null")
    private int age;
    @NotNull(message = "El atributo no puede ser null")
    private Double weight;
    @NotNull(message = "El atributo no puede ser null")
    private String history;
    @NotNull(message = "El atributo no puede ser null")
    @Min(0)
    private Long idMovie;

}
