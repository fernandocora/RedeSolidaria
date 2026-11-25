package com.fernando.redesolidaria.dto.response;

import com.fernando.redesolidaria.enums.TipoDoador;

import java.time.LocalDateTime;

public record DoadorResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        TipoDoador tipoDoador,
        String documento,
        Boolean ativo,
        EnderecoResponseDTO endereco,
        LocalDateTime dataCriacao
) {
}