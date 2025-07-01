package com.sirkaue.invoiceservice.infra.adapters.in.dto;

import java.math.BigDecimal;

public record TaxResponse(
        BigDecimal icms,
        BigDecimal iss,
        BigDecimal ir,
        BigDecimal totalTaxes
) {
    public TaxResponse {
        if (totalTaxes == null) totalTaxes = BigDecimal.ZERO;
    }
}
