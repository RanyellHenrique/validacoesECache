package com.ranyell.testes.validation.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ItemProduct {

    @PositiveOrZero
    @NotNull
    private Double price;
    @NotNull
    @Positive
    private Integer quantity;
    @NotBlank
    private String name;
}
