package com.prosper.day.module06personality;

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
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportGeneralDateTime;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameStatus;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameSubPhase;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseStatusImage;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelModulePersonalityChoice;
import com.prosper.day.databasesqlite.SqliteModulePersonalityAnswer;
import com.prosper.day.databasesqlite.SqliteModulePersonalityChoice;
import com.prosper.day.databasesqlite.SqliteSupportPointsUser;

import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_05;
import static com.prosper.day.applicationsupportclasses.SupportFormatDateCreation.supportFormatDateCreation;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPoints;

public class ModuleFragmentPersonalityRecyclerViewListEnneagram extends RecyclerView.Adapter<ModuleFragmentPersonalityRecyclerViewListEnneagram.ViewHolder> {

    private View mView;
    private Context mContext;
    private AppCompatActivity mAppCompatActivity;
    private FrameLayout frameLayout;
    private Intent mIntent;
    private Bitmap mBitmap;

    private String mStringAnswerId;
    private String mStringQuestionText;
    private String mStringAnswerText;
    private String mStringPhaseNumber;
    private String mStringPhaseCode;
    private String mStringPhaseText;
    private String mStringStatusCode;
    private String mStringStatusText;

    private String mStringImagePath;
    private String mStringPhotoController;
    private String mStringFormattedDateTime;
    private String mStringCurrentAnswerNumberPoints;
    private String mStringCurrentAnswerNumberPhotos;
    private String mStringCurrentAnswerNumberActions;
    private String mStringCurrentAnswerNumberSharing;
    private String mStringCurrentAnswerGrade;
    private String mStringCurrentPhotoId;
    private String mStringCurrentAnswerStatus;
    private String mStringCurrentAnswer;
    private String mStringCurrentQuestion;
    private String mStringCurrentUpdatedDateTime;
    private String mStringPhotoPhaseCode;
    private String mStringSharingPhaseCode;
    private String mStringCurrentAnswerText;

    private int mIntCurrentRecordNumber;

    private String mStringValueAnswerA;
    private String mStringValueAnswerB;
    private String mStringValueAnswerC;
    private String mStringValueAnswerD;

    private String mStringCurrentUpdated;
    private String mStringFormattedCurrentDate;
    private String mStringCurrentDate;

    private final List<ModelModulePersonalityChoice> mValues;

    // *********************************************************************************************
    // *********************************************************************************************
    ModuleFragmentPersonalityRecyclerViewListEnneagram(List<ModelModulePersonalityChoice> items, Context context) {

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

        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.personality_recyclerview_fragment_item_choice_enneagram, parent, false);
        return new ViewHolder(mView);
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        ModelModulePersonalityChoice model = mValues.get(position);
        holder.recyclerViewItem = model;

        uploadLayoutData(holder, model);

        holder.buttonNumber0.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateNumberPoints();

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                mStringCurrentAnswerText = STRING_NUMBER_00;

                SqliteModulePersonalityChoice.sqliteUpdateText(
                        mContext,
                        mIntCurrentRecordNumber,
                        mStringCurrentAnswerText,
                        mStringCurrentUpdatedDateTime);

                mStringCurrentAnswerStatus = STATUS_CLOSED;
                holder.mTextViewValueStatus.setText(R.string.label_status_ignored);

                mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_00);
                holder.mImageViewValueImage.setImageBitmap(mBitmap);

                updateDatabaseStatus();

            }
        });

        holder.buttonNumber1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateNumberPoints();

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                mStringCurrentAnswerText = STRING_NUMBER_01;

                SqliteModulePersonalityChoice.sqliteUpdateText(
                        mContext,
                        mIntCurrentRecordNumber,
                        mStringCurrentAnswerText,
                        mStringCurrentUpdatedDateTime);

                mStringCurrentAnswerStatus = STATUS_CLOSED;
                holder.mTextViewValueStatus.setText(R.string.label_status_ignored);

                mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_01);
                holder.mImageViewValueImage.setImageBitmap(mBitmap);

                updateDatabaseStatus();

            }
        });

        holder.buttonNumber2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateNumberPoints();

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                mStringCurrentAnswerText = STRING_NUMBER_02;

                SqliteModulePersonalityChoice.sqliteUpdateText(
                        mContext,
                        mIntCurrentRecordNumber,
                        mStringCurrentAnswerText,
                        mStringCurrentUpdatedDateTime);

                mStringCurrentAnswerStatus = STATUS_CLOSED;
                holder.mTextViewValueStatus.setText(R.string.label_status_ignored);

                mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_02);
                holder.mImageViewValueImage.setImageBitmap(mBitmap);

                updateDatabaseStatus();

            }
        });

        holder.buttonNumber3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateNumberPoints();

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                mStringCurrentAnswerText = STRING_NUMBER_03;

                SqliteModulePersonalityChoice.sqliteUpdateText(
                        mContext,
                        mIntCurrentRecordNumber,
                        mStringCurrentAnswerText,
                        mStringCurrentUpdatedDateTime);

                mStringCurrentAnswerStatus = STATUS_CLOSED;
                holder.mTextViewValueStatus.setText(R.string.label_status_ignored);

                mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_03);
                holder.mImageViewValueImage.setImageBitmap(mBitmap);

                updateDatabaseStatus();

            }
        });

        holder.buttonNumber4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateNumberPoints();

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                mStringCurrentAnswerText = STRING_NUMBER_04;

                SqliteModulePersonalityChoice.sqliteUpdateText(
                        mContext,
                        mIntCurrentRecordNumber,
                        mStringCurrentAnswerText,
                        mStringCurrentUpdatedDateTime);

                mStringCurrentAnswerStatus = STATUS_CLOSED;
                holder.mTextViewValueStatus.setText(R.string.label_status_ignored);

                mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_04);
                holder.mImageViewValueImage.setImageBitmap(mBitmap);

                updateDatabaseStatus();

            }
        });

        holder.buttonNumber5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateNumberPoints();

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                mStringCurrentAnswerText = STRING_NUMBER_05;

                SqliteModulePersonalityChoice.sqliteUpdateText(
                        mContext,
                        mIntCurrentRecordNumber,
                        mStringCurrentAnswerText,
                        mStringCurrentUpdatedDateTime);

                mStringCurrentAnswerStatus = STATUS_CLOSED;
                holder.mTextViewValueStatus.setText(R.string.label_status_ignored);

                mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_05);
                holder.mImageViewValueImage.setImageBitmap(mBitmap);

                updateDatabaseStatus();

            }
        });
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateNumberPoints() {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        mStringCurrentAnswerNumberPoints = generalNumberPoints(mContext, mStringCurrentAnswerNumberPhotos);

        SqliteModulePersonalityAnswer.sqliteUpdateNumberPoints(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerNumberPoints,
                mStringCurrentUpdatedDateTime);

        SqliteSupportPointsUser.sqliteUpdateNumberPoints(
                mContext,
                mStringPhaseCode,
                mStringPhaseNumber,
                mStringCurrentAnswerNumberPoints,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateDatabaseStatus() {

        updateNumberPoints();

        mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

        SqliteModulePersonalityChoice.sqliteUpdateStatus(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerStatus,
                mStringCurrentUpdatedDateTime);

        SqliteSupportPointsUser.sqliteUpdateStatus(
                mContext,
                mStringPhaseCode,
                mStringPhaseNumber,
                mStringCurrentAnswerStatus,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void uploadLayoutData(ViewHolder holder, ModelModulePersonalityChoice model) {

        mIntCurrentRecordNumber = Integer.parseInt(model.getRecordId());

        mStringPhaseCode = model.getRecordPhase();
        mStringPhaseNumber = model.getRecordNumber();
        mStringQuestionText = model.getRecordQuestionText();
        mStringAnswerText = model.getRecordAnswerText();
        mStringAnswerId = model.getRecordId();
        mStringStatusCode = model.getRecordStatus();
        mStringCurrentUpdated = model.getRecordDateUpdate();

        mStringPhaseText = SupportGeneratePhaseNameSubPhase.supportGeneratePhaseNameSubPhase(mContext, mStringPhaseCode);
        mStringStatusText = SupportGeneratePhaseNameStatus.supportGeneratePhaseNameStatus(mContext, mStringStatusCode);
        mBitmap =  SupportGeneratePhaseStatusImage.supportGeneratePhaseStatusImage(mContext, mStringStatusCode);

        mStringCurrentDate = mStringCurrentUpdated.substring(0, 8);
        mStringFormattedCurrentDate = supportFormatDateCreation(mStringCurrentDate);

        holder.mTextViewValueSubPhases.setText(mStringPhaseText);
        holder.mTextViewValueStatus.setText(mStringStatusText);
        holder.mTextViewValueId.setText(mStringAnswerId);
        holder.mTextViewValueNumber.setText(mStringPhaseNumber);

        holder.mTextViewValueQuestion.setText(mStringQuestionText);

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

        private final TextView mTextViewValueQuestion;

        private final TextView mTextViewValueSubPhases;
        private final TextView mTextViewValueStatus;
        private final TextView mTextViewValueUpdatedDate;

        private final ImageView mImageViewValueImage;

        private final Button buttonNumber0;
        private final Button buttonNumber1;
        private final Button buttonNumber2;
        private final Button buttonNumber3;
        private final Button buttonNumber4;
        private final Button buttonNumber5;

        ModelModulePersonalityChoice recyclerViewItem;

        // *****************************************************************************************
        // *****************************************************************************************
        ViewHolder(View view) {
            super(view);

            mView = view;

            mTextViewValueId = mView.findViewById(R.id.mTextViewValueId);
            mTextViewValueNumber = mView.findViewById(R.id.mTextViewValueNumber);

            mTextViewValueQuestion = mView.findViewById(R.id.mTextViewValueQuestion);

            mTextViewValueSubPhases = mView.findViewById(R.id.mTextViewValueSubPhase);
            mTextViewValueStatus = mView.findViewById(R.id.mTextViewValueStatus);
            mTextViewValueUpdatedDate = mView.findViewById(R.id.mTextViewValueUpdatedDate);

            mImageViewValueImage = mView.findViewById(R.id.imageView);

            buttonNumber0 = view.findViewById(R.id.buttonNumber0);
            buttonNumber1 = view.findViewById(R.id.buttonNumber1);
            buttonNumber2 = view.findViewById(R.id.buttonNumber2);
            buttonNumber3 = view.findViewById(R.id.buttonNumber3);
            buttonNumber4 = view.findViewById(R.id.buttonNumber4);
            buttonNumber5 = view.findViewById(R.id.buttonNumber5);

        }
    }
}
