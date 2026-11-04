package com.fernando.redesolidaria.entity;

import com.fernando.redesolidaria.enums.PapelUsuario;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Entity
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    protected Usuario(PapelUsuario papelUsuario) {
        this.papel = papelUsuario;
    }

    protected Usuario() {

    }

    @Setter(AccessLevel.NONE)
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

    @Setter(AccessLevel.NONE)
    @Enumerated(EnumType.STRING)
    @Column(name = "papel", nullable = false, length = 20)
    private PapelUsuario papel;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Embedded
    private Endereco endereco;

    @Setter(AccessLevel.NONE)
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now(ZoneOffset.UTC);
    }

    public static Usuario criarAdmin(String nome, String email, String senhaHash) {
        Usuario admin = new Usuario(PapelUsuario.ADMIN);

        admin.nome = nome;
        // espera um email normalizado
        admin.email = email;
        admin.senhaHash = senhaHash;

        return admin;
    }
}
