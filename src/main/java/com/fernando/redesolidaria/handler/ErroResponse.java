package com.fernando.redesolidaria.handler;

import java.time.Instant;

public record ErroResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
