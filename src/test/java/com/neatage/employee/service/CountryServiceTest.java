package com.neatage.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.neatage.employee.entity.Country;
import com.neatage.employee.error.NotFoundException;
import com.neatage.employee.repository.CountryRepository;
import com.neatage.employee.service.impl.CountryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryServiceImpl countryService;

    @Test
    @DisplayName("Country Service Test: return country when given existing country id.")
    public void givenExistingCountryId_thenReturnCountry() {
        Country mockCountry = new Country("CA", "Canada", 1);
        when(this.countryRepository.findById(anyString())).thenReturn(Optional.ofNullable(mockCountry));

        Country country = this.countryService.getByCountryId(anyString());

        assertTrue(mockCountry.getCountryId().equals(country.getCountryId()));
        assertTrue(mockCountry.getCountryName().equals(country.getCountryName()));
        assertTrue(mockCountry.getRegionId() == country.getRegionId());

        verify(this.countryRepository, times(1)).findById(anyString());
    }

    @Test
    @DisplayName("Country Service Test: throw NotFoundException when given id does not exist.")
    public void givenNonExistingCountryId_thenThrowNotFoundException() {
        NotFoundException mockException = new NotFoundException(HttpStatus.NOT_FOUND,
                "No country found for the given id");
        when(this.countryRepository.findById(anyString()))
                .thenThrow(mockException);

        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> this.countryService.getByCountryId(anyString()));

        assertTrue("REQUEST_NOT_FOUND".equals(exception.getCode()));
        assertTrue(mockException.getReason().equals(exception.getReason()));

        verify(this.countryRepository, times(1)).findById(anyString());
    }

    @Test
    @DisplayName("Country Service Test: find all countries when none exists.")
    public void givenNoCountriesSaved_returnEmptyCountriesList() {
        List<Country> mockCountries = new ArrayList<Country>();

        when(this.countryRepository.findAll()).thenReturn(mockCountries);

        List<Country> countries = this.countryService.getAllCountries();
        verify(this.countryRepository, times(1)).findAll();
        assertEquals(mockCountries.size(), countries.size());
    }

    @Test
    @DisplayName("Country Service Test: find all countries when some exists.")
    public void givenExistingCountries_returnCountriesAllList() {
        List<Country> mockCountries = new ArrayList<Country>();
        mockCountries.add(new Country("CA", "Canada", 1));
        mockCountries.add(new Country("US", "United States of America", 1));

        when(this.countryRepository.findAll()).thenReturn(mockCountries);

        List<Country> countries = this.countryService.getAllCountries();
        verify(this.countryRepository, times(1)).findAll();
        assertEquals(mockCountries.size(), countries.size());
        assertTrue(mockCountries.get(0).equals(countries.get(0)));
    }

    @Test
    @DisplayName("Country Service Test: return country when given existing country id.")
    public void givenCountryWithIdThatDoesNotExists_thenReturnCreatedCountry() {
        Country mockCountry = new Country("CA", "Canada", 1);
        when(this.countryRepository.save(mockCountry)).thenReturn(mockCountry);

        Country country = this.countryService.saveCountry(mockCountry);

        assertTrue(mockCountry.getCountryId().equals(country.getCountryId()));
        assertTrue(mockCountry.getCountryName().equals(country.getCountryName()));
        assertTrue(mockCountry.getRegionId() == country.getRegionId());

        verify(this.countryRepository, times(1)).save(mockCountry);
    }

    @Test
    @DisplayName("Country Service Test: return country when given existing country id.")
    public void givenCountryWithIdThatExists_thenReturnUpdatedCountry() {
        Country mockCountry = new Country("CA", "Canada", 1);
        when(this.countryRepository.save(mockCountry)).thenReturn(mockCountry);

        Country country = this.countryService.saveCountry(mockCountry);

        assertTrue(mockCountry.getCountryId().equals(country.getCountryId()));
        assertTrue(mockCountry.getCountryName().equals(country.getCountryName()));
        assertTrue(mockCountry.getRegionId() == country.getRegionId());

        verify(this.countryRepository, times(1)).save(mockCountry);
    }

}
