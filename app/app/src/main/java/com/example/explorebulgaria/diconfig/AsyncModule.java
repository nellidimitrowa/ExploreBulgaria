package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.async.AsyncSchedulerProvider;
import com.example.explorebulgaria.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {

    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }

}
