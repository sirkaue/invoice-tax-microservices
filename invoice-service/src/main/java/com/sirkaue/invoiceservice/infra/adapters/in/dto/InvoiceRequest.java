package com.sirkaue.invoiceservice.infra.adapters.in.dto;

import java.math.BigDecimal;
import java.util.List;

public record InvoiceRequest(String client, BigDecimal amount, List<String> taxType) {
}
