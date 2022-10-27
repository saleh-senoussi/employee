package com.neatage.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neatage.employee.entity.Location;
import com.neatage.employee.error.NotFoundException;
import com.neatage.employee.repository.LocationRepository;
import com.neatage.employee.service.LocationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public Location getByLocationId(long locationId) {
        Optional<Location> location = this.locationRepository.findById(locationId);
        if (location.isPresent()) {
            return location.get();
        }

        throw new NotFoundException(HttpStatus.NOT_FOUND, "No location found for the given id");
    }

    @Override
    public List<Location> getAllLocations() {
        List<Location> locations = this.locationRepository.findAll();
        return locations;
    }

    @Override
    public Location saveLocation(Location location) {
        return this.locationRepository.save(location);
    }

    @Override
    public void deleteByLocationId(long locationId) {
        this.locationRepository.deleteById(locationId);
    }

    @Override
    public List<Location> getAllByCountryId(String countryId) {
        List<Location> locations = this.locationRepository.findByCountryId(countryId);
        return locations;
    }

    @Override
    public List<Location> getAllByStreetAddressContainsIgnoreCase(String streetAddress) {
        List<Location> locations = this.locationRepository.findByStreetAddressContainsIgnoreCase(streetAddress);
        return locations;
    }
}
