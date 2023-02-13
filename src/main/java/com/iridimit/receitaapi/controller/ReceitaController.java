package com.iridimit.receitaapi.controller;

import com.iridimit.receitaapi.model.Receita;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {

    @GetMapping
    public List<Receita> listarReceitas(){
        Receita receita1 = new Receita(1L, new Date(), "Bolo de fubá");
        Receita receita2 = new Receita(2L, new Date(), "Feijão de Corda");
        receita1.setAutor("Atanes");
        receita2.setAutor("Atanes");
        List<Receita> listagemGeral = new ArrayList<>();
        listagemGeral.add(receita1);
        listagemGeral.add(receita2);
        return listagemGeral;
    }

    @GetMapping(value = "/uma-receita")
    public ResponseEntity<String> getReceita(){
        return ResponseEntity.ok("Lista uma unica receita!!!!!!");
    }
}
