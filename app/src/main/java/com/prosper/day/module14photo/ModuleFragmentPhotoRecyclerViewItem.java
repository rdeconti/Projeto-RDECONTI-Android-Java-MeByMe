package com.prosper.day.module14photo;

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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelModulePhotoAnswer;
import com.prosper.day.databasesqlite.SqliteModulePhotoAnswer;

import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_19;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_GA;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;

public class ModuleFragmentPhotoRecyclerViewItem extends Fragment {

    private View mView;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private TextView mTextViewMessage;

    private List<ModelModulePhotoAnswer> listAll;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentPhotoRecyclerViewItem() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = inflater.inflate(R.layout.photo_recyclerview_fragment_list, viewGroup, false);

        initializeMessage();
        initializeRecyclerView();

        generateRecyclerView();

        return mView;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeMessage() {

        mTextViewMessage = mView.findViewById(R.id.textViewMessage);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeRecyclerView() {

        mRecyclerView = mView.findViewById(R.id.recyclerView);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(20);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateRecyclerView() {

        switch (stringCurrentPhaseCode) {

            case PHOTO_PHASE_CODE_14_GA:
            case PHOTO_PHASE_CODE_14_OV:
            case PHOTO_PHASE_CODE_14_02:
            case PHOTO_PHASE_CODE_14_03:
            case PHOTO_PHASE_CODE_14_04:
            case PHOTO_PHASE_CODE_14_05:
            case PHOTO_PHASE_CODE_14_06:
            case PHOTO_PHASE_CODE_14_07:
            case PHOTO_PHASE_CODE_14_09:
            case PHOTO_PHASE_CODE_14_10:
            case PHOTO_PHASE_CODE_14_11:
            case PHOTO_PHASE_CODE_14_12:
            case PHOTO_PHASE_CODE_14_19:
                listAll = SqliteModulePhotoAnswer.sqliteGetPhase(mContext, stringCurrentPhaseCode);
                break;

            default:
                String className = getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + stringCurrentPhaseCode);
        }

        if (Objects.requireNonNull(listAll).size() == INT_NUMBER_00) {

            mRecyclerView.setVisibility(View.INVISIBLE);
            mTextViewMessage.setVisibility(View.VISIBLE);

        } else {

            mRecyclerView.setVisibility(View.VISIBLE);
            mTextViewMessage.setVisibility(View.INVISIBLE);

            mRecyclerView.setAdapter(new ModuleFragmentPhotoRecyclerViewList(listAll, mContext));

        }
    }
}
