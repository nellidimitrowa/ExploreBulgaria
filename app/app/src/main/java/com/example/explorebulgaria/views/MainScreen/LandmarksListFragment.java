package com.example.explorebulgaria.views.MainScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.explorebulgaria.R;
import com.example.explorebulgaria.models.Landmark;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

public class LandmarksListFragment extends DaggerFragment implements LandmarksListContracts.View, LandmarksListAdapter.OnLandmarkListClickListener {

    @BindView(R.id.rv_landmarks)
    RecyclerView mLandmarksListView;

    @Inject
    LandmarksListAdapter mLandmarksListAdapter;

    private LinearLayoutManager mLayoutManager;
    private LandmarksListContracts.Presenter mPresenter;

    @Inject
    public LandmarksListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landmarks_list, container, false);

        ButterKnife.bind(this, view);

        mLandmarksListAdapter.setOnLandmarkListClickListener(this);

        mLandmarksListView.setAdapter(mLandmarksListAdapter);
        mLayoutManager = new LinearLayoutManager(getContext());
        mLandmarksListView.setLayoutManager(mLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadLandmarks();
    }

    @Override
    public void setPresenter(LandmarksListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLandmarks(List<Landmark> landmarks) {
        mLandmarksListAdapter.clear();
        mLandmarksListAdapter.addAll(landmarks);
        mLandmarksListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyList() {
        Toast.makeText(getContext(),
                "NO LANDMARKS TO SHOW",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLandmarkDetails(Landmark landmark) {
        //intent kum sledvashtoto activity
    }

    @Override
    public void onClick(Landmark landmark) {
        mPresenter.selectLandmark(landmark);
    }
}