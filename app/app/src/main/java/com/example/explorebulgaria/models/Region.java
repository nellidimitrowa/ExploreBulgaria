package com.example.explorebulgaria.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Region implements Serializable {

    private int regionId;
    private String regionName;
    private BigDecimal regionLatitude;
    private BigDecimal regionLongitude;
    private boolean isRegionVisited;

    public Region(int regionId, String regionName, BigDecimal regionLatitude, BigDecimal regionLongitude, boolean isRegionVisited) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionLatitude = regionLatitude;
        this.regionLongitude = regionLongitude;
        this.isRegionVisited = isRegionVisited;
    }

    public int getRegionId() { return regionId; }

    public void setRegionId(int regionId) { this.regionId = regionId; }

    public String getRegionName() { return regionName; }

    public void setRegionName(String regionName) { this.regionName = regionName; }

    public BigDecimal getRegionLatitude() { return regionLatitude; }

    public void setRegionLatitude(BigDecimal regionLatitude) { this.regionLatitude = regionLatitude; }

    public BigDecimal getRegionLongitude() { return regionLongitude; }

    public void setRegionLongitude(BigDecimal regionLongitude) { this.regionLongitude = regionLongitude; }

    public boolean isRegionVisited() { return isRegionVisited; }

    public void setRegionVisited(boolean isRegionVisited) { this.isRegionVisited = isRegionVisited; }
}
