package com.sirkaue.calculatorservice.infra.adapters.out.strategy;

import com.sirkaue.calculatorservice.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.calculatorservice.domain.enums.TaxType;
import org.springframework.stereotype.Component;

@Component
public class ISSStrategy implements TaxStrategy {

    @Override
    public TaxType getType() {
        return TaxType.ISS;
    }

    @Override
    public double calculate(double amount) {
        return amount * 0.05; // ISS de 5%
    }
}
