package com.ranyell.testes.validation.controllers;

import com.ranyell.testes.validation.dtos.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos/cadastra_lista")
public class CadastrarListaProdutosController {


    @PostMapping
    public ResponseEntity<?> cadastrarListaDeProdutos(@Valid @RequestBody Order produtos) {

        return ResponseEntity.ok(produtos.toString());
    }
}
