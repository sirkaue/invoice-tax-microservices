package com.sirkaue.calculatorservice.infra.adapters.in.dto;

import com.sirkaue.calculatorservice.domain.enums.TaxType;

public record TaxRequest(TaxType taxType, double amount) {
}