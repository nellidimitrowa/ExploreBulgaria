package com.example.explorebulgaria.views.MainScreen;

import android.os.StrictMode;

import com.example.explorebulgaria.Constants;
import com.example.explorebulgaria.async.base.SchedulerProvider;
import com.example.explorebulgaria.models.Landmark;
import com.example.explorebulgaria.services.landmark.base.LandmarkService;
import com.example.explorebulgaria.services.region.base.RegionService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class ButtonMapPresenter implements ButtonMapContracts.Presenter {

    private final RegionService mRegionService;
    private final LandmarkService mLandmarkService;
    private final SchedulerProvider mSchedulerProvider;

    private ButtonMapContracts.View mView;

    @Inject
    public ButtonMapPresenter(RegionService regionService, LandmarkService landmarkService, SchedulerProvider schedulerProvider) {
        mRegionService = regionService;
        mLandmarkService = landmarkService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(ButtonMapContracts.View view) {
        mView = view;
    }

    @Override
    public void selectRegion() {
        Disposable observable = Observable.create((ObservableOnSubscribe<List<Landmark>>) emitter -> {
            List<Landmark> landmarks = mLandmarkService.getLandmarksByRegionId(Constants.REGION_ID);
            emitter.onNext(landmarks);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(mView::showLandmarks);
    }

    @Override
    public boolean checkRegionVisited(int regionId) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Constants.VISITED_REGION = mRegionService.isRegionVisited(regionId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Constants.VISITED_REGION;
    }
}
