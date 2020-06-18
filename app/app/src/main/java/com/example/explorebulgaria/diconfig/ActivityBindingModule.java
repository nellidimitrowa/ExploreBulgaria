package com.example.explorebulgaria.diconfig;

import com.example.explorebulgaria.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = RepositoryModule.class)
    abstract MainActivity mainActivity();
}