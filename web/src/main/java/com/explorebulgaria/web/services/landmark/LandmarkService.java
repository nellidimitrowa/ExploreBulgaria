package com.explorebulgaria.web.services.landmark;

import com.explorebulgaria.web.models.Landmark;

import java.util.List;

public interface LandmarkService {

    Landmark getLandmarkById(int id);
    List<Landmark> getLandmarksByRegion(int regionId);
    void updateLandmark(int landmarkId, Landmark landmark);
}
