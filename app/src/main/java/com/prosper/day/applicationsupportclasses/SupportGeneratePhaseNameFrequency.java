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

import com.prosper.day.R;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_DAILY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_MONTHLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_WEEKLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_YEARLY;

public class SupportGeneratePhaseNameFrequency {
    
    private static String mStringNameFrequencyReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGeneratePhaseNameFrequency(Context mContext, String mStringFrequencyCode) {

        mStringNameFrequencyReturned = mContext.getString(R.string.label_not_found);

        switch (mStringFrequencyCode) {

            case FREQUENCY_YEARLY:
                mStringNameFrequencyReturned = mContext.getString(R.string.label_annual);
                break;

            case FREQUENCY_MONTHLY:
                mStringNameFrequencyReturned = mContext.getString(R.string.label_monthly);
                break;

            case FREQUENCY_WEEKLY:
                mStringNameFrequencyReturned = mContext.getString(R.string.label_weekly);
                break;

            case FREQUENCY_DAILY:
                mStringNameFrequencyReturned = mContext.getString(R.string.label_daily);
                break;

            case FREQUENCY_NONE:
                mStringNameFrequencyReturned = mContext.getString(R.string.label_none);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mStringFrequencyCode);

        }

        // *************************************************************************************
        // *************************************************************************************

        return mStringNameFrequencyReturned;

    }
}
