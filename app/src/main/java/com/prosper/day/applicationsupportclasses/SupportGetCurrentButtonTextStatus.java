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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;

public class SupportGetCurrentButtonTextStatus {

    private static String status_all;
    private static String status_new;
    private static String status_pending;
    private static String status_closed;
    private static String status_postponed;
    private static String status_ignored;
    
    private static String mStringButtonTextReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGetCurrentButtonTextStatus(Context context, String mStringButtonTextReceived) {

        status_all = context.getString(R.string.label_list_all);
        status_new = context.getString(R.string.label_list_new);
        status_pending = context.getString(R.string.label_list_pending);
        status_closed = context.getString(R.string.label_list_closed);
        status_postponed = context.getString(R.string.label_list_postponed);
        status_ignored = context.getString(R.string.label_list_ignored);

        if (mStringButtonTextReceived.equals(status_all)) {
            mStringButtonTextReturned = STATUS_ALL;

        } else {
            if (mStringButtonTextReceived.equals(status_new)) {
                mStringButtonTextReturned = STATUS_NEW;

            } else {
                if (mStringButtonTextReceived.equals(status_pending)) {
                    mStringButtonTextReturned = STATUS_PENDING;
                } else {
                    if (mStringButtonTextReceived.equals(status_closed)) {
                        mStringButtonTextReturned = STATUS_CLOSED;

                    } else {
                        if (mStringButtonTextReceived.equals(status_postponed)) {
                            mStringButtonTextReturned = STATUS_POSTPONED;

                        } else {
                            if (mStringButtonTextReceived.equals(status_ignored)) {
                                mStringButtonTextReturned = STATUS_IGNORED;

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
