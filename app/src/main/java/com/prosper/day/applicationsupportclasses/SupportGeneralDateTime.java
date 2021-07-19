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

import java.util.Calendar;

public class SupportGeneralDateTime {

    private static String mStringCurrentDate;
    private static String mStringCurrentTime;
    private static String mStringCurrentDateTime;
    private static String mStringFormattedDateTime;

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("DefaultLocale")
    public static String generateFormattedDateTime() {

        int intYear = Calendar.getInstance().get(Calendar.YEAR);
        int intMonth = Calendar.getInstance().get(Calendar.MONTH);
        int intDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        int intHour = Calendar.getInstance().get(Calendar.HOUR);
        int intMinute = Calendar.getInstance().get(Calendar.MINUTE);
        int intSecond = Calendar.getInstance().get(Calendar.SECOND);

        mStringCurrentDate =
                String.format("%02d", intDay) + "/" + String.format("%02d", intMonth)  + "/" +  String.format("%04d", intYear);

        mStringCurrentTime =
                String.format("%02d", intHour)  + ":" + String.format("%02d", intMinute) + ":" + String.format("%02d", intSecond);

        mStringFormattedDateTime = mStringCurrentDate + " - " + mStringCurrentTime;

        return mStringFormattedDateTime;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("DefaultLocale")
    public static String generateCurrentDateTime() {

        int intYear = Calendar.getInstance().get(Calendar.YEAR);
        int intMonth = Calendar.getInstance().get(Calendar.MONTH);
        int intDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        int intHour = Calendar.getInstance().get(Calendar.HOUR);
        int intMinute = Calendar.getInstance().get(Calendar.MINUTE);
        int intSecond = Calendar.getInstance().get(Calendar.SECOND);

        mStringCurrentDate =
                String.format("%04d", intYear) + String.format("%02d", intMonth) + String.format("%02d", intDay);

        mStringCurrentTime =
                String.format("%02d", intHour) + String.format("%02d", intMinute) + String.format("%02d", intSecond);

        mStringCurrentDateTime = mStringCurrentDate + mStringCurrentTime;

        return mStringCurrentDateTime;

    }
}
