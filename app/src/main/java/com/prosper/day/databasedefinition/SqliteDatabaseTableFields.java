package com.prosper.day.databasedefinition;

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

import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_ATTRIBUTE_AUTOINCREMENT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_ATTRIBUTE_BLOB;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_ATTRIBUTE_INTEGER;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_ATTRIBUTE_NOTNULL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_ATTRIBUTE_PRIMARY_KEY;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_ATTRIBUTE_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_CREATE_TABLE;

public class SqliteDatabaseTableFields {

    // *********************************************************************************************
    // ** TABLE ACTION ANSWER
    // *********************************************************************************************
    public static final String FIELD_ACTION_ANSWER_ID = "recordId";
    public static final String FIELD_ACTION_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_ACTION_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_ACTION_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_ACTION_ANSWER_TEXT = "recordAnswer";
    public static final String FIELD_ACTION_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_ACTION_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_ACTION_ANSWER_PRIORITY = "recordPriority";
    public static final String FIELD_ACTION_ANSWER_FREQUENCY = "recordFrequency";
    public static final String FIELD_ACTION_ANSWER_COSTS = "recordCosts";
    public static final String FIELD_ACTION_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_ACTION_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_ACTION_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_ACTION_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_ACTION_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_ACTION_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_ACTION_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_ACTION_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_ACTION_ANSWER + " ("
            + FIELD_ACTION_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_ACTION_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_PRIORITY + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_FREQUENCY + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_COSTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_ACTION_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE AUTOBIOGRAPHY ANSWER
    // *********************************************************************************************
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_ID = "recordId";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_QUESTION = "recordQuestion";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_TEXT = "recordAnswer";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_AUTOBIOGRAPHY_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_AUTOBIOGRAPHY_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_AUTOBIOGRAPHY_ANSWER + " ("
            + FIELD_AUTOBIOGRAPHY_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_QUESTION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE AUTOBIOGRAPHY QUESTION
    // *********************************************************************************************
    public static final String FIELD_AUTOBIOGRAPHY_QUESTION_ID = "recordId";
    public static final String FIELD_AUTOBIOGRAPHY_QUESTION_LANGUAGE = "recordLanguage";
    public static final String FIELD_AUTOBIOGRAPHY_QUESTION_PHASE = "recordPhase";
    public static final String FIELD_AUTOBIOGRAPHY_QUESTION_NUMBER = "recordNumber";
    public static final String FIELD_AUTOBIOGRAPHY_QUESTION_TEXT = "recordText";
    public static final String FIELD_AUTOBIOGRAPHY_QUESTION_CREATION = "recordDateCreation";
    public static final String FIELD_AUTOBIOGRAPHY_QUESTION_UPDATE = "recordDateUpdate";
    public static final String FIELD_AUTOBIOGRAPHY_QUESTION_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_AUTOBIOGRAPHY_QUESTION = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_AUTOBIOGRAPHY_QUESTION + " ("
            + FIELD_AUTOBIOGRAPHY_QUESTION_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_AUTOBIOGRAPHY_QUESTION_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_QUESTION_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_QUESTION_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_QUESTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_QUESTION_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_QUESTION_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_AUTOBIOGRAPHY_QUESTION_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE BELIEF ANSWER
    // *********************************************************************************************
    public static final String FIELD_BELIEF_ANSWER_ID = "recordId";
    public static final String FIELD_BELIEF_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_BELIEF_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_BELIEF_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_BELIEF_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_BELIEF_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_BELIEF_ANSWER_NAME = "recordAnswerName";
    public static final String FIELD_BELIEF_ANSWER_DESCRIPTION = "recordAnswerDescription";
    public static final String FIELD_BELIEF_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_BELIEF_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_BELIEF_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_BELIEF_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_BELIEF_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_BELIEF_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_BELIEF_ANSWER_DATE_SYNC = "recordDateSync";
    public static final String FIELD_BELIEF_ANSWER_IMAGE = "recordImage";

    static final
    String CREATE_TABLE_MODULE_BELIEF_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_ANSWER + " ("
            + FIELD_BELIEF_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_BELIEF_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_NAME + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_DESCRIPTION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_ANSWER_IMAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE BELIEF CALENDAR
    // *********************************************************************************************
    public static final String FIELD_BELIEF_CALENDAR_ID = "recordId";
    public static final String FIELD_BELIEF_CALENDAR_PHASE = "recordPhase";
    public static final String FIELD_BELIEF_CALENDAR_SIGN = "recordSign";
    public static final String FIELD_BELIEF_CALENDAR_DAY_FROM = "recordDayFrom";
    public static final String FIELD_BELIEF_CALENDAR_MONTH_FROM = "recordMonthFrom";
    public static final String FIELD_BELIEF_CALENDAR_YEAR_FROM = "recordYearFrom";
    public static final String FIELD_BELIEF_CALENDAR_DAY_TO = "recordDayTo";
    public static final String FIELD_BELIEF_CALENDAR_MONTH_TO = "recordMonthTo";
    public static final String FIELD_BELIEF_CALENDAR_YEAR_TO = "recordYearTo";
    public static final String FIELD_BELIEF_CALENDAR_CREATION = "recordDateCreation";
    public static final String FIELD_BELIEF_CALENDAR_UPDATE = "recordDateUpdate";
    public static final String FIELD_BELIEF_CALENDAR_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_BELIEF_CALENDAR = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_CALENDAR + " ("
            + FIELD_BELIEF_CALENDAR_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_BELIEF_CALENDAR_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_SIGN + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_DAY_FROM + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_MONTH_FROM + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_YEAR_FROM + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_DAY_TO + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_MONTH_TO + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_YEAR_TO + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_CALENDAR_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE BELIEF DESCRIPTION
    // *********************************************************************************************
    public static final String FIELD_BELIEF_DESCRIPTION_ID = "recordId";
    public static final String FIELD_BELIEF_DESCRIPTION_PHASE = "recordPhase";
    public static final String FIELD_BELIEF_DESCRIPTION_SIGN = "recordSign";
    public static final String FIELD_BELIEF_DESCRIPTION_LANGUAGE = "recordLanguage";
    public static final String FIELD_BELIEF_DESCRIPTION_NAME = "recordName";
    public static final String FIELD_BELIEF_DESCRIPTION_TEXT = "recordText";
    public static final String FIELD_BELIEF_DESCRIPTION_CREATION = "recordDateCreation";
    public static final String FIELD_BELIEF_DESCRIPTION_UPDATE = "recordDateUpdate";
    public static final String FIELD_BELIEF_DESCRIPTION_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_BELIEF_DESCRIPTION = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_DESCRIPTION + " ("
            + FIELD_BELIEF_DESCRIPTION_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_BELIEF_DESCRIPTION_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_DESCRIPTION_SIGN + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_DESCRIPTION_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_DESCRIPTION_NAME + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_DESCRIPTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_DESCRIPTION_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_DESCRIPTION_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BELIEF_DESCRIPTION_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";
    
    // *********************************************************************************************
    // ** TABLE BIORHYTHM ANSWER
    // *********************************************************************************************
    public static final String FIELD_BIORHYTHM_ANSWER_ID = "recordId";
    public static final String FIELD_BIORHYTHM_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_BIORHYTHM_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_BIORHYTHM_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_BIORHYTHM_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_BIORHYTHM_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_BIORHYTHM_ANSWER_EMOTIONAL = "recordEmotional";
    public static final String FIELD_BIORHYTHM_ANSWER_PHYSICAL = "recordPhysical";
    public static final String FIELD_BIORHYTHM_ANSWER_INTELECTUAL = "recordIntelectual";
    public static final String FIELD_BIORHYTHM_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_BIORHYTHM_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_BIORHYTHM_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_BIORHYTHM_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_BIORHYTHM_ANSWER_DATE_EVENT = "recordDateEvent";
    public static final String FIELD_BIORHYTHM_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_BIORHYTHM_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_BIORHYTHM_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_BIORHYTHM_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_BIORHYTHM_ANSWER + " ("
            + FIELD_BIORHYTHM_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_BIORHYTHM_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_EMOTIONAL + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_PHYSICAL + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_INTELECTUAL + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_DATE_EVENT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_BIORHYTHM_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE CHALLENGE ANSWER
    // *********************************************************************************************
    public static final String FIELD_CHALLENGE_ANSWER_ID = "recordId";
    public static final String FIELD_CHALLENGE_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_CHALLENGE_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_CHALLENGE_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_CHALLENGE_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_CHALLENGE_ANSWER_PRIORITY = "recordPriority";
    public static final String FIELD_CHALLENGE_ANSWER_FREQUENCY = "recordFrequency";
    public static final String FIELD_CHALLENGE_ANSWER_COSTS = "recordCosts";
    public static final String FIELD_CHALLENGE_ANSWER_QUESTION = "recordQuestion";
    public static final String FIELD_CHALLENGE_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_CHALLENGE_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_CHALLENGE_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_CHALLENGE_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_CHALLENGE_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_CHALLENGE_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_CHALLENGE_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_CHALLENGE_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_CHALLENGE_ANSWER + " ("
            + FIELD_CHALLENGE_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_CHALLENGE_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT+ SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_PRIORITY + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_FREQUENCY + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_COSTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_QUESTION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE CHALLENGE QUESTION
    // *********************************************************************************************
    public static final String FIELD_CHALLENGE_QUESTION_ID = "recordId";
    public static final String FIELD_CHALLENGE_QUESTION_LANGUAGE = "recordLanguage";
    public static final String FIELD_CHALLENGE_QUESTION_NUMBER = "recordNumber";
    public static final String FIELD_CHALLENGE_QUESTION_TEXT = "recordText";
    public static final String FIELD_CHALLENGE_QUESTION_CREATION = "recordDateCreation";
    public static final String FIELD_CHALLENGE_QUESTION_UPDATE = "recordDateUpdate";
    public static final String FIELD_CHALLENGE_QUESTION_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_CHALLENGE_QUESTION = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_CHALLENGE_QUESTION + " ("
            + FIELD_CHALLENGE_QUESTION_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_CHALLENGE_QUESTION_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_QUESTION_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_QUESTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_QUESTION_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_QUESTION_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_CHALLENGE_QUESTION_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";
    
    // *********************************************************************************************
    // ** TABLE DIARY ANSWER
    // *********************************************************************************************
    public static final String FIELD_DIARY_ANSWER_ID = "recordId";
    public static final String FIELD_DIARY_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_DIARY_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_DIARY_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_DIARY_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_DIARY_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_DIARY_ANSWER_TEXT = "recordAnswer";
    public static final String FIELD_DIARY_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_DIARY_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_DIARY_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_DIARY_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_DIARY_ANSWER_DATE_EVENT = "recordDateEvent";
    public static final String FIELD_DIARY_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_DIARY_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_DIARY_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_DIARY_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_DIARY_ANSWER + " ("
            + FIELD_DIARY_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_DIARY_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_DATE_EVENT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_DIARY_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";
    
    // *********************************************************************************************
    // ** TABLE LIFE ANSWER
    // *********************************************************************************************
    public static final String FIELD_LIFE_ANSWER_ID = "recordId";
    public static final String FIELD_LIFE_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_LIFE_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_LIFE_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_LIFE_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_LIFE_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_LIFE_ANSWER_GRADE = "recordGrade";
    public static final String FIELD_LIFE_ANSWER_QUESTION = "recordQuestion";
    public static final String FIELD_LIFE_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_LIFE_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_LIFE_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_LIFE_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_LIFE_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_LIFE_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_LIFE_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_LIFE_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_LIFE_ANSWER + " ("
            + FIELD_LIFE_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_LIFE_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_GRADE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_QUESTION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";
    
    // *********************************************************************************************
    // ** TABLE LIFE QUESTION
    // *********************************************************************************************
    public static final String FIELD_LIFE_QUESTION_ID = "recordId";
    public static final String FIELD_LIFE_QUESTION_LANGUAGE = "recordLanguage";
    public static final String FIELD_LIFE_QUESTION_PHASE = "recordPhase";
    public static final String FIELD_LIFE_QUESTION_NUMBER = "recordNumber";
    public static final String FIELD_LIFE_QUESTION_TEXT = "recordText";
    public static final String FIELD_LIFE_QUESTION_CREATION = "recordDateCreation";
    public static final String FIELD_LIFE_QUESTION_UPDATE = "recordDateUpdate";
    public static final String FIELD_LIFE_QUESTION_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_LIFE_QUESTION = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_LIFE_QUESTION + " ("
            + FIELD_LIFE_QUESTION_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_LIFE_QUESTION_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_QUESTION_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_QUESTION_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_QUESTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_QUESTION_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_QUESTION_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_LIFE_QUESTION_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE MOOD ANSWER
    // *********************************************************************************************
    public static final String FIELD_MOOD_ANSWER_ID = "recordId";
    public static final String FIELD_MOOD_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_MOOD_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_MOOD_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_MOOD_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_MOOD_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_MOOD_ANSWER_TEXT = "recordAnswer";
    public static final String FIELD_MOOD_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_MOOD_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_MOOD_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_MOOD_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_MOOD_ANSWER_DATE_EVENT = "recordDateEvent";
    public static final String FIELD_MOOD_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_MOOD_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_MOOD_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_MOOD_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_MOOD_ANSWER + " ("
            + FIELD_MOOD_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_MOOD_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_DATE_EVENT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_MOOD_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE PERSONALITY ANSWER
    // *********************************************************************************************
    public static final String FIELD_PERSONALITY_ANSWER_ID = "recordId";
    public static final String FIELD_PERSONALITY_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_PERSONALITY_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_PERSONALITY_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_PERSONALITY_ANSWER_GROUP = "recordGroup";
    public static final String FIELD_PERSONALITY_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_PERSONALITY_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_PERSONALITY_ANSWER_QUESTION = "recordQuestion";
    public static final String FIELD_PERSONALITY_ANSWER_TEXT = "recordAnswer";
    public static final String FIELD_PERSONALITY_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_PERSONALITY_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_PERSONALITY_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_PERSONALITY_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_PERSONALITY_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_PERSONALITY_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_PERSONALITY_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_PERSONALITY_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_ANSWER + " ("
            + FIELD_PERSONALITY_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_PERSONALITY_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_GROUP + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_QUESTION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE PERSONALITY CHOICE
    // *********************************************************************************************
    public static final String FIELD_PERSONALITY_CHOICE_ID = "recordId";
    public static final String FIELD_PERSONALITY_CHOICE_USER_ID = "recordUserId";
    public static final String FIELD_PERSONALITY_CHOICE_PHASE = "recordPhase";
    public static final String FIELD_PERSONALITY_CHOICE_NUMBER = "recordNumber";
    public static final String FIELD_PERSONALITY_CHOICE_GROUP = "recordGroup";
    public static final String FIELD_PERSONALITY_CHOICE_STATUS = "recordStatus";
    public static final String FIELD_PERSONALITY_CHOICE_QUESTION_TEXT = "recordQuestion";
    public static final String FIELD_PERSONALITY_CHOICE_TEXT = "recordAnswer";
    public static final String FIELD_PERSONALITY_CHOICE_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_PERSONALITY_CHOICE_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_PERSONALITY_CHOICE_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_PERSONALITY_CHOICE = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_CHOICE + " ("
            + FIELD_PERSONALITY_CHOICE_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_PERSONALITY_CHOICE_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_CHOICE_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_CHOICE_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_CHOICE_GROUP + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_CHOICE_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_CHOICE_QUESTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_CHOICE_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_CHOICE_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_CHOICE_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_CHOICE_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";
    
    // *********************************************************************************************
    // ** TABLE PERSONALITY QUESTION
    // *********************************************************************************************
    public static final String FIELD_PERSONALITY_QUESTION_ID = "recordId";
    public static final String FIELD_PERSONALITY_QUESTION_LANGUAGE = "recordLanguage";
    public static final String FIELD_PERSONALITY_QUESTION_PHASE = "recordPhase";
    public static final String FIELD_PERSONALITY_QUESTION_NUMBER = "recordNumber";
    public static final String FIELD_PERSONALITY_QUESTION_GROUP = "recordGroup";
    public static final String FIELD_PERSONALITY_QUESTION_TEXT = "recordText";
    public static final String FIELD_PERSONALITY_QUESTION_CREATION = "recordDateCreation";
    public static final String FIELD_PERSONALITY_QUESTION_UPDATE = "recordDateUpdate";
    public static final String FIELD_PERSONALITY_QUESTION_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_PERSONALITY_QUESTION = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_QUESTION + " ("
            + FIELD_PERSONALITY_QUESTION_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_PERSONALITY_QUESTION_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_QUESTION_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_QUESTION_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_QUESTION_GROUP + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_QUESTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_QUESTION_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_QUESTION_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_QUESTION_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE PERSONALITY RESULT
    // *********************************************************************************************
    public static final String FIELD_PERSONALITY_RESULT_ID = "recordId";
    public static final String FIELD_PERSONALITY_RESULT_LANGUAGE = "recordLanguage";
    public static final String FIELD_PERSONALITY_RESULT_PHASE = "recordPhase";
    public static final String FIELD_PERSONALITY_RESULT_CODE = "recordCode";
    public static final String FIELD_PERSONALITY_RESULT_NAME = "recordName";
    public static final String FIELD_PERSONALITY_RESULT_GROUP = "recordGroup";
    public static final String FIELD_PERSONALITY_RESULT_CHARACTERISTIC = "recordCharacteristic";
    public static final String FIELD_PERSONALITY_RESULT_TEXT = "recordText";
    public static final String FIELD_PERSONALITY_RESULT_CREATION = "recordDateCreation";
    public static final String FIELD_PERSONALITY_RESULT_UPDATE = "recordDateUpdate";
    public static final String FIELD_PERSONALITY_RESULT_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_PERSONALITY_RESULT = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_RESULT + " ("
            + FIELD_PERSONALITY_RESULT_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_PERSONALITY_RESULT_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_RESULT_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_RESULT_CODE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_RESULT_NAME + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_RESULT_GROUP + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_RESULT_CHARACTERISTIC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_RESULT_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_RESULT_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_RESULT_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PERSONALITY_RESULT_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE PHOTO ANSWER
    // *********************************************************************************************
    public static final String FIELD_PHOTO_ANSWER_ID = "recordId";
    public static final String FIELD_PHOTO_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_PHOTO_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_PHOTO_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_PHOTO_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_PHOTO_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_PHOTO_ANSWER_DATE_SYNC = "recordDateSync";
    public static final String FIELD_PHOTO_ANSWER_IMAGE = "recordImage";

    static final
    String CREATE_TABLE_MODULE_PHOTO_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_PHOTO_ANSWER + " ("
            + FIELD_PHOTO_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_PHOTO_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PHOTO_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PHOTO_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PHOTO_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PHOTO_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PHOTO_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_PHOTO_ANSWER_IMAGE + SQLITE_ATTRIBUTE_BLOB + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE RECOGNITION ANSWER
    // *********************************************************************************************
    public static final String FIELD_RECOGNITION_ANSWER_ID = "recordId";
    public static final String FIELD_RECOGNITION_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_RECOGNITION_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_RECOGNITION_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_RECOGNITION_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_RECOGNITION_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_RECOGNITION_ANSWER_GRADE = "recordRecognition";
    public static final String FIELD_RECOGNITION_ANSWER_QUESTION = "recordQuestion";
    public static final String FIELD_RECOGNITION_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_RECOGNITION_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_RECOGNITION_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_RECOGNITION_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_RECOGNITION_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_RECOGNITION_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_RECOGNITION_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_RECOGNITION_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_RECOGNITION_ANSWER + " ("
            + FIELD_RECOGNITION_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_RECOGNITION_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_GRADE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_QUESTION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE RECOGNITION QUESTION
    // *********************************************************************************************
    public static final String FIELD_RECOGNITION_QUESTION_ID = "recordId";
    public static final String FIELD_RECOGNITION_QUESTION_LANGUAGE = "recordLanguage";
    public static final String FIELD_RECOGNITION_QUESTION_PHASE = "recordPhase";
    public static final String FIELD_RECOGNITION_QUESTION_NUMBER = "recordNumber";
    public static final String FIELD_RECOGNITION_QUESTION_HEADER = "recordHeader";
    public static final String FIELD_RECOGNITION_QUESTION_DESCRIPTION = "recordDescription";
    public static final String FIELD_RECOGNITION_QUESTION_CREATION = "recordDateCreation";
    public static final String FIELD_RECOGNITION_QUESTION_UPDATE = "recordDateUpdate";
    public static final String FIELD_RECOGNITION_QUESTION_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_RECOGNITION_QUESTION = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_RECOGNITION_QUESTION + " ("
            + FIELD_RECOGNITION_QUESTION_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_RECOGNITION_QUESTION_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_QUESTION_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_QUESTION_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_QUESTION_HEADER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_QUESTION_DESCRIPTION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_QUESTION_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_QUESTION_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_RECOGNITION_QUESTION_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE REFLECTION ANSWER
    // *********************************************************************************************
    public static final String FIELD_REFLECTION_ANSWER_ID = "recordId";
    public static final String FIELD_REFLECTION_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_REFLECTION_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_REFLECTION_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_REFLECTION_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_REFLECTION_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_REFLECTION_ANSWER_QUESTION_TEXT = "recordQuestion";
    public static final String FIELD_REFLECTION_ANSWER_TEXT = "recordAnswer";
    public static final String FIELD_REFLECTION_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_REFLECTION_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_REFLECTION_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_REFLECTION_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_REFLECTION_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_REFLECTION_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_REFLECTION_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_REFLECTION_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_REFLECTION_ANSWER + " ("
            + FIELD_REFLECTION_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_REFLECTION_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_QUESTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";
    
    // *********************************************************************************************
    // ** TABLE REFLECTION QUESTION
    // *********************************************************************************************
    public static final String FIELD_REFLECTION_QUESTION_ID = "recordId";
    public static final String FIELD_REFLECTION_QUESTION_LANGUAGE = "recordLanguage";
    public static final String FIELD_REFLECTION_QUESTION_PHASE = "recordPhase";
    public static final String FIELD_REFLECTION_QUESTION_NUMBER = "recordNumber";
    public static final String FIELD_REFLECTION_QUESTION_TEXT = "recordText";
    public static final String FIELD_REFLECTION_QUESTION_CREATION = "recordDateCreation";
    public static final String FIELD_REFLECTION_QUESTION_UPDATE = "recordDateUpdate";
    public static final String FIELD_REFLECTION_QUESTION_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_REFLECTION_QUESTION = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_REFLECTION_QUESTION + " ("
            + FIELD_REFLECTION_QUESTION_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_REFLECTION_QUESTION_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_QUESTION_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_QUESTION_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_QUESTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_QUESTION_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_QUESTION_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_REFLECTION_QUESTION_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE SHARING ANSWER
    // *********************************************************************************************
    public static final String FIELD_SHARING_ANSWER_ID = "recordId";
    public static final String FIELD_SHARING_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_SHARING_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_SHARING_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_SHARING_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_SHARING_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_SHARING_ANSWER_DATE_SYNC = "recordDateSync";
    public static final String FIELD_SHARING_ANSWER_IMAGE = "recordImage";

    static final
    String CREATE_TABLE_MODULE_SHARING_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_SHARING_ANSWER + " ("
            + FIELD_SHARING_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_SHARING_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SHARING_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SHARING_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SHARING_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SHARING_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SHARING_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SHARING_ANSWER_IMAGE + SQLITE_ATTRIBUTE_BLOB + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE YOU ANSWER
    // *********************************************************************************************
    public static final String FIELD_YOU_ANSWER_ID = "recordId";
    public static final String FIELD_YOU_ANSWER_USER_ID = "recordUserId";
    public static final String FIELD_YOU_ANSWER_PHASE = "recordPhase";
    public static final String FIELD_YOU_ANSWER_NUMBER = "recordNumber";
    public static final String FIELD_YOU_ANSWER_STATUS = "recordStatus";
    public static final String FIELD_YOU_ANSWER_EXPERIENCE = "recordExperience";
    public static final String FIELD_YOU_ANSWER_QUESTION_TEXT = "recordQuestion";
    public static final String FIELD_YOU_ANSWER_TEXT = "recordAnswer";
    public static final String FIELD_YOU_ANSWER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_YOU_ANSWER_NUMBER_SHARING = "recordNumberSharing";
    public static final String FIELD_YOU_ANSWER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_YOU_ANSWER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_YOU_ANSWER_DATE_CREATION = "recordDateCreation";
    public static final String FIELD_YOU_ANSWER_DATE_UPDATE = "recordDateUpdate";
    public static final String FIELD_YOU_ANSWER_DATE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_YOU_ANSWER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_YOU_ANSWER + " ("
            + FIELD_YOU_ANSWER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_YOU_ANSWER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_EXPERIENCE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_QUESTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_NUMBER_SHARING + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_DATE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_DATE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_ANSWER_DATE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE YOU QUESTION
    // *********************************************************************************************
    public static final String FIELD_YOU_QUESTION_ID = "recordId";
    public static final String FIELD_YOU_QUESTION_LANGUAGE = "recordLanguage";
    public static final String FIELD_YOU_QUESTION_PHASE = "recordPhase";
    public static final String FIELD_YOU_QUESTION_NUMBER = "recordNumber";
    public static final String FIELD_YOU_QUESTION_TEXT = "recordText";
    public static final String FIELD_YOU_QUESTION_CREATION = "recordDateCreation";
    public static final String FIELD_YOU_QUESTION_UPDATE = "recordDateUpdate";
    public static final String FIELD_YOU_QUESTION_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_MODULE_YOU_QUESTION = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_MODULE_YOU_QUESTION + " ("
            + FIELD_YOU_QUESTION_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_YOU_QUESTION_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_QUESTION_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_QUESTION_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_QUESTION_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_QUESTION_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_QUESTION_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_YOU_QUESTION_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE SUPPORT ADVICE
    // *********************************************************************************************
    public static final String FIELD_SUPPORT_ADVICE_ID = "recordId";
    public static final String FIELD_SUPPORT_ADVICE_LANGUAGE = "recordLanguage";
    public static final String FIELD_SUPPORT_ADVICE_NUMBER = "recordNumber";
    public static final String FIELD_SUPPORT_ADVICE_AUTHOR = "recordAuthor";
    public static final String FIELD_SUPPORT_ADVICE_TEXT = "recordText";
    public static final String FIELD_SUPPORT_ADVICE_CREATION = "recordDateCreation";
    public static final String FIELD_SUPPORT_ADVICE_UPDATE = "recordDateUpdate";
    public static final String FIELD_SUPPORT_ADVICE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_SUPPORT_ADVICE = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_SUPPORT_ADVICE + " ("
            + FIELD_SUPPORT_ADVICE_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_SUPPORT_ADVICE_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_ADVICE_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_ADVICE_AUTHOR + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_ADVICE_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_ADVICE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_ADVICE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_ADVICE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE SUPPORT HELP
    // *********************************************************************************************
    public static final String FIELD_SUPPORT_HELP_ID = "recordId";
    public static final String FIELD_SUPPORT_HELP_LANGUAGE = "recordLanguage";
    public static final String FIELD_SUPPORT_HELP_PHASE = "recordPhase";
    public static final String FIELD_SUPPORT_HELP_TEXT = "recordText";
    public static final String FIELD_SUPPORT_HELP_CREATION = "recordDateCreation";
    public static final String FIELD_SUPPORT_HELP_UPDATE = "recordDateUpdate";
    public static final String FIELD_SUPPORT_HELP_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_SUPPORT_HELP = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_SUPPORT_HELP + " ("
            + FIELD_SUPPORT_HELP_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_SUPPORT_HELP_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_HELP_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_HELP_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_HELP_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_HELP_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_HELP_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";
    
    // *********************************************************************************************
    // ** TABLE SUPPORT PHRASE
    // *********************************************************************************************
    public static final String FIELD_SUPPORT_PHRASE_ID = "recordId";
    public static final String FIELD_SUPPORT_PHRASE_LANGUAGE = "recordLanguage";
    public static final String FIELD_SUPPORT_PHRASE_NUMBER = "recordNumber";
    public static final String FIELD_SUPPORT_PHRASE_AUTHOR = "recordAuthor";
    public static final String FIELD_SUPPORT_PHRASE_TEXT = "recordText";
    public static final String FIELD_SUPPORT_PHRASE_CREATION = "recordDateCreation";
    public static final String FIELD_SUPPORT_PHRASE_UPDATE = "recordDateUpdate";
    public static final String FIELD_SUPPORT_PHRASE_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_SUPPORT_PHRASE = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_SUPPORT_PHRASE + " ("
            + FIELD_SUPPORT_PHRASE_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_SUPPORT_PHRASE_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_PHRASE_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_PHRASE_AUTHOR + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_PHRASE_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_PHRASE_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_PHRASE_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_PHRASE_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE SUPPORT WORD
    // *********************************************************************************************
    public static final String FIELD_SUPPORT_WORD_ID = "recordId";
    public static final String FIELD_SUPPORT_WORD_LANGUAGE = "recordLanguage";
    public static final String FIELD_SUPPORT_WORD_NUMBER = "recordNumber";
    public static final String FIELD_SUPPORT_WORD_TEXT = "recordText";
    public static final String FIELD_SUPPORT_WORD_CREATION = "recordDateCreation";
    public static final String FIELD_SUPPORT_WORD_UPDATE = "recordDateUpdate";
    public static final String FIELD_SUPPORT_WORD_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_SUPPORT_WORD = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_SUPPORT_WORD + " ("
            + FIELD_SUPPORT_WORD_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_SUPPORT_WORD_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_WORD_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_WORD_TEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_WORD_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_WORD_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_WORD_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE SUPPORT USER
    // *********************************************************************************************
    public static final String FIELD_SUPPORT_USER_ID = "recordId";
    public static final String FIELD_SUPPORT_USER_LANGUAGE = "recordUserLanguage";
    public static final String FIELD_SUPPORT_USER_FIRST_NAME = "recordUserFirstName";
    public static final String FIELD_SUPPORT_USER_LAST_NAME = "recordUserLastName";
    public static final String FIELD_SUPPORT_USER_COMPLETE_NAME = "recordUserCompleteName";
    public static final String FIELD_SUPPORT_USER_NICKNAME = "recordUserNickName";
    public static final String FIELD_SUPPORT_USER_BIRTHDATE = "recordUserBirthdate";
    public static final String FIELD_SUPPORT_USER_BIRTH_COUNTRY = "recordUserBirthCountry";
    public static final String FIELD_SUPPORT_USER_GENDER = "recordUserGender";
    public static final String FIELD_SUPPORT_USER_SEXUAL_OPTION = "recordUserSexualOption";
    public static final String FIELD_SUPPORT_USER_RACE = "recordUserRace";
    public static final String FIELD_SUPPORT_USER_MARITAL_STATUS = "recordUserMaritalStatus";
    public static final String FIELD_SUPPORT_USER_RELIGION = "recordUserReligion";
    public static final String FIELD_SUPPORT_USER_SCHOLARSHIP = "recordUserScholarity";
    public static final String FIELD_SUPPORT_USER_HEIGHT = "recordUserHeight";
    public static final String FIELD_SUPPORT_USER_WEIGHT = "recordUserWeight";
    public static final String FIELD_SUPPORT_USER_EMAIL = "recordUserEmail";
    public static final String FIELD_SUPPORT_USER_PHOTO = "recordUserPhoto";
    public static final String FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE = "recordPasswordChangeLast";
    public static final String FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE = "recordPasswordChangeNext";
    public static final String FIELD_SUPPORT_USER_PASSWORD_FREQUENCY = "recordPasswordChangeFrequency";
    public static final String FIELD_SUPPORT_USER_PASSWORD_BLOCKED = "recordPasswordBlocked";
    public static final String FIELD_SUPPORT_USER_APPLICATION_LANGUAGE = "recordApplicationLanguage";
    public static final String FIELD_SUPPORT_USER_APPLICATION_VERSION = "recordApplicationVersion";
    public static final String FIELD_SUPPORT_USER_APPLICATION_TYPE = "recordApplicationType";
    public static final String FIELD_SUPPORT_USER_SYNC_LAST = "recordDatabaseSyncLast";
    public static final String FIELD_SUPPORT_USER_SYNC_NEXT = "recordDatabaseSyncNext";
    public static final String FIELD_SUPPORT_USER_RESET_LAST = "recordDatabaseReset";
    public static final String FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE = "recordApplicationDonationDate";
    public static final String FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE = "recordApplicationDonationValue";
    public static final String FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE = "recordApplicationEvaluationDate";
    public static final String FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE = "recordApplicationEvaluationValue";
    public static final String FIELD_SUPPORT_USER_CREATION = "recordDateCreation";
    public static final String FIELD_SUPPORT_USER_UPDATE = "recordDateUpdate";
    public static final String FIELD_SUPPORT_USER_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_SUPPORT_USER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_SUPPORT_USER + " ("
            + FIELD_SUPPORT_USER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_SUPPORT_USER_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_FIRST_NAME + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_LAST_NAME + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_COMPLETE_NAME + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_NICKNAME + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_BIRTHDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_BIRTH_COUNTRY + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_GENDER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_SEXUAL_OPTION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_RACE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_MARITAL_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_RELIGION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_SCHOLARSHIP + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_HEIGHT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_WEIGHT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_EMAIL + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_PHOTO + SQLITE_ATTRIBUTE_BLOB
            + ", "
            + FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_PASSWORD_FREQUENCY + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_PASSWORD_BLOCKED + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_APPLICATION_LANGUAGE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_APPLICATION_VERSION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_APPLICATION_TYPE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_SYNC_LAST + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_SYNC_NEXT + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_RESET_LAST + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_USER_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

    // *********************************************************************************************
    // ** TABLE POINTS USER
    // *********************************************************************************************
    public static final String FIELD_SUPPORT_POINTS_USER_ID = "recordId";
    public static final String FIELD_SUPPORT_POINTS_USER_USER_ID = "recordUserId";
    public static final String FIELD_SUPPORT_POINTS_USER_PHASE = "recordPhase";
    public static final String FIELD_SUPPORT_POINTS_USER_NUMBER = "recordNumber";
    public static final String FIELD_SUPPORT_POINTS_USER_STATUS = "recordStatus";
    public static final String FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS = "recordNumberPoints";
    public static final String FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS = "recordNumberSharing";
    public static final String FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS = "recordNumberPhotos";
    public static final String FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS = "recordNumberActions";
    public static final String FIELD_SUPPORT_POINTS_USER_CREATION = "recordDateCreation";
    public static final String FIELD_SUPPORT_POINTS_USER_UPDATE = "recordDateUpdate";
    public static final String FIELD_SUPPORT_POINTS_USER_SYNC = "recordDateSync";

    static final
    String CREATE_TABLE_SUPPORT_POINTS_USER = SQLITE_CREATE_TABLE + SqliteDatabaseTableNames.TABLE_SUPPORT_POINTS_USER + " ("
            + FIELD_SUPPORT_POINTS_USER_ID + SQLITE_ATTRIBUTE_INTEGER + SQLITE_ATTRIBUTE_PRIMARY_KEY + SQLITE_ATTRIBUTE_AUTOINCREMENT
            + ", "
            + FIELD_SUPPORT_POINTS_USER_USER_ID + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_PHASE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_NUMBER + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_STATUS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_CREATION + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_UPDATE + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ", "
            + FIELD_SUPPORT_POINTS_USER_SYNC + SQLITE_ATTRIBUTE_TEXT + SQLITE_ATTRIBUTE_NOTNULL
            + ")";

}

