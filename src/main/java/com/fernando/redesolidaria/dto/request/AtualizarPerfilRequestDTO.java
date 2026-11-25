package com.fernando.redesolidaria.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AtualizarPerfilRequestDTO(
        @NotBlank @Size(max = 150) String nome,
        @Size(max = 20) String telefone,
        @NotNull @Valid EnderecoRequestDTO endereco
) {
}