package com.gabrielkirsten.microservices.currencyconversionservices.clients;

import com.gabrielkirsten.microservices.currencyconversionservices.model.CurrencyConverter;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-services")
public interface CurrencyExchangeClient {

    @GetMapping("/currency-exchange-services/currency-exchange/from/{from}/to/{to}")
    CurrencyConverter retrieveExchangeValue(@PathVariable String from,
                                            @PathVariable String to);

}
