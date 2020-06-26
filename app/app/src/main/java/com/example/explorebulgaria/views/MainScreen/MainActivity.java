package com.example.explorebulgaria.views.MainScreen;

import android.os.Bundle;

import com.example.explorebulgaria.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    ButtonMapFragment mButtonMapFragment;

    @Inject
    ButtonMapContracts.Presenter mButtonMapPresenter;

    @Inject
    LandmarksListFragment mLandmarksListFragment;

    @Inject
    LandmarksListContracts.Presenter mLandmarksListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mButtonMapFragment.setPresenter(mButtonMapPresenter);
        mLandmarksListFragment.setPresenter(mLandmarksListPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.buttonMapLayout, mButtonMapFragment)
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.landmarksLayout, mLandmarksListFragment)
                .commit();
    }
}