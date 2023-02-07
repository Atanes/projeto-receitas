package com.iridimit.receitaapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/receita-api")
public class ReceitaController {

    @GetMapping(value = "/listar")
    public ResponseEntity<String> listarReceitas(){
        return ResponseEntity.ok("Listagem de receitas");
    }

    @GetMapping(value = "/uma-receita")
    public ResponseEntity<String> getReceita(){
        return ResponseEntity.ok("Lista uma unica receita!!!!!!");
    }
}
