package com.sirkaue.calculatorservice.infra.adapters.out.factory;

import com.sirkaue.calculatorservice.application.ports.out.factory.TaxStrategyFactory;
import com.sirkaue.calculatorservice.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.calculatorservice.domain.enums.TaxType;

import java.util.Map;

public class TaxStrategyFactoryImpl implements TaxStrategyFactory {

    private final Map<TaxType, TaxStrategy> strategyMap;

    public TaxStrategyFactoryImpl(Map<TaxType, TaxStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public TaxStrategy create(TaxType taxType) {
        if (taxType == null) {
            throw new IllegalStateException("Tax type must not be null");
        }

        TaxStrategy strategy = strategyMap.get(taxType);

        if (strategy == null) {
            throw new IllegalStateException("No strategy set");
        }
        return strategy;
    }
}
