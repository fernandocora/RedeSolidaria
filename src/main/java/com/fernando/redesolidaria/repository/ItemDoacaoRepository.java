package com.fernando.redesolidaria.repository;

import com.fernando.redesolidaria.entity.ItemDoacao;
import com.fernando.redesolidaria.enums.ItemStatus;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ItemDoacaoRepository extends JpaRepository<ItemDoacao, Long>,
        JpaSpecificationExecutor<ItemDoacao> {

    // usado ao remover uma categoria
    boolean existsByCategoriaId(Integer categoriaId);

    // @EntityGraph carrega categoria e doador na mesma consulta (evita N+1)
    @EntityGraph(attributePaths = {"categoria", "doador"})
    Optional<ItemDoacao> findDetalhadoById(Long id);

    @EntityGraph(attributePaths = {"categoria", "doador"})
    Page<ItemDoacao> findByDoadorId(Long doadorId, Pageable pageable);

    // sobrescreve o método da Specification só para acrescentar o EntityGraph
    @Override
    @EntityGraph(attributePaths = {"categoria", "doador"})
    Page<ItemDoacao> findAll(Specification<ItemDoacao> spec, Pageable pageable);

    // relatório: itens parados (sem nenhuma solicitação) cadastrados antes de "limite"
    @Query("""
            select i from ItemDoacao i
            where i.status = :status
              and i.dataCadastro < :limite
              and not exists (select 1 from Solicitacao s where s.item = i)
            """)
    Page<ItemDoacao> buscarParados(@Param("status") ItemStatus status,
                                   @Param("limite") LocalDateTime limite,
                                   Pageable pageable);

    // OPCIONAL: só use se escolher lock PESSIMISTA na aprovação.
    // Com lock otimista (@Version), basta o findById normal.
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select i from ItemDoacao i where i.id = :id")
    Optional<ItemDoacao> buscarComLock(@Param("id") Long id);
}