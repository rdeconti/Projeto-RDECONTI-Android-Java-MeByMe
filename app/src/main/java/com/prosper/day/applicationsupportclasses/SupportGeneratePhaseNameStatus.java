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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;

public class SupportGeneratePhaseNameStatus {
    
    private static String mStringNameStatusReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGeneratePhaseNameStatus(Context mContext, String mStringStatusCode) {

        mStringNameStatusReturned = mContext.getString(R.string.label_not_found);

        switch (mStringStatusCode){

            case STATUS_NEW:
                mStringNameStatusReturned = mContext.getString(R.string.label_status_new);
                break;

            case STATUS_IGNORED:
                mStringNameStatusReturned = mContext.getString(R.string.label_status_ignored);
                break;

            case STATUS_PENDING:
                mStringNameStatusReturned = mContext.getString(R.string.label_status_pending);
                break;

            case STATUS_POSTPONED:
                mStringNameStatusReturned = mContext.getString(R.string.label_status_postponed);
                break;

            case STATUS_CLOSED:
                mStringNameStatusReturned = mContext.getString(R.string.label_status_closed);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mStringStatusCode);

        }

        // *************************************************************************************
        // *************************************************************************************

        return mStringNameStatusReturned;

    }
}
