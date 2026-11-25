package com.fernando.redesolidaria.dto.request;

import jakarta.validation.constraints.Size;

// Corpo opcional: no Controller use @RequestBody(required = false).
public record ConcluirEntregaRequestDTO(
        @Size(max = 500) String observacoes
) {
}