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

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelSupportPointsUser;
import com.prosper.day.databasesqlite.SqliteSupportPointsUser;
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
import com.prosper.day.module13user.ModuleFragmentUserCrud;
import com.prosper.day.module14photo.ModuleFragmentPhotoControl;
import com.prosper.day.module15sharing.ModuleFragmentSharingControl;
import com.prosper.day.module19you.ModuleFragmentYouControl;

import java.util.List;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.AUTOBIOGRAPHY_PHASE_CODE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.AUTOBIOGRAPHY_PHASE_CODE_03_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BIORHYTHM_PHASE_CODE_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BIORHYTHM_PHASE_CODE_10_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.CHALLENGE_PHASE_CODE_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.CHALLENGE_PHASE_CODE_11_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MOOD_PHASE_CODE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MOOD_PHASE_CODE_02_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PERSONALITY_PHASE_CODE_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PERSONALITY_PHASE_CODE_06_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.RECOGNITION_PHASE_CODE_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.RECOGNITION_PHASE_CODE_04_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_PHASE_CODE_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_PHASE_CODE_09_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.USER_PHASE_CODE_13_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_GE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_13;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_14;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_15;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_19;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_13;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_14;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_15;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_19;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_TOTAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;

public class ModuleControlMainOverviewFragment extends Fragment {

    private View mView;
    private Context mContext;
    private AppCompatActivity mAppCompatActivity;

    private Button mButtonPhaseYou;
    private Button mButtonPhaseDiary;
    private Button mButtonPhasePersonality;
    private Button mButtonPhaseMood;
    private Button mButtonPhaseAutobiography;
    private Button mButtonPhaseChallenge;
    private Button mButtonPhaseReflection;
    private Button mButtonPhaseBiorhythm;
    private Button mButtonPhaseRecognition;
    private Button mButtonPhaseBelief;
    private Button mButtonPhaseLife;
    private Button mButtonPhaseSharing;
    private Button mButtonPhaseUser;
    private Button mButtonPhasePhoto;
    private Button mButtonPhaseAction;

    private TextView mTextViewPhaseYouDone;
    private TextView mTextViewPhaseDiaryDone;
    private TextView mTextViewPhasePersonalityDone;
    private TextView mTextViewPhaseMoodDone;
    private TextView mTextViewPhaseAutobiographyDone;
    private TextView mTextViewPhaseChallengeDone;
    private TextView mTextViewPhaseReflectionDone;
    private TextView mTextViewPhaseBiorhythmDone;
    private TextView mTextViewPhaseRecognitionDone;
    private TextView mTextViewPhaseBeliefDone;
    private TextView mTextViewPhaseLifeDone;
    private TextView mTextViewPhaseSharingDone;
    private TextView mTextViewPhaseUserDone;
    private TextView mTextViewPhasePhotoDone;
    private TextView mTextViewPhaseActionDone;

    private int mIndex;

    private int mStringPhaseYouItems;
    private int mStringPhaseDiaryItems;
    private int mStringPhasePersonalityItems;
    private int mStringPhaseMoodItems;
    private int mStringPhaseAutobiographyItems;
    private int mStringPhaseChallengeItems;
    private int mStringPhaseReflectionItems;
    private int mStringPhaseBiorhythmItems;
    private int mStringPhaseRecognitionItems;
    private int mStringPhaseBeliefItems;
    private int mStringPhaseLifeItems;
    private int mStringPhaseSharingItems;
    private int mStringPhasePhotoItems;
    private int mStringPhaseActionItems;

    private int mStringPhaseYouDone;
    private int mStringPhaseDiaryDone;
    private int mStringPhasePersonalityDone;
    private int mStringPhaseMoodDone;
    private int mStringPhaseAutobiographyDone;
    private int mStringPhaseChallengeDone;
    private int mStringPhaseReflectionDone;
    private int mStringPhaseBiorhythmDone;
    private int mStringPhaseRecognitionDone;
    private int mStringPhaseBeliefDone;
    private int mStringPhaseLifeDone;
    private int mStringPhaseSharingDone;
    private int mStringPhasePhotoDone;
    private int mStringPhaseUserDone;
    private int mStringPhaseActionDone;

    private String mStringPhaseYouSituation;
    private String mStringPhaseDiarySituation;
    private String mStringPhasePersonalitySituation;
    private String mStringPhaseMoodSituation;
    private String mStringPhaseAutobiographySituation;
    private String mStringPhaseChallengeSituation;
    private String mStringPhaseReflectionSituation;
    private String mStringPhaseBiorhythmSituation;
    private String mStringPhaseRecognitionSituation;
    private String mStringPhaseBeliefSituation;
    private String mStringPhaseLifeSituation;
    private String mStringPhaseSharingSituation;
    private String mStringPhasePhotoSituation;
    private String mStringPhaseUserSituation;
    private String mStringPhaseActionSituation;

    private String mStringCurrentFragment;

    private List<ModelSupportPointsUser> mListData = null;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleControlMainOverviewFragment() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = inflater.inflate(R.layout.main_module_control_main_fragment_overview, viewGroup, false);

        readDataFromDatabase();
        initializeButtons();
        initializeTexts();

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = ACTION_PHASE_CODE_08_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentActionControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = YOU_PHASE_CODE_19_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentYouControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = DIARY_PHASE_CODE_12_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentDiaryControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhasePersonality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = PERSONALITY_PHASE_CODE_06_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentPersonalityControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = MOOD_PHASE_CODE_02_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentMoodControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseAutobiography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = AUTOBIOGRAPHY_PHASE_CODE_03_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentAutobiographyControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = CHALLENGE_PHASE_CODE_11_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentChallengeControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseReflection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = REFLECTION_PHASE_CODE_09_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentReflectionControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseBiorhythm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = BIORHYTHM_PHASE_CODE_10_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentBiorhythmControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseRecognition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = RECOGNITION_PHASE_CODE_04_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentRecognitionControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseBelief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = BELIEF_PHASE_CODE_05_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentBeliefControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = LIFE_PHASE_CODE_07_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentLifeControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });
        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = ACTION_PHASE_CODE_08_GE;

                mStringCurrentFragment = "ModuleFragmentMainOverview";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentSharingControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = USER_PHASE_CODE_13_GE;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentUserCrud(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhaseSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = SHARING_PHASE_CODE_15_OV;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentSharingControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhasePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringCurrentPhaseCode = PHOTO_PHASE_CODE_14_OV;

                mStringCurrentFragment = "ModuleControlMainOverviewFragment";
                mAppCompatActivity = (AppCompatActivity) view.getContext();

                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleFragmentPhotoControl(), mStringCurrentFragment)
                        .addToBackStack(mStringCurrentFragment)
                        .commit();

            }

        });

        return mView;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeButtons() {

        mButtonPhaseYou = mView.findViewById(R.id.buttonPhaseYou);
        mButtonPhaseDiary = mView.findViewById(R.id.buttonPhaseDiary);
        mButtonPhasePersonality = mView.findViewById(R.id.buttonPhasePersonality);
        mButtonPhaseMood = mView.findViewById(R.id.buttonPhaseMood);
        mButtonPhaseAutobiography = mView.findViewById(R.id.buttonPhaseAutobiography);
        mButtonPhaseChallenge = mView.findViewById(R.id.buttonPhaseChallenge);
        mButtonPhaseReflection = mView.findViewById(R.id.buttonPhaseReflection);
        mButtonPhaseBiorhythm = mView.findViewById(R.id.buttonPhaseBiorhythm);
        mButtonPhaseRecognition = mView.findViewById(R.id.buttonPhaseRecognition);
        mButtonPhaseBelief = mView.findViewById(R.id.buttonPhaseBelief);
        mButtonPhaseLife = mView.findViewById(R.id.buttonPhaseLife);
        mButtonPhaseSharing = mView.findViewById(R.id.buttonPhaseSharing);
        mButtonPhaseUser = mView.findViewById(R.id.buttonPhaseUser);
        mButtonPhaseSharing = mView.findViewById(R.id.buttonPhaseSharing);
        mButtonPhasePhoto = mView.findViewById(R.id.buttonPhasePhoto);
        mButtonPhaseAction = mView.findViewById(R.id.buttonPhaseAction);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("DefaultLocale")
    private void initializeTexts() {

        mTextViewPhaseYouDone = mView.findViewById(R.id.textViewPhaseYouDone);
        mTextViewPhaseDiaryDone = mView.findViewById(R.id.textViewPhaseDiaryDone);
        mTextViewPhasePersonalityDone = mView.findViewById(R.id.textViewPhasePersonalityDone);
        mTextViewPhaseMoodDone = mView.findViewById(R.id.textViewPhaseMoodDone);
        mTextViewPhaseAutobiographyDone = mView.findViewById(R.id.textViewPhaseAutobiographyDone);
        mTextViewPhaseChallengeDone = mView.findViewById(R.id.textViewPhaseChallengeDone);
        mTextViewPhaseReflectionDone = mView.findViewById(R.id.textViewPhaseReflectionDone);
        mTextViewPhaseBiorhythmDone = mView.findViewById(R.id.textViewPhaseBiorhythmDone);
        mTextViewPhaseRecognitionDone = mView.findViewById(R.id.textViewPhaseRecognitionDone);
        mTextViewPhaseBeliefDone = mView.findViewById(R.id.textViewPhaseBeliefDone);
        mTextViewPhaseLifeDone = mView.findViewById(R.id.textViewPhaseLifeDone);
        mTextViewPhaseSharingDone = mView.findViewById(R.id.textViewPhaseSharingDone);
        mTextViewPhaseUserDone = mView.findViewById(R.id.textViewPhaseUserDone);
        mTextViewPhaseSharingDone = mView.findViewById(R.id.textViewPhaseSharingDone);
        mTextViewPhasePhotoDone = mView.findViewById(R.id.textViewPhasePhotoDone);
        mTextViewPhaseActionDone = mView.findViewById(R.id.textViewPhaseActionDone);

        if (mStringPhaseDiaryItems == 0) {
            mStringPhaseDiarySituation = STRING_NUMBER_00;
            mTextViewPhaseDiaryDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseDiarySituation = mStringPhaseDiaryDone + "/" + mStringPhaseDiaryItems;
            mTextViewPhaseDiaryDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseYouItems == 0) {
            mStringPhaseYouSituation = STRING_NUMBER_00;
            mTextViewPhaseYouDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseYouSituation = mStringPhaseYouDone + "/" + mStringPhaseYouItems;
            mTextViewPhaseYouDone.setVisibility(VISIBLE);
        }

        if (mStringPhasePersonalityItems == 0) {
            mStringPhasePersonalitySituation = STRING_NUMBER_00;
            mTextViewPhasePersonalityDone.setVisibility(INVISIBLE);
        } else {
            mStringPhasePersonalitySituation = mStringPhasePersonalityDone  + "/" +  mStringPhasePersonalityItems;
            mTextViewPhasePersonalityDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseMoodItems == 0) {
            mStringPhaseMoodSituation = STRING_NUMBER_00;
            mTextViewPhaseMoodDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseMoodSituation = mStringPhaseMoodDone  + "/" +  mStringPhaseMoodItems;
            mTextViewPhaseMoodDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseAutobiographyItems == 0) {
            mStringPhaseAutobiographySituation = STRING_NUMBER_00;
            mTextViewPhaseAutobiographyDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseAutobiographySituation = mStringPhaseAutobiographyDone  + "/" +  mStringPhaseAutobiographyItems;
            mTextViewPhaseAutobiographyDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseChallengeItems == 0) {
            mStringPhaseChallengeSituation = STRING_NUMBER_00;
            mTextViewPhaseChallengeDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseChallengeSituation = mStringPhaseChallengeDone  + "/" +  mStringPhaseChallengeItems;
            mTextViewPhaseChallengeDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseReflectionItems == 0) {
            mStringPhaseReflectionSituation = STRING_NUMBER_00;
            mTextViewPhaseReflectionDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseReflectionSituation = mStringPhaseReflectionDone  + "/" +  mStringPhaseReflectionItems;
            mTextViewPhaseReflectionDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseBiorhythmItems == 0) {
            mStringPhaseBiorhythmSituation = STRING_NUMBER_00;
            mTextViewPhaseBiorhythmDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseBiorhythmSituation = mStringPhaseBiorhythmDone  + "/" +  mStringPhaseBiorhythmItems;
            mTextViewPhaseBiorhythmDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseRecognitionItems == 0) {
            mStringPhaseRecognitionSituation = STRING_NUMBER_00;
            mTextViewPhaseRecognitionDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseRecognitionSituation = mStringPhaseRecognitionDone  + "/" +  mStringPhaseRecognitionItems;
            mTextViewPhaseRecognitionDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseBeliefItems == 0) {
            mStringPhaseBeliefSituation = STRING_NUMBER_00;
            mTextViewPhaseBeliefDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseBeliefSituation = mStringPhaseBeliefDone  + "/" +  mStringPhaseBeliefItems;
            mTextViewPhaseBeliefDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseLifeItems == 0) {
            mStringPhaseLifeSituation = STRING_NUMBER_00;
            mTextViewPhaseLifeDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseLifeSituation = mStringPhaseLifeDone  + "/" +  mStringPhaseLifeItems;
            mTextViewPhaseLifeDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseSharingItems == 0) {
            mStringPhaseSharingSituation = STRING_NUMBER_00;
            mTextViewPhaseSharingDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseSharingSituation = mStringPhaseSharingDone  + "/" +  mStringPhaseSharingItems;
            mTextViewPhaseSharingDone.setVisibility(VISIBLE);
        }

        if (mStringPhasePhotoItems == 0) {
            mStringPhasePhotoSituation = STRING_NUMBER_00;
            mTextViewPhasePhotoDone.setVisibility(INVISIBLE);
        } else {
            mStringPhasePhotoSituation = mStringPhasePhotoDone  + "/" +  mStringPhasePhotoItems;
            mTextViewPhasePhotoDone.setVisibility(VISIBLE);
        }

        if (mStringPhaseActionItems == 0) {
            mStringPhaseActionSituation = STRING_NUMBER_00;
            mTextViewPhaseActionDone.setVisibility(INVISIBLE);
        } else {
            mStringPhaseActionSituation = mStringPhaseActionDone  + "/" +  mStringPhaseActionItems;
            mTextViewPhaseActionDone.setVisibility(VISIBLE);
        }

        mTextViewPhaseUserDone.setVisibility(INVISIBLE);

        mTextViewPhaseYouDone.setText(mStringPhaseYouSituation);
        mTextViewPhaseDiaryDone.setText(mStringPhaseDiarySituation);
        mTextViewPhasePersonalityDone.setText(mStringPhasePersonalitySituation);
        mTextViewPhaseMoodDone.setText(mStringPhaseMoodSituation);
        mTextViewPhaseAutobiographyDone.setText(mStringPhaseAutobiographySituation);
        mTextViewPhaseChallengeDone.setText(mStringPhaseChallengeSituation);
        mTextViewPhaseReflectionDone.setText(mStringPhaseReflectionSituation);
        mTextViewPhaseBiorhythmDone.setText(mStringPhaseBiorhythmSituation);
        mTextViewPhaseRecognitionDone.setText(mStringPhaseRecognitionSituation);
        mTextViewPhaseBeliefDone.setText(mStringPhaseBeliefSituation);
        mTextViewPhaseLifeDone.setText(mStringPhaseLifeSituation);
        mTextViewPhaseSharingDone.setText(mStringPhaseSharingSituation);
        mTextViewPhasePhotoDone.setText(mStringPhasePhotoSituation);
        mTextViewPhaseUserDone.setText(mStringPhaseUserSituation);
        mTextViewPhaseActionDone.setText(mStringPhaseActionSituation);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void readDataFromDatabase() {

        INT_GRAPH_VALUE_TOTAL = 0;

        INT_GRAPH_VALUE_02 = 0;
        INT_GRAPH_VALUE_03 = 0;
        INT_GRAPH_VALUE_04 = 0;
        INT_GRAPH_VALUE_05 = 0;
        INT_GRAPH_VALUE_06 = 0;
        INT_GRAPH_VALUE_07 = 0;
        INT_GRAPH_VALUE_08 = 0;
        INT_GRAPH_VALUE_09 = 0;
        INT_GRAPH_VALUE_10 = 0;
        INT_GRAPH_VALUE_11 = 0;
        INT_GRAPH_VALUE_12 = 0;
        INT_GRAPH_VALUE_13 = 0;
        INT_GRAPH_VALUE_14 = 0;
        INT_GRAPH_VALUE_15 = 0;
        INT_GRAPH_VALUE_19 = 0;

        INT_DONE_VALUE_02 = 0;
        INT_DONE_VALUE_03 = 0;
        INT_DONE_VALUE_04 = 0;
        INT_DONE_VALUE_05 = 0;
        INT_DONE_VALUE_06 = 0;
        INT_DONE_VALUE_07 = 0;
        INT_DONE_VALUE_08 = 0;
        INT_DONE_VALUE_09 = 0;
        INT_DONE_VALUE_10 = 0;
        INT_DONE_VALUE_11 = 0;
        INT_DONE_VALUE_12 = 0;
        INT_DONE_VALUE_13 = 0;
        INT_DONE_VALUE_14 = 0;
        INT_DONE_VALUE_15 = 0;
        INT_DONE_VALUE_19 = 0;

        mListData = SqliteSupportPointsUser.sqliteGetAll(mContext);

        for (mIndex = INT_NUMBER_00; mIndex < mListData.size(); mIndex++) {

            String graphPhase = mListData.get(mIndex).getRecordPhase();
            String graphStatus = mListData.get(mIndex).getRecordStatus();

            INT_GRAPH_VALUE_TOTAL++;

            String graphPhaseCode = graphPhase.substring(0, 2);

            switch (graphPhaseCode) {

                case MOOD_PHASE_CODE_02:
                    INT_GRAPH_VALUE_02++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_02++;
                    }
                    break;

                case AUTOBIOGRAPHY_PHASE_CODE_03:
                    INT_GRAPH_VALUE_03++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_03++;
                    }
                    break;

                case RECOGNITION_PHASE_CODE_04:
                    INT_GRAPH_VALUE_04++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_04++;
                    }
                    break;

                case BELIEF_PHASE_CODE_05:
                    INT_GRAPH_VALUE_05++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_05++;
                    }
                    break;

                case PERSONALITY_PHASE_CODE_06:
                    INT_GRAPH_VALUE_06++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_06++;
                    }
                    break;

                case LIFE_PHASE_CODE_07:
                    INT_GRAPH_VALUE_07++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_07++;
                    }
                    break;

                case ACTION_PHASE_CODE_08:
                    INT_GRAPH_VALUE_08++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_08++;
                    }
                    break;

                case REFLECTION_PHASE_CODE_09:
                    INT_GRAPH_VALUE_09++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_09++;
                    }
                    break;

                case BIORHYTHM_PHASE_CODE_10:
                    INT_GRAPH_VALUE_10++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_10++;
                    }
                    break;

                case CHALLENGE_PHASE_CODE_11:
                    INT_GRAPH_VALUE_11++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_11++;
                    }
                    break;

                case DIARY_PHASE_CODE_12:
                    INT_GRAPH_VALUE_12++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_12++;
                    }
                    break;

                case PHOTO_PHASE_CODE_14:
                    INT_GRAPH_VALUE_14++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_14++;
                    }
                    break;

                case SHARING_PHASE_CODE_15:
                    INT_GRAPH_VALUE_15++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_15++;
                    }
                    break;

                case YOU_PHASE_CODE_19:
                    INT_GRAPH_VALUE_19++;
                    if (graphStatus.equals(STATUS_CLOSED)) {
                        INT_DONE_VALUE_19++;
                    }
                    break;

                default:
                    String className = mContext.getClass().getName();
                    throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + graphPhaseCode);

            }

            mStringPhaseMoodItems = INT_GRAPH_VALUE_02;
            mStringPhaseAutobiographyItems = INT_GRAPH_VALUE_03;
            mStringPhaseRecognitionItems = INT_GRAPH_VALUE_04;
            mStringPhaseBeliefItems = INT_GRAPH_VALUE_05;
            mStringPhasePersonalityItems = INT_GRAPH_VALUE_06;
            mStringPhaseLifeItems = INT_GRAPH_VALUE_07;
            mStringPhaseActionItems = INT_GRAPH_VALUE_08;
            mStringPhaseReflectionItems = INT_GRAPH_VALUE_09;
            mStringPhaseBiorhythmItems = INT_GRAPH_VALUE_10;
            mStringPhaseChallengeItems = INT_GRAPH_VALUE_11;
            mStringPhaseDiaryItems = INT_GRAPH_VALUE_12;
            mStringPhasePhotoItems = INT_GRAPH_VALUE_14;
            mStringPhaseSharingItems = INT_GRAPH_VALUE_15;
            mStringPhaseYouItems = INT_GRAPH_VALUE_19;

            mStringPhaseMoodDone = INT_DONE_VALUE_02;
            mStringPhaseAutobiographyDone = INT_DONE_VALUE_03;
            mStringPhaseRecognitionDone = INT_DONE_VALUE_04;
            mStringPhaseBeliefDone = INT_DONE_VALUE_05;
            mStringPhasePersonalityDone = INT_DONE_VALUE_06;
            mStringPhaseLifeDone = INT_DONE_VALUE_07;
            mStringPhaseSharingDone = INT_DONE_VALUE_08;
            mStringPhaseReflectionDone = INT_DONE_VALUE_09;
            mStringPhaseBiorhythmDone = INT_DONE_VALUE_10;
            mStringPhaseChallengeDone = INT_DONE_VALUE_11;
            mStringPhaseDiaryDone = INT_DONE_VALUE_12;
            mStringPhasePhotoDone = INT_DONE_VALUE_14;
            mStringPhaseSharingDone = INT_DONE_VALUE_15;
            mStringPhaseYouDone = INT_DONE_VALUE_19;

        }
    }
}
