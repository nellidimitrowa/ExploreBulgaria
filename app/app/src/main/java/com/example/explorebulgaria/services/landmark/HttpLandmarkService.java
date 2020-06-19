package com.example.explorebulgaria.services.landmark;

import com.example.explorebulgaria.models.Landmark;
import com.example.explorebulgaria.repositories.landmark.base.LandmarkRepository;
import com.example.explorebulgaria.services.landmark.base.LandmarkService;

import java.io.IOException;
import java.util.List;

public class HttpLandmarkService implements LandmarkService {

    private final LandmarkRepository repository;

    public HttpLandmarkService(LandmarkRepository repository) {
        this.repository = repository;
    }

    @Override
    public Landmark getLandmarkById(int landmarkId) throws IOException {
        return repository.getLandmarkById(landmarkId);
    }

    @Override
    public List<Landmark> getLandmarksByRegionId(int regionId) throws IOException {
        return repository.getLandmarksByRegionId(regionId);
    }

    @Override
    public void updateLandmark(int landmarkId, Landmark landmark) throws IOException {
        repository.updateLandmark(landmarkId, landmark);
    }
}
