package com.fernando.redesolidaria.repository;

import com.fernando.redesolidaria.entity.Solicitacao;
import com.fernando.redesolidaria.enums.SolicitacaoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    @EntityGraph(attributePaths = {"itemDoacao", "itemDoacao.doador", "beneficiario"})
    Optional<Solicitacao> findDetalhadoById(Long id);

    // R5: já existe solicitação ativa deste beneficiário para este item?
    boolean existsByBeneficiarioIdAndItemIdAndStatusIn(Long beneficiarioId, Long itemId,
                                                       Collection<SolicitacaoStatus> status);

    // R6: quantas solicitações ativas o beneficiário tem?
    long countByBeneficiarioIdAndStatusIn(Long beneficiarioId, Collection<SolicitacaoStatus> status);

    // "minhas solicitações" (status opcional)
    @EntityGraph(attributePaths = {"itemDoacao", "beneficiario"})
    @Query("""
            select s from Solicitacao s
            where s.beneficiario.id = :beneficiarioId
              and (:status is null or s.status = :status)
            """)
    Page<Solicitacao> listarDoBeneficiario(@Param("beneficiarioId") Long beneficiarioId,
                                           @Param("status") SolicitacaoStatus status,
                                           Pageable pageable);

    // solicitações recebidas pelo doador, sobre os itens dele (status opcional)
    @EntityGraph(attributePaths = {"itemDoacao", "beneficiario"})
    @Query("""
            select s from Solicitacao s
            where s.item.doador.id = :doadorId
              and (:status is null or s.status = :status)
            """)
    Page<Solicitacao> listarDoDoador(@Param("doadorId") Long doadorId,
                                     @Param("status") SolicitacaoStatus status,
                                     Pageable pageable);

    // fila por urgência: maior prioridade primeiro, depois a mais antiga.
    // A ordenação está na query: passe um Pageable SEM sort (PageRequest.of(page, size)).
    @Query(value = """
            select s from Solicitacao s
            join fetch s.beneficiario b
            join fetch s.item i
            where (:status is null or s.status = :status)
            order by b.nivelPrioridade desc, s.dataSolicitacao asc
            """,
            countQuery = """
            select count(s) from Solicitacao s
            where (:status is null or s.status = :status)
            """)
    Page<Solicitacao> listarFila(@Param("status") SolicitacaoStatus status, Pageable pageable);
}