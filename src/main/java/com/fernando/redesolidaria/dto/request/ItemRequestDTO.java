package com.fernando.redesolidaria.dto.request;

import com.fernando.redesolidaria.enums.EstadoConservacao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ItemRequestDTO(
        @NotNull Integer categoriaId,
        @NotBlank @Size(max = 120) String nome,
        @Size(max = 500) String descricao,
        @NotNull EstadoConservacao estadoConservacao,
        @NotNull @Min(1) Integer quantidade,
        @Future LocalDate dataValidade
) {
}