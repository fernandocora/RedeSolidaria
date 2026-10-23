package com.fernando.redesolidaria.security;

import com.fernando.redesolidaria.entity.Usuario;
import com.fernando.redesolidaria.enums.PapelUsuario;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AuthenticatedUser implements UserDetails {
    private final  Long id;

    private final  String email;

    private final  String senhaHash;

    private final  PapelUsuario papel;

    private final  Boolean ativo;

    public AuthenticatedUser(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.senhaHash = usuario.getSenhaHash();
        this.papel = usuario.getPapel();
        this.ativo = usuario.getAtivo();
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + papel));
    }

    @Override
    public @Nullable String getPassword() {
        return senhaHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }
}
