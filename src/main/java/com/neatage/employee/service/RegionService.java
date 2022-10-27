package com.neatage.employee.service;

import java.util.List;

import com.neatage.employee.entity.Region;

public interface RegionService {
    Region getByRegionId(int regionId);

    List<Region> getAllRegions();

    Region saveRegion(Region region);

    void deleteByRegionId(int regionId);

    List<Region> getAllByRegionNameContainsIgnoreCase(String regionName);
}
