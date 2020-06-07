package com.explorebulgaria.web.controllers;

import com.explorebulgaria.web.models.Landmark;
import com.explorebulgaria.web.services.landmark.LandmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/landmarks")
public class LandmarkRestController {

    private LandmarkService landmarkService;

    public LandmarkRestController(LandmarkService landmarkService) {
        this.landmarkService = landmarkService;
    }

    @GetMapping("/{landmarkId}")
    public Landmark getLandmarkById(@PathVariable int landmarkId) {
        return landmarkService.getLandmarkById(landmarkId);
    }

    @GetMapping("/region/{regionId}")
    public List<Landmark> getLandmarksByRegionId(@PathVariable int regionId) {
        return landmarkService.getLandmarksByRegion(regionId);
    }

    @PutMapping("/{id}")
    public void updateLandmark(@PathVariable int id, @RequestBody Landmark landmark) {
        landmarkService.updateLandmark(id, landmark);
    }
}
