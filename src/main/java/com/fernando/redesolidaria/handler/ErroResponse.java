package com.fernando.redesolidaria.handler;

import java.time.LocalDateTime;

public record ErroResponse(
        String error,
        String message,
        int status,
        LocalDateTime timestamp,
        String path
) {
}
