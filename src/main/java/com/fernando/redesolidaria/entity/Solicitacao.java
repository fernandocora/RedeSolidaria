package com.fernando.redesolidaria.entity;

import com.fernando.redesolidaria.enums.SolicitacaoStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "solicitacao")
public class Solicitacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiario_id", nullable = false)
    private Beneficiario beneficiario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private ItemDoacao itemDoacao;

    @Column(name = "quantidade_solicitada", nullable = false)
    private Integer quantidadeSolicitada;

    @Column(name = "justificativa", nullable = false, length = 500)
    private String justificativa;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SolicitacaoStatus solicitacaoStatus;

    @Column(name = "data_solicitacao", nullable = false)
    private LocalDateTime dataSolicitacao;

    @Column(name = "data_decisao")
    private LocalDateTime dataDecisao;

    @Column(name = "motivo_decisao", length = 300)
    private String motivoDecisao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decidido_por")
    private Usuario usuario;

    @Column(name = "versao", nullable = false)
    private Integer versao;
}
