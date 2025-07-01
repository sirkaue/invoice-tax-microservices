package com.sirkaue.invoiceservice.infra.adapters.out.client;

import com.sirkaue.invoiceservice.infra.adapters.in.dto.TaxRequest;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.TaxResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "tax-calculator",
        url = "${clients.tax-calculator.url}")
public interface TaxCalculatorFeignClient {

    @PostMapping("/api/v1/tax/calculate")
    TaxResponse calculateTaxes(@RequestBody TaxRequest request);
}
