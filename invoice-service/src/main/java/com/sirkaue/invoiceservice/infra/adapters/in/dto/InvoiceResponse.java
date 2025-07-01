package com.sirkaue.invoiceservice.infra.adapters.in.dto;

import java.math.BigDecimal;

public record InvoiceResponse(
        String client,
        BigDecimal grossAmount,
        TaxResponse taxes,
        BigDecimal netAmount
) {
}
