package com.prosper.day.module07life;

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

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseGradeImage;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameStatus;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameSubPhase;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelModuleLifeAnswer;

import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentAnswerId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseNumber;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportFormatDateCreation.supportFormatDateCreation;

public class ModuleFragmentLifeRecyclerViewList extends RecyclerView.Adapter<ModuleFragmentLifeRecyclerViewList.ViewHolder> {

    private View mView;
    private final Context mContext;
    private AppCompatActivity mAppCompatActivity;
    private Bitmap mBitmap;

    private String mStringAnswerId;
    private String mStringQuestionText;
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

    private final List<ModelModuleLifeAnswer> mValues;

    // *********************************************************************************************
    // *********************************************************************************************
    ModuleFragmentLifeRecyclerViewList(List<ModelModuleLifeAnswer> items, Context context) {

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

        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.life_recyclerview_fragment_item, parent, false);
        return new ViewHolder(mView);
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        ModelModuleLifeAnswer model = mValues.get(position);
        holder.recyclerViewItem = model;

        uploadLayoutData(holder, model);

        // *****************************************************************************************
        // *****************************************************************************************
        holder.mView.setOnClickListener(view -> {

            stringCurrentAnswerId = holder.mTextViewValueId.getText().toString();
            stringCurrentPhaseNumber = mStringPhaseNumber;

            mStringCurrentFragment = "ModuleFragmentLifeRecyclerViewList";

            mAppCompatActivity = (AppCompatActivity) view.getContext();
            mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainConstraintLayout, new ModuleFragmentLifeCrud(), mStringCurrentFragment)
                    .addToBackStack(mStringCurrentFragment)
                    .commit();
            
        });

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void uploadLayoutData(ViewHolder holder, ModelModuleLifeAnswer model) {

        mStringPhaseCode = model.getRecordPhase();
        mStringPhaseNumber = model.getRecordNumber();
        mStringStatusCode = model.getRecordStatus();
        mStringQuestionText = model.getRecordQuestion();
        mStringAnswerId = model.getRecordId();
        mStringGradeNumber = model.getRecordGrade();
        mStringCurrentUpdated = model.getRecordDateUpdate();

        mStringPhaseText = SupportGeneratePhaseNameSubPhase.supportGeneratePhaseNameSubPhase(mContext, mStringPhaseCode);
        mStringStatusText = SupportGeneratePhaseNameStatus.supportGeneratePhaseNameStatus(mContext, mStringStatusCode);
        mBitmap = SupportGeneratePhaseGradeImage.supportGeneratePhaseGradeImage(mContext, mStringGradeNumber);

        mStringCurrentDate = mStringCurrentUpdated.substring(0, 8);
        mStringFormattedCurrentDate = supportFormatDateCreation(mStringCurrentDate);

        holder.mTextViewValueNumberPoints.setText(model.getRecordNumberPoints());
        holder.mTextViewValueNumberPhotos.setText(model.getRecordNumberPhotos());
        holder.mTextViewValueNumberActions.setText(model.getRecordNumberActions());
        holder.mTextViewValueNumberSharing.setText(model.getRecordNumberSharing());

        holder.mTextViewValueQuestion.setText(model.getRecordQuestion());

        holder.mTextViewValueSubPhases.setText(mStringPhaseText);
        holder.mTextViewValueStatus.setText(mStringStatusText);
        holder.mTextViewValueId.setText(mStringAnswerId);
        holder.mTextViewValueNumber.setText(mStringPhaseNumber);

        holder.mImageViewValueImage.setImageBitmap(mBitmap);

        holder.mTextViewValueUpdatedDate.setText(mStringFormattedCurrentDate);

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
        private final TextView mTextViewValueQuestion;
        private final TextView mTextViewValueNumberPhotos;
        private final TextView mTextViewValueNumberActions;
        private final TextView mTextViewValueNumberSharing;

        private final ImageView mImageViewValueImage;

        ModelModuleLifeAnswer recyclerViewItem;

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
            mTextViewValueQuestion = mView.findViewById(R.id.mTextViewValueQuestion);

            mTextViewValueNumberPhotos = mView.findViewById(R.id.mTextViewValueNumberPhotos);
            mTextViewValueNumberActions = mView.findViewById(R.id.mTextViewValueNumberActions);
            mTextViewValueNumberSharing = mView.findViewById(R.id.mTextViewValueNumberSharing);
            mTextViewValueNumberPoints = mView.findViewById(R.id.mTextViewValueNumberPoints);

            mImageViewValueImage = mView.findViewById(R.id.imageView);

        }
    }
}
