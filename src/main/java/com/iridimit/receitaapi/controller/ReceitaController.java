package com.iridimit.receitaapi.controller;

import com.iridimit.receitaapi.model.Receita;
import com.iridimit.receitaapi.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {

    @Autowired
    ReceitaRepository receitaRepository;

    @GetMapping
    public List<Receita> listarReceitas(){
        return receitaRepository.findAll();
    }

    @PostMapping
    public Receita salvarReceita(@RequestBody Receita receita){
        receita.setDataInclusao(new Date());
        return receitaRepository.save(receita);
    }

    @PutMapping(value = "/{id}")
    public Receita atualizarReceita(@PathVariable ("id") Long id, @RequestBody Receita receita){
        receita.setId(id);
        return receitaRepository.save(receita);
    }

}
