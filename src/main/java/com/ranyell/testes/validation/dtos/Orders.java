package com.ranyell.testes.validation.dtos;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class Orders {

    private List<@Valid Order> orders;
}
