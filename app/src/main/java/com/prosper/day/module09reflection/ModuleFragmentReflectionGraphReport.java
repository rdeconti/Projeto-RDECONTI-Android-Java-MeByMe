package com.prosper.day.module09reflection;

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
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasesqlite.SqliteModuleReflectionAnswer;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_REAL_PHASES;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NUMBER_CODES;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentScreenGraphStatus;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.REPORT_INITIAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.REPORT_NUMBER;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_TOTAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_04;

public class ModuleFragmentReflectionGraphReport extends Fragment {

    private View mView;
    private Context mContext;
    private Drawable mDrawable;
    private TextView mTextViewMessage;

    private GradientDrawable mGradientDrawable;
    private TableLayout mTableLayout;
    private TableRow mTableRow;
    private TextView mTextView;
    private TableRow.LayoutParams mLayoutParamsTableRow;

    private static int[][] mMultiArrayTotal;
    private static int[] mMultiArrayColumn;

    private static int mIntCellValue;
    private static String mStringCellValue;

    private static int mIndexArrayLine;
    private static int mIndexArrayColumn;

    private static int mIndexTotalLine;
    private static int mIndexTotalColumn;

    private static int mTotalByLine;
    private static int mTotalByColumn;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentReflectionGraphReport() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reflection_report_fragment, viewGroup, false);

        stringCurrentScreenGraphStatus = REPORT_INITIAL;

        initializeLayoutData();
        initializeMultidimensionalArray();

        if (INT_GRAPH_VALUE_TOTAL == INT_NUMBER_00) {

            mTableLayout.setVisibility(View.INVISIBLE);
            mTextViewMessage.setVisibility(View.VISIBLE);
            return mView;

        }

        initializeReportNumber();

        return mView;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeMultidimensionalArray() {

        mIndexTotalLine = REFLECTION_REAL_PHASES;
        mIndexTotalColumn = STATUS_NUMBER_CODES;

        mMultiArrayTotal = new int[mIndexTotalLine] [mIndexTotalColumn];

        for(mIndexArrayLine = 0; mIndexArrayLine < mIndexTotalLine; mIndexArrayLine++){

            for(mIndexArrayColumn = 0; mIndexArrayColumn < mIndexTotalColumn; mIndexArrayColumn++){

                mMultiArrayTotal [mIndexArrayLine] [mIndexArrayColumn] = INT_NUMBER_00;

            }

        }

        mMultiArrayColumn = new int [mIndexTotalColumn];

        for(mIndexArrayColumn = 0; mIndexArrayColumn < mIndexTotalColumn; mIndexArrayColumn++){

            mMultiArrayColumn [mIndexArrayColumn] = INT_NUMBER_00;

        }

        mMultiArrayTotal = SqliteModuleReflectionAnswer.sqliteReportAnalysis(mContext);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeLayoutData() {

        mTextViewMessage = mView.findViewById(R.id.textViewMessage);
        mTableLayout = mView.findViewById(R.id.tableLayout);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeReportNumber() {

        stringCurrentScreenGraphStatus = REPORT_NUMBER;

        mTableLayout.setVisibility(View.VISIBLE);

        generateReportNumber();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateReportNumber() {

        mTableLayout.setVisibility(View.VISIBLE);
        mTextViewMessage.setVisibility(View.INVISIBLE);

        generateReportHeader();
        generateReportBodyNumber();
        generateReportBottom();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateReportHeader() {

        mTableLayout.removeAllViewsInLayout();

        mTableLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(getResources().getColor(R.color.White));
        mGradientDrawable.setSize(2, 2);

        mTableLayout.setDividerPadding(5);
        mTableLayout.setDividerDrawable(mGradientDrawable);

        mTableLayout.setElevation(10.0f);

        mLayoutParamsTableRow = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        mLayoutParamsTableRow.weight = 1.0f;

        mTableRow = new TableRow(mContext);
        mTableRow.setBackgroundColor(Color.TRANSPARENT);
        mTableLayout.addView(mTableRow, mLayoutParamsTableRow);

        addToTableRow(mContext.getString(R.string.label_phases), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
        addToTableRow(mContext.getString(R.string.label_status_new), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
        addToTableRow(mContext.getString(R.string.label_status_pending), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
        addToTableRow(mContext.getString(R.string.label_status_closed), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
        addToTableRow(mContext.getString(R.string.label_status_ignored), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
        addToTableRow(mContext.getString(R.string.label_status_postponed), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
        addToTableRow(mContext.getString(R.string.label_total), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateReportBodyNumber() {

        mTotalByLine = 0;
        mTotalByColumn = 0;

        for(mIndexArrayLine = 0; mIndexArrayLine < REFLECTION_REAL_PHASES; mIndexArrayLine++){

            mTableRow = new TableRow(mContext);
            mTableRow.setBackgroundColor(Color.TRANSPARENT);
            mTableLayout.addView(mTableRow, mLayoutParamsTableRow);

            generateReportLineName();

            mTotalByLine = 0;

            for(mIndexArrayColumn = 0; mIndexArrayColumn < STATUS_NUMBER_CODES; mIndexArrayColumn++){

                mIntCellValue = mMultiArrayTotal[mIndexArrayLine] [mIndexArrayColumn];
                mStringCellValue = String.valueOf(mIntCellValue);
                addToTableRow(mStringCellValue, Color.WHITE, Color.TRANSPARENT, Gravity.CENTER);

                mTotalByLine = mTotalByLine + mIntCellValue;
                mMultiArrayColumn [mIndexArrayColumn] = mMultiArrayColumn [mIndexArrayColumn] + mIntCellValue;

            }

            mStringCellValue = String.valueOf(mTotalByLine);
            addToTableRow(mStringCellValue, Color.WHITE, Color.TRANSPARENT, Gravity.CENTER);

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateReportBodyPercent() {

        mTotalByLine = 0;
        mTotalByColumn = 0;

        for(mIndexArrayLine = 0; mIndexArrayLine < REFLECTION_REAL_PHASES; mIndexArrayLine++){

            mTableRow = new TableRow(mContext);
            mTableRow.setBackgroundColor(Color.TRANSPARENT);
            mTableLayout.addView(mTableRow, mLayoutParamsTableRow);

            generateReportLineName();

            mTotalByLine = 0;

            for(mIndexArrayColumn = 0; mIndexArrayColumn < STATUS_NUMBER_CODES; mIndexArrayColumn++){

                mIntCellValue = mMultiArrayTotal[mIndexArrayLine] [mIndexArrayColumn];
                mIntCellValue = mIntCellValue / INT_GRAPH_VALUE_TOTAL;

                mStringCellValue = String.valueOf(mIntCellValue);
                addToTableRow(mStringCellValue, Color.WHITE, Color.TRANSPARENT, Gravity.CENTER);

                mTotalByLine = mTotalByLine + mIntCellValue;
                mMultiArrayColumn [mIndexArrayColumn] = mMultiArrayColumn [mIndexArrayColumn] + mIntCellValue;

            }

            mStringCellValue = String.valueOf(mTotalByLine);
            addToTableRow(mStringCellValue, Color.WHITE, Color.TRANSPARENT, Gravity.CENTER);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateReportBottom() {

        mTableRow = new TableRow(mContext);
        mTableRow.setBackgroundColor(Color.TRANSPARENT);
        mTableLayout.addView(mTableRow, mLayoutParamsTableRow);

        addToTableRow(mContext.getString(R.string.label_total), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);

        mTotalByColumn = 0;

        for(mIndexArrayColumn = 0; mIndexArrayColumn < STATUS_NUMBER_CODES; mIndexArrayColumn++){

            mIntCellValue = mMultiArrayColumn [mIndexArrayColumn];

            mStringCellValue = String.valueOf(mIntCellValue);
            addToTableRow(mStringCellValue, Color.WHITE, Color.TRANSPARENT, Gravity.CENTER);

            mTotalByColumn = mTotalByColumn + mIntCellValue;

        }

        mStringCellValue = String.valueOf(mTotalByColumn);
        addToTableRow(mStringCellValue, Color.WHITE, Color.TRANSPARENT, Gravity.CENTER);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateReportLineName() {

        switch (mIndexArrayLine) {

            case INT_NUMBER_00:
                addToTableRow(mContext.getString(R.string.label_reflection_01), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
                break;

            case INT_NUMBER_01:
                addToTableRow(mContext.getString(R.string.label_reflection_02), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
                break;

            case INT_NUMBER_02:
                addToTableRow(mContext.getString(R.string.label_reflection_03), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
                break;

            case INT_NUMBER_03:
                addToTableRow(mContext.getString(R.string.label_reflection_04), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
                break;

            case INT_NUMBER_04:
                addToTableRow(mContext.getString(R.string.label_reflection_05), Color.WHITE, Color.TRANSPARENT, Gravity.LEFT);
                break;

            default:
                String className = mContext.getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + mIndexArrayLine);

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void addToTableRow(String stringText, int intColorText, int intColorBackground, int intGravity)
    {

        mTextView = new TextView(mContext);

        mTextView.setTextColor(intColorText);
        mTextView.setBackgroundColor(intColorBackground);

        mTextView.setTypeface(null, Typeface.BOLD);
        mTextView.setPadding(5,5,5,5);
        mTextView.setGravity(intGravity);

        mTextView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

        mTextView.setText(stringText);

        mTableRow.addView(mTextView);

    }

}
