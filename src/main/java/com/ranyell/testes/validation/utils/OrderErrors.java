package com.ranyell.testes.validation.utils;

import com.ranyell.testes.validation.dtos.FieldErros;
import lombok.Getter;

import java.util.List;


@Getter
public class OrderErrors extends RuntimeException{

    private final List<FieldErros> fieldErros;

    public OrderErrors(List<FieldErros> fieldErros) {
        super();
        this.fieldErros = fieldErros;
    }

}
