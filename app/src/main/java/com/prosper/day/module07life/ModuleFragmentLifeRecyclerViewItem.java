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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelModuleLifeAnswer;
import com.prosper.day.databasesqlite.SqliteModuleLifeAnswer;

import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_13;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_14;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_15;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_16;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_GA;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportGetCurrentButtonTextStatus.supportGetCurrentButtonTextStatus;

public class ModuleFragmentLifeRecyclerViewItem extends Fragment {

    private View mView;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private Drawable mDrawable;
    private Button mButtonStatus;
    private Button mButtonRefresh;
    private TextView mTextViewMessage;

    private String mCurrentButtonText;
    private String mCurrentButtonFunction;

    List<ModelModuleLifeAnswer> listAll;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentLifeRecyclerViewItem() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = inflater.inflate(R.layout.life_recyclerview_fragment_list, viewGroup, false);

        initializeButtons();
        initializeMessage();
        initializeRecyclerView();

        generateButtonStatus();
        generateRecyclerView();

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                formatButtonStatus();
                generateRecyclerView();

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                generateRecyclerView();

            }
        });

        return mView;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeButtons() {

        mButtonStatus = mView.findViewById(R.id.buttonStatus);
        mButtonRefresh = mView.findViewById(R.id.buttonRefresh);

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
    private void generateButtonStatus() {

        mButtonStatus.setText(mContext.getString(R.string.label_list_all));
        mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_all_white_24dp);
        mButtonStatus.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable , null, null);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatButtonStatus() {

        mCurrentButtonText = mButtonStatus.getText().toString();
        mCurrentButtonFunction = supportGetCurrentButtonTextStatus(mContext, mCurrentButtonText);

        switch (mCurrentButtonFunction) {

            case STATUS_ALL:
                mButtonStatus.setText(mContext.getString(R.string.label_list_new));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_new_white_24dp);
                break;

            case STATUS_NEW:
                mButtonStatus.setText(mContext.getString(R.string.label_list_pending));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_pending_white_24dp);
                break;

            case STATUS_PENDING:
                mButtonStatus.setText(mContext.getString(R.string.label_list_closed));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_closed_white_24dp);
                break;

            case STATUS_CLOSED:
                mButtonStatus.setText(mContext.getString(R.string.label_list_postponed));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_postponed_white_24dp);
                break;

            case STATUS_POSTPONED:
                mButtonStatus.setText(mContext.getString(R.string.label_list_ignored));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_ignored_white_24dp);
                break;

            case STATUS_IGNORED:
                mButtonStatus.setText(mContext.getString(R.string.label_list_all));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_all_white_24dp);
                break;

            default:
                String className = getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + mCurrentButtonFunction);

        }

        mButtonStatus.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable , null, null);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateRecyclerView() {

        mCurrentButtonText = mButtonStatus.getText().toString();
        mCurrentButtonFunction = supportGetCurrentButtonTextStatus(mContext, mCurrentButtonText);

        switch (stringCurrentPhaseCode) {

            case LIFE_PHASE_CODE_07_GE:
            case LIFE_PHASE_CODE_07_GA:
                listAll = null;
                break;

            case LIFE_PHASE_CODE_07_OV:
                listAll = SqliteModuleLifeAnswer.sqliteGetAll(mContext, mCurrentButtonFunction);
                break;

            case LIFE_PHASE_CODE_07_01:
            case LIFE_PHASE_CODE_07_02:
            case LIFE_PHASE_CODE_07_03:
            case LIFE_PHASE_CODE_07_04:
            case LIFE_PHASE_CODE_07_05:
            case LIFE_PHASE_CODE_07_06:
            case LIFE_PHASE_CODE_07_07:
            case LIFE_PHASE_CODE_07_08:
            case LIFE_PHASE_CODE_07_09:
            case LIFE_PHASE_CODE_07_10:
            case LIFE_PHASE_CODE_07_11:
            case LIFE_PHASE_CODE_07_12:
            case LIFE_PHASE_CODE_07_13:
            case LIFE_PHASE_CODE_07_14:
            case LIFE_PHASE_CODE_07_15:
            case LIFE_PHASE_CODE_07_16:
                listAll = SqliteModuleLifeAnswer.sqliteGetPhase(mContext, stringCurrentPhaseCode, mCurrentButtonFunction);
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

            mRecyclerView.setAdapter(new ModuleFragmentLifeRecyclerViewList(listAll, mContext));

        }
    }
}
