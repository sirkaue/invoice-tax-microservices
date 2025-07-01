package com.sirkaue.invoiceservice.infra.adapters.in.dto;

import java.math.BigDecimal;

public record TaxRequest(String taxType, BigDecimal amount) {
}
