package com.fernando.redesolidaria.dto.response;

import java.time.LocalDateTime;

public record ItemParadoResponseDTO(
        Long id,
        String nome,
        String categoria,
        Integer quantidadeDisponivel,
        LocalDateTime dataCadastro
) {
}