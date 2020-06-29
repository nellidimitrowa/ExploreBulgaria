package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.views.LandmarkDetailsScreen.LandmarkDetailsContracts;
import com.example.explorebulgaria.views.LandmarkDetailsScreen.LandmarkDetailsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LandmarkDetailsScreenPresenterModule {

    @Provides
    LandmarkDetailsContracts.Presenter landmarkDetailsPresenter(LandmarkDetailsPresenter presenter){
        return presenter;
    }

}
