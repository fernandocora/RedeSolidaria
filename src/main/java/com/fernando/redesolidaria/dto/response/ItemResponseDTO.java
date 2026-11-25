package com.fernando.redesolidaria.dto.response;

import com.fernando.redesolidaria.enums.EstadoConservacao;
import com.fernando.redesolidaria.enums.ItemStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ItemResponseDTO(
        Long id,
        String nome,
        String descricao,
        EstadoConservacao estadoConservacao,
        Integer quantidadeTotal,
        Integer quantidadeDisponivel,
        LocalDate dataValidade,
        ItemStatus status,
        LocalDateTime dataCadastro,
        CategoriaResponseDTO categoria,
        DoadorResumoDTO doador
) {
}