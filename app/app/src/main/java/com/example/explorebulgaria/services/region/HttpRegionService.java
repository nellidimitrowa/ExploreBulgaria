package com.example.explorebulgaria.services.region;

import com.example.explorebulgaria.models.Region;
import com.example.explorebulgaria.repositories.region.base.RegionRepository;
import com.example.explorebulgaria.services.region.base.RegionService;

import java.io.IOException;

public class HttpRegionService implements RegionService {

    private final RegionRepository repository;

    public HttpRegionService(RegionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Region getRegionById(int regionId) throws IOException {
        return repository.getRegionById(regionId);
    }

    @Override
    public void updateRegion(int regionId, Region region) throws IOException {
        repository.updateRegion(regionId, region);
    }

    @Override
    public boolean isRegionVisited(int regionId) throws IOException {
        return repository.isRegionVisited(regionId);
    }
}
