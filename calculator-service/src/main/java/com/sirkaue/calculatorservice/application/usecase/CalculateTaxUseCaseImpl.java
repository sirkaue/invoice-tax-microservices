package com.sirkaue.calculatorservice.application.usecase;

import com.sirkaue.calculatorservice.application.ports.in.CalculateTaxUseCase;
import com.sirkaue.calculatorservice.application.context.TaxContext;
import com.sirkaue.calculatorservice.domain.enums.TaxType;

public class CalculateTaxUseCaseImpl implements CalculateTaxUseCase {

    private final TaxContext context;

    public CalculateTaxUseCaseImpl(TaxContext context) {
        this.context = context;
    }

    @Override
    public double execute(TaxType taxType, double amount) {
        context.setStrategy(taxType);
        return context.calculateTax(amount);
    }
}
