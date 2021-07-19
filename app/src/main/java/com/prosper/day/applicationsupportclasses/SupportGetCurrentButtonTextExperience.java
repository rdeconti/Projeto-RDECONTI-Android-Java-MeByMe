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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_BAD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_GOOD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_NORMAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_VERY_BAD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_VERY_GOOD;

public class SupportGetCurrentButtonTextExperience {

    private static String experience_all;
    private static String experience_very_bad;
    private static String experience_bad;
    private static String experience_normal;
    private static String experience_good;
    private static String experience_very_good;

    private static String mStringButtonTextReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGetCurrentButtonTextExperience(Context context, String mStringButtonTextReceived) {

        experience_all = context.getString(R.string.label_list_all);
        experience_very_bad = context.getString(R.string.label_experience_very_bad);
        experience_bad = context.getString(R.string.label_experience_bad);
        experience_normal = context.getString(R.string.label_experience_normal);
        experience_good = context.getString(R.string.label_experience_good);
        experience_very_good = context.getString(R.string.label_experience_very_good);

        if (mStringButtonTextReceived.equals(experience_all)) {
            mStringButtonTextReturned = EXPERIENCE_ALL;

        } else{

            if (mStringButtonTextReceived.equals(experience_very_bad)) {
                mStringButtonTextReturned = EXPERIENCE_VERY_BAD;

            } else {
                if (mStringButtonTextReceived.equals(experience_bad)) {
                    mStringButtonTextReturned = EXPERIENCE_BAD;

                } else {
                    if (mStringButtonTextReceived.equals(experience_normal)) {
                        mStringButtonTextReturned = EXPERIENCE_NORMAL;
                    } else {
                        if (mStringButtonTextReceived.equals(experience_good)) {
                            mStringButtonTextReturned = EXPERIENCE_GOOD;

                        } else {
                            if (mStringButtonTextReceived.equals(experience_very_good)) {
                                mStringButtonTextReturned = EXPERIENCE_VERY_GOOD;

                            } else {
                                String className = context.getClass().getName();
                                throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + mStringButtonTextReceived);
                            }
                        }
                    }
                }
            }
        }

        return mStringButtonTextReturned;

    }
}
