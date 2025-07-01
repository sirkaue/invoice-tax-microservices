package com.sirkaue.invoiceservice.infra.adapters.out;

import com.sirkaue.invoiceservice.application.ports.out.TaxCalculatorClientPort;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.TaxRequest;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.TaxResponse;
import com.sirkaue.invoiceservice.infra.adapters.out.client.TaxCalculatorFeignClient;
import org.springframework.stereotype.Component;

@Component
public class TaxCalculatorClientAdapter implements TaxCalculatorClientPort {

    private final TaxCalculatorFeignClient feignClient;

    public TaxCalculatorClientAdapter(TaxCalculatorFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @Override
    public TaxResponse calculateTaxes(TaxRequest request) {
        return feignClient.calculateTaxes(request);
    }
}
