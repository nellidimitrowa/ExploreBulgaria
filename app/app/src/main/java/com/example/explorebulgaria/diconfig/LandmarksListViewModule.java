package com.example.explorebulgaria.diconfig;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.explorebulgaria.views.MainScreen.LandmarksListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class LandmarksListViewModule {

    @Provides
    public RecyclerView.Adapter<LandmarksListAdapter.LandmarksListViewHolder> LandmarksListArrayAdapter(Context context) {
        return new LandmarksListAdapter();
    }
}
