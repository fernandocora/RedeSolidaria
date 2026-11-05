package com.fernando.redesolidaria.config;

import com.fernando.redesolidaria.entity.Usuario;
import com.fernando.redesolidaria.enums.PapelUsuario;
import com.fernando.redesolidaria.exception.EmailJaCadastradoException;
import com.fernando.redesolidaria.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@Component
public class AdminInitializer implements CommandLineRunner {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminProperties adminProperties;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.existsByPapel(PapelUsuario.ADMIN)) {
            log.info("Já existe um administrador cadastrado. Inicialização ignorada.");
            return;
        }

        if (adminProperties.email().isBlank() || adminProperties.password().isBlank()) {
            throw new IllegalArgumentException("Credenciais Inválidas.");
        }

        if (adminProperties.password().length() < 12) {
            log.info("Senha fraca");
            return;
        }

        String email = adminProperties.email().trim().toLowerCase(Locale.ROOT);

        if (usuarioRepository.existsByEmail(email)) {
            throw new EmailJaCadastradoException("Email já cadastrado");
        }

        String senhaHash = passwordEncoder.encode(adminProperties.password());

        Usuario.criarAdmin(adminProperties.nome(), email, senhaHash);

        log.info("ADMIN criado com sucesso " + email);
    }
}
