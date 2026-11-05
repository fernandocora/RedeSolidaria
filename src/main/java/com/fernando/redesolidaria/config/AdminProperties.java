package com.fernando.redesolidaria.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.admin")
public record AdminProperties(
        String nome,
        String email,
        String password
) {
}
