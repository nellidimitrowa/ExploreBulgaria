package com.example.explorebulgaria.repositories.landmark.base;

import com.example.explorebulgaria.models.Landmark;

import java.io.IOException;
import java.util.List;

public interface LandmarkRepository {

    Landmark getLandmarkById(int landmarkId) throws IOException;

    List<Landmark> getLandmarksByRegionId(int regionId) throws IOException;

    void updateLandmark(int landmarkId, Landmark landmark) throws IOException;

}
