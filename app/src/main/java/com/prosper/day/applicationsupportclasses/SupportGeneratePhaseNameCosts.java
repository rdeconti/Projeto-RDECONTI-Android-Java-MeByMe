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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_HIGH;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_LOW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_MEDIUM;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_NONE;

public class SupportGeneratePhaseNameCosts {
    
    private static String mStringNameCostsReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGeneratePhaseNameCosts(Context mContext, String mStringCostsCode) {

        mStringNameCostsReturned = mContext.getString(R.string.label_not_found);

        switch (mStringCostsCode) {

            case COSTS_HIGH:
                mStringNameCostsReturned = mContext.getString(R.string.label_high);
                break;

            case COSTS_MEDIUM:
                mStringNameCostsReturned = mContext.getString(R.string.label_medium);
                break;

            case COSTS_LOW:
                mStringNameCostsReturned = mContext.getString(R.string.label_low);
                break;

            case COSTS_NONE:
                mStringNameCostsReturned = mContext.getString(R.string.label_none);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mStringCostsCode);

        }

        // *************************************************************************************
        // *************************************************************************************

        return mStringNameCostsReturned;

    }
}
