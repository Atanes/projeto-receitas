package com.iridimit.receitaapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receita {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descricao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataInclusao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String autor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String modoDePreparo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Ingrediente> ingredientes;

    public Receita(long id, Date dataInclusao, String nomeReceita) {
        this.id = id;
        this.dataInclusao = dataInclusao;
        this.nome = nomeReceita;
    }


}
