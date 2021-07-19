package com.prosper.day.databasesqlite;

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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.prosper.day.applicationsupportclasses.SupportHandlingExceptionError;
import com.prosper.day.databasedefinition.SqliteConnectionFactory;
import com.prosper.day.databasemodel.ModelModuleBeliefCalendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.SIGN_INITIAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_AND;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_GREATER_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_LESS_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_QUOTES;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_WHERE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_DAY_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_DAY_TO;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_MONTH_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_MONTH_TO;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_SIGN;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_YEAR_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_YEAR_TO;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_CALENDAR;

public class SqliteModuleBeliefCalendar {

    private static SQLiteDatabase mSqLiteDatabase;
    private static Cursor mCursor;
    private static ContentValues mContentValues;

    private static String mStringClassName;
    private static String mStringSelectQuery;
    private static String mStringSign = SIGN_INITIAL;

    private static int mIntKeyFromSqlite;

    private static long mLongRecordCounter;

    // *********************************************************************************************
    // *********************************************************************************************
    public static long sqliteCounter(Context context) {

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();
        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_MODULE_BELIEF_CALENDAR);
        mSqLiteDatabase.close();
        return mLongRecordCounter;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteInsert(
            Context context,
            String recordPhase,
            String recordSign,
            String recordDayFrom,
            String recordMonthFrom,
            String recordYearFrom,
            String recordDayTo,
            String recordMonthTo,
            String recordYearTo,
            String recordDateCreation,
            String recordDateUpdate,
            String recordDateSync
    ) {
        
        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_BELIEF_CALENDAR_PHASE, recordPhase);
            mContentValues.put(FIELD_BELIEF_CALENDAR_SIGN, recordSign);
            mContentValues.put(FIELD_BELIEF_CALENDAR_DAY_FROM, recordDayFrom);
            mContentValues.put(FIELD_BELIEF_CALENDAR_MONTH_FROM, recordMonthFrom);
            mContentValues.put(FIELD_BELIEF_CALENDAR_YEAR_FROM, recordYearFrom);
            mContentValues.put(FIELD_BELIEF_CALENDAR_DAY_TO, recordDayTo);
            mContentValues.put(FIELD_BELIEF_CALENDAR_MONTH_TO, recordMonthTo);
            mContentValues.put(FIELD_BELIEF_CALENDAR_YEAR_TO, recordYearTo);
            mContentValues.put(FIELD_BELIEF_CALENDAR_CREATION, recordDateCreation);
            mContentValues.put(FIELD_BELIEF_CALENDAR_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_BELIEF_CALENDAR_SYNC, recordDateSync);

            mSqLiteDatabase.insert(TABLE_MODULE_BELIEF_CALENDAR, null, mContentValues);
            mSqLiteDatabase.setTransactionSuccessful();

        } catch (SQLException sqlerror) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, sqlerror, context);

        } finally {

            mSqLiteDatabase.endTransaction();
        }

        mSqLiteDatabase.close();
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteDeleteAll(Context context) {

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_BELIEF_CALENDAR;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_ID));
                mSqLiteDatabase.delete(TABLE_MODULE_BELIEF_CALENDAR, FIELD_BELIEF_CALENDAR_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static String sqliteGetOne(Context context, String stringPhase, String stringDay, String stringMonth, String stringYear) {

        mStringSign = SIGN_INITIAL;
        mStringSelectQuery = null;

        List<ModelModuleBeliefCalendar> list = new ArrayList<>();
        list.clear();

        switch (stringPhase){

            case BELIEF_PHASE_CODE_05_02:
            case BELIEF_PHASE_CODE_05_05:

                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_BELIEF_CALENDAR

                        + SQLITE_COMMAND_WHERE + FIELD_BELIEF_CALENDAR_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES

                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringDay + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_GREATER_EQUAL + FIELD_BELIEF_CALENDAR_DAY_FROM
                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringDay + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_LESS_EQUAL + FIELD_BELIEF_CALENDAR_DAY_TO

                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringMonth + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_GREATER_EQUAL + FIELD_BELIEF_CALENDAR_MONTH_FROM
                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringMonth + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_LESS_EQUAL + FIELD_BELIEF_CALENDAR_MONTH_TO

                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringYear + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_GREATER_EQUAL + FIELD_BELIEF_CALENDAR_YEAR_FROM
                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringYear + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_LESS_EQUAL + FIELD_BELIEF_CALENDAR_YEAR_TO;

                break;

            default:

                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_BELIEF_CALENDAR

                        + SQLITE_COMMAND_WHERE + FIELD_BELIEF_CALENDAR_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES

                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringDay + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_GREATER_EQUAL + FIELD_BELIEF_CALENDAR_DAY_FROM
                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringDay + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_LESS_EQUAL + FIELD_BELIEF_CALENDAR_DAY_TO

                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringMonth + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_GREATER_EQUAL + FIELD_BELIEF_CALENDAR_MONTH_FROM
                        + SQLITE_COMMAND_AND + SQLITE_COMMAND_QUOTES + stringMonth + SQLITE_COMMAND_QUOTES + SQLITE_COMMAND_LESS_EQUAL + FIELD_BELIEF_CALENDAR_MONTH_TO;

                break;

        }

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleBeliefCalendar(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_SIGN)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_DAY_FROM)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_MONTH_FROM)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_YEAR_FROM)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_DAY_TO)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_MONTH_TO)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_YEAR_TO)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_SYNC))));

                mStringSign = mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_CALENDAR_SIGN));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return mStringSign;

    }
}