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

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportHandlingExceptionError;
import com.prosper.day.databasedefinition.SqliteConnectionFactory;

import java.util.Objects;

import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_AND;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_QUOTES;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_WHERE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_SIGN;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_DESCRIPTION;

public class SqliteModuleBeliefDescription {

    private static SQLiteDatabase mSqLiteDatabase;
    private static Cursor mCursor;
    private static ContentValues mContentValues;

    private static String mStringClassName;
    private static String mStringSelectQuery;
    private static String mStringText;

    private static int mIntKeyFromSqlite;

    private static long mLongRecordCounter;

    // *********************************************************************************************
    // *********************************************************************************************
    public static long sqliteCounter(Context context) {

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();
        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_MODULE_BELIEF_DESCRIPTION);
        mSqLiteDatabase.close();
        return mLongRecordCounter;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteInsert(
            Context context,
            String recordPhase,
            String recordSign,
            String recordLanguage,
            String recordName,
            String recordText,
            String recordDateCreation,
            String recordDateUpdate,
            String recordDateSync
    ) {
        
        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_BELIEF_DESCRIPTION_PHASE, recordPhase);
            mContentValues.put(FIELD_BELIEF_DESCRIPTION_SIGN, recordSign);
            mContentValues.put(FIELD_BELIEF_DESCRIPTION_LANGUAGE, recordLanguage);
            mContentValues.put(FIELD_BELIEF_DESCRIPTION_NAME, recordName);
            mContentValues.put(FIELD_BELIEF_DESCRIPTION_TEXT, recordText);
            mContentValues.put(FIELD_BELIEF_DESCRIPTION_CREATION, recordDateCreation);
            mContentValues.put(FIELD_BELIEF_DESCRIPTION_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_BELIEF_DESCRIPTION_SYNC, recordDateSync);

            mSqLiteDatabase.insert(TABLE_MODULE_BELIEF_DESCRIPTION, null, mContentValues);
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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_BELIEF_DESCRIPTION;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_BELIEF_DESCRIPTION_ID));
                mSqLiteDatabase.delete(TABLE_MODULE_BELIEF_DESCRIPTION, FIELD_BELIEF_DESCRIPTION_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static String sqliteGetOneDescription(Context context, String stringPhase, String stringSign) {

        mStringText = context.getString(R.string.message_application_problem);

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_BELIEF_DESCRIPTION
                + SQLITE_COMMAND_WHERE + FIELD_BELIEF_DESCRIPTION_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES
                + SQLITE_COMMAND_AND + FIELD_BELIEF_DESCRIPTION_SIGN + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringSign + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mStringText = mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_DESCRIPTION_TEXT));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return mStringText;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static String sqliteGetOneName(Context context, String stringPhase, String stringSign) {

        mStringText = context.getString(R.string.message_application_problem);

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_BELIEF_DESCRIPTION
                + SQLITE_COMMAND_WHERE + FIELD_BELIEF_DESCRIPTION_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES
                + SQLITE_COMMAND_AND + FIELD_BELIEF_DESCRIPTION_SIGN + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringSign + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mStringText = mCursor.getString(mCursor.getColumnIndex(FIELD_BELIEF_DESCRIPTION_NAME));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return mStringText;

    }
}