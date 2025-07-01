package com.sirkaue.invoiceservice.application.ports.out;

import com.sirkaue.invoiceservice.infra.adapters.in.dto.TaxRequest;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.TaxResponse;

import java.math.BigDecimal;
import java.util.Map;

public interface TaxCalculatorClientPort {

    TaxResponse calculateTaxes(TaxRequest request);
}
