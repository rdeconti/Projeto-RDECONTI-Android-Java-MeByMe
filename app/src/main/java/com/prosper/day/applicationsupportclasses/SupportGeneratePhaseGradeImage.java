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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_10;

public class SupportGeneratePhaseGradeImage {
    
    private static Bitmap mBitmapReturned;

    @SuppressLint("DefaultLocale")
    public static Bitmap supportGeneratePhaseGradeImage(Context mContext, String mStringGradeNumber) {

        switch (mStringGradeNumber) {

            case STRING_NUMBER_00:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_00);
                break;

            case STRING_NUMBER_01:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_01);
                break;

            case STRING_NUMBER_02:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_02);
                break;

            case STRING_NUMBER_03:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_03);
                break;

            case STRING_NUMBER_04:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_04);
                break;

            case STRING_NUMBER_05:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_05);
                break;

            case STRING_NUMBER_06:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_06);
                break;

            case STRING_NUMBER_07:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_07);
                break;

            case STRING_NUMBER_08:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_08);
                break;

            case STRING_NUMBER_09:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_09);
                break;

            case STRING_NUMBER_10:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_10);
                break;

            default:
                mBitmapReturned = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.grade_icon_99);
                break;
        }

        // *************************************************************************************
        // *************************************************************************************

        return mBitmapReturned;

    }
}
