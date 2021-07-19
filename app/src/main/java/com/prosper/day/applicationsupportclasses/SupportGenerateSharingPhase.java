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

public class SupportGenerateSharingPhase {
    
    private static String mStringSharingPhaseReturned;

    @SuppressLint("DefaultLocale")
    public static String generateSharingPhase(String mStringSharingPhaseReceived) {

        switch (mStringSharingPhaseReceived) {

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
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_19;
                break;

            case MOOD_PHASE_CODE_02_01:
            case MOOD_PHASE_CODE_02_02:
            case MOOD_PHASE_CODE_02_03:
            case MOOD_PHASE_CODE_02_04:
            case MOOD_PHASE_CODE_02_05:
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_02;
                break;

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
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_03;
                break;

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
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_04;
                break;

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
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_05;
                break;

            case PERSONALITY_PHASE_CODE_06_01:
            case PERSONALITY_PHASE_CODE_06_02:
            case PERSONALITY_PHASE_CODE_06_03:
            case PERSONALITY_PHASE_CODE_06_04:
            case PERSONALITY_PHASE_CODE_06_05:
            case PERSONALITY_PHASE_CODE_06_06:
            case PERSONALITY_PHASE_CODE_06_07:
            case PERSONALITY_PHASE_CODE_06_08:
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_06;
                break;

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
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_07;
                break;

            case REFLECTION_PHASE_CODE_09_01:
            case REFLECTION_PHASE_CODE_09_02:
            case REFLECTION_PHASE_CODE_09_03:
            case REFLECTION_PHASE_CODE_09_04:
            case REFLECTION_PHASE_CODE_09_05:
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_09;
                break;

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
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_10;
                break;

            case CHALLENGE_PHASE_CODE_11_OV:
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_11;
                break;

            case DIARY_PHASE_CODE_12_OV:
                mStringSharingPhaseReturned = SHARING_PHASE_CODE_15_12;
                break;

            default:
                mStringSharingPhaseReturned = null;
                break;

        }

        return mStringSharingPhaseReturned;

    }
}
