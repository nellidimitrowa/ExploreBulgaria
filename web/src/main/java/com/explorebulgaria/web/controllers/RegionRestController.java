package com.explorebulgaria.web.controllers;

import com.explorebulgaria.web.models.Landmark;
import com.explorebulgaria.web.models.Region;
import com.explorebulgaria.web.services.region.RegionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/regions")
public class RegionRestController {

    private RegionService regionService;

    public RegionRestController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/{regionId}")
    public Region getRegionById(@PathVariable int regionId) {
        return regionService.getRegionById(regionId);
    }

    @PutMapping("/visited/{id}")
    public void updateRegion(@PathVariable int id, @RequestBody Region region) {
        regionService.updateRegion(id, region);
    }
}
