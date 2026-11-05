package com.fernando.redesolidaria.repository;

import com.fernando.redesolidaria.entity.Usuario;
import com.fernando.redesolidaria.enums.PapelUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPapel(PapelUsuario papelUsuario);
}
