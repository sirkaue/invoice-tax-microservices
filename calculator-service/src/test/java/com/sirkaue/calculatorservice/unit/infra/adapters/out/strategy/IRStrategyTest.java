package com.sirkaue.calculatorservice.unit.infra.adapters.out.strategy;

import com.sirkaue.calculatorservice.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.calculatorservice.domain.enums.TaxType;
import com.sirkaue.calculatorservice.infra.adapters.out.strategy.IRStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IRStrategyTest {

    private final TaxStrategy strategy = new IRStrategy();

    @Test
    void shouldGetType() {
        // Arrange & Act
        TaxType type = strategy.getType();

        // Assert
        assertEquals(TaxType.IR, type, "O tipo retornado deve ser IR");
    }

    @Test
    void shouldCalculate() {
        // Arrange
        double amount = 100.0;

        // Act
        double result = strategy.calculate(amount);

        // Assert
        assertEquals(27.5, result, 0.0001, "O cálculo do IR deve ser 27.5% do valor");
    }
}
