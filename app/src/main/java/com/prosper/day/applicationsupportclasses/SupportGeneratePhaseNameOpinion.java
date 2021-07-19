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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.OPINION_APPROVED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.OPINION_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.OPINION_REPROVED;

public class SupportGeneratePhaseNameOpinion {
    
    private static String mStringNameOpinionReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGeneratePhaseNameOpinion(Context mContext, String mStringOpinionCode) {

        mStringNameOpinionReturned = mContext.getString(R.string.label_not_found);

        switch (mStringOpinionCode) {

            case OPINION_NONE:
                mStringNameOpinionReturned = mContext.getString(R.string.label_none);
                break;

            case OPINION_APPROVED:
                mStringNameOpinionReturned = mContext.getString(R.string.label_approved);
                break;

            case OPINION_REPROVED:
                mStringNameOpinionReturned = mContext.getString(R.string.label_reproved);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mStringOpinionCode);

        }

        return mStringNameOpinionReturned;

    }
}
