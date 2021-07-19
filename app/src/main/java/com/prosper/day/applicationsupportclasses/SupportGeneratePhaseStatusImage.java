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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.prosper.day.R;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;

public class SupportGeneratePhaseStatusImage {
    
    private static Bitmap mBitmapReturned;

    @SuppressLint("DefaultLocale")
    public static Bitmap supportGeneratePhaseStatusImage(Context mContext, String stringStatus) {

        switch (stringStatus) {

            default:
            case STATUS_NEW:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.status_bitmap_new);
                break;

            case STATUS_CLOSED:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.status_bitmap_closed);
                break;

            case STATUS_PENDING:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.status_bitmap_pending);
                break;

            case STATUS_IGNORED:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.status_bitmap_ignored);
                break;

            case STATUS_POSTPONED:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.status_bitmap_postponed);
                break;

        }

        // *************************************************************************************
        // *************************************************************************************

        return mBitmapReturned;

    }
}
