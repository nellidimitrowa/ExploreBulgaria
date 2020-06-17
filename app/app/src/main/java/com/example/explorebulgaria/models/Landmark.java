package com.example.explorebulgaria.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Landmark implements Serializable {

    private int landmarkId;
    private String landmarkName;
    private String description;
    private String picture;
    private BigDecimal landmarkLatitude;
    private BigDecimal landmarkLongitude;
    private String workTime;
    private String entranceFee;
    private int regionId;
    private boolean isVisited;

    public Landmark(int landmarkId, String landmarkName, String description, String picture, BigDecimal landmarkLatitude, BigDecimal landmarkLongitude, String workTime, String entranceFee, int regionId, boolean isVisited) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.description = description;
        this.picture = picture;
        this.landmarkLatitude = landmarkLatitude;
        this.landmarkLongitude = landmarkLongitude;
        this.workTime = workTime;
        this.entranceFee = entranceFee;
        this.regionId = regionId;
        this.isVisited = isVisited;
    }

    public int getLandmarkId() { return landmarkId; }

    public void setLandmarkId(int landmarkId) { this.landmarkId = landmarkId; }

    public String getLandmarkName() { return landmarkName; }

    public void setLandmarkName(String landmarkName) { this.landmarkName = landmarkName; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

    public BigDecimal getLandmarkLatitude() { return landmarkLatitude; }

    public void setLandmarkLatitude(BigDecimal landmarkLatitude) { this.landmarkLatitude = landmarkLatitude; }

    public BigDecimal getLandmarkLongitude() { return landmarkLongitude; }

    public void setLandmarkLongitude(BigDecimal landmarkLongitude) { this.landmarkLongitude = landmarkLongitude; }

    public String getWorkTime() { return workTime; }

    public void setWorkTime(String workTime) { this.workTime = workTime; }

    public String getEntranceFee() { return entranceFee; }

    public void setEntranceFee(String entranceFee) { this.entranceFee = entranceFee; }

    public int getRegionId() { return regionId; }

    public void setRegionId(int regionId) { this.regionId = regionId; }

    public boolean isVisited() { return isVisited; }

    public void setVisited(boolean visited) { isVisited = visited; }

}
