package com.prosper.day.module00splash;

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
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.module66authorization.AuthorizationApplicationLoginActivity;

import java.util.Locale;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentLanguageIsoCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsTheme;

public class ModuleSplashActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new SupportSharedPreferencesGet(getBaseContext());
        new SupportSettingLocalization(getBaseContext());

        setApplicationTheme();

        Locale locale = new Locale(sCurrentLanguageIsoCode);
        Locale.setDefault(locale);
        Configuration configuration = getBaseContext().getResources().getConfiguration();
        configuration.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.splash_activity);

        CountDownTimer mCountDownTimer = new CountDownTimer(2500, 200) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onFinish() {

                fadeOut();
                finish();

            }
        };

        mCountDownTimer.start();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void setApplicationTheme() {

        if (stringPreferredSettingsTheme.equals("amber")) {
            this.setTheme(R.style.ThemeColorAmber);
        } else {
            if (stringPreferredSettingsTheme.equals("blue")) {
                this.setTheme(R.style.ThemeColorBlue);
            } else {
                if (stringPreferredSettingsTheme.equals("brown")) {
                    this.setTheme(R.style.ThemeColorBrown);
                } else {
                    if (stringPreferredSettingsTheme.equals("cyan")) {
                        this.setTheme(R.style.ThemeColorCyan);
                    } else {
                        if (stringPreferredSettingsTheme.equals("gray")) {
                            this.setTheme(R.style.ThemeColorGray);
                        } else {
                            if (stringPreferredSettingsTheme.equals("green")) {
                                this.setTheme(R.style.ThemeColorGreen);
                            } else {
                                if (stringPreferredSettingsTheme.equals("indigo")) {
                                    this.setTheme(R.style.ThemeColorIndigo);
                                } else {
                                    if (stringPreferredSettingsTheme.equals("orange")) {
                                        this.setTheme(R.style.ThemeColorOrange);
                                    } else {
                                        if (stringPreferredSettingsTheme.equals("pink")) {
                                            this.setTheme(R.style.ThemeColorPink);
                                        } else {
                                            if (stringPreferredSettingsTheme.equals("purple")) {
                                                this.setTheme(R.style.ThemeColorPurple);
                                            } else {
                                                if (stringPreferredSettingsTheme.equals("red")) {
                                                    this.setTheme(R.style.ThemeColorRed);
                                                } else {
                                                    if (stringPreferredSettingsTheme.equals("teal")) {
                                                        this.setTheme(R.style.ThemeColorTeal);
                                                    } else {
                                                        if (stringPreferredSettingsTheme.equals("yellow")) {
                                                            this.setTheme(R.style.ThemeColorYellow);
                                                        } else {
                                                            this.setTheme(R.style.ThemeDefault);
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

    // *********************************************************************************************
    // *********************************************************************************************
    private void fadeOut() {

        Intent mainIntent = new Intent(this, AuthorizationApplicationLoginActivity.class);
        startActivity(mainIntent);
        overridePendingTransition(R.anim.splash_in, R.anim.splash_out);

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext((newBase));

    }
}