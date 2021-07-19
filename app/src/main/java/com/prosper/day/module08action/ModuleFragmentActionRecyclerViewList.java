package com.prosper.day.module08action;

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
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameCosts;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameFrequency;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNamePriority;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameStatus;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameSubPhase;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseStatusImage;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelModuleActionAnswer;

import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentAnswerId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseNumber;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.CRUD_U;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCrudType;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportFormatDateCreation.supportFormatDateCreation;

public class ModuleFragmentActionRecyclerViewList extends RecyclerView.Adapter<ModuleFragmentActionRecyclerViewList.ViewHolder> {

    private View mView;
    private final Context mContext;
    private AppCompatActivity mAppCompatActivity;
    private Bitmap mBitmap;

    private String mStringAnswerId;
    private String mStringQuestionText;
    private String mStringPhaseNumber;
    private String mStringPhaseCode;
    private String mStringPhaseText;
    private String mStringCostsCode;
    private String mStringCostsText;
    private String mStringFrequencyCode;
    private String mStringFrequencyText;
    private String mStringPriorityCode;
    private String mStringPriorityText;
    private String mStringStatusCode;
    private String mStringStatusText;
    private String mStringGradeNumber;
    private String mStringCurrentFragment;
    private String mStringCurrentUpdated;
    private String mStringFormattedCurrentDate;
    private String mStringCurrentDate;

    private final List<ModelModuleActionAnswer> mValues;

    // *********************************************************************************************
    // *********************************************************************************************
    ModuleFragmentActionRecyclerViewList(List<ModelModuleActionAnswer> items, Context context) {

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

        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_recyclerview_fragment_item, parent, false);
        return new ViewHolder(mView);
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        ModelModuleActionAnswer model = mValues.get(position);
        holder.recyclerViewItem = model;

        uploadLayoutData(holder, model);

        // *****************************************************************************************
        // *****************************************************************************************
        holder.mView.setOnClickListener(view -> {

            stringCurrentAnswerId = holder.mTextViewValueId.getText().toString();
            stringCurrentPhaseNumber = mStringPhaseNumber;
            stringCrudType = CRUD_U;

            mStringCurrentFragment = "ModuleFragmentActionRecyclerViewList";

            mAppCompatActivity = (AppCompatActivity) view.getContext();
            mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainConstraintLayout, new ModuleFragmentActionCrud(), mStringCurrentFragment)
                    .addToBackStack(mStringCurrentFragment)
                    .commit();
            
        });

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void uploadLayoutData(ViewHolder holder, ModelModuleActionAnswer model) {

        mStringPhaseCode = model.getRecordPhase();
        mStringPhaseNumber = model.getRecordNumber();
        mStringStatusCode = model.getRecordStatus();
        mStringAnswerId = model.getRecordId();
        mStringCostsCode = model.getRecordCosts();
        mStringPriorityCode = model.getRecordPriority();
        mStringFrequencyCode = model.getRecordFrequency();
        mStringCurrentUpdated = model.getRecordDateUpdate();

        mStringPhaseText = SupportGeneratePhaseNameSubPhase.supportGeneratePhaseNameSubPhase(mContext, mStringPhaseCode);
        mStringStatusText = SupportGeneratePhaseNameStatus.supportGeneratePhaseNameStatus(mContext, mStringStatusCode);
        mStringCostsText = SupportGeneratePhaseNameCosts.supportGeneratePhaseNameCosts(mContext, mStringStatusCode);
        mStringPriorityText = SupportGeneratePhaseNamePriority.supportGeneratePhaseNamePriority(mContext, mStringPriorityCode);
        mStringFrequencyText = SupportGeneratePhaseNameFrequency.supportGeneratePhaseNameFrequency(mContext, mStringFrequencyCode);

        mBitmap =  SupportGeneratePhaseStatusImage.supportGeneratePhaseStatusImage(mContext, mStringStatusCode);

        mStringCurrentDate = mStringCurrentUpdated.substring(0, 8);
        mStringFormattedCurrentDate = supportFormatDateCreation(mStringCurrentDate);

        holder.mTextViewValueNumberPoints.setText(model.getRecordNumberPoints());
        holder.mTextViewValueNumberPhotos.setText(model.getRecordNumberPhotos());
        holder.mTextViewValueNumberActions.setText(model.getRecordNumberActions());
        holder.mTextViewValueNumberSharing.setText(model.getRecordNumberSharing());

        holder.mTextViewValueSubPhases.setText(mStringPhaseText);
        holder.mTextViewValueStatus.setText(mStringStatusText);
        holder.mTextViewValueId.setText(mStringAnswerId);
        holder.mTextViewValueNumber.setText(mStringPhaseNumber);
        holder.mTextViewValueCosts.setText(mStringCostsText);
        holder.mTextViewValuePriority.setText(mStringPriorityText);
        holder.mTextViewValueFrequency.setText(mStringFrequencyText);

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
        private final TextView mTextViewValueCosts;
        private final TextView mTextViewValueFrequency;
        private final TextView mTextViewValuePriority;

        private final ImageView mImageViewValueImage;

        ModelModuleActionAnswer recyclerViewItem;

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

            mTextViewValuePriority = mView.findViewById(R.id.mTextViewValuePriority);
            mTextViewValueCosts = mView.findViewById(R.id.mTextViewValueCosts);
            mTextViewValueFrequency = mView.findViewById(R.id.mTextViewValueFrequency);

            mImageViewValueImage = mView.findViewById(R.id.imageView);

        }
    }
}
