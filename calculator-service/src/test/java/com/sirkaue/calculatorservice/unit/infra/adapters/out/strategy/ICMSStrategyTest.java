package com.sirkaue.calculatorservice.unit.infra.adapters.out.strategy;

import com.sirkaue.calculatorservice.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.calculatorservice.domain.enums.TaxType;
import com.sirkaue.calculatorservice.infra.adapters.out.strategy.ICMSStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ICMSStrategyTest {

    private final TaxStrategy strategy = new ICMSStrategy();

    @Test
    void shouldGetType() {
        // Arrange & Act
        TaxType type = strategy.getType();

        // Assert
        assertEquals(TaxType.ICMS, type, "O tipo retornado deve ser ICMS");
    }

    @Test
    void shouldCalculate() {
        // Arrange
        double amount = 100.0;

        // Act
        double result = strategy.calculate(amount);

        // Assert
        assertEquals(17.0, result, 0.0001, "O cálculo do ICMS deve ser 17% do valor");
    }
}
