package com.ranyell.testes.validation.dtos;

import com.ranyell.testes.validation.valid.ValidTotal;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@ValidTotal
public class Order {

    @NotNull
    @NotEmpty
    private List<@Valid ItemProduct> items;

    private @Valid ItemProduct product;

    @Positive
    private Double total;

    @Positive
    @NotNull
    private Integer id;

    @NotBlank
    private String name;
}
