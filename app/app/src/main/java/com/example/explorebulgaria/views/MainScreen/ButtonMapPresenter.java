package com.example.explorebulgaria.views.MainScreen;

import com.example.explorebulgaria.services.region.base.RegionService;

import javax.inject.Inject;

public class ButtonMapPresenter implements ButtonMapContracts.Presenter {

    private final RegionService mRegionService;
    private ButtonMapContracts.View mView;

    @Inject
    public ButtonMapPresenter(RegionService regionService) {
        mRegionService = regionService;
    }

    @Override
    public void subscribe(ButtonMapContracts.View view) {
        mView = view;
    }

    @Override
    public void selectRegion() {
        //TODO
        //showLandmarks
    }
}
