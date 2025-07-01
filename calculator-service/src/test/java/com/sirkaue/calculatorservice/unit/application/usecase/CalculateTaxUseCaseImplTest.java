package com.sirkaue.calculatorservice.unit.application.usecase;

import com.sirkaue.calculatorservice.application.context.TaxContext;
import com.sirkaue.calculatorservice.application.usecase.CalculateTaxUseCaseImpl;
import com.sirkaue.calculatorservice.domain.enums.TaxType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateTaxUseCaseImplTest {

    @Mock
    private TaxContext context;

    @InjectMocks
    private CalculateTaxUseCaseImpl useCase;

    @Test
    void shouldCalculateTax() {
        // Arrange
        TaxType taxType = TaxType.ICMS;
        double amount = 1000.0;
        double expectedTax = 170.0;

        doNothing().when(context).setStrategy(taxType);
        when(context.calculateTax(amount)).thenReturn(expectedTax);

        // Act
        double result = useCase.execute(taxType, amount);

        // Assert
        assertEquals(expectedTax, result);

        verify(context).setStrategy(taxType);
        verify(context).calculateTax(amount);
    }
}
