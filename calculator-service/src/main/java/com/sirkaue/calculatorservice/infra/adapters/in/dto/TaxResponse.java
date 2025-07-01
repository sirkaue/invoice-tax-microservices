package com.sirkaue.calculatorservice.infra.adapters.in.dto;

import com.sirkaue.calculatorservice.domain.enums.TaxType;

public record TaxResponse(
        TaxType taxType,
        double amount,
        double totalTaxes
) {
}