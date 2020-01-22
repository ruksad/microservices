package com.learn.microservices.scarycoders.CurrencyConversion.entity;


import java.math.BigDecimal;
import lombok.Data;

@Data
public class CurrencyConversionBean {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private int port;
}
