package com.gluscov.example.lab.api.country.service;

import com.gluscov.example.lab.api.country.dto.CountryFilterParams;
import com.gluscov.example.lab.api.country.dto.CreateUpdateCountryDTO;
import com.gluscov.example.lab.api.country.model.Country;
import com.gluscov.example.lab.api.country.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.gluscov.example.lab.util.MappingUtil.map;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public Country getById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Country> findAll(CountryFilterParams filterParams) {
        var countriesStream = countryRepository.findAll().stream();
        if (filterParams.getName() != null) {
            countriesStream = countriesStream.filter(country -> country.getName().contains(filterParams.getName()));
        }
        if (filterParams.getDescription() != null) {
            countriesStream = countriesStream.filter(country -> country.getDescription() != null && country.getDescription().contains(filterParams.getDescription()));
        }
        if (filterParams.getCurrentTempCelsiusFrom() != null) {
            countriesStream = countriesStream.filter(country -> country.getCurrentTempCelsius() != null
                    && country.getCurrentTempCelsius().compareTo(filterParams.getCurrentTempCelsiusFrom()) > 0);
        }
        if (filterParams.getCurrentTempCelsiusTo() != null) {
            countriesStream = countriesStream.filter(country -> country.getCurrentTempCelsius() != null
                    && country.getCurrentTempCelsius().compareTo(filterParams.getCurrentTempCelsiusTo()) < 0);
        }
        return countriesStream.toList();
    }

    public Country create(CreateUpdateCountryDTO dto) {
        var country = map(dto, Country.class);
        return countryRepository.save(country);
    }

    public Country update(CreateUpdateCountryDTO dto, Long id) {
        var country = getById(id);
        map(dto, country);
        return countryRepository.save(country);
    }

    public void delete(Long id) {
        var countryToDelete = getById(id);
        countryRepository.delete(countryToDelete);
    }
}
