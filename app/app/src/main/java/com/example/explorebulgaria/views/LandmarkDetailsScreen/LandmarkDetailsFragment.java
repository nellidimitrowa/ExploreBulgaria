package com.example.explorebulgaria.views.LandmarkDetailsScreen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.explorebulgaria.R;
import com.example.explorebulgaria.models.Landmark;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandmarkDetailsFragment extends Fragment implements LandmarkDetailsContracts.View {

    @BindView(R.id.tv_landmark_name)
    TextView mLandmarkName;

    @BindView(R.id.iv_landmark_detail)
    ImageView mLandmarkPicture;

    @BindView(R.id.tv_landmark_description)
    TextView mLandmarkDescription;

    @BindView(R.id.tv_work_time)
    TextView mLandmarkWorkTime;

    @BindView(R.id.tv_entrance_fee)
    TextView mLandmarkEntranceFee;

    @Inject
    LandmarkDetailsContracts.Presenter mPresenter;

    private LinearLayoutManager mLayoutManager;
    private int mLandmarkId;

    @Inject
    public LandmarkDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_landmark_details, container, false);
        ButterKnife.bind(this, view);

        Intent intent = getActivity().getIntent();
        mLandmarkId = intent.getIntExtra("landmarkId", 0);
        String landmarkName = intent.getStringExtra("landmarkName");
        mLandmarkName.setText(landmarkName);
        String landmarkPicture = intent.getStringExtra("picture");
        InputStream stream = new ByteArrayInputStream(Base64.decode(landmarkPicture.getBytes(), Base64.DEFAULT));
        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        mLandmarkPicture.setImageBitmap(bitmap);
        String landmarkDescription = intent.getStringExtra("description");
        mLandmarkDescription.setText(landmarkDescription);
        String landmarkWorkTime = intent.getStringExtra("workTime");
        mLandmarkWorkTime.setText(landmarkWorkTime);
        String landmarkEntranceFee = intent.getStringExtra("entranceFee");
        mLandmarkEntranceFee.setText(landmarkEntranceFee);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(LandmarkDetailsContracts.Presenter presenter) {
            mPresenter = presenter;
    }

    @Override
    public void showEmptyList() {
        Toast.makeText(getContext(),
                "Не е намерена информация за дадената забележителност",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLandmark(Landmark landmark) {

    }


}