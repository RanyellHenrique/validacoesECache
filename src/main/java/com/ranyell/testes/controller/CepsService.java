package com.ranyell.testes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CepsService {

    @Autowired
    private CepClient cepClient;

    @Cacheable(value = "cep", key = "#cep")
    public Endereco getCep(String cep){
        System.out.println("Passei cep");
        return cepClient.getCep(cep);
    }
}
