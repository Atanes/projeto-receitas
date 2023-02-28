package com.iridimit.receitaapi.controller;

import com.iridimit.receitaapi.model.Receita;
import com.iridimit.receitaapi.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {

    @Autowired
    ReceitaRepository receitaRepository;

    @GetMapping
    public List<Receita> listarReceitas(){
        return receitaRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscaReceita(@PathVariable ("id") Long id){
        Optional<Receita> receita = receitaRepository.findById(id);
        if(receita.isPresent()){
            return ResponseEntity.ok().body(receita);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita com o id: " + id + " não foi encontrada na base de dados!");
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> excluirReceita(@PathVariable ("id") Long id){
        try{
            receitaRepository.deleteById(id);
            return ResponseEntity.ok().body("Receita excluida com sucesso!!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("registro inexistente!!");
        }

    }


}
