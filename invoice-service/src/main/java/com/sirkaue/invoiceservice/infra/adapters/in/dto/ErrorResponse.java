package com.sirkaue.invoiceservice.infra.adapters.in.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path,
        String method) {
}
