package com.example.explorebulgaria.views.MainScreen;

import com.example.explorebulgaria.models.Landmark;

import java.util.List;

public interface ButtonMapContracts {

    interface View {

        void setPresenter(Presenter presenter);

        void showLandmarks(List<Landmark> landmarks);

        void showError(Throwable e);
    }

    interface Presenter {

        void subscribe(View view);

        void selectRegion();
    }
}
