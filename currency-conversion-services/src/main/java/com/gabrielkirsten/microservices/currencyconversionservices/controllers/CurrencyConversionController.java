package com.gabrielkirsten.microservices.currencyconversionservices.controllers;

import com.gabrielkirsten.microservices.currencyconversionservices.model.CurrencyConverter;
import com.gabrielkirsten.microservices.currencyconversionservices.services.ConversionCurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private ConversionCurrencyService conversionCurrencyService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CurrencyConversionController(ConversionCurrencyService conversionCurrencyService) {
        this.conversionCurrencyService = conversionCurrencyService;
    }

    @GetMapping("currency-converter/from/{from}/to/{to}/{quantity}")
    public CurrencyConverter currencyConverter(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity){

        CurrencyConverter currencyConverter = conversionCurrencyService.convert(from, to, quantity);

        logger.info("{}", currencyConverter);

        return currencyConverter;
    }

}
