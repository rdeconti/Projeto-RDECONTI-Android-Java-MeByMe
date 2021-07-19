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
import com.prosper.day.databasemodel.ModelModulePersonalityResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsLanguage;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_AND;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_QUOTES;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_WHERE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_CHARACTERISTIC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_CODE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_GROUP;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_RESULT;

public class SqliteModulePersonalityResult {

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
        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_MODULE_PERSONALITY_RESULT);
        mSqLiteDatabase.close();
        return mLongRecordCounter;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteInsert(
            Context context,
            String recordLanguage,
            String recordPhase,
            String recordCode,
            String recordName,
            String recordGroup,
            String recordCharacteristic,
            String recordText,
            String recordDateCreation,
            String recordDateUpdate,
            String recordDateSync
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_PERSONALITY_RESULT_LANGUAGE, recordLanguage);
            mContentValues.put(FIELD_PERSONALITY_RESULT_PHASE, recordPhase);
            mContentValues.put(FIELD_PERSONALITY_RESULT_CODE, recordCode);
            mContentValues.put(FIELD_PERSONALITY_RESULT_NAME, recordName);
            mContentValues.put(FIELD_PERSONALITY_RESULT_GROUP, recordGroup);
            mContentValues.put(FIELD_PERSONALITY_RESULT_CHARACTERISTIC, recordCharacteristic);
            mContentValues.put(FIELD_PERSONALITY_RESULT_TEXT, recordText);
            mContentValues.put(FIELD_PERSONALITY_RESULT_CREATION, recordDateCreation);
            mContentValues.put(FIELD_PERSONALITY_RESULT_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_PERSONALITY_RESULT_SYNC, recordDateSync);

            mSqLiteDatabase.insert(TABLE_MODULE_PERSONALITY_RESULT, null, mContentValues);
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
    public static void sqliteUpdate(
            Context context,
            int recordId,
            String recordLanguage,
            String recordPhase,
            String recordCode,
            String recordName,
            String recordGroup,
            String recordCharacteristic,
            String recordText,
            String recordDateCreation,
            String recordDateUpdate,
            String recordDateSync
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_PERSONALITY_RESULT_LANGUAGE, recordLanguage);
            mContentValues.put(FIELD_PERSONALITY_RESULT_PHASE, recordPhase);
            mContentValues.put(FIELD_PERSONALITY_RESULT_CODE, recordCode);
            mContentValues.put(FIELD_PERSONALITY_RESULT_NAME, recordName);
            mContentValues.put(FIELD_PERSONALITY_RESULT_GROUP, recordGroup);
            mContentValues.put(FIELD_PERSONALITY_RESULT_CHARACTERISTIC, recordCharacteristic);
            mContentValues.put(FIELD_PERSONALITY_RESULT_TEXT, recordText);
            mContentValues.put(FIELD_PERSONALITY_RESULT_CREATION, recordDateCreation);
            mContentValues.put(FIELD_PERSONALITY_RESULT_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_PERSONALITY_RESULT_SYNC, recordDateSync);

            mSqLiteDatabase.update(TABLE_MODULE_PERSONALITY_RESULT, mContentValues, FIELD_PERSONALITY_RESULT_ID + " = ?", new String[]{String.valueOf(recordId)});
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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PERSONALITY_RESULT;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_ID));
                mSqLiteDatabase.delete(TABLE_MODULE_PERSONALITY_RESULT, FIELD_PERSONALITY_RESULT_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModulePersonalityResult> sqliteGetAll(Context context) {
        
        List<ModelModulePersonalityResult> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PERSONALITY_RESULT
            + SQLITE_COMMAND_WHERE + FIELD_PERSONALITY_RESULT_LANGUAGE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPreferredSettingsLanguage + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModulePersonalityResult(

                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_ID)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_LANGUAGE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_PHASE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_CODE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_NAME)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_GROUP)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_CHARACTERISTIC)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_TEXT)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_CREATION)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_UPDATE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModulePersonalityResult> sqliteGetPhase(Context context, String stringPhase, String stringStatus) {

        List<ModelModulePersonalityResult> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PERSONALITY_RESULT
                + SQLITE_COMMAND_WHERE + FIELD_PERSONALITY_RESULT_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES
                + SQLITE_COMMAND_AND + FIELD_PERSONALITY_RESULT_LANGUAGE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModulePersonalityResult(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_LANGUAGE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_CODE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_NAME)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_GROUP)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_CHARACTERISTIC)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_TEXT)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PERSONALITY_RESULT_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }
}