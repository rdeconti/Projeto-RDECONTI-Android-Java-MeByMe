package com.prosper.day.module12diary;

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
import com.prosper.day.databasemodel.ModelModuleDiaryAnswer;
import com.prosper.day.databasesqlite.SqliteModuleDiaryAnswer;

import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12_GA;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_BAD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_GOOD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_NORMAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_VERY_BAD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_VERY_GOOD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportGetCurrentButtonTextExperience.supportGetCurrentButtonTextExperience;
import static com.prosper.day.applicationsupportclasses.SupportGetCurrentButtonTextStatus.supportGetCurrentButtonTextStatus;

public class ModuleFragmentDiaryRecyclerViewItem extends Fragment {

    private View mView;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private Drawable mDrawable;
    private Button mButtonStatus;
    private Button mButtonExperience;
    private Button mButtonRefresh;
    private TextView mTextViewMessage;

    private String mCurrentButtonText;
    private String mCurrentButtonFunction;

    List<ModelModuleDiaryAnswer> listAll;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentDiaryRecyclerViewItem() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = inflater.inflate(R.layout.diary_recyclerview_fragment_list, viewGroup, false);

        initializeRecyclerView();
        initializeButtons();
        initializeMessage();

        generateButtonStatus();
        generateButtonExperience();
        generateRecyclerViewStatus();

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewSelection) {

                formatButtonStatus();
                generateRecyclerViewStatus();

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewExperience) {

                formatButtonExperience();
                generateRecyclerViewExperience();

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewRefresh) {

                generateRecyclerViewStatus();

            }
        });

        return mView;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeButtons() {

        mButtonStatus = mView.findViewById(R.id.buttonStatus);
        mButtonExperience = mView.findViewById(R.id.buttonExperience);
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
    private void generateButtonExperience() {

        mButtonExperience.setText(mContext.getString(R.string.label_list_all));
        mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_all_white_24dp);
        mButtonExperience.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable , null, null);

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
    private void formatButtonExperience() {

        mCurrentButtonText = mButtonExperience.getText().toString();
        mCurrentButtonFunction = supportGetCurrentButtonTextExperience(mContext, mCurrentButtonText);

        switch (mCurrentButtonFunction) {

            case EXPERIENCE_ALL:
                mButtonExperience.setText(mContext.getString(R.string.label_experience_very_bad));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.mood_icon_very_sad_white_24dp);
                break;

            case EXPERIENCE_VERY_BAD:
                mButtonExperience.setText(mContext.getString(R.string.label_experience_bad));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.mood_icon_sad_white_24dp);
                break;

            case EXPERIENCE_BAD:
                mButtonExperience.setText(mContext.getString(R.string.label_experience_normal));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.mood_icon_indifferent_white_24dp);
                break;

            case EXPERIENCE_NORMAL:
                mButtonExperience.setText(mContext.getString(R.string.label_experience_good));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.mood_icon_happy_white_24dp);
                break;

            case EXPERIENCE_GOOD:
                mButtonExperience.setText(mContext.getString(R.string.label_experience_very_good));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.mood_icon_very_happy_white_24dp);
                break;

            case EXPERIENCE_VERY_GOOD:
                mButtonExperience.setText(mContext.getString(R.string.label_list_all));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_all_white_24dp);
                break;
                
            default:
                String className = getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + mCurrentButtonFunction);

        }

        mButtonExperience.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable , null, null);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateRecyclerViewStatus() {

        mCurrentButtonText = mButtonStatus.getText().toString();
        mCurrentButtonFunction = supportGetCurrentButtonTextStatus(mContext, mCurrentButtonText);

        switch (stringCurrentPhaseCode) {

            case DIARY_PHASE_CODE_12_GE:
            case DIARY_PHASE_CODE_12_GA:
                listAll = null;
                break;

            case DIARY_PHASE_CODE_12_OV:
                listAll = SqliteModuleDiaryAnswer.sqliteGetAllStatus(mContext, mCurrentButtonFunction);
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

            mRecyclerView.setAdapter(new ModuleFragmentDiaryRecyclerViewList(listAll, mContext));

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateRecyclerViewExperience() {

        mCurrentButtonText = mButtonExperience.getText().toString();
        mCurrentButtonFunction = supportGetCurrentButtonTextExperience(mContext, mCurrentButtonText);

        switch (stringCurrentPhaseCode) {

            case DIARY_PHASE_CODE_12_GE:
            case DIARY_PHASE_CODE_12_GA:
                listAll = null;
                break;

            case DIARY_PHASE_CODE_12_OV:
                listAll = SqliteModuleDiaryAnswer.sqliteGetAllExperience(mContext, mCurrentButtonFunction);
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

            mRecyclerView.setAdapter(new ModuleFragmentDiaryRecyclerViewList(listAll, mContext));

        }
    }
}
