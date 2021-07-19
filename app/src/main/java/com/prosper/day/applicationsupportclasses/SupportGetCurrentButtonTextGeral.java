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
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_DAILY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_MONTHLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_WEEKLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_YEARLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_HIGH;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_LOW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_MEDIUM;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;

public class SupportGetCurrentButtonTextGeral {

    private static String status_all;
    private static String status_new;
    private static String status_pending;
    private static String status_closed;
    private static String status_postponed;
    private static String status_ignored;

    private static String costs_none;
    private static String costs_high;
    private static String costs_medium;
    private static String costs_low;

    private static String priority_none;
    private static String priority_high;
    private static String priority_medium;
    private static String priority_low;

    private static String frequency_none;
    private static String frequency_daily;
    private static String frequency_weekly;
    private static String frequency_monthly;
    private static String frequency_yearly;

    private static String mStringButtonTextReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGetCurrentButtonTextGeral(Context context, String mStringButtonTextReceived) {

        status_all = context.getString(R.string.label_list_all);
        status_new = context.getString(R.string.label_list_new);
        status_pending = context.getString(R.string.label_list_pending);
        status_closed = context.getString(R.string.label_list_closed);
        status_postponed = context.getString(R.string.label_list_postponed);
        status_ignored = context.getString(R.string.label_list_ignored);

        costs_none = context.getString(R.string.label_costs_list_none);
        costs_high = context.getString(R.string.label_costs_list_high);
        costs_medium = context.getString(R.string.label_costs_list_medium);
        costs_low = context.getString(R.string.label_costs_list_low);

        priority_none = context.getString(R.string.label_priority_list_none);
        priority_high = context.getString(R.string.label_priority_list_high);
        priority_medium = context.getString(R.string.label_priority_list_medium);
        priority_low = context.getString(R.string.label_priority_list_low);

        frequency_none = context.getString(R.string.label_frequency_list_none);
        frequency_daily = context.getString(R.string.label_frequency_list_daily);
        frequency_weekly = context.getString(R.string.label_frequency_list_weekly);
        frequency_monthly = context.getString(R.string.label_frequency_list_monthly);
        frequency_yearly = context.getString(R.string.label_frequency_list_annual);

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

                                if (mStringButtonTextReceived.equals(costs_none)) {
                                    mStringButtonTextReturned = COSTS_NONE;

                                } else {

                                    if (mStringButtonTextReceived.equals(costs_high)) {
                                        mStringButtonTextReturned = COSTS_HIGH;

                                    } else {

                                        if (mStringButtonTextReceived.equals(costs_medium)) {
                                            mStringButtonTextReturned = COSTS_MEDIUM;

                                        } else {

                                            if (mStringButtonTextReceived.equals(costs_low)) {
                                                mStringButtonTextReturned = COSTS_LOW;

                                            } else {

                                                if (mStringButtonTextReceived.equals(priority_none)) {
                                                    mStringButtonTextReturned = PRIORITY_NONE;

                                                } else {

                                                    if (mStringButtonTextReceived.equals(priority_high)) {
                                                        mStringButtonTextReturned = PRIORITY_HIGH;

                                                    } else {

                                                        if (mStringButtonTextReceived.equals(priority_medium)) {
                                                            mStringButtonTextReturned = PRIORITY_MEDIUM;

                                                        } else {

                                                            if (mStringButtonTextReceived.equals(priority_low)) {
                                                                mStringButtonTextReturned = PRIORITY_LOW;

                                                            } else {

                                                                if (mStringButtonTextReceived.equals(frequency_none)) {
                                                                    mStringButtonTextReturned = FREQUENCY_NONE;

                                                                } else {

                                                                    if (mStringButtonTextReceived.equals(frequency_daily)) {
                                                                        mStringButtonTextReturned = FREQUENCY_DAILY;

                                                                    } else {

                                                                        if (mStringButtonTextReceived.equals(frequency_weekly)) {
                                                                            mStringButtonTextReturned = FREQUENCY_WEEKLY;

                                                                        } else {

                                                                            if (mStringButtonTextReceived.equals(frequency_monthly)) {
                                                                                mStringButtonTextReturned = FREQUENCY_MONTHLY;

                                                                            } else {

                                                                                if (mStringButtonTextReceived.equals(frequency_yearly)) {
                                                                                    mStringButtonTextReturned = FREQUENCY_YEARLY;

                                                                                } else {

                                                                                    String className = context.getClass().getName();
                                                                                    throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + mStringButtonTextReceived);

                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                           }
                        }
                    }
                }
            }
        }

        return mStringButtonTextReturned;

    }
}
