package com.neatage.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neatage.employee.entity.Country;
import com.neatage.employee.service.CountryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("employees/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("{countryId}")
    public ResponseEntity<Country> getCountryById(@PathVariable String countryId) {
        Country country = this.countryService.getByCountryId(countryId);
        return ResponseEntity.ok().body(country);
    }

    @PostMapping()
    public ResponseEntity<Country> saveCountry(@RequestBody @Valid Country country) {
        Country savedCountry = this.countryService.saveCountry(country);
        return ResponseEntity.ok().body(savedCountry);
    }

    @GetMapping()
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = this.countryService.getAllCountries();
        return ResponseEntity.ok().body(countries);
    }

    @GetMapping("region/{regionId}")
    public ResponseEntity<List<Country>> getCountriesByRegionId(@PathVariable int regionId) {
        List<Country> countries = this.countryService.getByRegionId(regionId);
        return ResponseEntity.ok().body(countries);
    }

    @DeleteMapping("{countryId}")
    public ResponseEntity<?> deleteByCountryId(@PathVariable String countryId) {
        this.countryService.deleteByCountryId(countryId);
        return ResponseEntity.ok("Country with id: " + countryId + " has been deleted");
    }
}
