package com.explorebulgaria.web.controllers;

import com.explorebulgaria.web.models.Region;
import com.explorebulgaria.web.services.region.RegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
