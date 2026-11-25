package com.fernando.redesolidaria.repository;

import com.fernando.redesolidaria.entity.Doador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoadorRepository extends JpaRepository<Long, Doador> {
    boolean existsByDocumento(String nome);
}
