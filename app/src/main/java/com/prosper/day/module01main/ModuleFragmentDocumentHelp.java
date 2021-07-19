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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNamePhase;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameSubPhase;
import com.prosper.day.databasesqlite.SqliteSupportHelp;

import java.util.Objects;
import java.util.Random;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_BORDER;

public class ModuleFragmentDocumentHelp extends Fragment {

    private View mView;
    private Activity mActivity;
    private Context mContext;
    private ImageView mImageView;
    private TextView mTextView;
    private TextView mTextHelp;
    private LinearLayout mLinearLayoutAdviceData;

    private Random mRandom;

    private String mStringBorder;
    private String mStringNamePhase;
    private String mStringNameSubPhase;
    private String mStringHelpTitle;
    private String mStringHelpText;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentDocumentHelp() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onResume() {
        super.onResume();

        formatFragmentTitles();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        // TODO APLICAR HELP DINAMICO AO INVES DO SHOWCASEVIEW

        mContext = getContext();
        mActivity = getActivity();

        mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_module_fragment_document_help, viewGroup, false);

        mImageView = mView.findViewById(R.id.imageViewAppIcon);
        mLinearLayoutAdviceData = mView.findViewById(R.id.linearLayoutAdviceData);
        mTextView = mView.findViewById(R.id.textViewHeader);
        mTextHelp = mView.findViewById(R.id.textViewHelp);

        formatFragmentTitles();

        formatMaterialShowCaseView_0();
        formatMaterialShowCaseView_1();
        formatMaterialShowCaseView_2();
        formatMaterialShowCaseView_3();

        return mView;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatMaterialShowCaseView_0() {

        initializeBorder();

        mStringHelpTitle = "1." + mStringNamePhase + " - " + mStringNameSubPhase;
        mTextView.setText(mStringHelpTitle);

        readHelpFromDatabase();
        mTextHelp.setText(mStringHelpText);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatMaterialShowCaseView_1() {

        initializeBorder();

        mStringHelpTitle = "2." + mStringNamePhase + " - " + mStringNameSubPhase;
        mTextView.setText(mStringHelpTitle);

        readHelpFromDatabase();
        mTextHelp.setText(mStringHelpText);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatMaterialShowCaseView_2() {

        initializeBorder();

        mStringHelpTitle = "3." + mStringNamePhase + " - " + mStringNameSubPhase;
        mTextView.setText(mStringHelpTitle);

        readHelpFromDatabase();
        mTextHelp.setText(mStringHelpText);


    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatMaterialShowCaseView_3() {

        initializeBorder();

        mStringHelpTitle = "4." + mStringNamePhase + " - " + mStringNameSubPhase;
        mTextView.setText(mStringHelpTitle);

        readHelpFromDatabase();
        mTextHelp.setText(mStringHelpText);

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
