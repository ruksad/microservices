package com.learn.microservices.scarycoders.CurrencyConversion.proxy;

import com.learn.microservices.scarycoders.CurrencyConversion.entity.CurrencyConversionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="forex-service",url = "localhost:8082")
public interface CurrencyExchangeService {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean retrieveExchangeValue(@PathVariable String from,@PathVariable String to);
}
