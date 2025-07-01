package com.sirkaue.calculatorservice.infra.adapters.in.controller;

import com.sirkaue.calculatorservice.application.ports.in.CalculateTaxUseCase;
import com.sirkaue.calculatorservice.infra.adapters.in.dto.TaxRequest;
import com.sirkaue.calculatorservice.infra.adapters.in.dto.TaxResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tax")
public class TaxController {

    private final CalculateTaxUseCase calculateTaxUseCase;

    public TaxController(CalculateTaxUseCase calculateTaxUseCase) {
        this.calculateTaxUseCase = calculateTaxUseCase;
    }

    @PostMapping("/calculate")
    public ResponseEntity<TaxResponse> calculateTax(@RequestBody TaxRequest request) {
        double taxValue = calculateTaxUseCase.execute(request.taxType(), request.amount());

        TaxResponse body = new TaxResponse(
                request.taxType(),
                request.amount(),
                taxValue
        );

        return ResponseEntity.ok(body);
    }
}
