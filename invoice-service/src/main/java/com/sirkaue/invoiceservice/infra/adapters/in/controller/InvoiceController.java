package com.sirkaue.invoiceservice.infra.adapters.in.controller;

import com.sirkaue.invoiceservice.application.ports.in.InvoiceUseCase;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.InvoiceRequest;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.InvoiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceUseCase invoiceUseCase;

    public InvoiceController(InvoiceUseCase invoiceUseCase) {
        this.invoiceUseCase = invoiceUseCase;
    }

    @PostMapping
    public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest request) {
        InvoiceResponse response = invoiceUseCase.execute(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
