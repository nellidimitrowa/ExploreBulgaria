package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.views.MainScreen.ButtonMapContracts;
import com.example.explorebulgaria.views.MainScreen.ButtonMapPresenter;
import com.example.explorebulgaria.views.MainScreen.LandmarksListContracts;
import com.example.explorebulgaria.views.MainScreen.LandmarksListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainScreenPresenterModule {

    @Provides
    ButtonMapContracts.Presenter buttonMapPresenter(ButtonMapPresenter presenter){
        return presenter;
    }

    @Provides
    LandmarksListContracts.Presenter landmarksListPresenter(LandmarksListPresenter presenter){
        return presenter;
    }

}
