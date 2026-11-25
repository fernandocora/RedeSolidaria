package com.fernando.redesolidaria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequestDTO(
        @NotBlank @Size(max = 80) String nome,
        @Size(max = 250) String descricao
) {
}