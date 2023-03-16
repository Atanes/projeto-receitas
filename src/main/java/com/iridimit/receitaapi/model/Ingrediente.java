package com.iridimit.receitaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receita_id")
    @JsonIgnore
    Receita receita;
    String nome;
    String qtd;
}
