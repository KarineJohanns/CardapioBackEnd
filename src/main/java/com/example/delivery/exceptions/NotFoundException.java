package com.example.delivery.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entidade, String mensagem) {
        super(entidade + " não encontrada. " + mensagem);
    }
}
