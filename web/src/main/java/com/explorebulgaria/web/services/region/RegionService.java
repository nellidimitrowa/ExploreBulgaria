package com.explorebulgaria.web.services.region;

import com.explorebulgaria.web.models.Landmark;
import com.explorebulgaria.web.models.Region;

public interface RegionService {

    Region getRegionById(int id);
    void updateRegion(int regionId, Region region);
}
