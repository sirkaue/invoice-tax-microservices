package com.sirkaue.calculatorservice.unit.application.context;

import com.sirkaue.calculatorservice.application.context.TaxContextImpl;
import com.sirkaue.calculatorservice.application.ports.out.factory.TaxStrategyFactory;
import com.sirkaue.calculatorservice.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.calculatorservice.domain.enums.TaxType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaxContextImplTest {

    @Mock
    private TaxStrategyFactory factory;

    @Mock
    private TaxStrategy strategy;

    @InjectMocks
    private TaxContextImpl context;

    @Test
    void shouldSetStrategyUsingFactory() {
        // Arrange
        TaxType taxType = TaxType.ICMS;
        when(factory.create(taxType)).thenReturn(strategy);

        // Act
        context.setStrategy(taxType);

        // Assert
        verify(factory).create(taxType);
    }

    @Test
    void shouldCalculateTaxUsingStrategy() {
        // Arrange
        TaxType taxType = TaxType.ICMS;
        double amount = 1000.0;
        double expectedTax = 170.0;

        when(factory.create(taxType)).thenReturn(strategy);
        when(strategy.calculate(amount)).thenReturn(expectedTax);

        // Act
        context.setStrategy(taxType);
        double result = context.calculateTax(amount);

        // Assert
        assertEquals(expectedTax, result);
        verify(factory).create(taxType);
        verify(strategy).calculate(amount);
    }

    @Test
    void shouldThrowExceptionWhenStrategyNotSet() {
        // Arrange
        TaxStrategyFactory factory = mock(TaxStrategyFactory.class);
        TaxContextImpl context = new TaxContextImpl(factory);

        // Act
        Executable executable = () -> context.calculateTax(100.0);

        // Assert
        assertThrows(IllegalStateException.class, executable);

        verifyNoInteractions(factory);
    }
}
