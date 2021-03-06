package com.example.explorebulgaria.views.MainScreen;

import com.example.explorebulgaria.models.Landmark;

import java.util.List;

public interface LandmarksListContracts {

    interface View {

        void setPresenter(Presenter presenter);

        void showLoading();

        void hideLoading();

        void showLandmarks(List<Landmark> landmarks);

        void showEmptyList();

        void showError(Throwable e);

        void showLandmarkDetails(Landmark landmark);

        boolean isRegionVisited(List<Landmark> landmarks);

        void changeRegionBackground(List<Landmark> landmarks);
    }

    interface Presenter {

        void subscribe(View view);

        void loadLandmarks();

        void selectLandmark(Landmark landmark);

        void changeLandmarkToVisited(Landmark landmark, int landmarkId);
    }
}
