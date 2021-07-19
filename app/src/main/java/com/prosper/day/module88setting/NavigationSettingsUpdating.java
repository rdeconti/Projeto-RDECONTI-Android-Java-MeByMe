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

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.prosper.day.R;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsLanguage;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsTheme;

public class NavigationSettingsUpdating extends AppCompatActivity {

    // *********************************************************************************************
    // *********************************************************************************************
    public NavigationSettingsUpdating(Context context, String value) {

        if (value.equals(String.valueOf(R.string.settings_language_value_english))) {
            stringPreferredSettingsLanguage = value;
        }
        if (value.equals(String.valueOf(R.string.settings_language_value_portuguese))) {
            stringPreferredSettingsLanguage = value;
        }
        if (value.equals(String.valueOf(R.string.settings_language_value_spanish))) {
            stringPreferredSettingsLanguage = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_default))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_amber))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_blue))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_brown))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_cyan))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_gray))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_green))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_indigo))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_orange))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_pink))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_purple))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_red))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_teal))) {
            stringPreferredSettingsTheme = value;
        }
        if (value.equals(String.valueOf(R.string.settings_theme_value_yellow))) {
            stringPreferredSettingsTheme = value;
        }

    }

}
