package com.ranyell.testes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class CadastraArquivoController {

    @PostMapping
    public ResponseEntity<String> findAll(@RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok(file.getOriginalFilename());
    }
}
