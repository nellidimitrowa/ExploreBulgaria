package com.example.explorebulgaria.views.LandmarkDetailsScreen;

import com.example.explorebulgaria.models.Landmark;

public interface LandmarkDetailsContracts {

    interface View {
        void setPresenter(LandmarkDetailsContracts.Presenter presenter);

        void showEmptyList();

        void showError(Throwable e);

        void showLandmark(Landmark landmark);
    }

    interface Presenter {

        void subscribe(LandmarkDetailsContracts.View view);

        void loadLandmark(int landmarkId);

    }
}
