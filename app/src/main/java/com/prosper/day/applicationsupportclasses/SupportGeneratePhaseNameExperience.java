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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_BAD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_GOOD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_NORMAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_VERY_BAD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_VERY_GOOD;

public class SupportGeneratePhaseNameExperience {
    
    private static String mStringNameExperienceReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGeneratePhaseNameExperience(Context mContext, String mStringExperienceCode) {

        mStringNameExperienceReturned = mContext.getString(R.string.label_not_found);

        switch (mStringExperienceCode){

            case EXPERIENCE_VERY_BAD:
                mStringNameExperienceReturned = mContext.getString(R.string.label_experience_very_bad);
                break;

            case EXPERIENCE_BAD:
                mStringNameExperienceReturned = mContext.getString(R.string.label_experience_bad);
                break;

            case EXPERIENCE_NORMAL:
                mStringNameExperienceReturned = mContext.getString(R.string.label_experience_normal);
                break;

            case EXPERIENCE_GOOD:
                mStringNameExperienceReturned = mContext.getString(R.string.label_experience_good);
                break;

            case EXPERIENCE_VERY_GOOD:
                mStringNameExperienceReturned = mContext.getString(R.string.label_experience_very_good);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mStringExperienceCode);

        }

        // *************************************************************************************
        // *************************************************************************************

        return mStringNameExperienceReturned;

    }
}
