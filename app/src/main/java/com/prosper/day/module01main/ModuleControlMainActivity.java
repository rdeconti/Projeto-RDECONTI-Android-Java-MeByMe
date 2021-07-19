package com.prosper.day.module01main;

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

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.navigation.NavigationView;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasesqlite.SqliteSupportUser;
import com.prosper.day.module02mood.ModuleFragmentMoodControl;
import com.prosper.day.module03autobiography.ModuleFragmentAutobiographyControl;
import com.prosper.day.module04recognition.ModuleFragmentRecognitionControl;
import com.prosper.day.module05belief.ModuleFragmentBeliefControl;
import com.prosper.day.module06personality.ModuleFragmentPersonalityControl;
import com.prosper.day.module07life.ModuleFragmentLifeControl;
import com.prosper.day.module08action.ModuleFragmentActionControl;
import com.prosper.day.module09reflection.ModuleFragmentReflectionControl;
import com.prosper.day.module10biorhythm.ModuleFragmentBiorhythmControl;
import com.prosper.day.module11challenge.ModuleFragmentChallengeControl;
import com.prosper.day.module12diary.ModuleFragmentDiaryControl;
import com.prosper.day.module14photo.ModuleFragmentPhotoControl;
import com.prosper.day.module15sharing.ModuleFragmentSharingControl;
import com.prosper.day.module66authorization.AuthorizationApplicationEmailActivity;
import com.prosper.day.module66authorization.AuthorizationApplicationLogoutActivity;
import com.prosper.day.module66authorization.AuthorizationApplicationSignoutActivity;
import com.prosper.day.module66authorization.AuthorizationPasswordChangeActivity;
import com.prosper.day.module66authorization.AuthorizationPasswordResetActivity;
import com.prosper.day.module88setting.NavigationSettingsActivity;

import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.AUTHORIZATION_PHASE_CODE_66_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.AUTHORIZATION_PHASE_CODE_66_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.AUTHORIZATION_PHASE_CODE_66_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.AUTHORIZATION_PHASE_CODE_66_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.AUTHORIZATION_PHASE_CODE_66_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.AUTOBIOGRAPHY_PHASE_CODE_03_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BIORHYTHM_PHASE_CODE_10_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.CHALLENGE_PHASE_CODE_11_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_13;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_AD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MOOD_PHASE_CODE_02_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PERSONALITY_PHASE_CODE_06_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.RECOGNITION_PHASE_CODE_04_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_PHASE_CODE_09_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentScreenGraphStatus;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsTheme;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.REPORT_INITIAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;

// *************************************************************************************************
// *************************************************************************************************
public class ModuleControlMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Context mContext;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private DrawerLayout mDrawerLayout;
    private Intent mIntent;

    private AppCompatActivity mAppCompatActivity;
    private String mStringCurrentFragment;

    private long recordCounter;

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getBaseContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        setApplicationTheme();

        setContentView(R.layout.main_module_control_main_app_activity);

        checkPermissionAudio();

        initializeToolBar();

        initializeNavigationView();
        initializeDrawerLayout();
        initializeMainFragment();
        initializeMobileAds();
        initializePhaseData();

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
    private void initializePhaseData() {

        recordCounter = SqliteSupportUser.sqliteCounter(mContext);

        Log.w("MEBYME", "initializePhaseData: recordCounter " + recordCounter );

        if (recordCounter <= 0 ){
            stringCurrentPhaseCode = MAIN_PHASE_CODE_01_07;
            setTitle(R.string.app_name);
            mToolbar.setSubtitle(R.string.label_reset);
            mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentToolReset(), null).commit();
        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeMainFragment() {

        setTitle(R.string.label_main);
        mToolbar.setSubtitle(R.string.label_advice);

        stringCurrentPhaseCode = MAIN_PHASE_CODE_01_AD;

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.frameLayout_container_module_control_main_content,new ModuleControlMainActivityFragment(), null)
                .commit();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeToolBar() {

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeDrawerLayout() {

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.label_status_pending, R.string.label_status_closed);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeNavigationView() {

        mNavigationView = findViewById(R.id.mNavigationView);
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setNavigationItemSelectedListener(this);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {

            mDrawerLayout.closeDrawer(GravityCompat.START);

        } else {

            treatExitApplication();

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public boolean onSupportNavigateUp() {

        treatExitApplication();
        return true;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void treatExitApplication() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (Objects.requireNonNull(fragmentManager).getBackStackEntryCount() > INT_NUMBER_00) {

            fragmentManager.popBackStack();

        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(ModuleControlMainActivity.this, R.style.AlertDialogTheme);

            builder.setTitle(R.string.label_alert_dialog_agreement_title);
            builder.setMessage(R.string.message_confirm_logout);
            builder.setIcon(R.drawable.application_bitmap_small);

            builder.setPositiveButton(R.string.label_alert_dialog_agreement_no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton(R.string.label_alert_dialog_agreement_yes, new DialogInterface.OnClickListener() {
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_header, menu);
        return true;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        stringCurrentScreenGraphStatus = REPORT_INITIAL;

        mFragmentManager = getSupportFragmentManager();
        mStringCurrentFragment = "ModuleControlMainActivity";
        mAppCompatActivity = (AppCompatActivity) mNavigationView.getContext();

        int menuItem = item.getItemId();

        switch (menuItem) {

            case R.id.menu_back:
                treatExitApplication();
                break;

            case R.id.menu_home:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_AD;
                setTitle(R.string.label_main);
                mToolbar.setSubtitle(R.string.label_evolution);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleControlMainActivityFragment(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_help:
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_help);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDocumentHelp(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_configurations:
                mIntent = new Intent(getApplicationContext(), NavigationSettingsActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
                break;

            case R.id.menu_reset_password:
                stringCurrentPhaseCode = AUTHORIZATION_PHASE_CODE_66_02;
                mIntent = new Intent(getApplicationContext(), AuthorizationPasswordResetActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
                break;

            case R.id.menu_change_password:
                stringCurrentPhaseCode = AUTHORIZATION_PHASE_CODE_66_05;
                mIntent = new Intent(getApplicationContext(), AuthorizationPasswordChangeActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
                break;

            case R.id.menu_change_email:
                stringCurrentPhaseCode = AUTHORIZATION_PHASE_CODE_66_06;
                mIntent = new Intent(getApplicationContext(), AuthorizationApplicationEmailActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
                break;

            case R.id.menu_signout:
                stringCurrentPhaseCode = AUTHORIZATION_PHASE_CODE_66_07;
                mIntent = new Intent(getApplicationContext(), AuthorizationApplicationSignoutActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
                break;

            case R.id.menu_logout:
                stringCurrentPhaseCode = AUTHORIZATION_PHASE_CODE_66_04;
                mIntent = new Intent(getApplicationContext(), AuthorizationApplicationLogoutActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
                break;

            case R.id.menu_mission:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_01;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_mission);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDocumentMission(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_company:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_02;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_mission);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDocumentCompany(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_terms:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_03;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_terms);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDocumentTerms(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_policy:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_04;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_policy);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDocumentPolicy(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_sync:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_06;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_sync);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentToolSync(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_reset_data:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_07;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_reset);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentToolReset(), null).commit();
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDocumentPolicy(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_contact_us:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_08;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_contact);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentToolContact(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_credits:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_09;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_credits);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDocumentCredits(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_donations:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_10;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_donations);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentToolDonations(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_evaluation:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_11;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_evaluation);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentToolEvaluation(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_about_application:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_12;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_application);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDocumentApplication(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            case R.id.menu_notifications:
                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_13;
                setTitle(R.string.app_name);
                mToolbar.setSubtitle(R.string.label_notifications);
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentToolNotifications(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();
                break;

            default:
                String className = getClass().getName();
                throw new IllegalStateException(getApplicationContext().getString(R.string.message_unexpected_value) + className + " " + stringCurrentPhaseCode);
        }

        return super.onOptionsItemSelected(item);
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        mFragmentManager = getSupportFragmentManager();

        int itemId = item.getItemId();

        mToolbar.setSubtitle(R.string.label_report);

        switch (itemId) {

            case R.id.item_mood:
                stringCurrentPhaseCode = MOOD_PHASE_CODE_02_GE;
                setTitle(R.string.label_mood);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentMoodControl(), null).commit();
                break;

            case R.id.item_autobiography:
                stringCurrentPhaseCode = AUTOBIOGRAPHY_PHASE_CODE_03_GE;
                setTitle(R.string.label_autobiography);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentAutobiographyControl(), null).commit();
                break;

            case R.id.item_recognition:
                stringCurrentPhaseCode = RECOGNITION_PHASE_CODE_04_GE;
                setTitle(R.string.label_recognition);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentRecognitionControl(), null).commit();
                break;

            case R.id.item_belief:
                stringCurrentPhaseCode = BELIEF_PHASE_CODE_05_GE;
                setTitle(R.string.label_belief);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentBeliefControl(), null).commit();
                break;

            case R.id.item_personality:
                stringCurrentPhaseCode = PERSONALITY_PHASE_CODE_06_GE;
                setTitle(R.string.label_personality);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentPersonalityControl(), null).commit();
                break;

            case R.id.item_life:
                stringCurrentPhaseCode = LIFE_PHASE_CODE_07_GE;
                setTitle(R.string.label_life);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentLifeControl(), null).commit();
                break;

            case R.id.item_action:
                stringCurrentPhaseCode = ACTION_PHASE_CODE_08_GE;
                setTitle(R.string.label_actions);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentActionControl(), null).commit();
                break;

            case R.id.item_reflection:
                stringCurrentPhaseCode = REFLECTION_PHASE_CODE_09_GE;
                setTitle(R.string.label_reflection);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentReflectionControl(), null).commit();
                break;

            case R.id.item_biorhythm:
                stringCurrentPhaseCode = BIORHYTHM_PHASE_CODE_10_GE;
                setTitle(R.string.label_biorhythm);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentBiorhythmControl(), null).commit();
                break;

            case R.id.item_challenge:
                stringCurrentPhaseCode = CHALLENGE_PHASE_CODE_11_GE;
                setTitle(R.string.label_challenge);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentChallengeControl(), null).commit();
                break;

            case R.id.item_diary:
                stringCurrentPhaseCode = DIARY_PHASE_CODE_12_GE;
                setTitle(R.string.label_diary);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDiaryControl(), null).commit();
                break;

            case R.id.item_photo:
                stringCurrentPhaseCode = PHOTO_PHASE_CODE_14_02;
                setTitle(R.string.label_photos);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentPhotoControl(), null).commit();
                break;

            case R.id.item_sharing:
                stringCurrentPhaseCode = SHARING_PHASE_CODE_15_02;
                setTitle(R.string.label_sharing);
                mFragmentManager.beginTransaction().replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentSharingControl(), null).commit();
                break;

            case R.id.item_book:
            case R.id.item_user:
                // TODO TO BE DEVELOPED - include FEEDBACK
                break;

            default:
                String className = getClass().getName();
                throw new IllegalStateException(getApplicationContext().getString(R.string.message_unexpected_value) + className + " " + stringCurrentPhaseCode);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeMobileAds() {

        MobileAds.initialize(this, initializationStatus -> { });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd interstitial = new InterstitialAd(ModuleControlMainActivity.this);
        interstitial.setAdUnitId(getString(R.string.app_admob_interstitial_id));
        interstitial.loadAd(adRequest);
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                displayInterstitial();
            }

            void displayInterstitial() {
                if (interstitial.isLoaded()) {
                    interstitial.show();
                }
            }
        });

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void checkPermissionAudio() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {

                mIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                startActivity(mIntent);
                finish();

            }
        }
    }
}
