package com.sirkaue.invoiceservice.application.usecase;

import com.sirkaue.invoiceservice.application.ports.in.InvoiceUseCase;
import com.sirkaue.invoiceservice.application.ports.out.TaxCalculatorClientPort;
import com.sirkaue.invoiceservice.domain.Invoice;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.InvoiceRequest;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.InvoiceResponse;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.TaxRequest;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.TaxResponse;

public class InvoiceUseCaseImpl implements InvoiceUseCase {

    private final TaxCalculatorClientPort clientPort;

    public InvoiceUseCaseImpl(TaxCalculatorClientPort clientPort) {
        this.clientPort = clientPort;
    }

    @Override
    public InvoiceResponse execute(InvoiceRequest request) {

        Invoice invoice = new Invoice(request.client(), request.amount());

        for (String taxType : request.taxType()) {
            var taxRequest = new TaxRequest(taxType, request.amount());
            var taxResponse = clientPort.calculateTaxes(taxRequest);
            invoice.addTax(taxType, taxResponse.totalTaxes());
        }

        return new InvoiceResponse(invoice.getClient(), invoice.getAmount(),
                new TaxResponse(
                        invoice.getTax("ICMS"),
                        invoice.getTax("ISS"),
                        invoice.getTax("IR"),
                        invoice.getTotalTaxes()
                ),
                invoice.getNetAmount()
        );
    }
}
