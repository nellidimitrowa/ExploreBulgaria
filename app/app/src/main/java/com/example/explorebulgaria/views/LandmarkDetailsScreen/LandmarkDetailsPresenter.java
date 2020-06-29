package com.example.explorebulgaria.views.LandmarkDetailsScreen;

import com.example.explorebulgaria.async.base.SchedulerProvider;
import com.example.explorebulgaria.models.Landmark;
import com.example.explorebulgaria.services.landmark.base.LandmarkService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class LandmarkDetailsPresenter implements LandmarkDetailsContracts.Presenter {

    private final LandmarkService mLandmarkService;
    private final SchedulerProvider mSchedulerProvider;
    private LandmarkDetailsContracts.View mView;

    @Inject
    public LandmarkDetailsPresenter(LandmarkService mLandmarkService, SchedulerProvider mSchedulerProvider) {
        this.mLandmarkService = mLandmarkService;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void subscribe(LandmarkDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadLandmark(int landmarkId) {
        Disposable observable = Observable.create((ObservableOnSubscribe<Landmark>) emitter -> {
            Landmark landmark = mLandmarkService.getLandmarkById(landmarkId);
            emitter.onNext(landmark);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .subscribe(mView::showLandmark);
    }
}
