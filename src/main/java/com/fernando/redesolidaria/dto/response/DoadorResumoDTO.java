package com.fernando.redesolidaria.dto.response;

// Visão pública do doador dentro de um item: sem e-mail, telefone nem documento.
public record DoadorResumoDTO(
        Long id,
        String nome
) {
}