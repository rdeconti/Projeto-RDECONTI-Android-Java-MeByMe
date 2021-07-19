package com.prosper.day.module01main;

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
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNamePhase;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameSubPhase;
import com.prosper.day.databasesqlite.SqliteSupportHelp;

import java.util.Objects;
import java.util.Random;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentShowCaseId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.INT_SHOW_CASE_WITH_DELAY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_BORDER;

public class ModuleFragmentDocumentApplication extends Fragment {

    private View mView;
    private Activity mActivity;
    private Context mContext;
    private ImageView mImageView;
    private LinearLayout mLinearLayoutAdviceData;

    private Random mRandom;

    private String mStringBorder;
    private String mStringNamePhase;
    private String mStringNameSubPhase;
    private String mStringHelpTitle;
    private String mStringHelpText;

    private ShowcaseConfig mShowCaseConfig;
    private MaterialShowcaseSequence mMaterialShowCaseSequence;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentDocumentApplication() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();
        mActivity = getActivity();

        mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_module_fragment_document_application, viewGroup, false);

        mImageView = mView.findViewById(R.id.imageViewAppIcon);
        mLinearLayoutAdviceData = mView.findViewById(R.id.linearLayoutAdviceData);

        formatFragmentTitles();
        settingMaterialShowCaseView();

        mMaterialShowCaseSequence = new MaterialShowcaseSequence(mActivity, stringCurrentShowCaseId);

        mMaterialShowCaseSequence.setConfig(mShowCaseConfig);

        mMaterialShowCaseSequence.setOnItemShownListener(new MaterialShowcaseSequence.OnSequenceItemShownListener() {
            @Override
            public void onShow(MaterialShowcaseView itemView, int ShowCaseNumber) {

                Log.w("MEBYME ", "onShow: ShowCaseNumber " + ShowCaseNumber );

                if (ShowCaseNumber >= 3 ){

                    Objects.requireNonNull(mActivity).onBackPressed();

                }
            }
        });

        formatMaterialShowCaseView_0();
        formatMaterialShowCaseView_1();
        formatMaterialShowCaseView_2();
        formatMaterialShowCaseView_3();

        mMaterialShowCaseSequence.start();

        return mView;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatMaterialShowCaseView_0() {

        initializeBorder();

        mStringHelpTitle = "1." + mStringNamePhase + " - " + mStringNameSubPhase;

        readHelpFromDatabase();

        mMaterialShowCaseSequence.addSequenceItem(
                new MaterialShowcaseView.Builder(mActivity)
                        .setTarget(mImageView)
                        .withCircleShape()
                        .setTitleText(mStringHelpTitle)
                        .setTitleTextColor(getResources().getColor(R.color.White))
                        .setContentText(mStringHelpText)
                        .setContentTextColor(getResources().getColor(R.color.White))
                        .setDismissText(getString(R.string.showCaseGotIt))
                        .setDismissTextColor(getResources().getColor(R.color.White))
                        .setGravity(Gravity.CENTER)
                        .setMaskColour(mShowCaseConfig.getMaskColor())
                        .build()
        );

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatMaterialShowCaseView_1() {

        initializeBorder();

        mStringHelpTitle = "2." + mStringNamePhase + " - " + mStringNameSubPhase;

        mMaterialShowCaseSequence.addSequenceItem(
                new MaterialShowcaseView.Builder(mActivity)
                        .setTarget(mImageView)
                        .withCircleShape()
                        .setTitleText(mStringHelpTitle)
                        .setTitleTextColor(getResources().getColor(R.color.White))
                        .setContentText(mStringHelpText)
                        .setContentTextColor(getResources().getColor(R.color.White))
                        .setDismissText(getString(R.string.showCaseGotIt))
                        .setDismissTextColor(getResources().getColor(R.color.White))
                        .setGravity(Gravity.CENTER)
                        .setMaskColour(mShowCaseConfig.getMaskColor())
                        .build()
        );

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatMaterialShowCaseView_2() {

        initializeBorder();

        mStringHelpTitle = "3." + mStringNamePhase + " - " + mStringNameSubPhase;

        mMaterialShowCaseSequence.addSequenceItem(
                new MaterialShowcaseView.Builder(mActivity)
                        .setTarget(mImageView)
                        .withCircleShape()
                        .setTitleText(mStringHelpTitle)
                        .setTitleTextColor(getResources().getColor(R.color.White))
                        .setContentText(mStringHelpText)
                        .setContentTextColor(getResources().getColor(R.color.White))
                        .setDismissText(getString(R.string.showCaseGotIt))
                        .setDismissTextColor(getResources().getColor(R.color.White))
                        .setGravity(Gravity.CENTER)
                        .setMaskColour(mShowCaseConfig.getMaskColor())
                        .build()
        );

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatMaterialShowCaseView_3() {

        initializeBorder();

        mStringHelpTitle = "4." + mStringNamePhase + " - " + mStringNameSubPhase;

        mMaterialShowCaseSequence.addSequenceItem(
                new MaterialShowcaseView.Builder(mActivity)
                        .setTarget(mImageView)
                        .withCircleShape()
                        .setTitleText(mStringHelpTitle)
                        .setTitleTextColor(getResources().getColor(R.color.White))
                        .setContentText(mStringHelpText)
                        .setContentTextColor(getResources().getColor(R.color.White))
                        .setDismissText(getString(R.string.showCaseGotIt))
                        .setDismissTextColor(getResources().getColor(R.color.White))
                        .setGravity(Gravity.CENTER)
                        .setMaskColour(mShowCaseConfig.getMaskColor())
                        .build()
        );

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void readHelpFromDatabase() {

        mStringHelpText = SqliteSupportHelp.sqliteGetOne(
                mContext,
                stringCurrentPhaseCode);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void settingMaterialShowCaseView() {

        MaterialShowcaseView.resetSingleUse(mActivity, stringCurrentShowCaseId);

        mShowCaseConfig = new ShowcaseConfig();
        mShowCaseConfig.setDelay(INT_SHOW_CASE_WITH_DELAY);
        mShowCaseConfig.setMaskColor(Color.argb(150, 0, 0, 0));

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeBorder() {

        mRandom = new Random();
        int intBorder = mRandom.nextInt(NUMBER_BORDER - 1000) + 1000;
        @SuppressLint("DefaultLocale") String stringNumber = String.format("%04d", intBorder);

        mStringBorder = getString(R.string.label_border) + stringNumber;

        int drawableResourceId = mContext.getResources().getIdentifier(mStringBorder, "drawable", mContext.getPackageName());

        mLinearLayoutAdviceData.setBackground(ContextCompat.getDrawable(mContext, drawableResourceId));

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatFragmentTitles() {

        mStringNamePhase = SupportGeneratePhaseNamePhase.supportGeneratePhaseNamePhase(mContext, stringCurrentPhaseCode);
        mStringNameSubPhase = SupportGeneratePhaseNameSubPhase.supportGeneratePhaseNameSubPhase(mContext, stringCurrentPhaseCode);

        requireActivity().setTitle(mStringNamePhase);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setSubtitle(mStringNameSubPhase);

    }
}
