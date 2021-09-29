package com.ranyell.testes.validation.controllers;

import com.ranyell.testes.validation.dtos.FieldErros;
import com.ranyell.testes.validation.utils.OrderErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(getErros(e));
    }


    private List<FieldErros> getErros(MethodArgumentNotValidException e) {
        return e.getFieldErrors().stream()
                .map(getFieldErrorFieldErrosFunction())
                .collect(Collectors.toList());
    }

    private Function<FieldError, FieldErros> getFieldErrorFieldErrosFunction() {
        return it -> new FieldErros(it.getField(), it.getDefaultMessage(), it.getRejectedValue());
    }

    @ExceptionHandler(OrderErrors.class)
    public ResponseEntity<List<FieldErros>> validationException(OrderErrors e) {
        return ResponseEntity.badRequest().body(e.getFieldErros());
    }
}
