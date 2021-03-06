package com.example.explorebulgaria.diconfig;

import android.app.Application;

import com.example.explorebulgaria.AndroidApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        HttpModule.class,
        ParserModule.class,
        ServicesModule.class,
        AsyncModule.class,
        RepositoryModule.class,
        MainScreenModule.class,
        MainScreenPresenterModule.class,
        LandmarksListViewModule.class,
        LandmarkDetailsScreenModule.class,
        LandmarkDetailsScreenPresenterModule.class
})

public interface AppComponent extends AndroidInjector<AndroidApplication> {

    //  TasksRepository getTasksRepository();

    // Gives us syntactic sugar we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }

}
