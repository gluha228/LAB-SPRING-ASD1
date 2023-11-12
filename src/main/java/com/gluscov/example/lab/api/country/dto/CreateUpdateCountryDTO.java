package com.gluscov.example.lab.api.country.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class CreateUpdateCountryDTO {
    @NotNull
    @Size(min = 2, max = 50)
    private String name;
    @Size(min = 2, max = 200)
    private String description;
    @Min(-80)
    @Max(80)
    private BigDecimal currentTempCelsius;
}
