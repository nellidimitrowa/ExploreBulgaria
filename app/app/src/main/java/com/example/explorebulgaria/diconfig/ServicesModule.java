package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.repositories.landmark.base.LandmarkRepository;
import com.example.explorebulgaria.repositories.region.base.RegionRepository;
import com.example.explorebulgaria.services.landmark.HttpLandmarkService;
import com.example.explorebulgaria.services.landmark.base.LandmarkService;
import com.example.explorebulgaria.services.region.HttpRegionService;
import com.example.explorebulgaria.services.region.base.RegionService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public RegionService RegionService(RegionRepository repository) {
        return new HttpRegionService(repository);
    }

    @Provides
    public LandmarkService LandmarkService(LandmarkRepository repository) {
        return new HttpLandmarkService(repository);
    }
}
