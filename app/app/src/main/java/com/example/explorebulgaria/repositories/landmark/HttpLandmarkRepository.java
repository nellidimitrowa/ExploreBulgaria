package com.example.explorebulgaria.repositories.landmark;

import com.example.explorebulgaria.http.HttpRequester;
import com.example.explorebulgaria.models.Landmark;
import com.example.explorebulgaria.models.Region;
import com.example.explorebulgaria.parsers.base.JsonParser;
import com.example.explorebulgaria.repositories.landmark.base.LandmarkRepository;

import java.io.IOException;
import java.util.List;

public class HttpLandmarkRepository implements LandmarkRepository {

    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<Landmark> mJsonParser;

    public HttpLandmarkRepository(HttpRequester mHttpRequester, String mServerUrl, JsonParser<Landmark> mJsonParser) {
        this.mHttpRequester = mHttpRequester;
        this.mServerUrl = mServerUrl;
        this.mJsonParser = mJsonParser;
    }

    @Override
    public Landmark getLandmarkById(int landmarkId) throws IOException {
        String url = mServerUrl + "/" + landmarkId;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
    }

    @Override
    public List<Landmark> getLandmarksByRegionId(int regionId) throws IOException {
        String url = mServerUrl + "/region/" + regionId;
        String jsonArray = mHttpRequester.get(url);
        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public void updateLandmark(int landmarkId, Landmark landmark) throws IOException {
        String url = mServerUrl + "/visited/" + landmarkId;
        String requestBody = mJsonParser.toJson(landmark);
        mHttpRequester.put(url, requestBody);
    }
}
