package com.fernando.redesolidaria.handler;

import com.fernando.redesolidaria.exception.AcessoNegadoException;
import com.fernando.redesolidaria.exception.EmailJaCadastradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErroResponse> tratarAutenticacao(RuntimeException ex, HttpServletRequest request) {
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<ErroResponse> tratarEmailDuplicado(RuntimeException ex, HttpServletRequest request) {
        return buildErrorResponse(HttpStatus.CONFLICT, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(AcessoNegadoException.class)
    public ResponseEntity<ErroResponse> tratarAcessoNegado(RuntimeException ex, HttpServletRequest request) {
        return buildErrorResponse(HttpStatus.FORBIDDEN, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErroResponse> tratarAcessoNegadoSecurity(RuntimeException ex, HttpServletRequest request){
        return buildErrorResponse(HttpStatus.FORBIDDEN, ex.getMessage(), request.getRequestURI());
    }

    private ResponseEntity<ErroResponse> buildErrorResponse(HttpStatus status, String message, String path) {
        ErroResponse erroResponse = new ErroResponse(
                status.getReasonPhrase(),
                message,
                status.value(),
                LocalDateTime.now(),
                path);

        return ResponseEntity.status(status).body(erroResponse);
    }
}
