package com.learn.microservices.scarycoders.ForexServiceApplication.controller;

import com.learn.microservices.scarycoders.ForexServiceApplication.Dao.ExchangeValueRepo;
import com.learn.microservices.scarycoders.ForexServiceApplication.entity.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {


    private ExchangeValueRepo valueRepo;

    @Value("${server.port}")
    private int port;
    @Autowired
    private ForexController(ExchangeValueRepo valueRepo){
        this.valueRepo=valueRepo;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retrieveExchangeValue(@PathVariable String from,@PathVariable String to){
        ExchangeValue byFromAndTo = valueRepo.findByFromIgnoreCaseAndToIgnoreCase(from, to);
        byFromAndTo.setPort(port);
        return new ResponseEntity<ExchangeValue>(byFromAndTo, HttpStatus.OK);
    }
}
