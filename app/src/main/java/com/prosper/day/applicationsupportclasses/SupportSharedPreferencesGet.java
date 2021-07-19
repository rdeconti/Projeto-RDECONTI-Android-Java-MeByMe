package com.prosper.day.applicationsupportclasses;

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
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.prosper.day.R;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsLanguage;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsTheme;

@SuppressLint("Registered")
public class SupportSharedPreferencesGet extends AppCompatActivity {

    public SupportSharedPreferencesGet(Context context) {

        SharedPreferences sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(context);

        stringPreferredSettingsLanguage = sharedPreferences.getString(context.getString(R.string.settings_language_key), context.getString(R.string.settings_language_label));
        if (TextUtils.isEmpty(stringPreferredSettingsLanguage)) {
            stringPreferredSettingsLanguage = String.valueOf(R.string.settings_language_label_english);
        }

        stringPreferredSettingsTheme = sharedPreferences.getString(context.getString(R.string.settings_theme_key), context.getString(R.string.settings_theme_label));
        if (TextUtils.isEmpty(stringPreferredSettingsTheme)) {
            stringPreferredSettingsTheme = String.valueOf(R.string.settings_theme_value_default);
        }
    }
}
