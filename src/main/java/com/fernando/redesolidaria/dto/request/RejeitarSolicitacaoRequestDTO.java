package com.fernando.redesolidaria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RejeitarSolicitacaoRequestDTO(
        @NotBlank @Size(max = 300) String motivo
) {
}