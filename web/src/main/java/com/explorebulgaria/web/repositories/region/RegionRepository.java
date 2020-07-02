package com.explorebulgaria.web.repositories.region;

import com.explorebulgaria.web.models.Landmark;
import com.explorebulgaria.web.models.Region;

public interface RegionRepository {

    Region getRegionById(int id);
    void updateRegion(int regionId, Region region);

}
