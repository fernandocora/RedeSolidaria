package com.fernando.redesolidaria.controller;

import com.fernando.redesolidaria.dto.request.LoginRequestDTO;
import com.fernando.redesolidaria.dto.response.LoginResponseDTO;
import com.fernando.redesolidaria.security.AuthService;
import com.fernando.redesolidaria.security.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return authService.login(loginRequestDTO);
    }
}
