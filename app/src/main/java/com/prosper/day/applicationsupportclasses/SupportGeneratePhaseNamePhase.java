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

public class SupportGeneratePhaseNamePhase {
    
    private static String mStringNamePhaseReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGeneratePhaseNamePhase(Context mContext, String mStringPhaseCodeReceived) {

        mStringNamePhaseReturned = mContext.getString(R.string.label_not_found);

        switch (mStringPhaseCodeReceived) {

            case MAIN_PHASE_CODE_01_OV:
            case MAIN_PHASE_CODE_01_GE:
            case MAIN_PHASE_CODE_01_GA:
            case MAIN_PHASE_CODE_01_AD:
            case MAIN_PHASE_CODE_01_01:
            case MAIN_PHASE_CODE_01_02:
            case MAIN_PHASE_CODE_01_03:
            case MAIN_PHASE_CODE_01_04:
            case MAIN_PHASE_CODE_01_05:
            case MAIN_PHASE_CODE_01_06:
            case MAIN_PHASE_CODE_01_07:
            case MAIN_PHASE_CODE_01_08:
            case MAIN_PHASE_CODE_01_09:
            case MAIN_PHASE_CODE_01_10:
            case MAIN_PHASE_CODE_01_11:
            case MAIN_PHASE_CODE_01_12:
            case MAIN_PHASE_CODE_01_13:
                mStringNamePhaseReturned = mContext.getString(R.string.label_main);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case MOOD_PHASE_CODE_02_CRUD:
            case MOOD_PHASE_CODE_02_GA:
            case MOOD_PHASE_CODE_02_GE:
            case MOOD_PHASE_CODE_02_OV:
            case MOOD_PHASE_CODE_02_01:
            case MOOD_PHASE_CODE_02_02:
            case MOOD_PHASE_CODE_02_03:
            case MOOD_PHASE_CODE_02_04:
            case MOOD_PHASE_CODE_02_05:
                mStringNamePhaseReturned = mContext.getString(R.string.label_mood);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case AUTOBIOGRAPHY_PHASE_CODE_03_CRUD:
            case AUTOBIOGRAPHY_PHASE_CODE_03_GA:
            case AUTOBIOGRAPHY_PHASE_CODE_03_GE:
            case AUTOBIOGRAPHY_PHASE_CODE_03_OV:
            case AUTOBIOGRAPHY_PHASE_CODE_03_01:
            case AUTOBIOGRAPHY_PHASE_CODE_03_02:
            case AUTOBIOGRAPHY_PHASE_CODE_03_03:
            case AUTOBIOGRAPHY_PHASE_CODE_03_04:
            case AUTOBIOGRAPHY_PHASE_CODE_03_05:
            case AUTOBIOGRAPHY_PHASE_CODE_03_06:
            case AUTOBIOGRAPHY_PHASE_CODE_03_07:
            case AUTOBIOGRAPHY_PHASE_CODE_03_08:
            case AUTOBIOGRAPHY_PHASE_CODE_03_09:
            case AUTOBIOGRAPHY_PHASE_CODE_03_10:
            case AUTOBIOGRAPHY_PHASE_CODE_03_11:
            case AUTOBIOGRAPHY_PHASE_CODE_03_12:
            case AUTOBIOGRAPHY_PHASE_CODE_03_13:
            case AUTOBIOGRAPHY_PHASE_CODE_03_14:
                mStringNamePhaseReturned = mContext.getString(R.string.label_autobiography);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case RECOGNITION_PHASE_CODE_04_CRUD:
            case RECOGNITION_PHASE_CODE_04_GA:
            case RECOGNITION_PHASE_CODE_04_GE:
            case RECOGNITION_PHASE_CODE_04_OV:
            case RECOGNITION_PHASE_CODE_04_01:
            case RECOGNITION_PHASE_CODE_04_02:
            case RECOGNITION_PHASE_CODE_04_03:
            case RECOGNITION_PHASE_CODE_04_04:
            case RECOGNITION_PHASE_CODE_04_05:
            case RECOGNITION_PHASE_CODE_04_06:
            case RECOGNITION_PHASE_CODE_04_07:
            case RECOGNITION_PHASE_CODE_04_08:
            case RECOGNITION_PHASE_CODE_04_09:
            case RECOGNITION_PHASE_CODE_04_10:
            case RECOGNITION_PHASE_CODE_04_11:
                mStringNamePhaseReturned = mContext.getString(R.string.label_recognition);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case BELIEF_PHASE_CODE_05_CRUD:
            case BELIEF_PHASE_CODE_05_GA:
            case BELIEF_PHASE_CODE_05_GE:
            case BELIEF_PHASE_CODE_05_OV:
            case BELIEF_PHASE_CODE_05_01:
            case BELIEF_PHASE_CODE_05_02:
            case BELIEF_PHASE_CODE_05_03:
            case BELIEF_PHASE_CODE_05_04:
            case BELIEF_PHASE_CODE_05_05:
            case BELIEF_PHASE_CODE_05_06:
            case BELIEF_PHASE_CODE_05_07:
            case BELIEF_PHASE_CODE_05_08:
            case BELIEF_PHASE_CODE_05_09:
            case BELIEF_PHASE_CODE_05_10:
            case BELIEF_PHASE_CODE_05_11:
            case BELIEF_PHASE_CODE_05_12:
            case BELIEF_PHASE_CODE_05_13:
                mStringNamePhaseReturned = mContext.getString(R.string.label_belief);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case PERSONALITY_PHASE_CODE_06_CRUD:
            case PERSONALITY_PHASE_CODE_06_GA:
            case PERSONALITY_PHASE_CODE_06_GE:
            case PERSONALITY_PHASE_CODE_06_OV:
            case PERSONALITY_PHASE_CODE_06_01:
            case PERSONALITY_PHASE_CODE_06_02:
            case PERSONALITY_PHASE_CODE_06_03:
            case PERSONALITY_PHASE_CODE_06_04:
            case PERSONALITY_PHASE_CODE_06_05:
            case PERSONALITY_PHASE_CODE_06_06:
            case PERSONALITY_PHASE_CODE_06_07:
            case PERSONALITY_PHASE_CODE_06_08:
            case PERSONALITY_PHASE_CODE_06_09:
            case PERSONALITY_PHASE_CODE_06_10:
                mStringNamePhaseReturned = mContext.getString(R.string.label_personality);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case LIFE_PHASE_CODE_07_CRUD:
            case LIFE_PHASE_CODE_07_GA:
            case LIFE_PHASE_CODE_07_GE:
            case LIFE_PHASE_CODE_07_OV:
            case LIFE_PHASE_CODE_07_01:
            case LIFE_PHASE_CODE_07_02:
            case LIFE_PHASE_CODE_07_03:
            case LIFE_PHASE_CODE_07_04:
            case LIFE_PHASE_CODE_07_05:
            case LIFE_PHASE_CODE_07_06:
            case LIFE_PHASE_CODE_07_07:
            case LIFE_PHASE_CODE_07_08:
            case LIFE_PHASE_CODE_07_09:
            case LIFE_PHASE_CODE_07_10:
            case LIFE_PHASE_CODE_07_11:
            case LIFE_PHASE_CODE_07_12:
            case LIFE_PHASE_CODE_07_13:
            case LIFE_PHASE_CODE_07_14:
            case LIFE_PHASE_CODE_07_15:
            case LIFE_PHASE_CODE_07_16:
                mStringNamePhaseReturned = mContext.getString(R.string.label_life);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case ACTION_PHASE_CODE_08_CRUD:
            case ACTION_PHASE_CODE_08_GA:
            case ACTION_PHASE_CODE_08_GE:
            case ACTION_PHASE_CODE_08_GF:
            case ACTION_PHASE_CODE_08_GC:
            case ACTION_PHASE_CODE_08_GP:
            case ACTION_PHASE_CODE_08_OV:
            case ACTION_PHASE_CODE_08_02:
            case ACTION_PHASE_CODE_08_03:
            case ACTION_PHASE_CODE_08_04:
            case ACTION_PHASE_CODE_08_05:
            case ACTION_PHASE_CODE_08_06:
            case ACTION_PHASE_CODE_08_07:
            case ACTION_PHASE_CODE_08_09:
            case ACTION_PHASE_CODE_08_10:
            case ACTION_PHASE_CODE_08_11:
            case ACTION_PHASE_CODE_08_12:
            case ACTION_PHASE_CODE_08_19:
                mStringNamePhaseReturned = mContext.getString(R.string.label_action);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case REFLECTION_PHASE_CODE_09_CRUD:
            case REFLECTION_PHASE_CODE_09_GA:
            case REFLECTION_PHASE_CODE_09_GE:
            case REFLECTION_PHASE_CODE_09_OV:
            case REFLECTION_PHASE_CODE_09_01:
            case REFLECTION_PHASE_CODE_09_02:
            case REFLECTION_PHASE_CODE_09_03:
            case REFLECTION_PHASE_CODE_09_04:
            case REFLECTION_PHASE_CODE_09_05:
                mStringNamePhaseReturned = mContext.getString(R.string.label_reflection);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case BIORHYTHM_PHASE_CODE_10_CRUD:
            case BIORHYTHM_PHASE_CODE_10_GE:
            case BIORHYTHM_PHASE_CODE_10_GA:
            case BIORHYTHM_PHASE_CODE_10_OV:
            case BIORHYTHM_PHASE_CODE_10_01:
            case BIORHYTHM_PHASE_CODE_10_02:
            case BIORHYTHM_PHASE_CODE_10_03:
            case BIORHYTHM_PHASE_CODE_10_04:
            case BIORHYTHM_PHASE_CODE_10_05:
            case BIORHYTHM_PHASE_CODE_10_06:
            case BIORHYTHM_PHASE_CODE_10_07:
            case BIORHYTHM_PHASE_CODE_10_08:
            case BIORHYTHM_PHASE_CODE_10_09:
                mStringNamePhaseReturned = mContext.getString(R.string.label_biorhythm);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case CHALLENGE_PHASE_CODE_11_CRUD:
            case CHALLENGE_PHASE_CODE_11_GA:
            case CHALLENGE_PHASE_CODE_11_GE:
            case CHALLENGE_PHASE_CODE_11_GF:
            case CHALLENGE_PHASE_CODE_11_GC:
            case CHALLENGE_PHASE_CODE_11_GP:
            case CHALLENGE_PHASE_CODE_11_OV:
                mStringNamePhaseReturned = mContext.getString(R.string.label_challenge);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case DIARY_PHASE_CODE_12_CRUD:
            case DIARY_PHASE_CODE_12_GE:
            case DIARY_PHASE_CODE_12_GA:
            case DIARY_PHASE_CODE_12_OV:
                mStringNamePhaseReturned = mContext.getString(R.string.label_diary);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case USER_PHASE_CODE_13_CRUD:
            case USER_PHASE_CODE_13_GE:
            case USER_PHASE_CODE_13_GA:
            case USER_PHASE_CODE_13_OV:
                mStringNamePhaseReturned = mContext.getString(R.string.label_user);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case PHOTO_PHASE_CODE_14_CRUD:
            case PHOTO_PHASE_CODE_14_GA:
            case PHOTO_PHASE_CODE_14_OV:
            case PHOTO_PHASE_CODE_14_02:
            case PHOTO_PHASE_CODE_14_03:
            case PHOTO_PHASE_CODE_14_04:
            case PHOTO_PHASE_CODE_14_05:
            case PHOTO_PHASE_CODE_14_06:
            case PHOTO_PHASE_CODE_14_07:
            case PHOTO_PHASE_CODE_14_09:
            case PHOTO_PHASE_CODE_14_10:
            case PHOTO_PHASE_CODE_14_11:
            case PHOTO_PHASE_CODE_14_12:
            case PHOTO_PHASE_CODE_14_19:
                mStringNamePhaseReturned = mContext.getString(R.string.label_photos);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case SHARING_PHASE_CODE_15_CRUD:
            case SHARING_PHASE_CODE_15_GA:
            case SHARING_PHASE_CODE_15_OV:
            case SHARING_PHASE_CODE_15_02:
            case SHARING_PHASE_CODE_15_03:
            case SHARING_PHASE_CODE_15_04:
            case SHARING_PHASE_CODE_15_05:
            case SHARING_PHASE_CODE_15_06:
            case SHARING_PHASE_CODE_15_07:
            case SHARING_PHASE_CODE_15_09:
            case SHARING_PHASE_CODE_15_10:
            case SHARING_PHASE_CODE_15_11:
            case SHARING_PHASE_CODE_15_12:
            case SHARING_PHASE_CODE_15_19:
                mStringNamePhaseReturned = mContext.getString(R.string.label_sharing);
                break;

            // *************************************************************************************
            // *************************************************************************************
            case YOU_PHASE_CODE_19_CRUD:
            case YOU_PHASE_CODE_19_GA:
            case YOU_PHASE_CODE_19_GE:
            case YOU_PHASE_CODE_19_OV:
            case YOU_PHASE_CODE_19_01:
            case YOU_PHASE_CODE_19_02:
            case YOU_PHASE_CODE_19_03:
            case YOU_PHASE_CODE_19_04:
            case YOU_PHASE_CODE_19_05:
            case YOU_PHASE_CODE_19_06:
            case YOU_PHASE_CODE_19_07:
            case YOU_PHASE_CODE_19_08:
            case YOU_PHASE_CODE_19_09:
            case YOU_PHASE_CODE_19_10:
            case YOU_PHASE_CODE_19_11:
            case YOU_PHASE_CODE_19_12:
            case YOU_PHASE_CODE_19_13:
            case YOU_PHASE_CODE_19_14:
            case YOU_PHASE_CODE_19_15:
            case YOU_PHASE_CODE_19_16:
                mStringNamePhaseReturned = mContext.getString(R.string.label_you);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mStringPhaseCodeReceived);
        }

        // *************************************************************************************
        // *************************************************************************************

        return mStringNamePhaseReturned;

    }
}
