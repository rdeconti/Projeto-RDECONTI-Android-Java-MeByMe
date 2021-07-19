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
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportCheckNetworkAvailability;
import com.prosper.day.applicationsupportclasses.SupportMessageToast;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasesqlite.SqliteSupportWord;
import com.prosper.day.module01main.ModuleControlMainActivity;

import java.util.Objects;
import java.util.Random;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.KEY_LOGIN_CHECKBOX;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.KEY_LOGIN_DATA_NOT_SAVE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.KEY_LOGIN_DATA_SAVE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.KEY_LOGIN_PASSWORD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.KEY_LOGIN_USERNAME;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sFirebaseAuth;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseEmail;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseUserId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsTheme;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_DAYWORD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_06;

public class AuthorizationApplicationLoginActivity extends AppCompatActivity {

    private Context mContext;

    private EditText userEmail;
    private EditText userPassword;
    private ProgressBar progressBar;
    private SharedPreferences sharedPreferences;
    private CheckBox checkBoxLoginData;
    private Boolean booleanReturnCode = null;

    private long recordCounter;

    static String email;
    static String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO REVIEW ALL CODING TO AUTHORIZATION MODULES - DO IT LIKE MODULES!!!!

        new SupportSharedPreferencesGet(this);
        new SupportSettingLocalization(this);

        setApplicationTheme();

        checkNetworkAvailability();

        checkUserAgreement();

        setContentView(R.layout.authorization_application_login_activity);

        checkBoxLoginData = findViewById(R.id.checkBoxLoginData);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mToolbar.setTitle(R.string.label_authorization);
        mToolbar.setSubtitle(R.string.label_login);

        userEmail = findViewById(R.id.editText_userEmail);
        userPassword = findViewById(R.id.editText_user_password);

        SharedPreferences sharedPreferences = this.getSharedPreferences(this.getString(R.string.sharedPreferencesLogin), MODE_PRIVATE);
        String stringUserName = sharedPreferences.getString(KEY_LOGIN_USERNAME, getApplicationContext().getString(R.string.label_none));
        String stringUserPassword = sharedPreferences.getString(KEY_LOGIN_PASSWORD, getApplicationContext().getString(R.string.label_none));
        String stringSaveLoginData = sharedPreferences.getString(KEY_LOGIN_CHECKBOX, getApplicationContext().getString(R.string.label_none));

        if (!stringSaveLoginData.equals(getApplicationContext().getString(R.string.label_none))) {

            if (stringSaveLoginData.equals(KEY_LOGIN_DATA_SAVE)) {

                if (!stringUserName.equals(getApplicationContext().getString(R.string.label_none))) {
                    userEmail.setText(stringUserName);
                }

                if (!stringUserPassword.equals(getApplicationContext().getString(R.string.label_none))) {
                    userPassword.setText(stringUserPassword);
                }

                checkBoxLoginData.setChecked(true);

            } else {

                checkBoxLoginData.setChecked(false);

            }

        } else {

            checkBoxLoginData.setChecked(false);
        }

        Button buttonSignin = findViewById(R.id.button_signin);
        Button buttonLogin = findViewById(R.id.button_login);
        Button buttonReset = findViewById(R.id.button_reset);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        sFirebaseAuth = FirebaseAuth.getInstance();

        getMotivationalWord();

        checkBoxLoginData.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checkBox)
            {
                if (checkBox) {

                    SharedPreferences sharedPreferences = getSharedPreferences(getApplicationContext().getString(R.string.sharedPreferencesLogin), MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_LOGIN_USERNAME, email);
                    editor.putString(KEY_LOGIN_PASSWORD, password);
                    editor.putString(KEY_LOGIN_CHECKBOX, KEY_LOGIN_DATA_SAVE );
                    editor.apply();

                } else {

                    SharedPreferences sharedPreferences = getSharedPreferences(getApplicationContext().getString(R.string.sharedPreferencesLogin), MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_LOGIN_USERNAME, null);
                    editor.putString(KEY_LOGIN_PASSWORD, null);
                    editor.putString(KEY_LOGIN_CHECKBOX, KEY_LOGIN_DATA_NOT_SAVE );
                    editor.apply();

                }
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /*
                if (APPLICATION_TEST_ON) {
                    new SupportMessageToast(getApplicationContext(), getApplicationContext().getString(R.string.message_network_not_available));
                    startActivity(new Intent(getApplicationContext(), ModuleControlMainActivity.class));
                    finish();
                }
                */

                email = userEmail.getText().toString();
                password = userPassword.getText().toString();

                //TODO REVIEW HOW TO TREAT NETWORK NOT AVAILABLE !!!!
                booleanReturnCode = SupportCheckNetworkAvailability.supportCheckNetworkAvailability(getApplicationContext());

                if (!booleanReturnCode) {
                    new SupportMessageToast(getApplicationContext(), getApplicationContext().getString(R.string.message_network_not_available));
                    startActivity(new Intent(getApplicationContext(), ModuleControlMainActivity.class));
                    finish();
                }

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

                if (stringSaveLoginData.equals(getApplicationContext().getString(R.string.label_none))){

                    SharedPreferences sharedPreferences = getSharedPreferences(getApplicationContext().getString(R.string.sharedPreferencesLogin), MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_LOGIN_USERNAME, null);
                    editor.putString(KEY_LOGIN_PASSWORD, null);
                    editor.apply();

                }

                if (stringSaveLoginData.equals(KEY_LOGIN_DATA_NOT_SAVE)){

                    SharedPreferences sharedPreferences = getSharedPreferences(getApplicationContext().getString(R.string.sharedPreferencesLogin), MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_LOGIN_USERNAME, null);
                    editor.putString(KEY_LOGIN_PASSWORD, null);
                    editor.apply();

                }

                if (stringSaveLoginData.equals(KEY_LOGIN_DATA_SAVE)){

                    SharedPreferences sharedPreferences = getSharedPreferences(getApplicationContext().getString(R.string.sharedPreferencesLogin), MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_LOGIN_USERNAME, email);
                    editor.putString(KEY_LOGIN_PASSWORD, password);
                    editor.putString(KEY_LOGIN_CHECKBOX, KEY_LOGIN_DATA_SAVE );
                    editor.apply();

                }

                progressBar.setVisibility(View.VISIBLE);

                sFirebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(AuthorizationApplicationLoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {
                                    new SupportMessageToast(getApplicationContext(), getString(R.string.message_user_logIn_failed));
                                    return;
                                }

                                progressBar.setVisibility(View.INVISIBLE);


                                stringCurrentUserFirebaseUserId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
                                stringCurrentUserFirebaseEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

                                SharedPreferences.Editor editor = AuthorizationApplicationLoginActivity.this.sharedPreferences.edit();

                                editor.putString(getString(R.string.label_userFirebaseId), stringCurrentUserFirebaseUserId);
                                editor.putString(getString(R.string.label_UserFirebaseEmail), stringCurrentUserFirebaseEmail);
                                editor.apply();

                                startActivity(new Intent(getApplicationContext(), ModuleControlMainActivity.class));
                                finish();
                            }

                        });
            }
        });

        buttonSignin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), AuthorizationApplicationSigninActivity.class));

            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), AuthorizationPasswordResetActivity.class));

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

    // *********************************************************************************************
    // *********************************************************************************************
    private void getMotivationalWord() {

        TextView mTextViewAppName;
        mTextViewAppName = findViewById(R.id.textViewAppName);

        TextView mTextViewDayWord;
        mTextViewDayWord = findViewById(R.id.textViewValueMotivation);

        TextView mTextViewHeaderMotivational;
        mTextViewHeaderMotivational = findViewById(R.id.textViewHeaderMotivational);

        recordCounter = SqliteSupportWord.sqliteCounter(getApplicationContext());
        if (recordCounter > 0 ) {

            Random random = new Random();
            int intWord = random.nextInt(NUMBER_DAYWORD - 1) + 1;
            @SuppressLint("DefaultLocale") String stringNumber = String.format("%04d", intWord);

            String stringWord = SqliteSupportWord.sqliteGetOne(getApplicationContext(), stringNumber);
            mTextViewDayWord.setText(stringWord);
            mTextViewDayWord.setVisibility(View.VISIBLE);
            mTextViewHeaderMotivational.setVisibility(View.VISIBLE);
            mTextViewAppName.setVisibility(View.INVISIBLE);

        } else {

            mTextViewDayWord.setVisibility(View.INVISIBLE);
            mTextViewHeaderMotivational.setVisibility(View.INVISIBLE);
            mTextViewAppName.setVisibility(View.VISIBLE);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void checkNetworkAvailability() {

        booleanReturnCode = SupportCheckNetworkAvailability.supportCheckNetworkAvailability(getApplicationContext());

        if (!booleanReturnCode) {

            AlertDialog.Builder builder = new AlertDialog.Builder(AuthorizationApplicationLoginActivity.this);

            builder.setTitle(R.string.label_alert_dialog_agreement_title);
            builder.setMessage(R.string.message_NetworkNotAvailableLogin);

            builder.setPositiveButton(R.string.label_alert_dialog_agreement_continue, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(getApplicationContext(), ModuleControlMainActivity.class));
                    finish();
                }
            });

            builder.setNegativeButton(R.string.label_alert_dialog_agreement_stop, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            builder.show();

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void checkUserAgreement() {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean userAgreement = sharedPreferences.getBoolean(getString(R.string.label_alert_dialog_agreement), false);

        AlertDialog.Builder builder = new AlertDialog.Builder(AuthorizationApplicationLoginActivity.this);

        if (!userAgreement) {
            builder.setTitle(R.string.label_alert_dialog_agreement);
            builder.setPositiveButton(R.string.label_alert_dialog_agreement_continue, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(getString(R.string.label_alert_dialog_agreement), true);
                    editor.apply();
                }
            });

            builder.setMessage(R.string.message_TermsAndConditions);
            builder.show();
        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}