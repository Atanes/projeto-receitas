package com.iridimit.receitaapi.controller;

import com.iridimit.receitaapi.model.Receita;
import com.iridimit.receitaapi.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<List<Receita>> listarReceitas() {
        return ResponseEntity.ok().body(receitaService.listar());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscaReceita(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(receitaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> salvarReceita(@RequestBody Receita receita) {
        receita = receitaService.salvar(receita);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(receita.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> atualizarReceita(@PathVariable("id") Long id, @RequestBody Receita receita) {
            receitaService.atualizar(id, receita);
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> excluirReceita(@PathVariable("id") Long id) {
            receitaService.excluir(id);
            return ResponseEntity.noContent().build();
    }
}
