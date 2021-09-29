package com.ranyell.testes.validation.controllers;

import com.ranyell.testes.validation.dtos.FieldErros;
import com.ranyell.testes.validation.dtos.Orders;
import com.ranyell.testes.validation.utils.OrderErrors;
import com.ranyell.testes.validation.valid.ValidationOrder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class CadastraOrdersController {

    private final ValidationOrder validation;

    @PostMapping
    public ResponseEntity<?> cadastrarListaDeProdutos(@RequestBody Orders orders) {
        validation(orders);
        return ResponseEntity.ok(orders.toString());
    }


    private void validation(Orders orders) {
        List<FieldErros> errors = getListErros(orders);
        if(!errors.isEmpty()) {
            throw new OrderErrors(errors);
        }
    }


    private List<FieldErros> getListErros(Orders orders) {
        return orders.getOrders().stream()
                .map(validation::validation)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
