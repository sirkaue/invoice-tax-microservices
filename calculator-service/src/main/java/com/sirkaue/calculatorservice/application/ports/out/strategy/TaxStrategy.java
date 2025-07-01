package com.sirkaue.calculatorservice.application.ports.out.strategy;

import com.sirkaue.calculatorservice.domain.enums.TaxType;

public interface TaxStrategy {

    TaxType getType();

    double calculate(double amount);
}
