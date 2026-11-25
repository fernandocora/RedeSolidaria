package com.fernando.redesolidaria.dto.response;

import java.time.LocalDateTime;

public record DoacaoResponseDTO(
        Long id,
        Long solicitacaoId,
        Long itemId,
        String itemNome,
        Long doadorId,
        String doadorNome,
        Long beneficiarioId,
        String beneficiarioNome,
        Integer quantidade,
        LocalDateTime dataEntrega,
        String observacoes
) {
}