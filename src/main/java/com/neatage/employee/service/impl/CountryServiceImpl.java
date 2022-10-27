package com.neatage.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neatage.employee.entity.Country;
import com.neatage.employee.error.NotFoundException;
import com.neatage.employee.repository.CountryRepository;
import com.neatage.employee.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country getByCountryId(String countryId) throws NotFoundException {
        Optional<Country> country = this.countryRepository.findById(countryId);
        if (country.isPresent()) {
            return country.get();
        }

        throw new NotFoundException(HttpStatus.NOT_FOUND, "No country found for the given id");
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = this.countryRepository.findAll();
        return countries;
    }

    @Override
    public Country saveCountry(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public void deleteByCountryId(String countryId) {
        this.countryRepository.deleteById(countryId);
    }

    @Override
    public List<Country> getByRegionId(int regionId) {
        return this.countryRepository.findByRegionId(regionId);
    }
}
