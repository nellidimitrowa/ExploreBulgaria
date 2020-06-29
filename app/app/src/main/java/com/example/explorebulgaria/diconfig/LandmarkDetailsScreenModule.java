package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.views.LandmarkDetailsScreen.LandmarkDetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LandmarkDetailsScreenModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LandmarkDetailsFragment landmarkDetailsFragment();

}
