package com.learn.microservices.scarycoders.CurrencyConversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import com.learn.microservices.scarycoders.CurrencyConversion.entity.CurrencyConversionBean;
import com.learn.microservices.scarycoders.CurrencyConversion.proxy.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

    private RestTemplate restTemplate;

    @Autowired
    private CurrencyExchangeService cur;

    @Autowired
    CurrencyConversionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
       // this.cur=cur;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversionBean> convertCurrencyInBulk(@PathVariable String from, @PathVariable String to
        , @PathVariable BigDecimal quantity) {

        CurrencyConversionBean body = cur.retrieveExchangeValue(from,to) ;
        body.setQuantity(quantity);
        body.setTotalCalculatedAmount(quantity.multiply(body.getConversionMultiple()));//getCurrencyConversionBean(from, to, quantity);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    private CurrencyConversionBean getCurrencyConversionBean(@PathVariable String from,
        @PathVariable String to, @PathVariable BigDecimal quantity) {
        HashMap<String, String> map = new HashMap<>();
        map.put("from", from);
        map.put("to", to);

        ResponseEntity<CurrencyConversionBean> forEntity = restTemplate
            .getForEntity("http://localhost:8082/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, map);

        //CurrencyConversionBean body = forEntity.getBody();
        CurrencyConversionBean body = cur.retrieveExchangeValue(from, to);
        body.setQuantity(quantity);
        body.setTotalCalculatedAmount(quantity.multiply(body.getConversionMultiple()));
        return body;
    }
}
