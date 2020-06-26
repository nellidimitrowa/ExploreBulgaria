package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.views.MainScreen.ButtonMapContracts;
import com.example.explorebulgaria.views.MainScreen.ButtonMapFragment;
import com.example.explorebulgaria.views.MainScreen.ButtonMapPresenter;
import com.example.explorebulgaria.views.MainScreen.LandmarksListContracts;
import com.example.explorebulgaria.views.MainScreen.LandmarksListFragment;
import com.example.explorebulgaria.views.MainScreen.LandmarksListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainScreenModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ButtonMapFragment buttonMapFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LandmarksListFragment landmarksListFragment();

    @ActivityScoped
    @Binds
    abstract ButtonMapContracts.Presenter buttonMapPresenter(ButtonMapPresenter presenter);

    @ActivityScoped
    @Binds
    abstract LandmarksListContracts.Presenter landmarksListPresenter(LandmarksListPresenter presenter);
}
