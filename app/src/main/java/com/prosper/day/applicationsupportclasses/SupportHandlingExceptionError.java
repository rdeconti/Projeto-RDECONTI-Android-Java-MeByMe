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

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.prosper.day.R;

import java.util.Calendar;

public class SupportHandlingExceptionError extends AppCompatActivity {

    public SupportHandlingExceptionError(String stringActivity, Exception error, Context context) {

        Log.e(context.getString(R.string.label_error),
                context.getString(R.string.message_error_date_time) + Calendar.getInstance());

        Log.e(context.getString(R.string.label_error),
                context.getString(R.string.message_error_activity) + stringActivity);

        Log.e(context.getString(R.string.label_error),
                context.getString(R.string.message_error_cause) + error.getCause());

        Log.e(context.getString(R.string.label_error),
                context.getString(R.string.message_error_class) + error.getClass());

        Log.e(context.getString(R.string.label_error),
                context.getString(R.string.message_error_details) + error.getMessage());

    }
}
