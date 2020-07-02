package com.example.explorebulgaria.views.MainScreen;

import com.example.explorebulgaria.Constants;
import com.example.explorebulgaria.async.base.SchedulerProvider;
import com.example.explorebulgaria.models.Landmark;
import com.example.explorebulgaria.services.landmark.base.LandmarkService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class LandmarksListPresenter implements LandmarksListContracts.Presenter {

    private final LandmarkService mLandmarkService;
    private final SchedulerProvider mSchedulerProvider;
    private LandmarksListContracts.View mView;
    private ButtonMapContracts.View mButtonMapView;

    @Inject
    LandmarksListPresenter(LandmarkService mLandmarkService, SchedulerProvider schedulerProvider) {
        this.mLandmarkService = mLandmarkService;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(LandmarksListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadLandmarks() {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<List<Landmark>>) emitter -> {
            List<Landmark> landmarks = mLandmarkService.getLandmarksByRegionId(Constants.REGION_ID);
            emitter.onNext(landmarks);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(this::presentLandmarksToView);
    }

    private void presentLandmarksToView(List<Landmark> landmarks) {
        if (landmarks.isEmpty()) {
            mView.showEmptyList();
        } else {
            mView.showLandmarks(landmarks);
        }
    }

    @Override
    public void selectLandmark(Landmark landmark) {
        mView.showLandmarkDetails(landmark);
    }

    @Override
    public void changeLandmarkToVisited(Landmark landmark, int landmarkId) {
        Disposable observable = Observable.create((ObservableOnSubscribe<List<Landmark>>) emitter -> {
            mLandmarkService.updateLandmark(landmarkId, landmark);
            List<Landmark> landmarks = mLandmarkService.getLandmarksByRegionId(landmark.getRegionId());
            emitter.onNext(landmarks);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(mView::changeRegionBackground);
    }
}
