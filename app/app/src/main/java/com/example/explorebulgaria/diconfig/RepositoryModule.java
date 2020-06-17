package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.http.HttpRequester;
import com.example.explorebulgaria.models.Landmark;
import com.example.explorebulgaria.models.Region;
import com.example.explorebulgaria.parsers.base.JsonParser;
import com.example.explorebulgaria.repositories.landmark.HttpLandmarkRepository;
import com.example.explorebulgaria.repositories.landmark.base.LandmarkRepository;
import com.example.explorebulgaria.repositories.region.HttpRegionRepository;
import com.example.explorebulgaria.repositories.region.base.RegionRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public RegionRepository regionRepository (
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            @Named("RegionParser")JsonParser<Region> jsonParser
    ) {
        String url = baseServerUrl + "/regions";
        return new HttpRegionRepository(httpRequester, url, jsonParser);
    }

    @Provides
    @Singleton
    public LandmarkRepository landmarkRepository (
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            @Named("LandmarkParser")JsonParser<Landmark> jsonParser
    ) {
        String url = baseServerUrl + "/landmarks";
        return new HttpLandmarkRepository(httpRequester, url, jsonParser);
    }
}
