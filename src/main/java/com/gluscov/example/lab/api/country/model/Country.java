package com.gluscov.example.lab.api.country.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "test_countries")
public class Country {
    @Id
    @GeneratedValue(generator = "test_countries_id_seq")
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal currentTempCelsius;
}
