package com.ranyell.testes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

    @Autowired
    private CepService cepService;

    @Autowired
    private CepsService cepsService;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<Object> getCep(@PathVariable String cep){
        var a = cepsService.getCep(cep);
        System.out.println(a);
        var b = cepService.getCep(cep);
        System.out.println(b);
        return ResponseEntity.ok(b);
    }

}
