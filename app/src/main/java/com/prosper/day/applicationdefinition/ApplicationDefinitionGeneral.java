package com.prosper.day.applicationdefinition;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.prosper.day.R;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.APPLICATION_TYPE_BASIC;

public class ApplicationDefinitionGeneral {

    // TODO REVIEW NOMENCLATURE - https://stackoverflow.com/questions/12870537/android-naming-convention

    public static FirebaseAuth sFirebaseAuth;
    public static FirebaseUser sFirebaseUser;

    public static String stringCurrentUserFirebaseUserId = null;
    public static String stringCurrentUserFirebaseEmail = null;

    public static String stringPreferredSettingsLanguage =  (String.valueOf(R.string.settings_language_value_english));
    public static String stringPreferredSettingsTheme =  (String.valueOf(R.string.settings_theme_value_default));

    public static String stringPreferredSettingsUserId = null;
    public static String stringPreferredSettingsUserBirthdate = null;
    public static String stringPreferredSettingsUserCompleteName = null;
    public static String stringPreferredSettingsUserNickName = null;
    public static String stringPreferredSettingsUserEmail = null;
    public static String stringPreferredSettingsType = APPLICATION_TYPE_BASIC;
    public static String sCurrentLanguageIsoCode = null;
    public static String sCurrentApplicationLanguage = null;



    public static String stringCrudType;



    public static int intThreadSleep = 6000;

    public static int intNumberEditTextCharacters = 500;

    public static int intNumberBiorhythmDays = 400;
    public static int intNumberDiaryDays = 400;
    public static int intNumberMoodDays = 400;

    public static int intLimitChartPizza = 10;

    // *********************************************************************************************
    // *********************************************************************************************
    // *********************************************************************************************

    public static final String SIGN_INITIAL = "001";
    public static final String SIGN_FILE_TYPE = ".jpg";

    public static final String KEY_LOGIN_USERNAME = "username";
    public static final String KEY_LOGIN_PASSWORD = "password";
    public static final String KEY_LOGIN_CHECKBOX = "checkbox";
    public static final String KEY_LOGIN_DATA_SAVE = "save";
    public static final String KEY_LOGIN_DATA_NOT_SAVE = "not save";

    public static final String TAG = "MEBYME";
    public static final String UNACQUAINTED = "UNACQUAINTED";

    public static final String CRUD_C = "C";
    public static final String CRUD_R = "R";
    public static final String CRUD_U = "U";
    public static final String CRUD_D = "D";

    public static final int INT_SHOW_CASE_WITH_DELAY = 1;

    public static final String USER_REGISTERED_SINCE = "01/01/2019";

    public static String mStringCurrentUpdated;
    public static String mStringFormattedCurrentDate;

}
