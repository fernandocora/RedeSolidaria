package com.fernando.redesolidaria.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

// 1 = baixa, 2 = média, 3 = alta, 4 = urgente
public record AlterarPrioridadeRequestDTO(
        @NotNull @Min(1) @Max(4) Integer nivel
) {
}