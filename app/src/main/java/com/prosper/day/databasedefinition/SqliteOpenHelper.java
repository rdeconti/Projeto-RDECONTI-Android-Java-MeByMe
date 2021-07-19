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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_DROP_TABLE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_ACTION_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_AUTOBIOGRAPHY_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_AUTOBIOGRAPHY_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_BELIEF_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_BELIEF_CALENDAR;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_BELIEF_DESCRIPTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_BIORHYTHM_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_CHALLENGE_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_CHALLENGE_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_DIARY_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_LIFE_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_LIFE_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_MOOD_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_PERSONALITY_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_PERSONALITY_CHOICE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_PERSONALITY_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_PERSONALITY_RESULT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_PHOTO_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_RECOGNITION_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_RECOGNITION_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_REFLECTION_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_REFLECTION_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_SHARING_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_YOU_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_MODULE_YOU_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_SUPPORT_ADVICE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_SUPPORT_HELP;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_SUPPORT_PHRASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_SUPPORT_POINTS_USER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_SUPPORT_USER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.CREATE_TABLE_SUPPORT_WORD;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_ACTION_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_AUTOBIOGRAPHY_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_AUTOBIOGRAPHY_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_CALENDAR;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_DESCRIPTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BIORHYTHM_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_CHALLENGE_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_CHALLENGE_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_DIARY_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_LIFE_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_LIFE_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_MOOD_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_CHOICE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_RESULT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PHOTO_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_RECOGNITION_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_RECOGNITION_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_REFLECTION_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_REFLECTION_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_SHARING_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_YOU_ANSWER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_YOU_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_ADVICE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_HELP;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_PHRASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_POINTS_USER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_USER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_WORD;
import static com.prosper.day.databasedefinition.SqliteDatabaseVersion.DATA_BASE_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseVersion.DATA_BASE_VERSION;

public class SqliteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    SqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version) {
        super(context, DATA_BASE_NAME, cursorFactory, DATA_BASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(CREATE_TABLE_MODULE_ACTION_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_AUTOBIOGRAPHY_QUESTION);
        database.execSQL(CREATE_TABLE_MODULE_AUTOBIOGRAPHY_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_BELIEF_DESCRIPTION);
        database.execSQL(CREATE_TABLE_MODULE_BELIEF_CALENDAR);
        database.execSQL(CREATE_TABLE_MODULE_BELIEF_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_BIORHYTHM_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_CHALLENGE_QUESTION);
        database.execSQL(CREATE_TABLE_MODULE_CHALLENGE_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_DIARY_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_LIFE_QUESTION);
        database.execSQL(CREATE_TABLE_MODULE_LIFE_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_MOOD_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_PERSONALITY_ANSWER);
        database.execSQL(CREATE_TABLE_MODULE_PERSONALITY_CHOICE);
        database.execSQL(CREATE_TABLE_MODULE_PERSONALITY_QUESTION);
        database.execSQL(CREATE_TABLE_MODULE_PERSONALITY_RESULT);

        database.execSQL(CREATE_TABLE_MODULE_PHOTO_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_RECOGNITION_QUESTION);
        database.execSQL(CREATE_TABLE_MODULE_RECOGNITION_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_REFLECTION_QUESTION);
        database.execSQL(CREATE_TABLE_MODULE_REFLECTION_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_SHARING_ANSWER);

        database.execSQL(CREATE_TABLE_MODULE_YOU_QUESTION);
        database.execSQL(CREATE_TABLE_MODULE_YOU_ANSWER);

        database.execSQL(CREATE_TABLE_SUPPORT_ADVICE);
        database.execSQL(CREATE_TABLE_SUPPORT_HELP);
        database.execSQL(CREATE_TABLE_SUPPORT_PHRASE);
        database.execSQL(CREATE_TABLE_SUPPORT_POINTS_USER);
        database.execSQL(CREATE_TABLE_SUPPORT_USER);
        database.execSQL(CREATE_TABLE_SUPPORT_WORD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_ACTION_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_AUTOBIOGRAPHY_QUESTION);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_AUTOBIOGRAPHY_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_BELIEF_DESCRIPTION);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_BELIEF_CALENDAR);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_BELIEF_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_BIORHYTHM_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_CHALLENGE_QUESTION);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_CHALLENGE_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_DIARY_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_LIFE_QUESTION);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_LIFE_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_MOOD_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_PERSONALITY_ANSWER);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_PERSONALITY_CHOICE);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_PERSONALITY_QUESTION);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_PERSONALITY_RESULT);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_PHOTO_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_RECOGNITION_QUESTION);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_RECOGNITION_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_REFLECTION_QUESTION);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_REFLECTION_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_SHARING_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_YOU_QUESTION);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_MODULE_YOU_ANSWER);

        database.execSQL(SQLITE_DROP_TABLE + TABLE_SUPPORT_ADVICE);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_SUPPORT_HELP);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_SUPPORT_PHRASE);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_SUPPORT_POINTS_USER);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_SUPPORT_USER);
        database.execSQL(SQLITE_DROP_TABLE + TABLE_SUPPORT_WORD);

        onCreate(database);
    }
}
