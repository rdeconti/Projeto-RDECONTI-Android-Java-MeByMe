package com.prosper.day.module10biorhythm;

 /* ****************************************************************************
 /* Copyright (C) 2016 The Android Open Source Project
 /*
 /* Licensed under the Apache License, Version 2.0 (the "License");
 /* you may not use this file except in compliance with the License.
 /* You may obtain a copy of the License at
 /*
 /*     http://www.apache.org/licenses/LICENSE-2.0
 /*
 /* Unless required by applicable law or agreed to in writing, software
 /* distributed under the License is distributed on an "AS IS" BASIS,
 /* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 /* See the License for the specific language governing permissions and
 /* limitations under the License.
 /* ****************************************************************************
 /* Created by Rosemeire Deconti on 2019 / July
 /* ****************************************************************************/

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameStatus;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameSubPhase;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseStatusImage;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelModuleBiorhythmAnswer;

import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentAnswerId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseNumber;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportFormatDateCreation.supportFormatDateCreation;
import static com.prosper.day.applicationsupportclasses.SupportFormatDateEvent.supportFormatDateEvent;

public class ModuleFragmentBiorhythmRecyclerViewList extends RecyclerView.Adapter<ModuleFragmentBiorhythmRecyclerViewList.ViewHolder> {

    private View mView;
    private final Context mContext;
    private AppCompatActivity mAppCompatActivity;
    private Bitmap mBitmap;

    private String mStringAnswerId;
    private String mStringQuestionHeader;
    private String mStringPhaseNumber;
    private String mStringPhaseCode;
    private String mStringPhaseText;
    private String mStringGradeNumber;
    private String mStringStatusCode;
    private String mStringStatusText;
    private String mStringCurrentFragment;

    private String mStringCurrentUpdated;
    private String mStringFormattedCurrentDate;
    private String mStringCurrentDate;
    private String mStringFormatFloat;

    private Drawable mDrawable;
    private Legend mLegend;
    private HorizontalBarChart mHorizontalBarChart;

    private double value1;
    private double value2;
    private double value3;

    private final List<ModelModuleBiorhythmAnswer> mValues;

    // *********************************************************************************************
    // *********************************************************************************************
    ModuleFragmentBiorhythmRecyclerViewList(List<ModelModuleBiorhythmAnswer> items, Context context) {

        mContext = context;

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mValues = items;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.biorhythm_recyclerview_fragment_item, parent, false);
        return new ViewHolder(mView);
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        ModelModuleBiorhythmAnswer model = mValues.get(position);
        holder.recyclerViewItem = model;

        uploadLayoutData(holder, model);

        // *****************************************************************************************
        // *****************************************************************************************
        holder.mView.setOnClickListener(view -> {

            stringCurrentAnswerId = holder.mTextViewValueId.getText().toString();
            stringCurrentPhaseNumber = mStringPhaseNumber;

            mStringCurrentFragment = "ModuleFragmentBiorhythmRecyclerViewList";

            mAppCompatActivity = (AppCompatActivity) view.getContext();
            mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainConstraintLayout, new ModuleFragmentBiorhythmCrud(), mStringCurrentFragment)
                    .addToBackStack(mStringCurrentFragment)
                    .commit();
            
        });

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("DefaultLocale")
    private void uploadLayoutData(ViewHolder holder, ModelModuleBiorhythmAnswer model) {

        mStringPhaseCode = stringCurrentPhaseCode;
        mStringPhaseNumber = model.getRecordNumber();
        mStringStatusCode = model.getRecordStatus();
        mStringAnswerId = model.getRecordId();

        mStringPhaseText = SupportGeneratePhaseNameSubPhase.supportGeneratePhaseNameSubPhase(mContext, mStringPhaseCode);
        mStringStatusText = SupportGeneratePhaseNameStatus.supportGeneratePhaseNameStatus(mContext, mStringStatusCode);

        mBitmap =  SupportGeneratePhaseStatusImage.supportGeneratePhaseStatusImage(mContext, mStringStatusCode);

        mStringCurrentUpdated = model.getRecordDateUpdate();
        mStringCurrentDate = mStringCurrentUpdated.substring(0, 8);
        mStringFormattedCurrentDate = supportFormatDateCreation(mStringCurrentDate);
        holder.mTextViewValueUpdatedDate.setText(mStringFormattedCurrentDate);

        mStringCurrentUpdated = model.getRecordDateEvent();
        mStringCurrentDate = mStringCurrentUpdated.substring(0, 10);
        mStringFormattedCurrentDate = supportFormatDateEvent(mStringCurrentDate);
        holder.mTextViewValueEventDate.setText(mStringFormattedCurrentDate);

        holder.mTextViewValueNumberPoints.setText(model.getRecordNumberPoints());
        holder.mTextViewValueNumberPhotos.setText(model.getRecordNumberPhotos());
        holder.mTextViewValueNumberActions.setText(model.getRecordNumberActions());
        holder.mTextViewValueNumberSharing.setText(model.getRecordNumberSharing());

        holder.mTextViewValueSubPhases.setText(mStringPhaseText);
        holder.mTextViewValueStatus.setText(mStringStatusText);
        holder.mTextViewValueId.setText(mStringAnswerId);
        holder.mTextViewValueNumber.setText(mStringPhaseNumber);

        value1 = model.getRecordEmotional();
        mStringFormatFloat = String.format("%.4f", value1);
        holder.mTextViewValueEmotional.setText(mStringFormatFloat);

        if (value1 > 0) {
            holder.imageViewValueEmotional.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hand_bitmap_approved_small));
        } else {
            holder.imageViewValueEmotional.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hand_bitmap_reproved_small));
        }

        value2 = model.getRecordIntelectual();
        mStringFormatFloat = String.format("%.4f", value2);
        holder.mTextViewValueIntellectual.setText(mStringFormatFloat);

        if (value2 > 0) {
            holder.imageViewValueIntellectual.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hand_bitmap_approved_small));
        } else {
            holder.imageViewValueIntellectual.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hand_bitmap_reproved_small));
        }

        value3 = model.getRecordPhysical();
        mStringFormatFloat = String.format("%.4f", value3);
        holder.mTextViewValuePhysical.setText(mStringFormatFloat);

        if (value3 > 0) {
            holder.imageViewValuePhysical.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hand_bitmap_approved_small));
        } else {
            holder.imageViewValuePhysical.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hand_bitmap_reproved_small));
        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public int getItemCount() {

        if (mValues == null) {

            return INT_NUMBER_00;

        } else {

            return mValues.size();
        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    static class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;

        private final TextView mTextViewValueNumber;
        private final TextView mTextViewValueId;
        private final TextView mTextViewValueNumberPoints;
        private final TextView mTextViewValueSubPhases;
        private final TextView mTextViewValueStatus;
        private final TextView mTextViewValueUpdatedDate;
        private final TextView mTextViewValueEventDate;
        private final TextView mTextViewValueNumberPhotos;
        private final TextView mTextViewValueNumberActions;
        private final TextView mTextViewValueNumberSharing;
        private final TextView mTextViewValueIntellectual;
        private final TextView mTextViewValuePhysical;
        private final TextView mTextViewValueEmotional;

        private final ImageView imageViewValueIntellectual;
        private final ImageView imageViewValuePhysical;
        private final ImageView imageViewValueEmotional;

        ModelModuleBiorhythmAnswer recyclerViewItem;

        // *****************************************************************************************
        // *****************************************************************************************
        ViewHolder(View view) {
            super(view);

            mView = view;

            mTextViewValueId = mView.findViewById(R.id.mTextViewValueId);
            mTextViewValueNumber = mView.findViewById(R.id.mTextViewValueNumber);

            mTextViewValueSubPhases = mView.findViewById(R.id.mTextViewValueSubPhase);
            mTextViewValueStatus = mView.findViewById(R.id.mTextViewValueStatus);
            mTextViewValueUpdatedDate = mView.findViewById(R.id.mTextViewValueUpdatedDate);
            mTextViewValueEventDate = mView.findViewById(R.id.mTextViewValueEventDate);

            mTextViewValueNumberPhotos = mView.findViewById(R.id.mTextViewValueNumberPhotos);
            mTextViewValueNumberActions = mView.findViewById(R.id.mTextViewValueNumberActions);
            mTextViewValueNumberSharing = mView.findViewById(R.id.mTextViewValueNumberSharing);
            mTextViewValueNumberPoints = mView.findViewById(R.id.mTextViewValueNumberPoints);

            imageViewValueIntellectual = mView.findViewById(R.id.imageViewIntellectual);
            imageViewValuePhysical = mView.findViewById(R.id.imageViewPhysical);
            imageViewValueEmotional = mView.findViewById(R.id.imageViewEmotional);

            mTextViewValueIntellectual = mView.findViewById(R.id.mTextViewValueIntellectual);
            mTextViewValuePhysical = mView.findViewById(R.id.mTextViewValuePhysical);
            mTextViewValueEmotional = mView.findViewById(R.id.mTextViewValueEmotional);

        }
    }
}
