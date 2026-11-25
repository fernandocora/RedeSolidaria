package com.fernando.redesolidaria.dto.request;

import jakarta.validation.constraints.NotNull;

public record AlterarAtivoRequestDTO(
        @NotNull Boolean ativo
) {
}