package com.explorebulgaria.web.models;

import java.math.BigDecimal;

public class Landmark {

    private int landmarkId;
    private String landmarkName;
    private String description;
    private String picture;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private int regionId;
    private boolean userBeen;

    public Landmark() { }

    public Landmark(int landmarkId, String landmarkName, String description, String picture, BigDecimal latitude, BigDecimal longitude, int regionId, boolean userBeen) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.description = description;
        this.picture = picture;
        this.latitude = latitude;
        this.longitude = longitude;
        this.regionId = regionId;
        this.userBeen = userBeen;
    }

    public int getlandmarkId() {
        return landmarkId;
    }

    public void setlandmarkId(int landmarkId) {
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

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public boolean isUserBeen() {
        return userBeen;
    }

    public void setUserBeen(boolean userBeen) {
        this.userBeen = userBeen;
    }
}
