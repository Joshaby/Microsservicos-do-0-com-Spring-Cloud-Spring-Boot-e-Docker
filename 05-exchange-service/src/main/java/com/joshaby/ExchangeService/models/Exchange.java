package com.joshaby.ExchangeService.models;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exchange {

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionFactor;

    private BigDecimal convertedValue;

    private String environment;
}
