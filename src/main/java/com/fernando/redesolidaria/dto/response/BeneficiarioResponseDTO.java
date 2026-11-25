package com.fernando.redesolidaria.dto.response;

import com.fernando.redesolidaria.enums.TipoBeneficiario;

import java.time.LocalDateTime;

public record BeneficiarioResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        TipoBeneficiario tipoBeneficiario,
        Integer nivelPrioridade,
        Boolean verificado,
        Boolean ativo,
        EnderecoResponseDTO endereco,
        LocalDateTime dataCriacao
) {
}