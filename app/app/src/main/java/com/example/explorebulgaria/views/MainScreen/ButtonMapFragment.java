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

    public boolean isRegionVisited;

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
        setButtonBackgrounds();
        mPresenter.selectRegion();
    }

    @Override
    public void setPresenter(ButtonMapContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setButtonBackgrounds() {
        if(mPresenter.checkRegionVisited(Constants.BLAGOEVGRAD_ID)) {
            mBlagoevgradButton.setBackgroundResource(R.drawable.blagoevgrad_color);
        } else {
            mBlagoevgradButton.setBackgroundResource(R.drawable.blagoevgrad_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.BURGAS_ID)) {
            mBurgasButton.setBackgroundResource(R.drawable.burgas_color);
        } else {
            mBurgasButton.setBackgroundResource(R.drawable.burgas_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.VARNA_ID)) {
            mVarnaButton.setBackgroundResource(R.drawable.varna_color);
        } else {
            mVarnaButton.setBackgroundResource(R.drawable.varna_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.VELIKO_TARNOVO_ID)) {
            mVelikoTarnovoButton.setBackgroundResource(R.drawable.veliko_tarnovo_color);
        } else {
            mVelikoTarnovoButton.setBackgroundResource(R.drawable.veliko_tarnovo_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.VIDIN_ID)) {
            mVidinButton.setBackgroundResource(R.drawable.vidin_color);
        } else {
            mVidinButton.setBackgroundResource(R.drawable.vidin_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.VRACA_ID)) {
            mVracaButton.setBackgroundResource(R.drawable.vraca_color);
        } else {
            mVracaButton.setBackgroundResource(R.drawable.vraca_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.GABROVO_ID)) {
            mGabrovoButton.setBackgroundResource(R.drawable.gabrovo_color);
        } else {
            mGabrovoButton.setBackgroundResource(R.drawable.gabrovo_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.DOBRICH_ID)) {
            mDobrichButton.setBackgroundResource(R.drawable.dobrich_color);
        } else {
            mDobrichButton.setBackgroundResource(R.drawable.dobrich_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.KARDJALI_ID)) {
            mKardjaliButton.setBackgroundResource(R.drawable.kardjali_color);
        } else {
            mKardjaliButton.setBackgroundResource(R.drawable.kardjali_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.KUSTENDIL_ID)) {
            mKustendilButton.setBackgroundResource(R.drawable.kustendil_color);
        } else {
            mKustendilButton.setBackgroundResource(R.drawable.kustendil_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.LOVECH_ID)) {
            mLovechButton.setBackgroundResource(R.drawable.lovech_color);
        } else {
            mLovechButton.setBackgroundResource(R.drawable.lovech_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.MONTANA_ID)) {
            mMontanaButton.setBackgroundResource(R.drawable.montana_color);
        } else {
            mMontanaButton.setBackgroundResource(R.drawable.montana_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.PAZARDJIK_ID)) {
            mPazardjikButton.setBackgroundResource(R.drawable.pazardjik_color);
        } else {
            mPazardjikButton.setBackgroundResource(R.drawable.pazardjik_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.PERNIK_ID)) {
            mPerniksButton.setBackgroundResource(R.drawable.pernik_color);
        } else {
            mPerniksButton.setBackgroundResource(R.drawable.pernik_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.PLEVEN_ID)) {
            mPlevenButton.setBackgroundResource(R.drawable.pleven_color);
        } else {
            mPlevenButton.setBackgroundResource(R.drawable.pleven_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.PLOVDIV_ID)) {
            mPlovdivButton.setBackgroundResource(R.drawable.plovdiv_color);
        } else {
            mPlovdivButton.setBackgroundResource(R.drawable.plovdiv_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.RAZGRAD_ID)) {
            mRazgradButton.setBackgroundResource(R.drawable.razgrad_color);
        } else {
            mRazgradButton.setBackgroundResource(R.drawable.razgrad_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.RUSE_ID)) {
            mRuseButton.setBackgroundResource(R.drawable.ruse_color);
        } else {
            mRuseButton.setBackgroundResource(R.drawable.ruse_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.SILISTRA_ID)) {
            mSilistraButton.setBackgroundResource(R.drawable.silistra_color);
        } else {
            mSilistraButton.setBackgroundResource(R.drawable.silistra_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.SLIVEN_ID)) {
            mSlivenButton.setBackgroundResource(R.drawable.sliven_color);
        } else {
            mSlivenButton.setBackgroundResource(R.drawable.sliven_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.SMOLYAN_ID)) {
            mSmolyanButton.setBackgroundResource(R.drawable.smolyan_color);
        } else {
            mSmolyanButton.setBackgroundResource(R.drawable.smolyan_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.SOFIYA_ID)) {
            mSofiyaButton.setBackgroundResource(R.drawable.sofiya_sofiya_oblast_color);
        } else {
            mSofiyaButton.setBackgroundResource(R.drawable.sofiya_sofiya_oblast_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.STARA_ZAGORA_ID)) {
            mStaraZagoraButton.setBackgroundResource(R.drawable.stara_zagora_color);
        } else {
            mStaraZagoraButton.setBackgroundResource(R.drawable.stara_zagora_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.TARGOVISHTE_ID)) {
            mTargovishteButton.setBackgroundResource(R.drawable.targovishte_color);
        } else {
            mTargovishteButton.setBackgroundResource(R.drawable.targovishte_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.HASKOVO_ID)) {
            mHaskovoButton.setBackgroundResource(R.drawable.haskovo_color);
        } else {
            mHaskovoButton.setBackgroundResource(R.drawable.haskovo_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.SHUMEN_ID)) {
            mShumenButton.setBackgroundResource(R.drawable.shumen_color);
        } else {
            mShumenButton.setBackgroundResource(R.drawable.shumen_selector);
        }

        if(mPresenter.checkRegionVisited(Constants.YAMBOL_ID)) {
            mYambolButton.setBackgroundResource(R.drawable.yambol_color);
        } else {
            mYambolButton.setBackgroundResource(R.drawable.yambol_selector);
        }
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
        ((MainActivity)getActivity()).setTitle("Опознай България - област Благоевград");
    }

    @OnClick({R.id.btn_burgas})
    public void mBurgasButtonClick() {
        setSelectedRegion(Constants.BURGAS_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Бургас");
    }

    @OnClick({R.id.btn_varna})
    public void mVarnaButtonClick() {
        setSelectedRegion(Constants.VARNA_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Варна");
    }

    @OnClick({R.id.btn_veliko_tarnovo})
    public void mVelikoTarnovoButtonOnClick() {
        setSelectedRegion(Constants.VELIKO_TARNOVO_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Велико Търново");
    }

    @OnClick({R.id.btn_vidin})
    public void mVidinButtonOnClick() {
        setSelectedRegion(Constants.VIDIN_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Видин");
    }

    @OnClick({R.id.btv_vraca})
    public void mVracaButtonOnClick() {
        setSelectedRegion(Constants.VRACA_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Враца");
    }

    @OnClick({R.id.btn_gabrovo})
    public void mGabrovoButtonOnClick() {
        setSelectedRegion(Constants.GABROVO_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Габрово");
    }

    @OnClick({R.id.btn_dobrich})
    public void mDobrichButtonOnClick() {
        setSelectedRegion(Constants.DOBRICH_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Добрич");
    }

    @OnClick({R.id.btn_kardjali})
    public void mKardjaliButtonOnClick() {
        setSelectedRegion(Constants.KARDJALI_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Кърджали");
    }

    @OnClick({R.id.btn_kustendil})
    public void mKustendilButtonOnClick() {
        setSelectedRegion(Constants.KUSTENDIL_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Кюстендил");
    }

    @OnClick({R.id.btn_lovech})
    public void mLovechButtonOnClick() {
        setSelectedRegion(Constants.LOVECH_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Ловеч");
    }

    @OnClick({R.id.btn_montana})
    public void mMontanaButtonOnClick() {
        setSelectedRegion(Constants.MONTANA_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Монтана");
    }

    @OnClick({R.id.btn_pazardjik})
    public void mPazardjikButtonOnClick() {
        setSelectedRegion(Constants.PAZARDJIK_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Пазарджик");
    }

    @OnClick({R.id.btn_pernik})
    public void mPerniksButtonOnClick() {
        setSelectedRegion(Constants.PERNIK_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Перник");
    }

    @OnClick({R.id.btn_pleven})
    public void mPlevenButtonOnClick() {
        setSelectedRegion(Constants.PLEVEN_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Плевен");
    }

    @OnClick({R.id.btn_plovdiv})
    public void mPlovdivButtonOnClick() {
        setSelectedRegion(Constants.PLOVDIV_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Пловдив");
    }

    @OnClick({R.id.btn_razgrad})
    public void mRazgradButtonOnClick() {
        setSelectedRegion(Constants.RAZGRAD_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Разград");
    }

    @OnClick({R.id.btn_ruse})
    public void mRuseButtonOnClick() {
        setSelectedRegion(Constants.RUSE_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Русе");
    }

    @OnClick({R.id.btn_silistra})
    public void mSilistraButtonOnClick() {
        setSelectedRegion(Constants.SILISTRA_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Силистра");
    }

    @OnClick({R.id.btn_sliven})
    public void mSlivenButtonOnClick() {
        setSelectedRegion(Constants.SLIVEN_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Сливен");
    }

    @OnClick({R.id.btn_smolyan})
    public void mSmolyanButtonOnClick() {
        setSelectedRegion(Constants.SMOLYAN_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Смолян");
    }

    @OnClick({R.id.btn_sofiya_oblast})
    public void mSofiyaButtonOnClick() {
        setSelectedRegion(Constants.SOFIYA_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област София");
    }

    @OnClick({R.id.btn_stara_zagora})
    public void mStaraZagoraButtonOnClick() {
        setSelectedRegion(Constants.STARA_ZAGORA_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Стара Загора");
    }

    @OnClick({R.id.btn_targovishte})
    public void mTargovishteButtonOnClick() {
        setSelectedRegion(Constants.TARGOVISHTE_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Търговище");
    }

    @OnClick({R.id.btn_haskovo})
    public void mHaskovoButtonOnClick() {
        setSelectedRegion(Constants.HASKOVO_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Хасково");
    }

    @OnClick({R.id.btn_shumen})
    public void mShumenButtonOnClick() {
        setSelectedRegion(Constants.SHUMEN_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Шумен");
    }

    @OnClick({R.id.btn_yambol})
    public void mYambolButtonOnClick() {
        setSelectedRegion(Constants.YAMBOL_ID);
        ((MainActivity)getActivity()).setTitle("Опознай България - област Ямбол");
    }
}