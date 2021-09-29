package com.ranyell.testes.validation.controllers;

import com.ranyell.testes.validation.dtos.ItemProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class CadastraProdutoController {

    @GetMapping
    public ResponseEntity<String> findAll(ItemProduct item) {
        return ResponseEntity.ok(item.toString());
    }
}
