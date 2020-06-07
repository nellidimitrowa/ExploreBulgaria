package com.explorebulgaria.web.models;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "landmarks")
public class Landmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int landmarkId;

    @Column(name = "landmark_name")
    private String landmarkName;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;

    @Column(name = "latitude")
    private BigDecimal landmarkLatitude;

    @Column(name = "longitude")
    private BigDecimal landmarkLongitude;

    @Column(name = "region_id")
    private int regionId;

    @Column(name = "is_visited")
    private boolean isVisited;

    public Landmark() { }

    public Landmark(int landmarkId, String landmarkName, String description, String picture, BigDecimal landmarkLatitude, BigDecimal landmarkLongitude, int regionId, boolean isVisited) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.description = description;
        this.picture = picture;
        this.landmarkLatitude = landmarkLatitude;
        this.landmarkLongitude = landmarkLongitude;
        this.regionId = regionId;
        this.isVisited = isVisited;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigDecimal getLandmarkLatitude() {
        return landmarkLatitude;
    }

    public void setLandmarkLatitude(BigDecimal landmarkLatitude) {
        this.landmarkLatitude = landmarkLatitude;
    }

    public BigDecimal getLandmarkLongitude() {
        return landmarkLongitude;
    }

    public void setLandmarkLongitude(BigDecimal landmarkLongitude) {
        this.landmarkLongitude = landmarkLongitude;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
}
