package com.sirkaue.invoiceservice.application.ports.in;

import com.sirkaue.invoiceservice.infra.adapters.in.dto.InvoiceRequest;
import com.sirkaue.invoiceservice.infra.adapters.in.dto.InvoiceResponse;

public interface InvoiceUseCase {

    InvoiceResponse execute(InvoiceRequest request);
}
