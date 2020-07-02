package com.example.explorebulgaria.repositories.region.base;

import com.example.explorebulgaria.models.Region;

import java.io.IOException;

public interface RegionRepository {

    Region getRegionById(int regionId) throws IOException;

    void updateRegion(int regionId, Region region) throws IOException;

    boolean isRegionVisited(int regionId) throws IOException;

}
