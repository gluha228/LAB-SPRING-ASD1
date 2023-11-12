package com.gluscov.example.lab.api.country.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CountryFilterParams {
    private String name;
    private String description;
    private BigDecimal currentTempCelsiusFrom;
    private BigDecimal currentTempCelsiusTo;
}
