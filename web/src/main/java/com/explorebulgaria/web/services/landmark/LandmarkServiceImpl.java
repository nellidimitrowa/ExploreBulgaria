package com.explorebulgaria.web.services.landmark;

import com.explorebulgaria.web.models.Landmark;
import com.explorebulgaria.web.repositories.landmark.LandmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandmarkServiceImpl implements LandmarkService {

    private LandmarkRepository repository;

    @Autowired
    public LandmarkServiceImpl(LandmarkRepository repository) {
        this.repository = repository;
    }

    @Override
    public Landmark getLandmarkById(int id) {
        return repository.getLandmarkById(id);
    }

    @Override
    public List<Landmark> getLandmarksByRegion(int regionId) {
        return repository.getLandmarksByRegion(regionId);
    }

    @Override
    public void updateLandmark(int landmarkId, Landmark landmark) {
        repository.updateLandmark(landmarkId, landmark);
    }
}
