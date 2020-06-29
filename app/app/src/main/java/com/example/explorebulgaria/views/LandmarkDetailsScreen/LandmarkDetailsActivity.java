package com.example.explorebulgaria.views.LandmarkDetailsScreen;

import android.os.Bundle;

import com.example.explorebulgaria.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LandmarkDetailsActivity extends DaggerAppCompatActivity {

    @Inject
    LandmarkDetailsFragment mLandmarkDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmark_details);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, mLandmarkDetailsFragment)
                .commit();
    }
}