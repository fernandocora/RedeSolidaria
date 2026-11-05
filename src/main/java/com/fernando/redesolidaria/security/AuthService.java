package com.fernando.redesolidaria.security;

import com.fernando.redesolidaria.dto.request.LoginRequestDTO;
import com.fernando.redesolidaria.dto.response.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.email(), loginRequestDTO.senha()));

        if (!(authentication.getPrincipal() instanceof AuthenticatedUser user)) {
            throw new IllegalArgumentException("Principal inesperado após autenticação");
        }

        return new LoginResponseDTO(jwtService.gerarToken(user));
    }

}
