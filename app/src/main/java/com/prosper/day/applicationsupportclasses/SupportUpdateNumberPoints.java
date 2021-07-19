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

import android.content.Context;

import com.prosper.day.R;

import java.util.Random;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentAnswerNumberPoints;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_ACTION_NUMBER_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_AUTOBIOGRAPHY_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_BELIEFS_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_CHALLENGE_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_DIARY_NUMBER_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_LIFE_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_MOOD_NUMBER_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_PERSONALITY_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_RECOGNITION_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_REFLECTION_POINTS;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_12;

public class SupportUpdateNumberPoints {

    private static Integer intNumberPoints;

    public static void supportUpdateNumberPoints(Context mContext) {

        // TODO DELETE mStringCurrentAnswerNumberPoints and receive like parammeter

        stringCurrentAnswerNumberPoints = "0";

        intNumberPoints = Integer.valueOf(stringCurrentAnswerNumberPoints);
        String stringPhaseCode = stringCurrentPhaseCode.substring(0, 2);

        Random random = new Random();
        int intPoints;

        switch (stringPhaseCode) {

            case STRING_NUMBER_02:
                intPoints = random.nextInt(NUMBER_MOOD_NUMBER_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_03:
                intPoints = random.nextInt(NUMBER_AUTOBIOGRAPHY_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_04:
                intPoints = random.nextInt(NUMBER_RECOGNITION_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_05:
                intPoints = random.nextInt(NUMBER_BELIEFS_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_06:
                intPoints = random.nextInt(NUMBER_PERSONALITY_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_07:
                intPoints = random.nextInt(NUMBER_LIFE_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_08:
                intPoints = random.nextInt(NUMBER_ACTION_NUMBER_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_09:
                intPoints = random.nextInt(NUMBER_REFLECTION_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_11:
                intPoints = random.nextInt(NUMBER_CHALLENGE_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_12:
                intPoints = random.nextInt(NUMBER_DIARY_NUMBER_POINTS - 1) + 1;
                break;

            default:
                String className = mContext.getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + stringPhaseCode);

        }

        intNumberPoints = intNumberPoints + intPoints;
        stringCurrentAnswerNumberPoints = String.valueOf(intNumberPoints);

    }
}
