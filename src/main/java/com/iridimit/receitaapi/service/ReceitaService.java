package com.iridimit.receitaapi.service;

import com.iridimit.receitaapi.model.Receita;
import com.iridimit.receitaapi.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {
    @Autowired
    ReceitaRepository receitaRepository;

    public List<Receita> listar(){
        return receitaRepository.findAll();
    }

    public Optional<Receita> buscarPorId(Long id){
        Optional<Receita> receita = receitaRepository.findById(id);
        if(receita.isPresent()){
            return receita;
        }
        throw new RuntimeException("Receita com o id: " + id + " não foi encontrada.");
    }

    public Receita salvar(Receita receita){
        receita.setId(null);
        receita.setDataInclusao(new Date());
        return receitaRepository.save(receita);
    }

    public void atualizar(Long id, Receita receita){
        if(receitaRepository.findById(id).isEmpty()){
            throw new RuntimeException("Receita com o id: " + id + " não foi encontrada.");
        }
        receita.setId(id);
        receitaRepository.save(receita);
    }
    public void excluir(Long id){
        if(receitaRepository.findById(id).isEmpty()){
            throw new RuntimeException("Receita com o id: " + id + " não foi encontrada.");
        }
        receitaRepository.deleteById(id);
    }
}
