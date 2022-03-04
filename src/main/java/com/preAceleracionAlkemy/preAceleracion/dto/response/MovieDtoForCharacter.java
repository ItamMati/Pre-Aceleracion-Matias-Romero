package com.preAceleracionAlkemy.preAceleracion.dto.response;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MovieDtoForCharacter {
    
    private Long id;
    
    private String image;
    
    private String title;
    
    private LocalDate dateOfCreation;
    
    private String calification; //1 a 5
    
}
