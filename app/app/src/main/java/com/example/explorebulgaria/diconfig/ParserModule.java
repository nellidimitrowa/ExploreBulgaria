package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.models.Landmark;
import com.example.explorebulgaria.models.Region;
import com.example.explorebulgaria.parsers.GsonJsonParser;
import com.example.explorebulgaria.parsers.base.JsonParser;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ParserModule {

    @Provides
    @Named("RegionParser")
    public JsonParser<Region> regionJsonParser() {
        return new GsonJsonParser<>(Region.class, Region[].class);
    }

    @Provides
    @Named("LandmarkParser")
    public JsonParser<Landmark> landmarkJsonParser() {
        return new GsonJsonParser<>(Landmark.class, Landmark[].class);
    }
}
