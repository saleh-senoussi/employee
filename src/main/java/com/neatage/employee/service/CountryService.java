package com.neatage.employee.service;

import java.util.List;

import com.neatage.employee.entity.Country;

public interface CountryService {
    Country getByCountryId(String countryId);

    List<Country> getAllCountries();

    Country saveCountry(Country country);

    void deleteByCountryId(String countryId);

    List<Country> getByRegionId(int regionId);
}
