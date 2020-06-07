package com.explorebulgaria.web.models;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int regionId;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "latitude")
    private BigDecimal regionLatitude;

    @Column(name = "longitude")
    private BigDecimal regionLongitude;

    public Region() { }

    public Region(int regionId, String regionName, BigDecimal regionLatitude, BigDecimal regionLongitude) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionLatitude = regionLatitude;
        this.regionLongitude = regionLongitude;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public BigDecimal getRegionLatitude() {
        return regionLatitude;
    }

    public void setRegionLatitude(BigDecimal regionLatitude) {
        this.regionLatitude = regionLatitude;
    }

    public BigDecimal getRegionLongitude() {
        return regionLongitude;
    }

    public void setRegionLongitude(BigDecimal regionLongitude) {
        this.regionLongitude = regionLongitude;
    }
}
