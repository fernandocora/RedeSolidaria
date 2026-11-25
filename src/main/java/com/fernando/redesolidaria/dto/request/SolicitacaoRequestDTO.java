package com.fernando.redesolidaria.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SolicitacaoRequestDTO(
        @NotNull Long itemId,
        @NotNull @Min(1) Integer quantidade,
        @NotBlank @Size(max = 500) String justificativa
) {
}