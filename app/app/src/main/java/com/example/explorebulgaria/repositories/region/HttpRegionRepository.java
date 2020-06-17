package com.example.explorebulgaria.repositories.region;

import com.example.explorebulgaria.http.HttpRequester;
import com.example.explorebulgaria.models.Region;
import com.example.explorebulgaria.parsers.base.JsonParser;
import com.example.explorebulgaria.repositories.region.base.RegionRepository;

import java.io.IOException;

public class HttpRegionRepository implements RegionRepository {

    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<Region> mJsonParser;

    public HttpRegionRepository(HttpRequester mHttpRequester, String mServerUrl, JsonParser<Region> mJsonParser) {
        this.mHttpRequester = mHttpRequester;
        this.mServerUrl = mServerUrl;
        this.mJsonParser = mJsonParser;
    }

    @Override
    public Region getRegionById(int regionId) throws IOException {
        String url = mServerUrl + "/" + regionId;
        String json = mHttpRequester.get(url);
        return  mJsonParser.fromJson(json);
    }
}
