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

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.prosper.day.R;

import java.util.Locale;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeLanguage.LANGUAGE_ENGLISH_ISO_CODE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeLanguage.LANGUAGE_PORTUGUESE_ISO_CODE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeLanguage.LANGUAGE_SPANISH_ISO_CODE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentLanguageIsoCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsLanguage;

public class SupportSettingLocalization extends AppCompatActivity {

    public SupportSettingLocalization(Context context) {

        if (TextUtils.isEmpty(stringPreferredSettingsLanguage)) {
            stringPreferredSettingsLanguage = (String.valueOf(R.string.settings_language_value_english));
        }

        sCurrentLanguageIsoCode = LANGUAGE_ENGLISH_ISO_CODE;
        sCurrentApplicationLanguage = "ENG";

        if (stringPreferredSettingsLanguage.equals("English")){
            sCurrentLanguageIsoCode = LANGUAGE_ENGLISH_ISO_CODE;
            sCurrentApplicationLanguage = "ENG";
        }

        if (stringPreferredSettingsLanguage.equals("Portuguese")){
            sCurrentLanguageIsoCode = LANGUAGE_PORTUGUESE_ISO_CODE;
            sCurrentApplicationLanguage = "POR";
        }

        if (stringPreferredSettingsLanguage.equals("Spanish")){
            sCurrentLanguageIsoCode = LANGUAGE_SPANISH_ISO_CODE;
            sCurrentApplicationLanguage = "SPA";
        }

        Locale locale = new Locale(sCurrentLanguageIsoCode);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());

    }
}
