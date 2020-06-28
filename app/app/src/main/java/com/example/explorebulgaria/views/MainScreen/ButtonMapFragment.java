package com.example.explorebulgaria.views.MainScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.explorebulgaria.Constants;
import com.example.explorebulgaria.R;
import com.example.explorebulgaria.models.Landmark;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButtonMapFragment extends Fragment implements ButtonMapContracts.View {

    @BindView(R.id.btn_blagoevgrad)
    Button mBlagoevgradButton;
    @BindView(R.id.btn_burgas)
    Button mBurgasButton;
    @BindView(R.id.btn_varna)
    Button mVarnaButton;
    @BindView(R.id.btn_veliko_tarnovo)
    Button mVelikoTarnovoButton;
    @BindView(R.id.btn_vidin)
    Button mVidinButton;
    @BindView(R.id.btv_vraca)
    Button mVracaButton;
    @BindView(R.id.btn_gabrovo)
    Button mGabrovoButton;
    @BindView(R.id.btn_dobrich)
    Button mDobrichButton;
    @BindView(R.id.btn_kardjali)
    Button mKardjaliButton;
    @BindView(R.id.btn_kustendil)
    Button mKustendilButton;
    @BindView(R.id.btn_lovech)
    Button mLovechButton;
    @BindView(R.id.btn_montana)
    Button mMontanaButton;
    @BindView(R.id.btn_pazardjik)
    Button mPazardjikButton;
    @BindView(R.id.btn_pernik)
    Button mPerniksButton;
    @BindView(R.id.btn_pleven)
    Button mPlevenButton;
    @BindView(R.id.btn_plovdiv)
    Button mPlovdivButton;
    @BindView(R.id.btn_razgrad)
    Button mRazgradButton;
    @BindView(R.id.btn_ruse)
    Button mRuseButton;
    @BindView(R.id.btn_silistra)
    Button mSilistraButton;
    @BindView(R.id.btn_sliven)
    Button mSlivenButton;
    @BindView(R.id.btn_smolyan)
    Button mSmolyanButton;
    @BindView(R.id.btn_sofiya_oblast)
    Button mSofiyaButton;
    @BindView(R.id.btn_stara_zagora)
    Button mStaraZagoraButton;
    @BindView(R.id.btn_targovishte)
    Button mTargovishteButton;
    @BindView(R.id.btn_haskovo)
    Button mHaskovoButton;
    @BindView(R.id.btn_shumen)
    Button mShumenButton;
    @BindView(R.id.btn_yambol)
    Button mYambolButton;

    ButtonMapContracts.Presenter mPresenter;

    @Inject
    LandmarksListFragment mLandmarksListFragment;
    @Inject
    LandmarksListContracts.Presenter mLandmarksListPresenter;

    @Inject
    public ButtonMapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button_map, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.selectRegion();
    }

    @Override
    public void setPresenter(ButtonMapContracts.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void showLandmarks(List<Landmark> landmarks) {
        mLandmarksListFragment.setPresenter(mLandmarksListPresenter);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.landmarksLayout, mLandmarksListFragment);
        fragmentTransaction.detach(mLandmarksListFragment).attach(mLandmarksListFragment).commit();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    public void setSelectedRegion(int regionId) {
        Constants.REGION_ID = regionId;
        mPresenter.selectRegion();
    }

    @OnClick({R.id.btn_blagoevgrad})
    public void mBlagoevgradButtonClick() {
        setSelectedRegion(Constants.BLAGOEVGRAD_ID);
    }

    @OnClick({R.id.btn_burgas})
    public void mBurgasButtonClick() {
        setSelectedRegion(Constants.BURGAS_ID);
    }

    @OnClick({R.id.btn_varna})
    public void mVarnaButtonClick() {
        setSelectedRegion(Constants.VARNA_ID);
    }

    @OnClick({R.id.btn_veliko_tarnovo})
    public void mVelikoTarnovoButtonOnClick() {
        setSelectedRegion(Constants.VELIKO_TARNOVO_ID);
    }

    @OnClick({R.id.btn_vidin})
    public void mVidinButtonOnClick() {
        setSelectedRegion(Constants.VIDIN_ID);
    }

    @OnClick({R.id.btv_vraca})
    public void mVracaButtonOnClick() {
        setSelectedRegion(Constants.VRACA_ID);
    }

    @OnClick({R.id.btn_gabrovo})
    public void mGabrovoButtonOnClick() {
        setSelectedRegion(Constants.GABROVO_ID);
    }

    @OnClick({R.id.btn_dobrich})
    public void mDobrichButtonOnClick() {
        setSelectedRegion(Constants.DOBRICH_ID);
    }

    @OnClick({R.id.btn_kardjali})
    public void mKardjaliButtonOnClick() {
        setSelectedRegion(Constants.KARDJALI_ID);
    }

    @OnClick({R.id.btn_kustendil})
    public void mKustendilButtonOnClick() {
        setSelectedRegion(Constants.KUSTENDIL_ID);
    }

    @OnClick({R.id.btn_lovech})
    public void mLovechButtonOnClick() {
        setSelectedRegion(Constants.LOVECH_ID);
    }

    @OnClick({R.id.btn_montana})
    public void mMontanaButtonOnClick() {
        setSelectedRegion(Constants.MONTANA_ID);
    }

    @OnClick({R.id.btn_pazardjik})
    public void mPazardjikButtonOnClick() {
        setSelectedRegion(Constants.PAZARDJIK_ID);
    }

    @OnClick({R.id.btn_pernik})
    public void mPerniksButtonOnClick() {
        setSelectedRegion(Constants.PERNIK_ID);
    }

    @OnClick({R.id.btn_pleven})
    public void mPlevenButtonOnClick() {
        setSelectedRegion(Constants.PLEVEN_ID);
    }

    @OnClick({R.id.btn_plovdiv})
    public void mPlovdivButtonOnClick() {
        setSelectedRegion(Constants.PLOVDIV_ID);
    }

    @OnClick({R.id.btn_razgrad})
    public void mRazgradButtonOnClick() {
        setSelectedRegion(Constants.RAZGRAD_ID);
    }

    @OnClick({R.id.btn_ruse})
    public void mRuseButtonOnClick() {
        setSelectedRegion(Constants.RUSE_ID);
    }

    @OnClick({R.id.btn_silistra})
    public void mSilistraButtonOnClick() {
        setSelectedRegion(Constants.SILISTRA_ID);
    }

    @OnClick({R.id.btn_sliven})
    public void mSlivenButtonOnClick() {
        setSelectedRegion(Constants.SLIVEN_ID);
    }

    @OnClick({R.id.btn_smolyan})
    public void mSmolyanButtonOnClick() {
        setSelectedRegion(Constants.SMOLYAN_ID);
    }

    @OnClick({R.id.btn_sofiya_oblast})
    public void mSofiyaButtonOnClick() {
        setSelectedRegion(Constants.SOFIYA_ID);
    }

    @OnClick({R.id.btn_stara_zagora})
    public void mStaraZagoraButtonOnClick() {
        setSelectedRegion(Constants.STARA_ZAGORA_ID);
    }

    @OnClick({R.id.btn_targovishte})
    public void mTargovishteButtonOnClick() {
        setSelectedRegion(Constants.TARGOVISHTE_ID);
    }

    @OnClick({R.id.btn_haskovo})
    public void mHaskovoButtonOnClick() {
        setSelectedRegion(Constants.HASKOVO_ID);
    }

    @OnClick({R.id.btn_shumen})
    public void mShumenButtonOnClick() {
        setSelectedRegion(Constants.SHUMEN_ID);
    }

    @OnClick({R.id.btn_yambol})
    public void mYambolButtonOnClick() {
        setSelectedRegion(Constants.YAMBOL_ID);
    }
}