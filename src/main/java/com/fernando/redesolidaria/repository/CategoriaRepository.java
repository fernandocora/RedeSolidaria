package com.fernando.redesolidaria.repository;

import com.fernando.redesolidaria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Long, Categoria> {
    boolean existsByNome(String nome);

    boolean existsByNomeAndNotId(String nome, Long id);
}
