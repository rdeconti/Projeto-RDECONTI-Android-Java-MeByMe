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
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNamePhase;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseNameSubPhase;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasesqlite.SqliteModuleDiaryAnswer;

import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12_GA;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_SUB_PHASES;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentScreenGraphStatus;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsTheme;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.REPORT_INITIAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_02;
import static com.prosper.day.databasereset.ResetModuleDiaryAnswer.resetModuleDiaryAnswer;

public class ModuleFragmentDiaryControl extends Fragment {

    private Context mContext;
    private AppBarLayout mAppBarLayout;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private View mView;
    private ViewPagerAdapter mViewPagerAdapter;

    private String mStringNamePhase;
    private String mStringNameSubPhase;

    private long recordCounter;

    private final int[] mTabLayoutIcons = {
            R.drawable.tab_icon_graph_evolution_white_24dp,
            R.drawable.tab_icon_graph_analysis_white_24dp,
            R.drawable.tab_icon_overview_white_24dp};

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentDiaryControl() {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = inflater.inflate(R.layout.main_module_control_main_app_content, viewGroup, false);

        initializeViewPager();
        initializeTabLayout();
        initializeTabIcons();
        initializePhaseData();

        mAppBarLayout = viewGroup.findViewById(R.id.appBarLayout);
        mAppBarLayout.addView(mTabLayout);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                stringCurrentScreenGraphStatus = REPORT_INITIAL;

                switch (position) {

                    case INT_NUMBER_00:
                        stringCurrentPhaseCode = DIARY_PHASE_CODE_12_GE;
                        break;

                    case INT_NUMBER_01:
                        stringCurrentPhaseCode = DIARY_PHASE_CODE_12_GA;
                        break;

                    case INT_NUMBER_02:
                        stringCurrentPhaseCode = DIARY_PHASE_CODE_12_OV;
                        break;

                    default:
                        String className = getClass().getName();
                        throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + stringCurrentPhaseCode);

                }

                formatFragmentTitles();

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return mView;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializePhaseData() {

        recordCounter = SqliteModuleDiaryAnswer.sqliteCounter(mContext);
        if (recordCounter <= 0 ){
            Log.w("MEBYME", "CREATE DIARY");
            resetModuleDiaryAnswer(mContext);
        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeViewPager() {

        mViewPager = mView.findViewById(R.id.mViewPager);
        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeTabLayout() {

        mTabLayout = new TabLayout(requireActivity());
        mTabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        setTabLayoutColor();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void setTabLayoutColor() {

        if (stringPreferredSettingsTheme.equals("amber")) {
            mTabLayout.setBackgroundColor(getResources().getColor(R.color.amber_primary_dark));
        } else {
            if (stringPreferredSettingsTheme.equals("blue")) {
                mTabLayout.setBackgroundColor(getResources().getColor(R.color.blue_primary_dark));
            } else {
                if (stringPreferredSettingsTheme.equals("brown")) {
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.brown_primary_dark));
                } else {
                    if (stringPreferredSettingsTheme.equals("cyan")) {
                        mTabLayout.setBackgroundColor(getResources().getColor(R.color.cyan_primary_dark));
                    } else {
                        if (stringPreferredSettingsTheme.equals("gray")) {
                            mTabLayout.setBackgroundColor(getResources().getColor(R.color.gray_primary_dark));
                        } else {
                            if (stringPreferredSettingsTheme.equals("green")) {
                                mTabLayout.setBackgroundColor(getResources().getColor(R.color.green_primary_dark));
                            } else {
                                if (stringPreferredSettingsTheme.equals("indigo")) {
                                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.indigo_primary_dark));
                                } else {
                                    if (stringPreferredSettingsTheme.equals("orange")) {
                                        mTabLayout.setBackgroundColor(getResources().getColor(R.color.orange_primary_dark));
                                    } else {
                                        if (stringPreferredSettingsTheme.equals("pink")) {
                                            mTabLayout.setBackgroundColor(getResources().getColor(R.color.pink_primary_dark));
                                        } else {
                                            if (stringPreferredSettingsTheme.equals("purple")) {
                                                mTabLayout.setBackgroundColor(getResources().getColor(R.color.purple_primary_dark));
                                            } else {
                                                if (stringPreferredSettingsTheme.equals("red")) {
                                                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.red_primary_dark));
                                                } else {
                                                    if (stringPreferredSettingsTheme.equals("teal")) {
                                                        mTabLayout.setBackgroundColor(getResources().getColor(R.color.teal_primary_dark));
                                                    } else {
                                                        if (stringPreferredSettingsTheme.equals("yellow")) {
                                                            mTabLayout.setBackgroundColor(getResources().getColor(R.color.yellow_primary_dark));
                                                        } else {
                                                            mTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeTabIcons() {

        Objects.requireNonNull(mTabLayout.getTabAt(0)).setIcon(mTabLayoutIcons[0]);
        Objects.requireNonNull(mTabLayout.getTabAt(1)).setIcon(mTabLayoutIcons[1]);
        Objects.requireNonNull(mTabLayout.getTabAt(2)).setIcon(mTabLayoutIcons[2]);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mAppBarLayout.removeView(mTabLayout);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        final String[] pageTitles =

                {
                        mContext.getString(R.string.label_evolution),
                        mContext.getString(R.string.label_analysis),
                        mContext.getString(R.string.label_overview),

                };

        // *********************************************************************************************
        // *********************************************************************************************
        public ViewPagerAdapter(FragmentManager mFragmentManager) {
            super(mFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        // *********************************************************************************************
        // *********************************************************************************************
        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {

                case INT_NUMBER_00:
                    stringCurrentPhaseCode = DIARY_PHASE_CODE_12_GE;
                    return new ModuleFragmentDiaryGraphEvolution();

                case INT_NUMBER_01:
                    stringCurrentPhaseCode = DIARY_PHASE_CODE_12_GA;
                    return new ModuleFragmentDiaryGraphAnalysis();

                case INT_NUMBER_02:
                    stringCurrentPhaseCode = DIARY_PHASE_CODE_12_OV;
                    return new ModuleFragmentDiaryRecyclerViewItem();

                default:
                    String className = getClass().getName();
                    throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + position);

            }

        }

        // *********************************************************************************************
        // *********************************************************************************************
        @Override
        public int getCount() {

            return DIARY_SUB_PHASES;

        }

        // *********************************************************************************************
        // *********************************************************************************************
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            return pageTitles[position];

        }


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
