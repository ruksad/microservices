package com.learn.microservices.scarycoders.ForexServiceApplication.Dao;

import com.learn.microservices.scarycoders.ForexServiceApplication.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepo extends JpaRepository<ExchangeValue,Long> {
    ExchangeValue findByFromIgnoreCaseAndToIgnoreCase(String from,String to);
}
