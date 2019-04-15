package com.gabrielkirsten.microservices.currencyexchangeservices.repositories;

import com.gabrielkirsten.microservices.currencyexchangeservices.models.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, UUID> {
    ExchangeValue findByFromAndTo(String from, String to);
}