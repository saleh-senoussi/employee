package com.neatage.employee.service;

import java.util.List;

import com.neatage.employee.entity.Location;

public interface LocationService {
    Location getByLocationId(long locationId);

    List<Location> getAllLocations();

    Location saveLocation(Location location);

    void deleteByLocationId(long locationId);

    List<Location> getAllByCountryId(String countryId);

    List<Location> getAllByStreetAddressContainsIgnoreCase(String streetAddress);
}
