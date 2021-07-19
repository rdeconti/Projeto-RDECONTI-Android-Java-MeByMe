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
import com.prosper.day.databasemodel.ModelModuleSharingAnswer;
import com.prosper.day.databasesqlite.SqliteModuleSharingAnswer;

import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_19;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_GA;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;

public class ModuleFragmentSharingRecyclerViewItem extends Fragment {

    private View mView;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private TextView mTextViewMessage;

    List<ModelModuleSharingAnswer> listAll;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentSharingRecyclerViewItem() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = inflater.inflate(R.layout.sharing_recyclerview_fragment_list, viewGroup, false);

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

            case SHARING_PHASE_CODE_15_GA:
                listAll = null;
                break;

            case SHARING_PHASE_CODE_15_OV:
                listAll = SqliteModuleSharingAnswer.sqliteGetAll(mContext);
                break;

            case SHARING_PHASE_CODE_15_02:
            case SHARING_PHASE_CODE_15_03:
            case SHARING_PHASE_CODE_15_04:
            case SHARING_PHASE_CODE_15_05:
            case SHARING_PHASE_CODE_15_06:
            case SHARING_PHASE_CODE_15_07:
            case SHARING_PHASE_CODE_15_09:
            case SHARING_PHASE_CODE_15_10:
            case SHARING_PHASE_CODE_15_11:
            case SHARING_PHASE_CODE_15_12:
            case SHARING_PHASE_CODE_15_19:
                listAll = SqliteModuleSharingAnswer.sqliteGetPhase(mContext, stringCurrentPhaseCode);
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

            mRecyclerView.setAdapter(new ModuleFragmentSharingRecyclerViewList(listAll, mContext));

        }
    }
}
