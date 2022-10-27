package com.neatage.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neatage.employee.entity.Location;
import com.neatage.employee.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees/locations")
public class LocationController {

    private final LocationService locationService;

    @GetMapping("{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable long locationId) {
        Location location = this.locationService.getByLocationId(locationId);
        return ResponseEntity.ok().body(location);
    }

    @PostMapping()
    public ResponseEntity<Location> saveLocation(@RequestBody Location location) {
        Location savedLocation = this.locationService.saveLocation(location);
        return ResponseEntity.ok().body(savedLocation);
    }

    @DeleteMapping("{locationId}")
    public ResponseEntity<?> deleteByLocationId(@PathVariable long locationId) {
        this.locationService.deleteByLocationId(locationId);
        return ResponseEntity.ok("Location with id: " + locationId + " has been deleted");
    }

    @GetMapping("all")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> Locations = this.locationService.getAllLocations();
        return ResponseEntity.ok().body(Locations);
    }

    @GetMapping("all/{countryId}")
    public ResponseEntity<List<Location>> getLocationsByCountryId(@PathVariable String countryId) {
        List<Location> Locations = this.locationService.getAllByCountryId(countryId);
        return ResponseEntity.ok().body(Locations);
    }

    @GetMapping("all/search/{streetAddress}")
    public ResponseEntity<List<Location>> getAllByStreetAddressContainsIgnoreCase(@PathVariable String streetAddress) {
        List<Location> Locations = this.locationService.getAllByStreetAddressContainsIgnoreCase(streetAddress);
        return ResponseEntity.ok().body(Locations);
    }
}
