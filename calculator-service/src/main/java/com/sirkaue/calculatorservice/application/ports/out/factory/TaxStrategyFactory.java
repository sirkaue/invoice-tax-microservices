package com.sirkaue.calculatorservice.application.ports.out.factory;

import com.sirkaue.calculatorservice.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.calculatorservice.domain.enums.TaxType;

public interface TaxStrategyFactory {

    TaxStrategy create(TaxType taxType);
}
