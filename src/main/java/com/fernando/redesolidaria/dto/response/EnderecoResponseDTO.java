package com.fernando.redesolidaria.dto.response;

public record EnderecoResponseDTO(
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String uf,
        String cep
) {
}