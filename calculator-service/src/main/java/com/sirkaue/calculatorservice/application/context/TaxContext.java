package com.sirkaue.calculatorservice.application.context;

import com.sirkaue.calculatorservice.domain.enums.TaxType;

public interface TaxContext {

    void setStrategy(TaxType taxType);

    double calculateTax(double amount);
}
