package com.explorebulgaria.web.services.region;

import com.explorebulgaria.web.models.Landmark;
import com.explorebulgaria.web.models.Region;
import com.explorebulgaria.web.repositories.region.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

    private RegionRepository repository;

    @Autowired
    public RegionServiceImpl(RegionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Region getRegionById(int id) {
        return repository.getRegionById(id);
    }

    @Override
    public void updateRegion(int regionId, Region region) {
        repository.updateRegion(regionId, region);
    }
}
