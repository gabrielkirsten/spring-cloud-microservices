package com.gabrielkirsten.microservices.currencyexchangeservices.controllers;

import com.gabrielkirsten.microservices.currencyexchangeservices.models.ExchangeValue;
import com.gabrielkirsten.microservices.currencyexchangeservices.services.ExchangeValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    private Environment environment;
    private ExchangeValueService exchangeValueService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CurrencyExchangeController(Environment environment, ExchangeValueService exchangeValueService) {
        this.environment = environment;
        this.exchangeValueService = exchangeValueService;
    }

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueService.getExchange(from, to);
        exchangeValue.setPort(
                Integer.parseInt(
                        Optional.ofNullable(environment.getProperty("local.server.port")).orElse("")
                ));

        logger.info("{}", exchangeValue);

        return exchangeValue;
    }

}
