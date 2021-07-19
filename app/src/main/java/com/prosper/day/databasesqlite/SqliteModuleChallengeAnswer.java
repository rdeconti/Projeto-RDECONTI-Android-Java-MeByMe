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
import com.prosper.day.databasemodel.ModelModuleChallengeAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_HIGH;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_LOW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_MEDIUM;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_DAILY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_MONTHLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_WEEKLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_YEARLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_HIGH;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_LOW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_MEDIUM;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_TOTAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_AND;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_QUOTES;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_WHERE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_COSTS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_DATE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_DATE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_DATE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_EXPERIENCE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_FREQUENCY;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_NUMBER_ACTIONS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_NUMBER_PHOTOS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_NUMBER_POINTS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_NUMBER_SHARING;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_PRIORITY;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_CHALLENGE_ANSWER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_CHALLENGE_ANSWER;

public class SqliteModuleChallengeAnswer {

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
        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_MODULE_CHALLENGE_ANSWER);
        mSqLiteDatabase.close();
        return mLongRecordCounter;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteInsert(
            Context context,
            String recordUserId,
            String recordNumber,
            String recordStatus,
            String recordExperience,
            String recordPriority,
            String recordFrequency,
            String recordCosts,
            String recordQuestion,
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

            mContentValues.put(FIELD_CHALLENGE_ANSWER_USER_ID, recordUserId);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_NUMBER, recordNumber);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_STATUS, recordStatus);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_EXPERIENCE, recordExperience);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_PRIORITY, recordPriority);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_FREQUENCY, recordFrequency);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_COSTS, recordCosts);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_QUESTION, recordQuestion);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_NUMBER_POINTS, recordNumberPoints);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_NUMBER_SHARING, recordNumberSharing);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_NUMBER_PHOTOS, recordNumberPhotos);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_NUMBER_ACTIONS, recordNumberActions);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_CREATION, recordDateCreation);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_SYNC, recordDateSync);

            mSqLiteDatabase.insert(TABLE_MODULE_CHALLENGE_ANSWER, null, mContentValues);
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
            
            mContentValues.put(FIELD_CHALLENGE_ANSWER_NUMBER_PHOTOS, recordNumberPhotos);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_CHALLENGE_ANSWER, mContentValues, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
            
            mContentValues.put(FIELD_CHALLENGE_ANSWER_NUMBER_POINTS, recordNumberPoints);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_CHALLENGE_ANSWER, mContentValues, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
            
            mContentValues.put(FIELD_CHALLENGE_ANSWER_NUMBER_ACTIONS, recordNumberActions);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_CHALLENGE_ANSWER, mContentValues, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
            
            mContentValues.put(FIELD_CHALLENGE_ANSWER_NUMBER_SHARING, recordNumberSharing);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_CHALLENGE_ANSWER, mContentValues, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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

            mContentValues.put(FIELD_CHALLENGE_ANSWER_STATUS, recordStatus);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_CHALLENGE_ANSWER, mContentValues, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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

            mContentValues.put(FIELD_CHALLENGE_ANSWER_EXPERIENCE, recordExperience);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_CHALLENGE_ANSWER, mContentValues, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
    public static void sqliteUpdateFrequency(
            Context context,
            int recordId,
            String recordFrequency,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();
            
            mContentValues.put(FIELD_CHALLENGE_ANSWER_FREQUENCY, recordFrequency);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_CHALLENGE_ANSWER, mContentValues, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
    public static void sqliteUpdateCosts(
            Context context,
            int recordId,
            String recordCosts,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();
            
            mContentValues.put(FIELD_CHALLENGE_ANSWER_COSTS, recordCosts);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_CHALLENGE_ANSWER, mContentValues, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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
    public static void sqliteUpdatePriority(
            Context context,
            int recordId,
            String recordPriority,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();
            
            mContentValues.put(FIELD_CHALLENGE_ANSWER_PRIORITY, recordPriority);
            mContentValues.put(FIELD_CHALLENGE_ANSWER_DATE_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_MODULE_CHALLENGE_ANSWER, mContentValues, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});
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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_ID));
                mSqLiteDatabase.delete(TABLE_MODULE_CHALLENGE_ANSWER, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleChallengeAnswer> sqliteGetAll(Context context, String stringStatus) {
        
        List<ModelModuleChallengeAnswer> list = new ArrayList<>();

        list.clear();

        switch (stringStatus) {

            case STATUS_ALL:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER;
                break;

            case STATUS_NEW:
            case STATUS_PENDING:
            case STATUS_CLOSED:
            case STATUS_POSTPONED:
            case STATUS_IGNORED:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                        + SQLITE_COMMAND_WHERE + FIELD_CHALLENGE_ANSWER_STATUS + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;

                break;

            case COSTS_NONE:
            case COSTS_HIGH:
            case COSTS_MEDIUM:
            case COSTS_LOW:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                        + SQLITE_COMMAND_WHERE + FIELD_CHALLENGE_ANSWER_COSTS + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;
                break;

            case PRIORITY_NONE:
            case PRIORITY_HIGH:
            case PRIORITY_MEDIUM:
            case PRIORITY_LOW:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                        + SQLITE_COMMAND_WHERE + FIELD_CHALLENGE_ANSWER_PRIORITY + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;
                break;

            case FREQUENCY_NONE:
            case FREQUENCY_DAILY:
            case FREQUENCY_WEEKLY:
            case FREQUENCY_MONTHLY:
            case FREQUENCY_YEARLY:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                        + SQLITE_COMMAND_WHERE + FIELD_CHALLENGE_ANSWER_FREQUENCY + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;
                break;

            default:
                String className = context.getClass().getName();
                throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + stringStatus);

        }

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleChallengeAnswer(

                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_ID)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_USER_ID)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_STATUS)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_EXPERIENCE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_PRIORITY)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_FREQUENCY)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_COSTS)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_QUESTION)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_POINTS)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_SHARING)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_PHOTOS)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_ACTIONS)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_DATE_CREATION)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_DATE_UPDATE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_DATE_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleChallengeAnswer> sqliteGetPhase(Context context, String stringPhase, String stringStatus) {
        
        List<ModelModuleChallengeAnswer> list = new ArrayList<>();

        list.clear();

        switch (stringStatus) {

            case STATUS_ALL:
            case STATUS_NEW:
            case STATUS_PENDING:
            case STATUS_CLOSED:
            case STATUS_POSTPONED:
            case STATUS_IGNORED:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                        + SQLITE_COMMAND_AND + FIELD_CHALLENGE_ANSWER_STATUS + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;

                break;

            case COSTS_NONE:
            case COSTS_HIGH:
            case COSTS_MEDIUM:
            case COSTS_LOW:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                        + SQLITE_COMMAND_AND + FIELD_CHALLENGE_ANSWER_COSTS + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;
                break;

            case PRIORITY_NONE:
            case PRIORITY_HIGH:
            case PRIORITY_MEDIUM:
            case PRIORITY_LOW:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                        + SQLITE_COMMAND_AND + FIELD_CHALLENGE_ANSWER_PRIORITY + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;
                break;

            case FREQUENCY_NONE:
            case FREQUENCY_DAILY:
            case FREQUENCY_WEEKLY:
            case FREQUENCY_MONTHLY:
            case FREQUENCY_YEARLY:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                        + SQLITE_COMMAND_WHERE + FIELD_CHALLENGE_ANSWER_FREQUENCY + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringStatus + SQLITE_COMMAND_QUOTES;
                break;

            default:
                String className = context.getClass().getName();
                throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + stringStatus);

        }

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleChallengeAnswer(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_STATUS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_EXPERIENCE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_PRIORITY)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_FREQUENCY)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_COSTS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_QUESTION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_POINTS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_SHARING)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_PHOTOS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_ACTIONS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_DATE_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_DATE_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_DATE_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleChallengeAnswer> sqliteGetOne(Context context, String mStringRecordId) {
        
        List<ModelModuleChallengeAnswer> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_CHALLENGE_ANSWER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + mStringRecordId + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleChallengeAnswer(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_STATUS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_EXPERIENCE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_PRIORITY)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_FREQUENCY)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_COSTS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_QUESTION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_POINTS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_SHARING)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_PHOTOS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_NUMBER_ACTIONS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_DATE_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_DATE_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_DATE_SYNC))));

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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_CHALLENGE_ANSWER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + recordId + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mSqLiteDatabase.delete(TABLE_MODULE_CHALLENGE_ANSWER, FIELD_CHALLENGE_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});

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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphStatus = mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_STATUS));

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
    public static void sqliteGraphEvolution(Context context) {

        INT_GRAPH_VALUE_TOTAL = 0;
        INT_GRAPH_VALUE_01 = 0;
        INT_GRAPH_VALUE_02 = 0;
        INT_GRAPH_VALUE_03 = 0;
        INT_GRAPH_VALUE_04 = 0;
        INT_GRAPH_VALUE_05 = 0;

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphStatus = mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_STATUS));

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
    public static void sqliteGraphCosts(Context context) {

        INT_GRAPH_VALUE_TOTAL = 0;
        INT_GRAPH_VALUE_01 = 0;
        INT_GRAPH_VALUE_02 = 0;
        INT_GRAPH_VALUE_03 = 0;
        INT_GRAPH_VALUE_04 = 0;

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphCosts = mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_COSTS));

                INT_GRAPH_VALUE_TOTAL++;

                switch (graphCosts) {

                    case COSTS_NONE:
                        INT_GRAPH_VALUE_01++;
                        break;

                    case COSTS_LOW:
                        INT_GRAPH_VALUE_02++;
                        break;

                    case COSTS_MEDIUM:
                        INT_GRAPH_VALUE_03++;
                        break;

                    case COSTS_HIGH:
                        INT_GRAPH_VALUE_04++;
                        break;

                    default:
                        String className = context.getClass().getName();
                        throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + graphCosts);

                }

            } while (mCursor.moveToNext());

        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteGraphPriority(Context context) {

        INT_GRAPH_VALUE_TOTAL = 0;
        INT_GRAPH_VALUE_01 = 0;
        INT_GRAPH_VALUE_02 = 0;
        INT_GRAPH_VALUE_03 = 0;
        INT_GRAPH_VALUE_04 = 0;

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphPriority = mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_PRIORITY));

                INT_GRAPH_VALUE_TOTAL++;

                switch (graphPriority) {

                    case PRIORITY_NONE:
                        INT_GRAPH_VALUE_01++;
                        break;

                    case PRIORITY_LOW:
                        INT_GRAPH_VALUE_02++;
                        break;

                    case PRIORITY_MEDIUM:
                        INT_GRAPH_VALUE_03++;
                        break;

                    case PRIORITY_HIGH:
                        INT_GRAPH_VALUE_04++;
                        break;

                    default:
                        String className = context.getClass().getName();
                        throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + stringCurrentPhaseCode);

                }

            } while (mCursor.moveToNext());

        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteGraphFrequency(Context context) {

        INT_GRAPH_VALUE_TOTAL = 0;
        INT_GRAPH_VALUE_01 = 0;
        INT_GRAPH_VALUE_02 = 0;
        INT_GRAPH_VALUE_03 = 0;
        INT_GRAPH_VALUE_04 = 0;
        INT_GRAPH_VALUE_05 = 0;

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_CHALLENGE_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphFrequency = mCursor.getString(mCursor.getColumnIndex(FIELD_CHALLENGE_ANSWER_FREQUENCY));

                INT_GRAPH_VALUE_TOTAL++;

                switch (graphFrequency) {

                    case FREQUENCY_NONE:
                        INT_GRAPH_VALUE_01++;
                        break;

                    case FREQUENCY_DAILY:
                        INT_GRAPH_VALUE_02++;
                        break;

                    case FREQUENCY_WEEKLY:
                        INT_GRAPH_VALUE_03++;
                        break;

                    case FREQUENCY_MONTHLY:
                        INT_GRAPH_VALUE_04++;
                        break;

                    case FREQUENCY_YEARLY:
                        INT_GRAPH_VALUE_05++;
                        break;

                    default:
                        String className = context.getClass().getName();
                        throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + graphFrequency);

                }

            } while (mCursor.moveToNext());

        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

}