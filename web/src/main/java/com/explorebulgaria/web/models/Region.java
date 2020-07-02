package com.explorebulgaria.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "regions")
@DynamicUpdate
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

    @Column(name = "is_region_visited")
    private boolean isRegionVisited;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Landmark> landmarks = new ArrayList<>();

    public Region() { }

    public Region(int regionId, String regionName, BigDecimal regionLatitude, BigDecimal regionLongitude, boolean isRegionVisited) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionLatitude = regionLatitude;
        this.regionLongitude = regionLongitude;
        this.isRegionVisited = isRegionVisited;
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


    public boolean isRegionVisited() {
        return isRegionVisited;
    }

    public void setRegionIsVisited(boolean isRegionVisited) {
        this.isRegionVisited = isRegionVisited;
    }

    public List<Landmark> getLandmarks() { return landmarks; }

    public void setLandmarks(List<Landmark> landmarks) { this.landmarks = landmarks; }
}
