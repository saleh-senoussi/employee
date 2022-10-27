package com.neatage.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neatage.employee.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
	List<Region> findByRegionNameContainsIgnoreCase(String regionName);
}
