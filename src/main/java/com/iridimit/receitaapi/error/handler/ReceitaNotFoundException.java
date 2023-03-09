package com.iridimit.receitaapi.error.handler;

public class ReceitaNotFoundException extends RuntimeException {
    public ReceitaNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ReceitaNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
