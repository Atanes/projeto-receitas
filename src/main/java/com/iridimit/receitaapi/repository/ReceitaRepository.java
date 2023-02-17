package com.iridimit.receitaapi.repository;

import com.iridimit.receitaapi.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
