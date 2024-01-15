package com.joshaby.ExchangeService.repositories;

import com.joshaby.ExchangeService.models.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    Optional<Exchange> findByFromAndTo(String from, String to);
}
