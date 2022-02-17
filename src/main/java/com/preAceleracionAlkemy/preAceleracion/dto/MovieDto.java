package com.preAceleracionAlkemy.preAceleracion.dto;

import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class MovieDto {

    private Long id;
    private String imagen;
    private String titulo;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaDeCreacion;
    private String calificacion; //1 a 5
  

}
