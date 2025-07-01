package com.sirkaue.calculatorservice.application.ports.in;

import com.sirkaue.calculatorservice.domain.enums.TaxType;

public interface CalculateTaxUseCase {

    double execute(TaxType taxType, double amount);
}
