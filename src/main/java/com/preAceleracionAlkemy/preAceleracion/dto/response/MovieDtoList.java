package com.preAceleracionAlkemy.preAceleracion.dto.response;

import com.preAceleracionAlkemy.preAceleracion.entity.GenreEntity;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter

public class MovieDtoList {

    private String image;
    private String title;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfCreation;

}
