package com.iridimit.receitaapi.error.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetalhes {
    private String titulo;
    private String detalhesErro;
    private int status;
    private Long timestamp;

}
