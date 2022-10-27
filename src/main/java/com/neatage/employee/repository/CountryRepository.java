package com.neatage.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neatage.employee.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	List<Country> findByRegionId(int regionId);
}
