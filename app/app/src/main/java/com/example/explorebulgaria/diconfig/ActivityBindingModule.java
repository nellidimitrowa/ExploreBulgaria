package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.views.MainScreen.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainScreenModule.class)
    abstract MainActivity mainActivity();
}
