package com.fernando.redesolidaria.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// Mapeia um grupo de propriedades para uma classe
@ConfigurationProperties(prefix = "app.admin")
public record AdminProperties(
        String nome,
        String email,
        String password
) {
}
