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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.*;

public class SupportGeneratePhaseNameSubPhase {
    
    private static String mStringNameSubPhaseReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGeneratePhaseNameSubPhase(Context mContext, String mStringPhaseCodeReceived) {

        mStringNameSubPhaseReturned = mContext.getString(R.string.label_not_found);

        switch (mStringPhaseCodeReceived) {

            case MAIN_PHASE_CODE_01_OV:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_overview);
                break;

            case MAIN_PHASE_CODE_01_CRUD:
            case YOU_PHASE_CODE_19_CRUD:
            case MOOD_PHASE_CODE_02_CRUD:
            case AUTOBIOGRAPHY_PHASE_CODE_03_CRUD:
            case RECOGNITION_PHASE_CODE_04_CRUD:
            case BELIEF_PHASE_CODE_05_CRUD:
            case PERSONALITY_PHASE_CODE_06_CRUD:
            case LIFE_PHASE_CODE_07_CRUD:
            case ACTION_PHASE_CODE_08_CRUD:
            case REFLECTION_PHASE_CODE_09_CRUD:
            case BIORHYTHM_PHASE_CODE_10_CRUD:
            case CHALLENGE_PHASE_CODE_11_CRUD:
            case DIARY_PHASE_CODE_12_CRUD:
            case USER_PHASE_CODE_13_CRUD:
            case PHOTO_PHASE_CODE_14_CRUD:
            case SHARING_PHASE_CODE_15_CRUD:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_maintenance);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case MAIN_PHASE_CODE_01_AD:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_advice);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case MAIN_PHASE_CODE_01_GE:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_evolution);
                break;

            case MOOD_PHASE_CODE_02_GE:
            case AUTOBIOGRAPHY_PHASE_CODE_03_GE:
            case RECOGNITION_PHASE_CODE_04_GE:
            case BELIEF_PHASE_CODE_05_GE:
            case PERSONALITY_PHASE_CODE_06_GE:
            case LIFE_PHASE_CODE_07_GE:
            case ACTION_PHASE_CODE_08_GE:
            case REFLECTION_PHASE_CODE_09_GE:
            case BIORHYTHM_PHASE_CODE_10_GE:
            case CHALLENGE_PHASE_CODE_11_GE:
            case DIARY_PHASE_CODE_12_GE:
            case USER_PHASE_CODE_13_GE:
            case YOU_PHASE_CODE_19_GE:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_evolution);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case MAIN_PHASE_CODE_01_GA:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_analysis);
                break;

            case MOOD_PHASE_CODE_02_GA:
            case AUTOBIOGRAPHY_PHASE_CODE_03_GA:
            case RECOGNITION_PHASE_CODE_04_GA:
            case BELIEF_PHASE_CODE_05_GA:
            case PERSONALITY_PHASE_CODE_06_GA:
            case LIFE_PHASE_CODE_07_GA:
            case ACTION_PHASE_CODE_08_GA:
            case REFLECTION_PHASE_CODE_09_GA:
            case BIORHYTHM_PHASE_CODE_10_GA:
            case CHALLENGE_PHASE_CODE_11_GA:
            case DIARY_PHASE_CODE_12_GA:
            case USER_PHASE_CODE_13_GA:
            case PHOTO_PHASE_CODE_14_GA:
            case SHARING_PHASE_CODE_15_GA:
            case YOU_PHASE_CODE_19_GA:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_analysis);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case MOOD_PHASE_CODE_02_OV:
            case AUTOBIOGRAPHY_PHASE_CODE_03_OV:
            case RECOGNITION_PHASE_CODE_04_OV:
            case BELIEF_PHASE_CODE_05_OV:
            case PERSONALITY_PHASE_CODE_06_OV:
            case LIFE_PHASE_CODE_07_OV:
            case ACTION_PHASE_CODE_08_OV:
            case REFLECTION_PHASE_CODE_09_OV:
            case BIORHYTHM_PHASE_CODE_10_OV:
            case CHALLENGE_PHASE_CODE_11_OV:
            case DIARY_PHASE_CODE_12_OV:
            case USER_PHASE_CODE_13_OV:
            case PHOTO_PHASE_CODE_14_OV:
            case SHARING_PHASE_CODE_15_OV:
            case YOU_PHASE_CODE_19_OV:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_overview);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case ACTION_PHASE_CODE_08_GC:
            case CHALLENGE_PHASE_CODE_11_GC:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_costs);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case ACTION_PHASE_CODE_08_GP:
            case CHALLENGE_PHASE_CODE_11_GP:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_priority);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case ACTION_PHASE_CODE_08_GF:
            case CHALLENGE_PHASE_CODE_11_GF:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_frequency);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case MOOD_PHASE_CODE_02_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mood_very_sad);
                break;

            case MOOD_PHASE_CODE_02_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mood_sad);
                break;

            case MOOD_PHASE_CODE_02_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mood_indifferent);
                break;

            case MOOD_PHASE_CODE_02_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mood_happy);
                break;

            case MOOD_PHASE_CODE_02_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mood_very_happy);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case AUTOBIOGRAPHY_PHASE_CODE_03_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_family);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_relatives);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_friends);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_enemies);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_education);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_jobs);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_challenges);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_08:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_memories);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_wins);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_defeats);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_11:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_forgiveness);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_12:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_gratitude);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_13:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_secrets);
                break;

            case AUTOBIOGRAPHY_PHASE_CODE_03_14:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_safety);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case RECOGNITION_PHASE_CODE_04_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_weaknesses);
                break;

            case RECOGNITION_PHASE_CODE_04_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_strengths);
                break;

            case RECOGNITION_PHASE_CODE_04_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_skills);
                break;

            case RECOGNITION_PHASE_CODE_04_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_values);
                break;

            case RECOGNITION_PHASE_CODE_04_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_sabotage);
                break;

            case RECOGNITION_PHASE_CODE_04_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_limits);
                break;

            case RECOGNITION_PHASE_CODE_04_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_needs);
                break;

            case RECOGNITION_PHASE_CODE_04_08:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_emotions);
                break;

            case RECOGNITION_PHASE_CODE_04_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_fears);
                break;

            case RECOGNITION_PHASE_CODE_04_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_sins);
                break;

            case RECOGNITION_PHASE_CODE_04_11:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_virtues);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case BELIEF_PHASE_CODE_05_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_angel);
                break;

            case BELIEF_PHASE_CODE_05_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_aztec);
                break;

            case BELIEF_PHASE_CODE_05_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_brazilian);
                break;

            case BELIEF_PHASE_CODE_05_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_celtic);
                break;

            case BELIEF_PHASE_CODE_05_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_chinese);
                break;

            case BELIEF_PHASE_CODE_05_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_gypsy);
                break;

            case BELIEF_PHASE_CODE_05_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_egyptian);
                break;

            case BELIEF_PHASE_CODE_05_08:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_indian);
                break;

            case BELIEF_PHASE_CODE_05_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mayan);
                break;

            case BELIEF_PHASE_CODE_05_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_occidental);
                break;

            case BELIEF_PHASE_CODE_05_11:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_shamanic);
                break;

            case BELIEF_PHASE_CODE_05_12:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_numerology);
                break;

            case BELIEF_PHASE_CODE_05_13:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_birthdate);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case PERSONALITY_PHASE_CODE_06_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_personality_questions);
                break;

            case PERSONALITY_PHASE_CODE_06_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_personality_result);
                break;

            case PERSONALITY_PHASE_CODE_06_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_hippocrates_questions);
                break;

            case PERSONALITY_PHASE_CODE_06_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_hippocrates_result);
                break;

            case PERSONALITY_PHASE_CODE_06_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_enneagram_questions);
                break;

            case PERSONALITY_PHASE_CODE_06_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_enneagram_result);
                break;

            case PERSONALITY_PHASE_CODE_06_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_behavioral_questions);
                break;

            case PERSONALITY_PHASE_CODE_06_08:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_behavioral_result);
                break;

            case PERSONALITY_PHASE_CODE_06_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_neurolinguistics_questions);
                break;

            case PERSONALITY_PHASE_CODE_06_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_neurolinguistics_result);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case LIFE_PHASE_CODE_07_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mental);
                break;

            case LIFE_PHASE_CODE_07_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_physical);
                break;

            case LIFE_PHASE_CODE_07_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_personal);
                break;

            case LIFE_PHASE_CODE_07_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_social);
                break;

            case LIFE_PHASE_CODE_07_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_familiar);
                break;

            case LIFE_PHASE_CODE_07_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_community);
                break;

            case LIFE_PHASE_CODE_07_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_love);
                break;

            case LIFE_PHASE_CODE_07_08:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_sexual);
                break;

            case LIFE_PHASE_CODE_07_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_religion);
                break;

            case LIFE_PHASE_CODE_07_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_emotional);
                break;

            case LIFE_PHASE_CODE_07_11:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_cultural);
                break;

            case LIFE_PHASE_CODE_07_12:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_intellectual);
                break;

            case LIFE_PHASE_CODE_07_13:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_professional);
                break;

            case LIFE_PHASE_CODE_07_14:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_financial);
                break;

            case LIFE_PHASE_CODE_07_15:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_recreation);
                break;

            case LIFE_PHASE_CODE_07_16:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_environment);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case ACTION_PHASE_CODE_08_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mood);
                break;

            case ACTION_PHASE_CODE_08_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_autobiography);
                break;

            case ACTION_PHASE_CODE_08_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_recognition);
                break;

            case ACTION_PHASE_CODE_08_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_belief);
                break;

            case ACTION_PHASE_CODE_08_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_personality);
                break;

            case ACTION_PHASE_CODE_08_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_life);
                break;

            case ACTION_PHASE_CODE_08_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_reflection);
                break;

            case ACTION_PHASE_CODE_08_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_biorhythm);
                break;

            case ACTION_PHASE_CODE_08_11:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_challenge);
                break;

            case ACTION_PHASE_CODE_08_12:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_diary);
                break;

            case ACTION_PHASE_CODE_08_19:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_you);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case REFLECTION_PHASE_CODE_09_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_reflection_01);
                break;

            case REFLECTION_PHASE_CODE_09_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_reflection_02);
                break;

            case REFLECTION_PHASE_CODE_09_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_reflection_03);
                break;

            case REFLECTION_PHASE_CODE_09_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_reflection_04);
                break;

            case REFLECTION_PHASE_CODE_09_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_reflection_05);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case BIORHYTHM_PHASE_CODE_10_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_intellectual_negative);
                break;

            case BIORHYTHM_PHASE_CODE_10_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_intellectual_critical);
                break;

            case BIORHYTHM_PHASE_CODE_10_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_intellectual_positive);
                break;

            case BIORHYTHM_PHASE_CODE_10_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_emotional_negative);
                break;

            case BIORHYTHM_PHASE_CODE_10_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_emotional_critical);
                break;

            case BIORHYTHM_PHASE_CODE_10_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_emotional_positive);
                break;

            case BIORHYTHM_PHASE_CODE_10_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_physical_negative);
                break;

            case BIORHYTHM_PHASE_CODE_10_08:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_physical_negative);
                break;

            case BIORHYTHM_PHASE_CODE_10_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_physical_positive);
                break;

            // *************************************************************************************
            // *************************************************************************************
            // CHALLENGE 11

            // *************************************************************************************
            // *************************************************************************************
            // USER 13

            // *************************************************************************************
            // *************************************************************************************
            case PHOTO_PHASE_CODE_14_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mood);
                break;

            case PHOTO_PHASE_CODE_14_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_autobiography);
                break;

            case PHOTO_PHASE_CODE_14_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_recognition);
                break;

            case PHOTO_PHASE_CODE_14_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_belief);
                break;

            case PHOTO_PHASE_CODE_14_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_personality);
                break;

            case PHOTO_PHASE_CODE_14_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_life);
                break;

            case PHOTO_PHASE_CODE_14_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_reflection);
                break;

            case PHOTO_PHASE_CODE_14_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_biorhythm);
                break;

            case PHOTO_PHASE_CODE_14_11:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_challenge);
                break;

            case PHOTO_PHASE_CODE_14_12:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_diary);
                break;

            case PHOTO_PHASE_CODE_14_19:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_you);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case SHARING_PHASE_CODE_15_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mood);
                break;

            case SHARING_PHASE_CODE_15_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_autobiography);
                break;

            case SHARING_PHASE_CODE_15_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_recognition);
                break;

            case SHARING_PHASE_CODE_15_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_belief);
                break;

            case SHARING_PHASE_CODE_15_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_personality);
                break;

            case SHARING_PHASE_CODE_15_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_life);
                break;

            case SHARING_PHASE_CODE_15_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_reflection);
                break;

            case SHARING_PHASE_CODE_15_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_biorhythm);
                break;

            case SHARING_PHASE_CODE_15_11:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_challenge);
                break;

            case SHARING_PHASE_CODE_15_12:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_diary);
                break;

            case SHARING_PHASE_CODE_15_19:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_you);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case YOU_PHASE_CODE_19_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_meaning);
                break;

            case YOU_PHASE_CODE_19_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_origin_surname);
                break;

            case YOU_PHASE_CODE_19_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_coat_arms);
                break;

            case YOU_PHASE_CODE_19_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_live_days);
                break;

            case YOU_PHASE_CODE_19_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_live_stage);
                break;

            case YOU_PHASE_CODE_19_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_heart_beats);
                break;

            case YOU_PHASE_CODE_19_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_respiratory_frequency);
                break;

            case YOU_PHASE_CODE_19_08:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_birthplace);
                break;

            case YOU_PHASE_CODE_19_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_gender);
                break;

            case YOU_PHASE_CODE_19_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_sexual_option);
                break;

            case YOU_PHASE_CODE_19_11:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_race);
                break;

            case YOU_PHASE_CODE_19_12:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_marital_status);
                break;

            case YOU_PHASE_CODE_19_13:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_religion);
                break;

            case YOU_PHASE_CODE_19_14:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_scholarity);
                break;

            case YOU_PHASE_CODE_19_15:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_body_mass_index);
                break;

            case YOU_PHASE_CODE_19_16:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_life_expectancy);
                break;
                
            // *************************************************************************************
            // *************************************************************************************
            case MAIN_PHASE_CODE_01_01:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_mission);
                break;

            case MAIN_PHASE_CODE_01_02:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_company);
                break;

            case MAIN_PHASE_CODE_01_03:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_terms);
                break;

            case MAIN_PHASE_CODE_01_04:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_policy);
                break;

            case MAIN_PHASE_CODE_01_05:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_help);
                break;

            case MAIN_PHASE_CODE_01_06:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_sync);
                break;

            case MAIN_PHASE_CODE_01_07:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_reset);
                break;

            case MAIN_PHASE_CODE_01_08:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_contact);
                break;

            case MAIN_PHASE_CODE_01_09:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_credits);
                break;

            case MAIN_PHASE_CODE_01_10:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_donations);
                break;

            case MAIN_PHASE_CODE_01_11:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_evaluation);
                break;

            case MAIN_PHASE_CODE_01_12:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_application);
                break;

            case MAIN_PHASE_CODE_01_13:
                mStringNameSubPhaseReturned = mContext.getString(R.string.label_notifications);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mStringPhaseCodeReceived);
        }

        // *************************************************************************************
        // *************************************************************************************

        return mStringNameSubPhaseReturned;

    }
}
