package com.example.explorebulgaria.views.MainScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.explorebulgaria.Constants;
import com.example.explorebulgaria.R;
import com.example.explorebulgaria.http.OkHttpHttpRequester;
import com.example.explorebulgaria.models.Landmark;
import com.example.explorebulgaria.views.LandmarkDetailsScreen.LandmarkDetailsActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

public class LandmarksListFragment extends DaggerFragment implements LandmarksListContracts.View, LandmarksListAdapter.OnLandmarkListClickListener, LandmarksListAdapter.OnCheckBoxItemClickListener {

    @BindView(R.id.rv_landmarks)
    RecyclerView mLandmarksListView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @Inject
    LandmarksListAdapter mLandmarksListAdapter;
    //ButtonMapFragment mButtonMapFragment;

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
        mLandmarksListAdapter.setOnLandmarkCheckBoxClickListener(this);

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
    public void showLoading() {
        mLandmarksListView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLandmarksListView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
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
                "Изберете регион",
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
        Intent intent = new Intent(getContext(), LandmarkDetailsActivity.class);
        intent.putExtra("landmarkId", landmark.getLandmarkId());
        intent.putExtra("landmarkName", landmark.getLandmarkName());
        intent.putExtra("picture", landmark.getPicture());
        intent.putExtra("description", landmark.getDescription());
        intent.putExtra("workTime", landmark.getWorkTime());
        intent.putExtra("entranceFee", landmark.getEntranceFee());
        intent.putExtra("latitude", landmark.getLandmarkLatitude().toString());
        intent.putExtra("longitude", landmark.getLandmarkLongitude().toString());

        startActivity(intent);
    }

    @Override
    public void onClick(Landmark landmark) {
        mPresenter.selectLandmark(landmark);
    }

    @Override
    public void onItemClick(Landmark landmark) {
        mPresenter.changeLandmarkToVisited(landmark, landmark.getLandmarkId());
    }

    public boolean isRegionVisited(List<Landmark> landmarks) {
        boolean visited = true;
        for (Landmark landmark: landmarks) {
            if(!landmark.isVisited()) {
                visited = false;
                break;
            }
        }
        return visited;
    }

    public void changeRegionBackground(List<Landmark> landmarks) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpHttpRequester okHttpHttpRequester = new OkHttpHttpRequester();
        String body;
        int regionId = landmarks.get(0).getRegionId();
        boolean isRegionVisited = isRegionVisited(landmarks);
        JSONObject object = null;
        boolean regionVisited = false;
        try {
            String checkRegionInDatabase = okHttpHttpRequester.get( Constants.BASE_SERVER_URL + "/regions/" + regionId);
            object = new JSONObject(checkRegionInDatabase);
            regionVisited = object.getBoolean("regionVisited");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        if(isRegionVisited) {
            if(!regionVisited) {
                body = "{ \n \"isRegionVisited\": true\n }";
                try {
                    okHttpHttpRequester.put( Constants.BASE_SERVER_URL + "/regions/visited/" + regionId, body);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            switch (regionId) {
                case Constants.BLAGOEVGRAD_ID:
                        ((MainActivity)getActivity()).mButtonMapFragment.mBlagoevgradButton.setBackgroundResource(R.drawable.blagoevgrad_color);
                        break;
                case Constants.BURGAS_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mBurgasButton.setBackgroundResource(R.drawable.burgas_color);
                    break;
                case Constants.VARNA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mVarnaButton.setBackgroundResource(R.drawable.varna_color);
                    break;
                case Constants.VELIKO_TARNOVO_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mVelikoTarnovoButton.setBackgroundResource(R.drawable.veliko_tarnovo_color);
                    break;
                case Constants.VIDIN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mVidinButton.setBackgroundResource(R.drawable.vidin_color);
                    break;
                case Constants.VRACA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mVracaButton.setBackgroundResource(R.drawable.vraca_color);
                    break;
                case Constants.GABROVO_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mGabrovoButton.setBackgroundResource(R.drawable.gabrovo_color);
                    break;
                case Constants.DOBRICH_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mDobrichButton.setBackgroundResource(R.drawable.dobrich_color);
                    break;
                case Constants.KARDJALI_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mKardjaliButton.setBackgroundResource(R.drawable.kardjali_color);
                    break;
                case Constants.KUSTENDIL_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mKustendilButton.setBackgroundResource(R.drawable.kustendil_color);
                    break;
                case Constants.LOVECH_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mLovechButton.setBackgroundResource(R.drawable.lovech_color);
                    break;
                case Constants.MONTANA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mMontanaButton.setBackgroundResource(R.drawable.montana_color);
                    break;
                case Constants.PAZARDJIK_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mPazardjikButton.setBackgroundResource(R.drawable.pazardjik_color);
                    break;
                case Constants.PERNIK_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mPerniksButton.setBackgroundResource(R.drawable.pernik_color);
                    break;
                case Constants.PLEVEN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mPlevenButton.setBackgroundResource(R.drawable.pleven_color);
                    break;
                case Constants.PLOVDIV_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mPlovdivButton.setBackgroundResource(R.drawable.plovdiv_color);
                    break;
                case Constants.RAZGRAD_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mRazgradButton.setBackgroundResource(R.drawable.razgrad_color);
                    break;
                case Constants.RUSE_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mRuseButton.setBackgroundResource(R.drawable.ruse_color);
                    break;
                case Constants.SILISTRA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mSilistraButton.setBackgroundResource(R.drawable.silistra_color);
                    break;
                case Constants.SLIVEN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mSlivenButton.setBackgroundResource(R.drawable.sliven_color);
                    break;
                case Constants.SMOLYAN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mSmolyanButton.setBackgroundResource(R.drawable.smolyan_color);
                    break;
                case Constants.SOFIYA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mSofiyaButton.setBackgroundResource(R.drawable.sofiya_sofiya_oblast_color);
                    break;
                case Constants.STARA_ZAGORA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mStaraZagoraButton.setBackgroundResource(R.drawable.stara_zagora_color);
                    break;
                case Constants.TARGOVISHTE_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mTargovishteButton.setBackgroundResource(R.drawable.targovishte_color);
                    break;
                case Constants.HASKOVO_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mHaskovoButton.setBackgroundResource(R.drawable.haskovo_color);
                    break;
                case Constants.SHUMEN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mShumenButton.setBackgroundResource(R.drawable.shumen_color);
                    break;
                case Constants.YAMBOL_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mYambolButton.setBackgroundResource(R.drawable.yambol_color);
                    break;
            }
        } else {
            if (regionVisited) {
                body = "{ \n \"isRegionVisited\": false\n }";
                try {
                    okHttpHttpRequester.put( Constants.BASE_SERVER_URL + "/regions/visited/" + regionId, body);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            switch (regionId) {
                case Constants.BLAGOEVGRAD_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mBlagoevgradButton.setBackgroundResource(R.drawable.blagoevgrad_selector);
                    break;
                case Constants.BURGAS_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mBurgasButton.setBackgroundResource(R.drawable.burgas_selector);
                    break;
                case Constants.VARNA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mVarnaButton.setBackgroundResource(R.drawable.varna_selector);
                    break;
                case Constants.VELIKO_TARNOVO_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mVelikoTarnovoButton.setBackgroundResource(R.drawable.veliko_tarnovo_selector);
                    break;
                case Constants.VIDIN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mVidinButton.setBackgroundResource(R.drawable.vidin_selector);
                    break;
                case Constants.VRACA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mVracaButton.setBackgroundResource(R.drawable.vraca_selector);
                    break;
                case Constants.GABROVO_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mGabrovoButton.setBackgroundResource(R.drawable.gabrovo_selector);
                    break;
                case Constants.DOBRICH_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mDobrichButton.setBackgroundResource(R.drawable.dobrich_selector);
                    break;
                case Constants.KARDJALI_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mKardjaliButton.setBackgroundResource(R.drawable.kardjali_selector);
                    break;
                case Constants.KUSTENDIL_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mKustendilButton.setBackgroundResource(R.drawable.kustendil_selector);
                    break;
                case Constants.LOVECH_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mLovechButton.setBackgroundResource(R.drawable.lovech_selector);
                    break;
                case Constants.MONTANA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mMontanaButton.setBackgroundResource(R.drawable.montana_selector);
                    break;
                case Constants.PAZARDJIK_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mPazardjikButton.setBackgroundResource(R.drawable.pazardjik_selector);
                    break;
                case Constants.PERNIK_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mPerniksButton.setBackgroundResource(R.drawable.pernik_selector);
                    break;
                case Constants.PLEVEN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mPlevenButton.setBackgroundResource(R.drawable.pleven_selector);
                    break;
                case Constants.PLOVDIV_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mPlovdivButton.setBackgroundResource(R.drawable.plovdiv_selector);
                    break;
                case Constants.RAZGRAD_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mRazgradButton.setBackgroundResource(R.drawable.razgrad_selector);
                    break;
                case Constants.RUSE_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mRuseButton.setBackgroundResource(R.drawable.ruse_selector);
                    break;
                case Constants.SILISTRA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mSilistraButton.setBackgroundResource(R.drawable.silistra_selector);
                    break;
                case Constants.SLIVEN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mSlivenButton.setBackgroundResource(R.drawable.sliven_selector);
                    break;
                case Constants.SMOLYAN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mSmolyanButton.setBackgroundResource(R.drawable.smolyan_selector);
                    break;
                case Constants.SOFIYA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mSofiyaButton.setBackgroundResource(R.drawable.sofiya_sofiya_oblast_selector);
                    break;
                case Constants.STARA_ZAGORA_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mStaraZagoraButton.setBackgroundResource(R.drawable.stara_zagora_selector);
                    break;
                case Constants.TARGOVISHTE_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mTargovishteButton.setBackgroundResource(R.drawable.targovishte_selector);
                    break;
                case Constants.HASKOVO_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mHaskovoButton.setBackgroundResource(R.drawable.haskovo_selector);
                    break;
                case Constants.SHUMEN_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mShumenButton.setBackgroundResource(R.drawable.shumen_selector);
                    break;
                case Constants.YAMBOL_ID:
                    ((MainActivity)getActivity()).mButtonMapFragment.mYambolButton.setBackgroundResource(R.drawable.yambol_selector);
                    break;
            }
        }
    }
}