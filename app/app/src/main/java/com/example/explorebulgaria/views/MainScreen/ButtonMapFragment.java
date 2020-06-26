package com.example.explorebulgaria.views.MainScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.explorebulgaria.R;
import com.example.explorebulgaria.models.Landmark;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    public void setPresenter(ButtonMapContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLandmarks(List<Landmark> landmarks) {
        //TODO
        //tyka toi otvarq nov intent
        //a az trqbva da vidq kak da vikam drygiq fragment
    }
}