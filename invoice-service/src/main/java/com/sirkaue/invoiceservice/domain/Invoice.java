package com.sirkaue.invoiceservice.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Invoice {

    private final String client;
    private final BigDecimal amount;
    private final Map<String, BigDecimal> taxes;

    public Invoice(String client, BigDecimal amount) {
        this.client = client;
        this.amount = amount;
        this.taxes = new HashMap<>();
    }

    public void addTax(String taxType, BigDecimal value) {
        taxes.put(taxType.toUpperCase(), value);
    }

    public BigDecimal getTotalTaxes() {
        return taxes.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getNetAmount() {
        return amount.add(getTotalTaxes());
    }

    public String getClient() {
        return client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getTax(String type) {
        return taxes.getOrDefault(type.toUpperCase(), BigDecimal.ZERO);
    }

    public Map<String, BigDecimal> getTaxes() {
        return Map.copyOf(taxes);
    }
}
