package com.fernando.redesolidaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Embeddable
public class Endereco {
    @Column(name = "logradouro", nullable = true, length = 150)
    private String logradouro;

    @Column(name = "numero", nullable = true, length = 10)
    private String numero;

    @Column(name = "bairro", nullable = true, length = 80)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 80)
    private String cidade;

    @Column(name = "uf", nullable = false, length = 2)
    private Character uf;

    @Column(name = "cep", nullable = true, length = 8)
    private Character cep;
}
