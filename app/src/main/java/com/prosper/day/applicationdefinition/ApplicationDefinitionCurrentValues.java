package com.prosper.day.applicationdefinition;

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

import java.util.ArrayList;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGraphs.REPORT_INITIAL;

public class ApplicationDefinitionCurrentValues {

    // TODO REVIEW NOMENCLATURE - https://stackoverflow.com/questions/12870537/android-naming-convention

    public static ArrayList<String> globalStringArrayList;

    public static String stringCurrentScreenGraphStatus = REPORT_INITIAL;

    public static String stringCurrentAnswerId;
    public static String stringCurrentPhaseCode;
    public static String stringCurrentPhaseNumber;
    public static String stringCurrentAnswerNumberPoints;
    public static String stringCurrentAnswerNumberPhotos;
    public static String stringCurrentAnswerNumberActions;
    public static String stringCurrentAnswerNumberSharing;
    public static String stringCurrentShowCaseId;

}
