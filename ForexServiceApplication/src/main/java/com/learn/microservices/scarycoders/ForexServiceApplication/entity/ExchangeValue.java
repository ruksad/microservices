package com.learn.microservices.scarycoders.ForexServiceApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor()
public class ExchangeValue {

    @Id
    private Long id;
    @Column(name = "Currency_from")
    private String from;
    @Column(name = "Currency_to")
    private String to;
    private int port;
    private BigDecimal conversionMultiple;

}
