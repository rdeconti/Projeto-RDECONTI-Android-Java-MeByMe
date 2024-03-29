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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.*;

public class SupportGeneratePhaseCodeAction {
    
    private static String mStringPhaseReturned;

    @SuppressLint("DefaultLocale")
    public static String supportGeneratePhaseCodeAction(String mStringPhaseReceived) {

        switch (mStringPhaseReceived) {

            case MOOD_PHASE_CODE_02_CRUD:
            case MOOD_PHASE_CODE_02_GA:
            case MOOD_PHASE_CODE_02_GE:
            case MOOD_PHASE_CODE_02_OV:
            case MOOD_PHASE_CODE_02_01:
            case MOOD_PHASE_CODE_02_02:
            case MOOD_PHASE_CODE_02_03:
            case MOOD_PHASE_CODE_02_04:
            case MOOD_PHASE_CODE_02_05:
                mStringPhaseReturned = ACTION_PHASE_CODE_08_02;
                break;

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
                mStringPhaseReturned = ACTION_PHASE_CODE_08_03;
                break;

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
                mStringPhaseReturned = ACTION_PHASE_CODE_08_04;
                break;

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
                mStringPhaseReturned = ACTION_PHASE_CODE_08_05;
                break;

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
                mStringPhaseReturned = ACTION_PHASE_CODE_08_06;
                break;

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
                mStringPhaseReturned = ACTION_PHASE_CODE_08_07;
                break;

            case REFLECTION_PHASE_CODE_09_CRUD:
            case REFLECTION_PHASE_CODE_09_GA:
            case REFLECTION_PHASE_CODE_09_GE:
            case REFLECTION_PHASE_CODE_09_OV:
            case REFLECTION_PHASE_CODE_09_01:
            case REFLECTION_PHASE_CODE_09_02:
            case REFLECTION_PHASE_CODE_09_03:
            case REFLECTION_PHASE_CODE_09_04:
            case REFLECTION_PHASE_CODE_09_05:
                mStringPhaseReturned = ACTION_PHASE_CODE_08_09;
                break;

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
                mStringPhaseReturned = ACTION_PHASE_CODE_08_10;
                break;

            case CHALLENGE_PHASE_CODE_11_CRUD:
            case CHALLENGE_PHASE_CODE_11_GA:
            case CHALLENGE_PHASE_CODE_11_GE:
            case CHALLENGE_PHASE_CODE_11_GF:
            case CHALLENGE_PHASE_CODE_11_GC:
            case CHALLENGE_PHASE_CODE_11_GP:
            case CHALLENGE_PHASE_CODE_11_OV:
                mStringPhaseReturned = ACTION_PHASE_CODE_08_11;
                break;

            case DIARY_PHASE_CODE_12_CRUD:
            case DIARY_PHASE_CODE_12_GE:
            case DIARY_PHASE_CODE_12_GA:
            case DIARY_PHASE_CODE_12_OV:
                mStringPhaseReturned = ACTION_PHASE_CODE_08_12;
                break;

            case YOU_PHASE_CODE_19_CRUD:
            case YOU_PHASE_CODE_19_GA:
            case YOU_PHASE_CODE_19_GE:
            case YOU_PHASE_CODE_19_OV:
            case YOU_PHASE_CODE_19_01:
            case YOU_PHASE_CODE_19_02:
            case YOU_PHASE_CODE_19_03:
            case YOU_PHASE_CODE_19_04:
            case YOU_PHASE_CODE_19_05:
            case YOU_PHASE_CODE_19_08:
            case YOU_PHASE_CODE_19_09:
            case YOU_PHASE_CODE_19_10:
            case YOU_PHASE_CODE_19_11:
            case YOU_PHASE_CODE_19_12:
            case YOU_PHASE_CODE_19_13:
            case YOU_PHASE_CODE_19_14:
            case YOU_PHASE_CODE_19_15:
            case YOU_PHASE_CODE_19_16:
                mStringPhaseReturned = ACTION_PHASE_CODE_08_19;
                break;

        }

        return mStringPhaseReturned;

    }
}
