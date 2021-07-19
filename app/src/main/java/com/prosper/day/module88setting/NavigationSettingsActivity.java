package com.prosper.day.module88setting;

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

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsTheme;

public class NavigationSettingsActivity extends AppCompatActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setApplicationTheme();

        setContentView(R.layout.setting_activity);

        ActionBar actionBar = this.getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        new SupportSharedPreferencesGet(getApplicationContext());
        new SupportSettingLocalization(getBaseContext());

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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}