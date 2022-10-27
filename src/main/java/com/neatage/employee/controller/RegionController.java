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

import com.neatage.employee.entity.Region;
import com.neatage.employee.service.RegionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees/regions")
public class RegionController {

    private final RegionService regionService;

    @GetMapping("{regionId}")
    public ResponseEntity<Region> getRegionById(@PathVariable int regionId) {
        Region region = this.regionService.getByRegionId(regionId);
        return ResponseEntity.ok().body(region);
    }

    @PostMapping()
    public ResponseEntity<Region> saveRegion(@RequestBody Region region) {
        Region savedRegion = this.regionService.saveRegion(region);
        return ResponseEntity.ok().body(savedRegion);
    }

    @DeleteMapping("{regionId}")
    public ResponseEntity<?> deleteByRegionId(@PathVariable int regionId) {
        this.regionService.deleteByRegionId(regionId);
        return ResponseEntity.ok("Region with id: " + regionId + " has been deleted");
    }

    @GetMapping("all")
    public ResponseEntity<List<Region>> getAllRegions() {
        List<Region> regions = this.regionService.getAllRegions();
        return ResponseEntity.ok().body(regions);
    }

    @GetMapping("all/search/{regionName}")
    public ResponseEntity<List<Region>> getAllByRegionNameContainsIgnoreCase(@PathVariable String regionName) {
        List<Region> regions = this.regionService.getAllByRegionNameContainsIgnoreCase(regionName);
        return ResponseEntity.ok().body(regions);
    }
}
