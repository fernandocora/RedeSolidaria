package com.fernando.redesolidaria.dto.response;

import com.fernando.redesolidaria.enums.SolicitacaoStatus;

import java.time.LocalDateTime;

public record SolicitacaoResponseDTO(
        Long id,
        Long itemId,
        String itemNome,
        Long beneficiarioId,
        String beneficiarioNome,
        Integer prioridadeBeneficiario,
        Integer quantidadeSolicitada,
        String justificativa,
        SolicitacaoStatus status,
        LocalDateTime dataSolicitacao,
        LocalDateTime dataDecisao,
        String motivoDecisao
) {
}