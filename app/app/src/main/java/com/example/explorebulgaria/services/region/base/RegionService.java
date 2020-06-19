package com.example.explorebulgaria.services.region.base;

import com.example.explorebulgaria.models.Region;

import java.io.IOException;

public interface RegionService {

    Region getRegionById(int regionId) throws IOException;

}
