package com.prosper.day.module10biorhythm;

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
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportPieChartRenderer;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasesqlite.SqliteModuleBiorhythmAnswer;

import java.util.ArrayList;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentScreenGraphStatus;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.GRAPH_BAR_HORIZONTAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.GRAPH_PIE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.REPORT_INITIAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_TOTAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;

public class ModuleFragmentBiorhythmGraphAnalysis extends Fragment {

    private View mView;
    private Button mButtonChart;
    private Context mContext;
    private Drawable mDrawable;
    private TextView mTextViewMessage;
    private HorizontalBarChart mHorizontalBarChart;
    private PieChart mPieChart;
    private PieDataSet mPieDataSet;
    private PieData mPieData;
    private Legend mLegend;

    private float value1;
    private float value2;
    private float value3;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentBiorhythmGraphAnalysis() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.biorhythm_graph_fragment, viewGroup, false);

        initializeLayoutData();

        SqliteModuleBiorhythmAnswer.sqliteGraphAnalysis(mContext);

        value1 = Float.parseFloat(String.valueOf((INT_GRAPH_VALUE_01)));
        value2 = Float.parseFloat(String.valueOf((INT_GRAPH_VALUE_02)));
        value3 = Float.parseFloat(String.valueOf((INT_GRAPH_VALUE_03)));

        if (INT_GRAPH_VALUE_TOTAL == INT_NUMBER_00) {

            mHorizontalBarChart.setVisibility(View.INVISIBLE);
            mPieChart.setVisibility(View.INVISIBLE);
            mButtonChart.setVisibility(View.INVISIBLE);
            mTextViewMessage.setVisibility(View.VISIBLE);
            return mView;

        }

        switch (stringCurrentScreenGraphStatus) {

            case REPORT_INITIAL:
            case GRAPH_BAR_HORIZONTAL:
                initializeHorizontalBarChart();
                break;

            case GRAPH_PIE:
                initializePieChart();
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
                        initializePieChart();
                        break;

                    case GRAPH_PIE:
                        initializeHorizontalBarChart();
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
    private void initializePieChart() {

        stringCurrentScreenGraphStatus = GRAPH_PIE;

        mHorizontalBarChart.setVisibility(View.INVISIBLE);
        mPieChart.setVisibility(View.VISIBLE);

        mDrawable = ContextCompat.getDrawable(mContext, R.drawable.tab_icon_graph_chart_bar_white_24dp);

        mButtonChart.setText(mContext.getString(R.string.label_chart_bar));
        mButtonChart.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable , null, null);

        generatePieChart();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeHorizontalBarChart() {

        stringCurrentScreenGraphStatus = GRAPH_BAR_HORIZONTAL;

        mHorizontalBarChart.setVisibility(View.VISIBLE);
        mPieChart.setVisibility(View.INVISIBLE);

        mDrawable = ContextCompat.getDrawable(mContext, R.drawable.tab_icon_graph_chart_pie_white_24dp);

        mButtonChart.setText(mContext.getString(R.string.label_chart_pie));
        mButtonChart.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable , null, null);

        generateHorizontalBarChart();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generatePieChart() {

        mPieChart.setVisibility(View.VISIBLE);
        mTextViewMessage.setVisibility(View.INVISIBLE);

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        if (value1 > INT_NUMBER_00) {
            pieEntries.add(new PieEntry(value1, getString(R.string.label_none), 1));
        }

        if (value2 > INT_NUMBER_00) {
            pieEntries.add(new PieEntry(value2, getString(R.string.label_approved), 2));
        }

        if (value3 > INT_NUMBER_00) {
            pieEntries.add(new PieEntry(value3, getString(R.string.label_reproved), 3));
        }

        mPieDataSet = new PieDataSet(pieEntries, "");
        mPieData = new PieData(mPieDataSet);
        mPieData.setValueFormatter(new PercentFormatter());
        mPieChart.setData(mPieData);

        mPieData.setValueFormatter(new PercentFormatter(mPieChart));
        mPieChart.setUsePercentValues(true);

        mPieChart.setDrawHoleEnabled(true);
        mPieChart.setHoleColor(Color.TRANSPARENT);
        mPieChart.setHoleRadius(40);
        mPieChart.setTransparentCircleRadius(50);

        mLegend = mPieChart.getLegend();
        mLegend.setEnabled(false);

        ArrayList<Integer> colors = new ArrayList<>();

        final int[] mTableColors = {
                ContextCompat.getColor(requireActivity(), R.color.graphColorAmberPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorBluePrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorBrownPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorCyanPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorGreenPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorIndigoPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorOrangePrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorPinkPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorPurplePrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorRedPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorTealPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorYellowPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorAmberPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorBluePrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorBrownPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorCyanPrimaryDark),
        };

        for (int color : mTableColors) {
            colors.add(color);
        }


        mPieDataSet.setColors(colors);

        mPieDataSet.setValueTextColor(Color.WHITE);
        mPieDataSet.setValueTextSize(15f);

        mPieDataSet.setYValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);
        mPieDataSet.setXValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);

        mPieChart.setEntryLabelColor(Color.WHITE);

        mPieChart.animateY(2000);
        mPieChart.animateXY(1400, 1400);

        mPieChart.getDescription().setEnabled(false);

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

        mHorizontalBarChart.setVisibility(View.VISIBLE);
        mTextViewMessage.setVisibility(View.INVISIBLE);

        mHorizontalBarChart.getDescription().setEnabled(false);

        mHorizontalBarChart.animateY(2000);
        mHorizontalBarChart.animateXY(1400, 1400);

        mHorizontalBarChart.getXAxis().setDrawGridLines(true);
        mHorizontalBarChart.getAxisLeft().setDrawGridLines(true);
        mHorizontalBarChart.getAxisRight().setDrawGridLines(true);

        mHorizontalBarChart.getXAxis().setDrawAxisLine(true);
        mHorizontalBarChart.getAxisLeft().setDrawAxisLine(true);
        mHorizontalBarChart.getAxisRight().setDrawAxisLine(true);

        mHorizontalBarChart.getAxisLeft().setDrawTopYLabelEntry(true);
        mHorizontalBarChart.getAxisLeft().setDrawTopYLabelEntry(true);
        mHorizontalBarChart.getAxisRight().setDrawTopYLabelEntry(true);

        mHorizontalBarChart.getAxisLeft().setDrawZeroLine(true);
        mHorizontalBarChart.getAxisRight().setDrawZeroLine(true);

        mHorizontalBarChart.getAxisLeft().setDrawLimitLinesBehindData(true);
        mHorizontalBarChart.getAxisRight().setDrawLimitLinesBehindData(true);

        Legend legend = mHorizontalBarChart.getLegend();
        legend.setEnabled(false);

        ArrayList<Integer> colors = new ArrayList<>();

        final int[] mTableColors = {
                ContextCompat.getColor(requireActivity(), R.color.graphColorAmberPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorBluePrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorBrownPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorCyanPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorGreenPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorIndigoPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorOrangePrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorPinkPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorPurplePrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorRedPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorTealPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorYellowPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorAmberPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorBluePrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorBrownPrimaryDark),
                ContextCompat.getColor(requireActivity(), R.color.graphColorCyanPrimaryDark),
        };

        for (int color : mTableColors) {
            colors.add(color);
        }

        ArrayList<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(0f, value1));
        entries.add(new BarEntry(1f, value2));
        entries.add(new BarEntry(2f, value3));

        BarDataSet barDataSet = new BarDataSet(entries, "");
        barDataSet.setBarBorderWidth(0.9f);

        BarData barData = new BarData(barDataSet);
        mHorizontalBarChart.setData(barData);
        mHorizontalBarChart.setFitBars(true);

        XAxis xAxis = mHorizontalBarChart.getXAxis();

        final String[] mTableLabels = new String[]
                {   mContext.getString(R.string.label_none),
                    mContext.getString(R.string.label_approved),
                    mContext.getString(R.string.label_reproved)};

        IndexAxisValueFormatter formatter = new IndexAxisValueFormatter(mTableLabels);

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setAxisLineColor(2);

        xAxis.setValueFormatter(formatter);

        mHorizontalBarChart.getXAxis().setTextColor(ContextCompat.getColor(mContext, R.color.White));
        mHorizontalBarChart.getAxisRight().setTextColor(ContextCompat.getColor(mContext, R.color.White));
        mHorizontalBarChart.getAxisLeft().setTextColor(ContextCompat.getColor(mContext, R.color.White));

        xAxis.setTextColor(Color.WHITE);
        xAxis.setGridColor(Color.WHITE);
        xAxis.setAxisLineColor(Color.WHITE);

        barDataSet.setColors(colors);
        barDataSet.setValueTextSize(15f);
        barDataSet.setValueTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        barDataSet.setValueTextColor(Color.WHITE);

        mHorizontalBarChart.getXAxis().setTextSize(15f);
        mHorizontalBarChart.getXAxis().setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        mHorizontalBarChart.invalidate();

    }
}
