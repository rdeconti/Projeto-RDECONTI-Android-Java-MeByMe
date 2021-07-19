package com.prosper.day.module66authorization;

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
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportCheckNetworkAvailability;
import com.prosper.day.applicationsupportclasses.SupportMessageToast;
import com.prosper.day.databasesqlite.SqliteSupportWord;

import java.util.Random;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sFirebaseAuth;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sFirebaseUser;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsTheme;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_DAYWORD;
import static com.prosper.day.applicationsupportclasses.SupportCheckUserFirebaseLogIn.supportCheckUserFirebaseLogIn;

public class AuthorizationApplicationSignoutActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Boolean booleanReturnCode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        booleanReturnCode = SupportCheckNetworkAvailability.supportCheckNetworkAvailability(getApplicationContext());
        if (!booleanReturnCode) {
            new SupportMessageToast(getApplicationContext(), getString(R.string.message_network_not_available));
            startActivity(new Intent(getApplicationContext(), AuthorizationApplicationLoginActivity.class));
            finish();
        }

        booleanReturnCode = supportCheckUserFirebaseLogIn(getApplicationContext());
        if (!booleanReturnCode) {
            new SupportMessageToast(getApplicationContext(), getString(R.string.message_user_please_login));
            startActivity(new Intent(getApplicationContext(), AuthorizationApplicationLoginActivity.class));
            finish();
        }

        sFirebaseAuth = FirebaseAuth.getInstance();
        sFirebaseUser = sFirebaseAuth.getCurrentUser();

        sFirebaseAuth = FirebaseAuth.getInstance();
        sFirebaseUser = sFirebaseAuth.getCurrentUser();

        setApplicationTheme();

        setContentView(R.layout.authorization_application_signout_activity);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mToolbar.setTitle(R.string.label_authorization);
        mToolbar.setSubtitle(R.string.label_signout);

        Button buttonSignout = findViewById(R.id.button_signout);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        // **************************************************************************** Get day word
        TextView mTextViewDayWord;
        mTextViewDayWord = findViewById(R.id.textViewValueMotivation);

        Random random = new Random();
        int intWord = random.nextInt(NUMBER_DAYWORD - 1) + 1;

        @SuppressLint("DefaultLocale") String stringNumber = String.format("%04d", intWord);
        String stringWord = SqliteSupportWord.sqliteGetOne(getApplicationContext(), stringNumber);

        mTextViewDayWord.setText(stringWord);

        // *************************************************************************** Treat signout
        buttonSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sFirebaseUser != null) {

                    progressBar.setVisibility(View.VISIBLE);

                    sFirebaseUser.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        new SupportMessageToast(getApplicationContext(), getString(R.string.message_user_signOut_success));
                                        startActivity(new Intent(getApplicationContext(), AuthorizationApplicationSigninActivity.class));
                                        progressBar.setVisibility(View.INVISIBLE);
                                        finish();

                                    } else {

                                        new SupportMessageToast(getApplicationContext(), getString(R.string.message_user_signOut_failed));
                                    }
                                }
                            });
                }
            }
        });

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);

    }
}
