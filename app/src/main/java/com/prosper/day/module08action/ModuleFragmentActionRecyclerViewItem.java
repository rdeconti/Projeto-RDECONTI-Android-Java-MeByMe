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
import com.prosper.day.databasemodel.ModelModuleActionAnswer;
import com.prosper.day.databasesqlite.SqliteModuleActionAnswer;

import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_19;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_GA;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_GC;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_GF;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_GP;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_HIGH;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_LOW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_MEDIUM;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_DAILY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_MONTHLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_WEEKLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_YEARLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_HIGH;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_LOW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_MEDIUM;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportGetCurrentButtonTextGeral.supportGetCurrentButtonTextGeral;

public class ModuleFragmentActionRecyclerViewItem extends Fragment {

    private View mView;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private Drawable mDrawable;
    private Button mButtonStatus;
    private Button mButtonRefresh;
    private TextView mTextViewMessage;

    private String mCurrentButtonText;
    private String mCurrentButtonFunction;

    List<ModelModuleActionAnswer> listAll;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentActionRecyclerViewItem() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = inflater.inflate(R.layout.action_recyclerview_fragment_list, viewGroup, false);

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
        mCurrentButtonFunction = supportGetCurrentButtonTextGeral(mContext, mCurrentButtonText);

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
                mButtonStatus.setText(mContext.getString(R.string.label_costs_list_none));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.button_icon_none_white_24dp);
                break;

            case COSTS_NONE:
                mButtonStatus.setText(mContext.getString(R.string.label_costs_list_high));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.button_icon_high_white_24dp);
                break;

            case COSTS_HIGH:
                mButtonStatus.setText(mContext.getString(R.string.label_costs_list_medium));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.button_icon_medium_white_24dp);
                break;

            case COSTS_MEDIUM:
                mButtonStatus.setText(mContext.getString(R.string.label_costs_list_low));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.button_icon_low_white_24dp);
                break;

            case COSTS_LOW:
                mButtonStatus.setText(mContext.getString(R.string.label_priority_list_none));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.button_icon_none_white_24dp);
                break;

            case PRIORITY_NONE:
                mButtonStatus.setText(mContext.getString(R.string.label_costs_list_high));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.button_icon_high_white_24dp);
                break;

            case PRIORITY_HIGH:
                mButtonStatus.setText(mContext.getString(R.string.label_costs_list_medium));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.button_icon_medium_white_24dp);
                break;

            case PRIORITY_MEDIUM:
                mButtonStatus.setText(mContext.getString(R.string.label_costs_list_low));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.button_icon_low_white_24dp);
                break;

            case PRIORITY_LOW:
                mButtonStatus.setText(mContext.getString(R.string.label_frequency_list_none));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.button_icon_none_white_24dp);
                break;

            case FREQUENCY_NONE:
                mButtonStatus.setText(mContext.getString(R.string.label_frequency_list_daily));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_new_white_24dp);
                break;

            case FREQUENCY_DAILY:
                mButtonStatus.setText(mContext.getString(R.string.label_frequency_list_weekly));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_opened_white_24dp);
                break;

            case FREQUENCY_WEEKLY:
                mButtonStatus.setText(mContext.getString(R.string.label_frequency_list_monthly));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_pending_white_24dp);
                break;

            case FREQUENCY_MONTHLY:
                mButtonStatus.setText(mContext.getString(R.string.label_frequency_list_annual));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_closed_white_24dp);
                break;

            case FREQUENCY_YEARLY:
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
        mCurrentButtonFunction = supportGetCurrentButtonTextGeral(mContext, mCurrentButtonText);

        switch (stringCurrentPhaseCode) {

            case ACTION_PHASE_CODE_08_GE:
            case ACTION_PHASE_CODE_08_GA:
            case ACTION_PHASE_CODE_08_GC:
            case ACTION_PHASE_CODE_08_GF:
            case ACTION_PHASE_CODE_08_GP:
                listAll = null;
                break;

            case ACTION_PHASE_CODE_08_OV:
                listAll = SqliteModuleActionAnswer.sqliteGetAll(mContext, mCurrentButtonFunction);
                break;

            case ACTION_PHASE_CODE_08_02:
            case ACTION_PHASE_CODE_08_03:
            case ACTION_PHASE_CODE_08_04:
            case ACTION_PHASE_CODE_08_05:
            case ACTION_PHASE_CODE_08_06:
            case ACTION_PHASE_CODE_08_07:
            case ACTION_PHASE_CODE_08_09:
            case ACTION_PHASE_CODE_08_10:
            case ACTION_PHASE_CODE_08_11:
            case ACTION_PHASE_CODE_08_12:
            case ACTION_PHASE_CODE_08_19:
                listAll = SqliteModuleActionAnswer.sqliteGetPhase(mContext, stringCurrentPhaseCode, mCurrentButtonFunction);
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

            mRecyclerView.setAdapter(new ModuleFragmentActionRecyclerViewList(listAll, mContext));

        }
    }
}
