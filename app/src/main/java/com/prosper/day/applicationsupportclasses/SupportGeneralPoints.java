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

import java.util.Random;

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

public class SupportGeneralPoints {

    private static int mIntNumber;
    private static int mIntPoints;

    private static String mStringReturnedCurrentAnswerNumberPoints;
    private static String mStringReturnedCurrentAnswerNumberPhotos;
    private static String mStringReturnedCurrentAnswerNumberActions;
    private static String mStringReturnedCurrentAnswerNumberSharing;

    // *********************************************************************************************
    // *********************************************************************************************
    public static String generalNumberPointsActions(String mStringReceivedCurrentAnswerNumberActions) {

        mIntNumber = Integer.parseInt(mStringReceivedCurrentAnswerNumberActions);
        mIntNumber++;

        mStringReturnedCurrentAnswerNumberActions = String.valueOf(mIntNumber);

        return mStringReturnedCurrentAnswerNumberActions;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static String generalNumberPointsPhotosDecrease(String mStringReceivedCurrentAnswerNumberPhotos) {

        mIntNumber = Integer.parseInt(mStringReceivedCurrentAnswerNumberPhotos);
        mIntNumber--;

        mStringReturnedCurrentAnswerNumberPhotos = String.valueOf(mIntNumber);

        return mStringReturnedCurrentAnswerNumberPhotos;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static String generalNumberPointsPhotosIncrease(String mStringReceivedCurrentAnswerNumberPhotos) {

        mIntNumber = Integer.parseInt(mStringReceivedCurrentAnswerNumberPhotos);
        mIntNumber++;

        mStringReturnedCurrentAnswerNumberPhotos = String.valueOf(mIntNumber);

        return mStringReturnedCurrentAnswerNumberPhotos;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static String generalNumberPointsSharing(String mStringReceivedCurrentAnswerNumberSharing) {

        mIntNumber = Integer.parseInt(mStringReceivedCurrentAnswerNumberSharing);
        mIntNumber++;

        mStringReturnedCurrentAnswerNumberSharing = String.valueOf(mIntNumber);

        return mStringReturnedCurrentAnswerNumberSharing;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static String generalNumberPoints(Context mContext, String mStringReceivedCurrentAnswerNumberPoints) {

        mIntNumber = Integer.parseInt(mStringReceivedCurrentAnswerNumberPoints);
        String stringPhaseCode = stringCurrentPhaseCode.substring(0, 2);

        Random random = new Random();

        switch (stringPhaseCode) {

            case STRING_NUMBER_02:
                mIntPoints = random.nextInt(NUMBER_MOOD_NUMBER_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_03:
                mIntPoints = random.nextInt(NUMBER_AUTOBIOGRAPHY_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_04:
                mIntPoints = random.nextInt(NUMBER_RECOGNITION_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_05:
                mIntPoints = random.nextInt(NUMBER_BELIEFS_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_06:
                mIntPoints = random.nextInt(NUMBER_PERSONALITY_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_07:
                mIntPoints = random.nextInt(NUMBER_LIFE_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_08:
                mIntPoints = random.nextInt(NUMBER_ACTION_NUMBER_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_09:
                mIntPoints = random.nextInt(NUMBER_REFLECTION_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_11:
                mIntPoints = random.nextInt(NUMBER_CHALLENGE_POINTS - 1) + 1;
                break;

            case STRING_NUMBER_12:
                mIntPoints = random.nextInt(NUMBER_DIARY_NUMBER_POINTS - 1) + 1;
                break;

            default:
                mIntPoints++;
                break;

            // TODO REDEFINE HOW TO GET POINTS
            /*
            default:
                String className = mContext.getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + stringPhaseCode);
             */

        }

        mIntNumber = mIntNumber + mIntPoints;
        mStringReturnedCurrentAnswerNumberPoints = String.valueOf(mIntNumber);

        return mStringReturnedCurrentAnswerNumberPoints;

    }
}
