package com.neatage.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neatage.employee.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
	List<Location> findByCountryId(String countryId);
	
	List<Location> findByStreetAddressContainsIgnoreCase(String streetAddress);
}
