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
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportPieChartRenderer;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasesqlite.SqliteModuleDiaryAnswer;

import java.util.ArrayList;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentScreenGraphStatus;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.intLimitChartPizza;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.GRAPH_BAR_HORIZONTAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.GRAPH_PIE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.REPORT_INITIAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_TOTAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;

public class ModuleFragmentDiaryGraphAnalysis extends Fragment {

    private View mView;
    private Button mButtonChart;
    private Context mContext;
    private Drawable mDrawable;
    private TextView mTextViewMessage;

    private XAxis xAxis;
    private IndexAxisValueFormatter mFormatter;
    private HorizontalBarChart mHorizontalBarChart;
    private BarDataSet mBarDataSet;
    private BarData mBarData;

    private PieChart mPieChart;
    private PieDataSet mPieDataSet;
    private PieData mPieData;

    private float value1;
    private float value2;
    private float value3;
    private float value4;
    private float value5;

    private Legend mLegend;

    private String[] mTableLabels;
    private ArrayList<Integer> mColors;
    private int[] mTableColors;

    ArrayList<PieEntry> mPieEntries;
    ArrayList<BarEntry> mBarEntries;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentDiaryGraphAnalysis() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.diary_graph_fragment, viewGroup, false);

        initializeLayoutData();
        readDataFromDatabase();

        if (INT_GRAPH_VALUE_TOTAL == INT_NUMBER_00) {

            mHorizontalBarChart.setVisibility(View.INVISIBLE);
            mPieChart.setVisibility(View.INVISIBLE);
            mButtonChart.setVisibility(View.INVISIBLE);
            mTextViewMessage.setVisibility(View.VISIBLE);
            return mView;

        }

        stringCurrentScreenGraphStatus = REPORT_INITIAL;

        initializeGraphColor();
        initializeGraphNames();

        switch (stringCurrentScreenGraphStatus) {

            case REPORT_INITIAL:
            case GRAPH_BAR_HORIZONTAL:
                generateHorizontalBarChart();
                break;

            case GRAPH_PIE:
                generatePieChart();
                break;

            default:
                String className = getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + stringCurrentScreenGraphStatus);

        }

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (stringCurrentScreenGraphStatus) {

                    case REPORT_INITIAL:
                    case GRAPH_BAR_HORIZONTAL:
                        generatePieChart();
                        break;

                    case GRAPH_PIE:
                        generateHorizontalBarChart();
                        break;

                    default:
                        String className = getClass().getName();
                        throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + stringCurrentScreenGraphStatus);

                }
            }
        });

        return mView;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeLayoutData() {

        mButtonChart = mView.findViewById(R.id.buttonChart);
        mTextViewMessage = mView.findViewById(R.id.textViewMessage);
        mHorizontalBarChart = mView.findViewById(R.id.graphTypeBarChart);
        mPieChart = mView.findViewById(R.id.graphTypePieChart);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generatePieChart() {

        initializeGraphDataPie();

        stringCurrentScreenGraphStatus = GRAPH_PIE;

        mHorizontalBarChart.setVisibility(View.INVISIBLE);
        mPieChart.setVisibility(View.VISIBLE);

        mTextViewMessage.setVisibility(View.INVISIBLE);

        mDrawable = ContextCompat.getDrawable(mContext, R.drawable.tab_icon_graph_chart_bar_white_24dp);

        mButtonChart.setText(mContext.getString(R.string.label_chart_bar));
        mButtonChart.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable , null, null);

        mPieDataSet = new PieDataSet(mPieEntries, "");
        mPieData = new PieData(mPieDataSet);

        mPieDataSet.setColors(mColors);
        mPieDataSet.setValueTextColor(Color.WHITE);
        mPieDataSet.setValueTextSize(15f);

        mPieDataSet.setYValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);
        mPieDataSet.setXValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);

        mPieChart.setData(mPieData);

        mPieChart.animateY(2000);
        mPieChart.animateXY(1400, 1400);

        mPieChart.getDescription().setEnabled(false);
        mPieChart.setHoleColor(Color.TRANSPARENT);
        mPieChart.setHoleRadius(40);
        mPieChart.setTransparentCircleRadius(50);
        mPieChart.setEntryLabelColor(Color.WHITE);
        mPieChart.setDrawMarkers(true);

        mLegend = mPieChart.getLegend();
        mLegend.setEnabled(false);

        mPieChart.setRenderer(new SupportPieChartRenderer(
                mPieChart,
                mPieChart.getAnimator(),
                mPieChart.getViewPortHandler()
        ));

        mPieChart.invalidate();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateHorizontalBarChart() {

        initializeGraphDataBar();

        stringCurrentScreenGraphStatus = GRAPH_BAR_HORIZONTAL;

        mHorizontalBarChart.setVisibility(View.VISIBLE);
        mPieChart.setVisibility(View.INVISIBLE);

        mTextViewMessage.setVisibility(View.INVISIBLE);

        mDrawable = ContextCompat.getDrawable(mContext, R.drawable.tab_icon_graph_chart_pie_white_24dp);

        mButtonChart.setText(mContext.getString(R.string.label_chart_pie));
        mButtonChart.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable , null, null);

        mBarDataSet = new BarDataSet(mBarEntries, "");
        mBarData = new BarData(mBarDataSet);

        mBarDataSet.setColors(mColors);
        mBarDataSet.setValueTextSize(15f);
        mBarDataSet.setValueTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        mBarDataSet.setValueTextColor(Color.WHITE);
        mBarDataSet.setBarBorderWidth(0.9f);

        mHorizontalBarChart.setData(mBarData);
        mHorizontalBarChart.getDescription().setEnabled(false);

        mHorizontalBarChart.animateY(2000);
        mHorizontalBarChart.animateXY(1400, 1400);

        mHorizontalBarChart.setFitBars(true);

        mHorizontalBarChart.getXAxis().setDrawGridLines(true);
        mHorizontalBarChart.getAxisLeft().setDrawGridLines(true);
        mHorizontalBarChart.getAxisRight().setDrawGridLines(true);

        mHorizontalBarChart.getXAxis().setDrawAxisLine(true);
        mHorizontalBarChart.getAxisLeft().setDrawAxisLine(true);
        mHorizontalBarChart.getAxisRight().setDrawAxisLine(true);

        mHorizontalBarChart.getAxisLeft().setDrawTopYLabelEntry(true);
        mHorizontalBarChart.getAxisRight().setDrawTopYLabelEntry(true);

        mHorizontalBarChart.getAxisLeft().setDrawZeroLine(true);
        mHorizontalBarChart.getAxisRight().setDrawZeroLine(true);

        mHorizontalBarChart.getAxisLeft().setDrawLimitLinesBehindData(true);
        mHorizontalBarChart.getAxisRight().setDrawLimitLinesBehindData(true);

        mHorizontalBarChart.getXAxis().setTextColor(ContextCompat.getColor(mContext, R.color.White));
        mHorizontalBarChart.getAxisRight().setTextColor(ContextCompat.getColor(mContext, R.color.White));
        mHorizontalBarChart.getAxisLeft().setTextColor(ContextCompat.getColor(mContext, R.color.White));

        mHorizontalBarChart.getXAxis().setTextSize(15f);
        mHorizontalBarChart.getXAxis().setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        mLegend = mHorizontalBarChart.getLegend();
        mLegend.setEnabled(false);

        mFormatter = new IndexAxisValueFormatter(mTableLabels);

        xAxis = mHorizontalBarChart.getXAxis();
        xAxis.setValueFormatter(mFormatter);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setAxisLineColor(2);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setGridColor(Color.WHITE);
        xAxis.setAxisLineColor(Color.WHITE);

        mHorizontalBarChart.invalidate();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeGraphDataBar() {

        mBarEntries = new ArrayList<>();

        mBarEntries.add(new BarEntry(0f, value1));
        mBarEntries.add(new BarEntry(1f, value2));
        mBarEntries.add(new BarEntry(2f, value3));
        mBarEntries.add(new BarEntry(3f, value4));
        mBarEntries.add(new BarEntry(4f, value5));

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeGraphDataPie() {

        mPieEntries = new ArrayList<>();

        if (value1 > intLimitChartPizza) {
            mPieEntries.add(new PieEntry(value1, mTableLabels[0], 1));
        } else {
            mPieEntries.add(new PieEntry(value1, "", 1));
        }

        if (value2 > intLimitChartPizza) {
            mPieEntries.add(new PieEntry(value2, mTableLabels[1], 2));
        } else {
            mPieEntries.add(new PieEntry(value2, "", 2));
        }

        if (value3 > intLimitChartPizza) {
            mPieEntries.add(new PieEntry(value3, mTableLabels[2], 3));
        } else {
            mPieEntries.add(new PieEntry(value3, "", 3));
        }

        if (value4 > intLimitChartPizza) {
            mPieEntries.add(new PieEntry(value4, mTableLabels[3], 4));
        } else {
            mPieEntries.add(new PieEntry(value4, "", 4));
        }

        if (value5 > intLimitChartPizza) {
            mPieEntries.add(new PieEntry(value5, mTableLabels[4], 5));
        } else {
            mPieEntries.add(new PieEntry(value5, "", 5));
        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeGraphNames() {

        mTableLabels = new String[] {
                mContext.getString(R.string.label_experience_very_bad),
                mContext.getString(R.string.label_experience_bad),
                mContext.getString(R.string.label_experience_normal),
                mContext.getString(R.string.label_experience_good),
                mContext.getString(R.string.label_experience_very_good)};

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeGraphColor() {

        mColors = new ArrayList<>();

        mTableColors = new int[]{
                ContextCompat.getColor(requireActivity(), R.color.graphColorGreenPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorBluePrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorPinkPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorCyanPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorOrangePrimaryDark)
        };

        for (int mIndex : mTableColors) {
            mColors.add(mIndex);
        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void readDataFromDatabase() {

        SqliteModuleDiaryAnswer.sqliteGraphExperience(mContext);

        value1 = Float.parseFloat(String.valueOf((INT_GRAPH_VALUE_01)));
        value2 = Float.parseFloat(String.valueOf((INT_GRAPH_VALUE_02)));
        value3 = Float.parseFloat(String.valueOf((INT_GRAPH_VALUE_03)));
        value4 = Float.parseFloat(String.valueOf((INT_GRAPH_VALUE_04)));
        value5 = Float.parseFloat(String.valueOf((INT_GRAPH_VALUE_05)));

    }
}
