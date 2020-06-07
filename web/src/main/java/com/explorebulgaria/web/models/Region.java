package com.explorebulgaria.web.models;

import java.math.BigDecimal;

public class Region {

    private int regionId;
    private String regionName;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public Region() { }

    public Region(int regionId, String regionName, BigDecimal latitude, BigDecimal longitude) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getregionId() {
        return regionId;
    }

    public void setregionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
