package com.gluscov.example.lab.api.country.repository;

import com.gluscov.example.lab.api.country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
}