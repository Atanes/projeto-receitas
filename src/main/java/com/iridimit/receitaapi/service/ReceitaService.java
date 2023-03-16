package com.iridimit.receitaapi.service;

import com.iridimit.receitaapi.error.handler.ReceitaNotFoundException;
import com.iridimit.receitaapi.model.Ingrediente;
import com.iridimit.receitaapi.model.Receita;
import com.iridimit.receitaapi.repository.IngredienteRepository;
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

    @Autowired
    IngredienteRepository ingredienteRepository;

    public List<Receita> listar() {
        return receitaRepository.findAll();
    }

    public Optional<Receita> buscarPorId(Long id) {
        Optional<Receita> receita = receitaRepository.findById(id);
        if (receita.isPresent()) {
            return receita;
        }
        geraReceitaNotFoundException(id);
        return Optional.empty();
    }

    public Receita salvar(Receita receita) {
        receita.setId(null);
        receita.setDataInclusao(new Date());
        Receita novaReceita = receitaRepository.save(receita);
        if(receita.getIngredientes() != null){
            salvarIngredientes(novaReceita, receita.getIngredientes());
        }
        return receitaRepository.save(receita);
    }

    public void salvarIngredientes(Receita receita, List<Ingrediente> ingredientes) {
        ingredientes.forEach(ingrediente -> ingrediente.setReceita(receita));
        ingredienteRepository.saveAll(ingredientes);
    }


    public void atualizar(Long id, Receita receita) {
        if (receitaRepository.findById(id).isEmpty()) {
            geraReceitaNotFoundException(id);
        }
        receita.setId(id);
        receitaRepository.save(receita);
    }

    public void excluir(Long id) {
        if (receitaRepository.findById(id).isEmpty()) {
            geraReceitaNotFoundException(id);
        }
        receitaRepository.deleteById(id);
    }

    public void geraReceitaNotFoundException(Long id) {
        throw new ReceitaNotFoundException("Receita com o id: " + id + " não foi encontrada.");
    }
}
