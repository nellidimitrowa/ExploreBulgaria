package com.explorebulgaria.web.repositories.landmark;

import com.explorebulgaria.web.models.Landmark;

import java.util.List;

public interface LandmarkRepository {

    Landmark getLandmarkById(int id);
    List<Landmark> getLandmarksByRegion(int regionId);
    void updateLandmark(int landmarkId, Landmark landmark);
}
