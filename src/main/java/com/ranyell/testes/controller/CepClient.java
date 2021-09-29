package com.ranyell.testes.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cep-test", url = "https://viacep.com.br/ws")
public interface CepClient {

    @GetMapping("/{cep}/json")
    public Endereco getCep(@PathVariable String cep);
}
