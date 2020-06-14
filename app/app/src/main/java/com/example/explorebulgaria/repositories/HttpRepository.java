package com.example.explorebulgaria.repositories;

import com.example.explorebulgaria.http.HttpRequester;
import com.example.explorebulgaria.parsers.base.JsonParser;
import com.example.explorebulgaria.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpRepository<T> implements Repository {

    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<T> mJsonParser;

    public HttpRepository(HttpRequester mHttpRequester, String mServerUrl, JsonParser<T> mJsonParser) {
        this.mHttpRequester = mHttpRequester;
        this.mServerUrl = mServerUrl;
        this.mJsonParser = mJsonParser;
    }

    @Override
    public List<T> getAll() throws IOException {
        String jsonArray = null;
        jsonArray = mHttpRequester.get(mServerUrl);
        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public T getById(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
    }
}
