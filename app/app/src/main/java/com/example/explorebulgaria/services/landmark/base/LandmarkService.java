package com.example.explorebulgaria.services.landmark.base;

import com.example.explorebulgaria.models.Landmark;

import java.io.IOException;
import java.util.List;

public interface LandmarkService {

    Landmark getLandmarkById(int landmarkId) throws IOException;

    List<Landmark> getLandmarksByRegionId(int regionId) throws IOException;

    void updateLandmark(int landmarkId, Landmark landmark) throws IOException;
}
