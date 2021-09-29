package com.ranyell.testes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private CepClient cepClient;

    @Cacheable(value = "ceps", key = "#cep_id")
    public Endereco getCep(String cep_id) {
        System.out.println("Passei aqui (ceps)");
        return cepClient.getCep(cep_id);
    }
}
