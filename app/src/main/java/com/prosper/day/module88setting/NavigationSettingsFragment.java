package com.prosper.day.module88setting;

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
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;

import androidx.preference.CheckBoxPreference;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

import com.prosper.day.R;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;

public class NavigationSettingsFragment extends PreferenceFragmentCompat implements
        OnSharedPreferenceChangeListener, Preference.OnPreferenceChangeListener {

    private Context mContext;

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("ResourceType")
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

        mContext = getContext();

        addPreferencesFromResource(R.menu.menu_settings);

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();

        PreferenceScreen prefScreen = getPreferenceScreen();

        int count = prefScreen.getPreferenceCount();

        for (int index = INT_NUMBER_00; index < count; index++) {

            Preference preference = prefScreen.getPreference(index);

            if (!(preference instanceof CheckBoxPreference)) {
                String value = sharedPreferences.getString(preference.getKey(), "");
                setPreferenceSummary(preference, value);
            }
        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        Preference preference = findPreference(key);

        if (null != preference) {

            if (!(preference instanceof CheckBoxPreference)) {
                String value = sharedPreferences.getString(preference.getKey(), "");
                setPreferenceSummary(preference, value);
                new NavigationSettingsUpdating(mContext, value);

            }
        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void setPreferenceSummary(Preference preference, String value) {

        new NavigationSettingsUpdating(mContext, value);

        if (preference instanceof ListPreference) {

            ListPreference listPreference = (ListPreference) preference;

            int prefIndex = listPreference.findIndexOfValue(value);

            if (prefIndex >= INT_NUMBER_00) {

                listPreference.setSummary(listPreference.getEntries()[prefIndex]);

            }

            } else if (preference instanceof EditTextPreference) {

                preference.setSummary(value);

                new NavigationSettingsUpdating(mContext, value);

            }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        return true;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onDestroy() {
        super.onDestroy();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}