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
import com.prosper.day.databasemodel.ModelModuleChallengeQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_QUESTION_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_QUESTION_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_QUESTION_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_QUESTION_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_QUESTION_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_QUESTION_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_QUESTION_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_CHALLENGE_QUESTION;

public class SqliteModuleChallengeQuestion {

    private static SQLiteDatabase mSqLiteDatabase;
    private static Cursor mCursor;
    private static ContentValues mContentValues;

    private static String mStringClassName;
    private static String mStringSelectQuery;

    private static int mIntKeyFromSqlite;

    private static long mLongRecordCounter;

    // *********************************************************************************************
    // *********************************************************************************************
    public static long sqliteCounter(Context context) {

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_MODULE_CHALLENGE_QUESTION);

        mSqLiteDatabase.close();

        return mLongRecordCounter;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteInsert(
            Context context,
            String recordLanguage,
            String recordNumber,
            String recordText,
            String recordDateCreation,
            String recordDateUpdate,
            String recordDateSync
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_CHALLENGE_QUESTION_LANGUAGE, recordLanguage);
            mContentValues.put(FIELD_CHALLENGE_QUESTION_NUMBER, recordNumber);
            mContentValues.put(FIELD_CHALLENGE_QUESTION_TEXT, recordText);
            mContentValues.put(FIELD_CHALLENGE_QUESTION_CREATION, recordDateCreation);
            mContentValues.put(FIELD_CHALLENGE_QUESTION_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_CHALLENGE_QUESTION_SYNC, recordDateSync);

            mSqLiteDatabase.insert(TABLE_MODULE_CHALLENGE_QUESTION, null, mContentValues);
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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_QUESTION;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_CHALLENGE_QUESTION_ID));
                mSqLiteDatabase.delete(TABLE_MODULE_CHALLENGE_QUESTION, FIELD_CHALLENGE_QUESTION_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleChallengeQuestion> sqliteGetAll(Context context) {

        List<ModelModuleChallengeQuestion> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_QUESTION;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleChallengeQuestion(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_QUESTION_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_QUESTION_LANGUAGE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_QUESTION_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_QUESTION_TEXT)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_QUESTION_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_QUESTION_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_QUESTION_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }
}