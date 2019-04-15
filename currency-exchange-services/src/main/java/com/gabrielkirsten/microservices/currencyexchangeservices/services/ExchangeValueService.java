package com.gabrielkirsten.microservices.currencyexchangeservices.services;

import com.gabrielkirsten.microservices.currencyexchangeservices.models.ExchangeValue;
import com.gabrielkirsten.microservices.currencyexchangeservices.repositories.ExchangeValueRepository;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueService {

    private ExchangeValueRepository exchangeValueRepository;

    public ExchangeValueService(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }


    public ExchangeValue getExchange(String from, String to) {
        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}
