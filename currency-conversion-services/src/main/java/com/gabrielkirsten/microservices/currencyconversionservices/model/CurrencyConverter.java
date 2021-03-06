package com.gabrielkirsten.microservices.currencyconversionservices.model;

import java.math.BigDecimal;
import java.util.UUID;

public class CurrencyConverter {

    private UUID id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculationAmount;
    private int port;

    public CurrencyConverter() {
    }

    public CurrencyConverter(UUID id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal totalCalculationAmount, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculationAmount = totalCalculationAmount;
        this.port = port;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculationAmount() {
        return totalCalculationAmount;
    }

    public void setTotalCalculationAmount(BigDecimal totalCalculationAmount) {
        this.totalCalculationAmount = totalCalculationAmount;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
