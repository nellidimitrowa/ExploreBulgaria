package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.views.MainScreen.ButtonMapFragment;
import com.example.explorebulgaria.views.MainScreen.LandmarksListFragment;

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

}
