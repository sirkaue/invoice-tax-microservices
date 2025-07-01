package com.sirkaue.invoiceservice.infra.config;

import com.sirkaue.invoiceservice.application.ports.in.InvoiceUseCase;
import com.sirkaue.invoiceservice.application.ports.out.TaxCalculatorClientPort;
import com.sirkaue.invoiceservice.application.usecase.InvoiceUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public InvoiceUseCase invoiceUseCase(TaxCalculatorClientPort taxCalculatorClientPort) {
        return new InvoiceUseCaseImpl(taxCalculatorClientPort);
    }
}
