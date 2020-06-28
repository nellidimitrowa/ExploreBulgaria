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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mButtonMapFragment.setPresenter(mButtonMapPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.buttonMapLayout, mButtonMapFragment)
                .commit();
    }
}