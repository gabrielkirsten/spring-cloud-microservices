package com.gabrielkirsten.microservices.currencyconversionservices.services;

import com.gabrielkirsten.microservices.currencyconversionservices.clients.CurrencyExchangeClient;
import com.gabrielkirsten.microservices.currencyconversionservices.model.CurrencyConverter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConversionCurrencyService {

    private CurrencyExchangeClient currencyExchangeClient;

    public ConversionCurrencyService(CurrencyExchangeClient currencyExchangeClient) {
        this.currencyExchangeClient = currencyExchangeClient;
    }

    public CurrencyConverter convert(String from, String to, BigDecimal quantity) {
        CurrencyConverter currencyConverter = currencyExchangeClient.retrieveExchangeValue(from, to);
        currencyConverter.setQuantity(quantity);
        currencyConverter.setTotalCalculationAmount(quantity.multiply(currencyConverter.getConversionMultiple()));

        return currencyConverter;
    }

}
