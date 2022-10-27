package com.neatage.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neatage.employee.entity.Region;
import com.neatage.employee.error.NotFoundException;
import com.neatage.employee.repository.RegionRepository;
import com.neatage.employee.service.RegionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private RegionRepository regionRepository;

    @Override
    public Region getByRegionId(int regionId) {
        Optional<Region> region = this.regionRepository.findById(regionId);
        if (region.isPresent()) {
            return region.get();
        }

        throw new NotFoundException(HttpStatus.NOT_FOUND, "No region found for the given id");
    }

    @Override
    public List<Region> getAllRegions() {
        List<Region> regions = this.regionRepository.findAll();
        return regions;
    }

    @Override
    public Region saveRegion(Region region) {
        return this.regionRepository.save(region);
    }

    @Override
    public void deleteByRegionId(int regionId) {
        this.regionRepository.deleteById(regionId);
    }

    @Override
    public List<Region> getAllByRegionNameContainsIgnoreCase(String regionName) {
        List<Region> regions = this.regionRepository.findByRegionNameContainsIgnoreCase(regionName);
        return regions;
    }
}
