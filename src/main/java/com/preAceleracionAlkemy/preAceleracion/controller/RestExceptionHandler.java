package com.preAceleracionAlkemy.preAceleracion.controller;

import com.preAceleracionAlkemy.preAceleracion.dto.response.ApiErrorDto;
import com.preAceleracionAlkemy.preAceleracion.exception.ParamNotFound;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ParamNotFound.class})
    protected ResponseEntity<Object> handleParamNotFound(RuntimeException ex, WebRequest request) {

        ApiErrorDto errorDto = new ApiErrorDto(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                Arrays.asList("Param Not Found")
        );

        return handleExceptionInternal(ex, errorDto, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {

            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        ApiErrorDto apiError = new ApiErrorDto(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);

        return handleExceptionInternal(
                ex, apiError, headers, apiError.getStatus(), request);

    }
}


//Hace un buen uso de la nueva respuesta RESTful ResposeEntity.
//Una cosa a tener en cuenta aquí es hacer coincidir las excepciones declaradas 
//con @ExceptionHandler con la excepción utilizada como argumento del método.