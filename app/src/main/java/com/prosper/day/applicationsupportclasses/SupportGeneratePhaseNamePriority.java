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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_HIGH;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_LOW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_MEDIUM;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_NONE;

public class SupportGeneratePhaseNamePriority {
    
    private static String mStringNamePriorityReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGeneratePhaseNamePriority(Context mContext, String mStringPriorityCode) {

        mStringNamePriorityReturned = mContext.getString(R.string.label_not_found);

        switch (mStringPriorityCode) {

            case PRIORITY_HIGH:
                mStringNamePriorityReturned = mContext.getString(R.string.label_high);
                break;

            case PRIORITY_MEDIUM:
                mStringNamePriorityReturned = mContext.getString(R.string.label_medium);
                break;

            case PRIORITY_LOW:
                mStringNamePriorityReturned = mContext.getString(R.string.label_low);
                break;

            case PRIORITY_NONE:
                mStringNamePriorityReturned = mContext.getString(R.string.label_none);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mStringPriorityCode);

        }

        // *************************************************************************************
        // *************************************************************************************

        return mStringNamePriorityReturned;

    }
}
