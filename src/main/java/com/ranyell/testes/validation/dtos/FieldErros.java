package com.ranyell.testes.validation.dtos;

import lombok.Data;

@Data
public class FieldErros {

    private String field;
    private String erro;
    private String currentValue;
    private Integer id;
    private String name;

    public FieldErros(String field, String defaultMessage, Object rejectedValue) {
        this.field = field;
        this.erro = defaultMessage;
        this.currentValue = String.valueOf(rejectedValue);
    }

    public FieldErros(String field, String defaultMessage, Object rejectedValue, Integer id, String name) {
        this.field = field;
        this.erro = defaultMessage;
        this.currentValue = String.valueOf(rejectedValue);
        this.id = id;
        this.name = name;
    }
}
