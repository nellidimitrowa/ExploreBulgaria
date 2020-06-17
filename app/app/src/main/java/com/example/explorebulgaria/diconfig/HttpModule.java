package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.Constants;
import com.example.explorebulgaria.http.HttpRequester;
import com.example.explorebulgaria.http.OkHttpHttpRequester;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {

    @Provides
    public HttpRequester httpRequester() { return new OkHttpHttpRequester(); }

    @Provides
    @Named("baseServerUrl")
    public String baseServerUrl() { return Constants.BASE_SERVER_URL; }
}
