package com.fernando.redesolidaria.exception;

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException(String message) {
        super("Email já cadastrado");
    }
}
