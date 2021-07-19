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
import com.prosper.day.databasemodel.ModelModuleReflectionAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_PHASE_CODE_09_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_PHASE_CODE_09_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_PHASE_CODE_09_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_PHASE_CODE_09_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_PHASE_CODE_09_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_REAL_PHASES;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NUMBER_CODES;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_TOTAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_AND;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_QUOTES;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_WHERE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_DATE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_DATE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_DATE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_EXPERIENCE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_NUMBER_ACTIONS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_NUMBER_PHOTOS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_NUMBER_POINTS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_NUMBER_SHARING;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_QUESTION_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_REFLECTION_ANSWER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_REFLECTION_ANSWER;

public class SqliteModuleReflectionAnswer {

    private static SQLiteDatabase mSqLiteDatabase;
    private static Cursor mCursor;
    private static ContentValues mContentValues;

    private static String mStringClassName;
    private static String mStringSelectQuery;

    private static int mIntKeyFromSqlite;

    private static long mLongRecordCounter;

    private static int[][] mMultiArrayTotal;

    private static String mGraphPhase;
    private static String mGraphStatus;

    private static int mIndexArrayLine;
    private static int mIndexArrayColumn;

    private static int mIndexTotalLine;
    private static int mIndexTotalColumn;

    // *********************************************************************************************
    // *********************************************************************************************
    public static long sqliteCounter(Context context) {

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();
        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_MODULE_REFLECTION_ANSWER);
        mSqLiteDatabase.close();
        return mLongRecordCounter;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteInsert(
            Context context,
            String recordUserId,
            String recordPhase,
            String recordNumber,
            String recordStatus,
            String recordExperience,
            String recordQuestion,
            String recordAnswer,
            String recordNumberPoints,
            String recordNumberSharing,
            String recordNumberPhotos,
            String recordNumberActions,
            String recordDateCreation,
            String recordDateUpdate,
            String recordDateSync
    
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_REFLECTION_ANSWER_USER_ID, recordUserId);
            mContentValues.put(FIELD_REFLECTION_ANSWER_PHASE, recordPhase);
            mContentValues.put(FIELD_REFLECTION_ANSWER_NUMBER, recordNumber);
            mContentValues.put(FIELD_REFLECTION_ANSWER_STATUS, recordStatus);
            mContentValues.put(FIELD_REFLECTION_ANSWER_EXPERIENCE, recordExperience);
            mContentValues.put(FIELD_REFLECTION_ANSWER_QUESTION_TEXT, recordQuestion);
            mContentValues.put(FIELD_REFLECTION_ANSWER_TEXT, recordAnswer);
            mContentValues.put(FIELD_REFLECTION_ANSWER_NUMBER_POINTS, recordNumberPoints);
            mContentValues.put(FIELD_REFLECTION_ANSWER_NUMBER_SHARING, recordNumberSharing);
            mContentValues.put(FIELD_REFLECTION_ANSWER_NUMBER_PHOTOS, recordNumberPhotos);
            mContentValues.put(FIELD_REFLECTION_ANSWER_NUMBER_ACTIONS, recordNumberActions);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_CREATION, recordDateCreation);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_SYNC, recordDateSync);

            mSqLiteDatabase.insert(TABLE_MODULE_REFLECTION_ANSWER, null, mContentValues);
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
    public static void sqliteUpdateText(
            Context context,
            int recordId,
            String recordAnswer,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();
            
            mContentValues.put(FIELD_REFLECTION_ANSWER_TEXT, recordAnswer);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_REFLECTION_ANSWER, mContentValues, FIELD_REFLECTION_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
    public static void sqliteUpdateNumberPhotos(
            Context context,
            int recordId,
            String recordNumberPhotos,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();
            
            mContentValues.put(FIELD_REFLECTION_ANSWER_NUMBER_PHOTOS, recordNumberPhotos);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_REFLECTION_ANSWER, mContentValues, FIELD_REFLECTION_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
    public static void sqliteUpdateNumberPoints(
            Context context,
            int recordId,
            String recordNumberPoints,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();
            
            mContentValues.put(FIELD_REFLECTION_ANSWER_NUMBER_POINTS, recordNumberPoints);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_REFLECTION_ANSWER, mContentValues, FIELD_REFLECTION_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
    public static void sqliteUpdateNumberActions(
            Context context,
            int recordId,
            String recordNumberActions,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();
            
            mContentValues.put(FIELD_REFLECTION_ANSWER_NUMBER_ACTIONS, recordNumberActions);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_REFLECTION_ANSWER, mContentValues, FIELD_REFLECTION_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
    public static void sqliteUpdateNumberSharing(
            Context context,
            int recordId,
            String recordNumberSharing,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();
            
            mContentValues.put(FIELD_REFLECTION_ANSWER_NUMBER_SHARING, recordNumberSharing);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_REFLECTION_ANSWER, mContentValues, FIELD_REFLECTION_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
    public static void sqliteUpdateStatus(
            Context context,
            int recordId,
            String recordStatus,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();
            
            mContentValues.put(FIELD_REFLECTION_ANSWER_STATUS, recordStatus);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_REFLECTION_ANSWER, mContentValues, FIELD_REFLECTION_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
    public static void sqliteUpdateExperience(
            Context context,
            int recordId,
            String recordExperience,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_REFLECTION_ANSWER_EXPERIENCE, recordExperience);
            mContentValues.put(FIELD_REFLECTION_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_REFLECTION_ANSWER, mContentValues, FIELD_REFLECTION_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_ID));
                mSqLiteDatabase.delete(TABLE_MODULE_REFLECTION_ANSWER, FIELD_REFLECTION_ANSWER_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleReflectionAnswer> sqliteGetAll(Context context, String stringStatus) {

        List<ModelModuleReflectionAnswer> list = new ArrayList<>();

        list.clear();

        switch (stringStatus) {

            case STATUS_ALL:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER;
                break;

            case STATUS_NEW:
            case STATUS_PENDING:
            case STATUS_CLOSED:
            case STATUS_POSTPONED:
            case STATUS_IGNORED:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER
                        + SQLITE_COMMAND_WHERE + FIELD_REFLECTION_ANSWER_STATUS + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;

                break;

            default:
                String className = context.getClass().getName();
                throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + stringStatus);

        }

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleReflectionAnswer(

                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_ID)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_USER_ID)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_PHASE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_STATUS)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_EXPERIENCE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_QUESTION_TEXT)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_TEXT)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_POINTS)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_SHARING)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_PHOTOS)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_ACTIONS)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_DATE_CREATION)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_DATE_UPDATE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_DATE_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleReflectionAnswer> sqliteGetPhase(Context context, String stringPhase, String stringStatus) {

        List<ModelModuleReflectionAnswer> list = new ArrayList<>();

        list.clear();

        switch (stringStatus) {

            case STATUS_ALL:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER
                        + SQLITE_COMMAND_WHERE + FIELD_REFLECTION_ANSWER_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES;

                break;

            case STATUS_NEW:
            case STATUS_PENDING:
            case STATUS_CLOSED:
            case STATUS_POSTPONED:
            case STATUS_IGNORED:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER
                        + SQLITE_COMMAND_WHERE + FIELD_REFLECTION_ANSWER_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES
                        + SQLITE_COMMAND_AND + FIELD_REFLECTION_ANSWER_STATUS + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;

                break;

            default:
                String className = context.getClass().getName();
                throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + stringStatus);

        }

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleReflectionAnswer(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_STATUS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_EXPERIENCE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_QUESTION_TEXT)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_TEXT)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_POINTS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_SHARING)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_PHOTOS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_ACTIONS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_DATE_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_DATE_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_DATE_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleReflectionAnswer> sqliteGetOne(Context context, String mStringRecordId) {

        List<ModelModuleReflectionAnswer> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_REFLECTION_ANSWER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + mStringRecordId + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleReflectionAnswer(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_STATUS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_EXPERIENCE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_QUESTION_TEXT)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_TEXT)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_POINTS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_SHARING)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_PHOTOS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_NUMBER_ACTIONS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_DATE_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_DATE_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_DATE_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteDeleteOne(
            Context context,
            int recordId) {

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_REFLECTION_ANSWER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + recordId + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mSqLiteDatabase.delete(TABLE_MODULE_REFLECTION_ANSWER, FIELD_REFLECTION_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteGraphEvolution(Context context) {

        INT_GRAPH_VALUE_TOTAL = 0;
        INT_GRAPH_VALUE_01 = 0;
        INT_GRAPH_VALUE_02 = 0;
        INT_GRAPH_VALUE_03 = 0;
        INT_GRAPH_VALUE_04 = 0;
        INT_GRAPH_VALUE_05 = 0;

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphStatus = mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_STATUS));

                INT_GRAPH_VALUE_TOTAL++;

                switch (graphStatus) {

                    case STATUS_NEW:
                        INT_GRAPH_VALUE_01++;
                        break;

                    case STATUS_PENDING:
                        INT_GRAPH_VALUE_02++;
                        break;

                    case STATUS_CLOSED:
                        INT_GRAPH_VALUE_03++;
                        break;

                    case STATUS_IGNORED:
                        INT_GRAPH_VALUE_04++;
                        break;

                    case STATUS_POSTPONED:
                        INT_GRAPH_VALUE_05++;
                        break;

                    default:
                        String className = context.getClass().getName();
                        throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + graphStatus);

                }

            } while (mCursor.moveToNext());

        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteGraphAnalysis(Context context) {

        INT_GRAPH_VALUE_TOTAL = 0;
        INT_GRAPH_VALUE_01 = 0;
        INT_GRAPH_VALUE_02 = 0;
        INT_GRAPH_VALUE_03 = 0;
        INT_GRAPH_VALUE_04 = 0;
        INT_GRAPH_VALUE_05 = 0;

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphPhase = mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_PHASE));

                INT_GRAPH_VALUE_TOTAL++;

                switch (graphPhase) {

                    case REFLECTION_PHASE_CODE_09_01:
                        INT_GRAPH_VALUE_01++;
                        break;

                    case REFLECTION_PHASE_CODE_09_02:
                        INT_GRAPH_VALUE_02++;
                        break;

                    case REFLECTION_PHASE_CODE_09_03:
                        INT_GRAPH_VALUE_03++;
                        break;

                    case REFLECTION_PHASE_CODE_09_04:
                        INT_GRAPH_VALUE_04++;
                        break;

                    case REFLECTION_PHASE_CODE_09_05:
                        INT_GRAPH_VALUE_05++;
                        break;

                    default:
                        String className = context.getClass().getName();
                        throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + graphPhase);

                }

            } while (mCursor.moveToNext());

        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static int[][] sqliteReportAnalysis(Context context) {

        INT_GRAPH_VALUE_TOTAL = 0;

        initializeMultidimensionalArray();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_REFLECTION_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                INT_GRAPH_VALUE_TOTAL++;

                mGraphPhase = mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_PHASE));
                mGraphStatus = mCursor.getString(mCursor.getColumnIndex(FIELD_REFLECTION_ANSWER_STATUS));

                computeStatusByPhase(context);

            } while (mCursor.moveToNext());

        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return mMultiArrayTotal;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private static void initializeMultidimensionalArray() {

        mIndexTotalLine = REFLECTION_REAL_PHASES;
        mIndexTotalColumn = STATUS_NUMBER_CODES;

        mMultiArrayTotal = new int[mIndexTotalLine] [mIndexTotalColumn];

        for(mIndexArrayLine = 0; mIndexArrayLine < mIndexTotalLine; mIndexArrayLine++){

            for(mIndexArrayColumn = 0; mIndexArrayColumn < mIndexTotalColumn; mIndexArrayColumn++){

                mMultiArrayTotal[mIndexArrayLine] [mIndexArrayColumn] = INT_NUMBER_00;

            }

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private static void computeStatusByPhase(Context context) {

        switch (mGraphPhase) {

            case REFLECTION_PHASE_CODE_09_01:
                mIndexArrayLine = 0;
                break;

            case REFLECTION_PHASE_CODE_09_02:
                mIndexArrayLine = 1;
                break;

            case REFLECTION_PHASE_CODE_09_03:
                mIndexArrayLine = 2;
                break;

            case REFLECTION_PHASE_CODE_09_04:
                mIndexArrayLine = 3;
                break;

            case REFLECTION_PHASE_CODE_09_05:
                mIndexArrayLine = 4;
                break;

            default:
                String className = context.getClass().getName();
                throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + mGraphPhase);

        }

        switch (mGraphStatus) {

            case STATUS_NEW:
                mIndexArrayColumn = 0;
                break;

            case STATUS_PENDING:
                mIndexArrayColumn = 1;
                break;

            case STATUS_CLOSED:
                mIndexArrayColumn = 2;
                break;

            case STATUS_IGNORED:
                mIndexArrayColumn = 3;
                break;

            case STATUS_POSTPONED:
                mIndexArrayColumn = 4;
                break;

            default:
                String className = context.getClass().getName();
                throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + mGraphStatus);

        }

        mMultiArrayTotal[mIndexArrayLine] [mIndexArrayColumn] = mMultiArrayTotal[mIndexArrayLine] [mIndexArrayColumn] + 1;

    }
}