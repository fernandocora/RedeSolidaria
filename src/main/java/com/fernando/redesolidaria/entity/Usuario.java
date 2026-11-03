package com.fernando.redesolidaria.entity;

import com.fernando.redesolidaria.enums.PapelUsuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 254, unique = true)
    private String email;

    @Column(name = "senha_hash", nullable = false, length = 100)
    private String senhaHash;

    @Column(name = "telefone", nullable = true, length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "papel", nullable = false, length = 20)
    private PapelUsuario papel;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Embedded
    private Endereco endereco;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    public void onCreate() {
        this.dataCriacao = LocalDateTime.now(ZoneOffset.UTC);
    }
}
