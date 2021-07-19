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
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportCheckNetworkAvailability;
import com.prosper.day.applicationsupportclasses.SupportMessageToast;
import com.prosper.day.databasesqlite.SqliteSupportWord;

import java.util.Random;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sFirebaseAuth;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsTheme;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_DAYWORD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_06;

public class AuthorizationApplicationSigninActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
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

        sFirebaseAuth = FirebaseAuth.getInstance();

        setApplicationTheme();

        setContentView(R.layout.authorization_application_signin_activity);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mToolbar.setTitle(R.string.label_authorization);
        mToolbar.setSubtitle(R.string.label_signin);

        editTextEmail = findViewById(R.id.editText_userEmail);
        editTextPassword = findViewById(R.id.editText_user_password);

        Button buttonSignin = findViewById(R.id.button_signin);
        Button buttonReset = findViewById(R.id.button_reset);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        TextView mTextViewDayWord;
        mTextViewDayWord = findViewById(R.id.textViewValueMotivation);

        Random random = new Random();
        int intWord = random.nextInt(NUMBER_DAYWORD - 1) + 1;

        @SuppressLint("DefaultLocale") String stringNumber = String.format("%04d", intWord);
        String stringWord = SqliteSupportWord.sqliteGetOne(getApplicationContext(), stringNumber);

        mTextViewDayWord.setText(stringWord);

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), AuthorizationPasswordResetActivity.class));
                finish();
            }
        });

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    new SupportMessageToast(getApplicationContext(), getString(R.string.message_userEmail));
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    new SupportMessageToast(getApplicationContext(), getString(R.string.message_user_password));
                    return;
                }

                if (password.length() < INT_NUMBER_06) {
                    new SupportMessageToast(getApplicationContext(), getString(R.string.message_password_short));
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                sFirebaseAuth = FirebaseAuth.getInstance();

                sFirebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(AuthorizationApplicationSigninActivity.this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {

                                    new SupportMessageToast(getApplicationContext(), getString(R.string.message_user_signIn_failed));

                                } else {

                                    new SupportMessageToast(getApplicationContext(), getString(R.string.message_user_signIn_success));
                                    progressBar.setVisibility(View.INVISIBLE);
                                    startActivity(new Intent(getApplicationContext(), AuthorizationApplicationLoginActivity.class));
                                    finish();
                                }
                            }
                        });
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
}
