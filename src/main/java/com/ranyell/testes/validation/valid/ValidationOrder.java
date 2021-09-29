package com.ranyell.testes.validation.valid;


import com.ranyell.testes.validation.dtos.FieldErros;
import com.ranyell.testes.validation.dtos.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ValidationOrder {

    private final Validator validator;

    public List<FieldErros> validation(Order order) {
       return validator.validate(order)
               .stream()
               .map(it -> getFieldErros(it, order))
               .collect(Collectors.toList());
    }

    private FieldErros getFieldErros(ConstraintViolation<Order> error, Order order) {
        return new FieldErros(getCampo(error.getPropertyPath().toString()), error.getMessage(), error.getInvalidValue(),order.getId(), order.getName());
    }

    private String getCampo(String field) {
        return Arrays.stream(field.split("]."))
                .reduce((first, second) -> second).orElse(field);
    }
}
