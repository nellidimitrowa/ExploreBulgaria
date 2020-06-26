package com.example.explorebulgaria.views.MainScreen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.explorebulgaria.R;
import com.example.explorebulgaria.models.Landmark;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LandmarksListAdapter extends RecyclerView.Adapter<LandmarksListAdapter.LandmarksListViewHolder>{

    private List<Landmark> mLandmarks;
    private OnLandmarkListClickListener mOnLandmarkListClickListener;

    @Inject
    public LandmarksListAdapter() {
        mLandmarks = new ArrayList<>();
    }

    @NonNull
    @Override
    public LandmarksListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.landmark_item, parent, false);
        return new LandmarksListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarksListViewHolder holder, int position) {
        holder.setOnClickListener(mOnLandmarkListClickListener);
        holder.bind(mLandmarks.get(position));
    }

    @Override
    public int getItemCount() {
        return mLandmarks.size();
    }

    public Landmark getItem(int position) {
        return mLandmarks.get(position);
    }

    public void clear() {  mLandmarks.clear(); }

    public void addAll(List<Landmark> Landmarks) {
        mLandmarks.addAll(Landmarks);
    }

    public void setOnLandmarkListClickListener(OnLandmarkListClickListener onLandmarkListClickListener) {
        this.mOnLandmarkListClickListener = onLandmarkListClickListener;
    }

    public static class LandmarksListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_landmark)
        ImageView mLandmarkImageView;

        @BindView(R.id.tv_landmarkName)
        TextView mLandmarkNameTextView;

        @BindView(R.id.cb_visited)
        CheckBox mLandmarkVisitedCheckBox;

        private OnLandmarkListClickListener mOnClickListener;
        private Landmark mLandmark;

        public LandmarksListViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Landmark landmark) {
            mLandmarkImageView.setImageBitmap(convertImageToBitmap(landmark.getPicture()));
            mLandmarkNameTextView.setText(landmark.getLandmarkName());
            mLandmarkVisitedCheckBox.setChecked(landmark.isVisited());

            mLandmark = landmark;
        }

        private Bitmap convertImageToBitmap(String image) {
            InputStream stream = new ByteArrayInputStream(Base64.decode(image.getBytes(), Base64.DEFAULT));

            return BitmapFactory.decodeStream(stream);
        }

        @OnClick
        public void OnClick() {
            mOnClickListener.onClick(mLandmark);
        }

        public void setOnClickListener(OnLandmarkListClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnLandmarkListClickListener {
        void onClick(Landmark landmark);
    }
}
