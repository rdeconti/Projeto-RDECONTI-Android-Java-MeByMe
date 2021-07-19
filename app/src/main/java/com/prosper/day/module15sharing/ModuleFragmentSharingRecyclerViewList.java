package com.prosper.day.module15sharing;

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
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameSubPhase;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelModuleSharingAnswer;

import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportFormatDateCreation.supportFormatDateCreation;

public class ModuleFragmentSharingRecyclerViewList extends RecyclerView.Adapter<ModuleFragmentSharingRecyclerViewList.ViewHolder> {

    private View mView;
    private final Context mContext;
    private Bitmap mBitmap;

    private String mStringAnswerId;
    private String mStringQuestionHeader;
    private String mStringPhaseCode;
    private String mStringPhaseText;

    private String mStringCurrentUpdated;
    private String mStringFormattedCurrentDate;
    private String mStringCurrentDate;

    private final List<ModelModuleSharingAnswer> mValues;

    // *********************************************************************************************
    // *********************************************************************************************
    ModuleFragmentSharingRecyclerViewList(List<ModelModuleSharingAnswer> items, Context context) {

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

        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sharing_recyclerview_fragment_item, parent, false);
        return new ViewHolder(mView);
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        ModelModuleSharingAnswer model = mValues.get(position);
        holder.recyclerViewItem = model;

        uploadLayoutData(holder, model);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void uploadLayoutData(ViewHolder holder, ModelModuleSharingAnswer model) {

        mStringPhaseCode = model.getRecordPhase();

        mStringAnswerId = model.getRecordId();

        mStringPhaseText = SupportGeneratePhaseNameSubPhase.supportGeneratePhaseNameSubPhase(mContext, mStringPhaseCode);
        holder.mTextViewValueSubPhases.setText(mStringPhaseText);

        mStringQuestionHeader = mStringPhaseText;
        holder.mTextViewValueQuestion.setText(mStringQuestionHeader);

        byte[] byteArray = model.getRecordImage();
        mBitmap = BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length);
        holder.mImageViewValueImage.setImageBitmap(mBitmap);

        mStringCurrentUpdated = model.getRecordDateUpdate();
        mStringCurrentDate = mStringCurrentUpdated.substring(0, 8);
        mStringFormattedCurrentDate = supportFormatDateCreation(mStringCurrentDate);
        holder.mTextViewValueUpdatedDate.setText(mStringFormattedCurrentDate);

        holder.mTextViewValueId.setText(mStringAnswerId);

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

        private final TextView mTextViewValueId;
        private final TextView mTextViewValueNumber;

        private final TextView mTextViewValueSubPhases;
        private final TextView mTextViewValueUpdatedDate;
        private final TextView mTextViewValueQuestion;

        private final ImageView mImageViewValueImage;

        ModelModuleSharingAnswer recyclerViewItem;

        // *****************************************************************************************
        // *****************************************************************************************
        ViewHolder(View view) {
            super(view);

            mView = view;

            mTextViewValueId = mView.findViewById(R.id.mTextViewValueId);
            mTextViewValueNumber = mView.findViewById(R.id.mTextViewValueNumber);

            mTextViewValueSubPhases = mView.findViewById(R.id.mTextViewValueSubPhase);
            mTextViewValueUpdatedDate = mView.findViewById(R.id.mTextViewValueUpdatedDate);
            mTextViewValueQuestion = mView.findViewById(R.id.mTextViewValueQuestion);
            mImageViewValueImage = mView.findViewById(R.id.imageViewShared);

        }
    }
}
