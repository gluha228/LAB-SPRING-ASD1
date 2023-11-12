package com.gluscov.example.lab.api.country.controller;

import com.gluscov.example.lab.api.country.dto.CountryDTO;
import com.gluscov.example.lab.api.country.dto.CountryFilterParams;
import com.gluscov.example.lab.api.country.dto.CreateUpdateCountryDTO;
import com.gluscov.example.lab.api.country.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.gluscov.example.lab.util.MappingUtil.map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/{id}")
    public CountryDTO getById(@PathVariable Long id) {
        return map(countryService.getById(id), CountryDTO.class);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> create(@Valid @RequestBody CreateUpdateCountryDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(map(countryService.create(dto), CountryDTO.class));
    }

    @PutMapping("/{id}")
    public CountryDTO update(@Valid @RequestBody CreateUpdateCountryDTO dto, @PathVariable Long id) {
        return map(countryService.update(dto, id), CountryDTO.class);
    }

    @GetMapping
    public List<CountryDTO> getAll(CountryFilterParams filterParams) {
        return map(countryService.findAll(filterParams), CountryDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        countryService.delete(id);
    }
}
