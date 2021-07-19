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
import com.prosper.day.databasemodel.ModelSupportPointsUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.ACTION_PHASE_CODE_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.AUTOBIOGRAPHY_PHASE_CODE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BIORHYTHM_PHASE_CODE_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.CHALLENGE_PHASE_CODE_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.DIARY_PHASE_CODE_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.LIFE_PHASE_CODE_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MOOD_PHASE_CODE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PERSONALITY_PHASE_CODE_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.RECOGNITION_PHASE_CODE_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.REFLECTION_PHASE_CODE_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_ALL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_DONE_VALUE_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_TOTAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_AND;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_QUOTES;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_WHERE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_POINTS_USER;

public class SqliteSupportPointsUser {

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
        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_SUPPORT_POINTS_USER);
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

            mContentValues.put(FIELD_SUPPORT_POINTS_USER_USER_ID, recordUserId);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_PHASE, recordPhase);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_NUMBER, recordNumber);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_STATUS, recordStatus);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS, recordNumberPoints);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS, recordNumberSharing);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS, recordNumberPhotos);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS, recordNumberActions);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_CREATION, recordDateCreation);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_SYNC, recordDateSync);

            mSqLiteDatabase.insert(TABLE_SUPPORT_POINTS_USER, null, mContentValues);
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
            String recordPhase,
            String recordNumber,
            String recordNumberPoints,                  // Number of points of phase
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS, recordNumberPoints);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_POINTS_USER, mContentValues, FIELD_SUPPORT_POINTS_USER_PHASE + " = ? AND " + FIELD_SUPPORT_POINTS_USER_NUMBER + " = ?", new String[]{recordPhase, recordNumber});
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
            String recordPhase,
            String recordNumber,
            String recordNumberSharing,                 // Number of Sharings done by user
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS, recordNumberSharing);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_POINTS_USER, mContentValues, FIELD_SUPPORT_POINTS_USER_PHASE + " = ? AND " + FIELD_SUPPORT_POINTS_USER_NUMBER + " = ?", new String[]{recordPhase, recordNumber});
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
            String recordPhase,
            String recordNumber,
            String recordNumberPhotos,                  // Number of Photos taken by user
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS, recordNumberPhotos);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_POINTS_USER, mContentValues, FIELD_SUPPORT_POINTS_USER_PHASE + " = ? AND " + FIELD_SUPPORT_POINTS_USER_NUMBER + " = ?", new String[]{recordPhase, recordNumber});
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
            String recordPhase,
            String recordNumber,
            String recordNumberActions,                 // Number of Actions taken by user
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS, recordNumberActions);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_POINTS_USER, mContentValues, FIELD_SUPPORT_POINTS_USER_PHASE + " = ? AND " + FIELD_SUPPORT_POINTS_USER_NUMBER + " = ?", new String[]{recordPhase, recordNumber});
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
            String recordPhase,
            String recordNumber,
            String recordStatus,                        // Status
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_POINTS_USER_STATUS, recordStatus);
            mContentValues.put(FIELD_SUPPORT_POINTS_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_POINTS_USER, mContentValues, FIELD_SUPPORT_POINTS_USER_PHASE + " = ? AND " + FIELD_SUPPORT_POINTS_USER_NUMBER + " = ?", new String[]{recordPhase, recordNumber});
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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_POINTS_USER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_ID));
                mSqLiteDatabase.delete(TABLE_SUPPORT_POINTS_USER, FIELD_SUPPORT_POINTS_USER_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportPointsUser> sqliteGetAll(Context context) {

        List<ModelSupportPointsUser> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_POINTS_USER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelSupportPointsUser(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_STATUS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportPointsUser> sqliteGetPhase(Context context, String stringPhase, String stringStatus) {

        List<ModelSupportPointsUser> list = new ArrayList<>();

        list.clear();

        switch (stringStatus) {

            case STATUS_ALL:
            case STATUS_NEW:
            case STATUS_PENDING:
            case STATUS_CLOSED:
            case STATUS_POSTPONED:
            case STATUS_IGNORED:
                mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_POINTS_USER
                        + SQLITE_COMMAND_WHERE + FIELD_SUPPORT_POINTS_USER_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES;

                break;

            default:
                String className = context.getClass().getName();
                throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + stringStatus);

        }

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelSupportPointsUser(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_STATUS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportPointsUser> sqliteGetOne(Context context, String stringPhase, String stringNumber) {

        List<ModelSupportPointsUser> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_POINTS_USER
                + SQLITE_COMMAND_WHERE + FIELD_SUPPORT_POINTS_USER_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES
                + SQLITE_COMMAND_AND + FIELD_SUPPORT_POINTS_USER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringNumber + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelSupportPointsUser(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_STATUS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_POINTS_USER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphStatus = mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_STATUS));

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
        INT_GRAPH_VALUE_06 = 0;
        INT_GRAPH_VALUE_07 = 0;
        INT_GRAPH_VALUE_08 = 0;
        INT_GRAPH_VALUE_09 = 0;
        INT_GRAPH_VALUE_10 = 0;
        INT_GRAPH_VALUE_11 = 0;
        INT_GRAPH_VALUE_12 = 0;

        INT_DONE_VALUE_01 = 0;
        INT_DONE_VALUE_02 = 0;
        INT_DONE_VALUE_03 = 0;
        INT_DONE_VALUE_04 = 0;
        INT_DONE_VALUE_05 = 0;
        INT_DONE_VALUE_06 = 0;
        INT_DONE_VALUE_07 = 0;
        INT_DONE_VALUE_08 = 0;
        INT_DONE_VALUE_09 = 0;
        INT_DONE_VALUE_10 = 0;
        INT_DONE_VALUE_11 = 0;
        INT_DONE_VALUE_12 = 0;

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_POINTS_USER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphPhase = mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_PHASE));
                String graphStatus = mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_POINTS_USER_STATUS));

                INT_GRAPH_VALUE_TOTAL++;

                String graphPhaseCode = graphPhase.substring(0, 2);

                switch (graphPhaseCode) {

                    case MOOD_PHASE_CODE_02:
                        INT_GRAPH_VALUE_01++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_01++;
                        }
                        break;

                    case AUTOBIOGRAPHY_PHASE_CODE_03:
                        INT_GRAPH_VALUE_02++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_02++;
                        }
                        break;

                    case RECOGNITION_PHASE_CODE_04:
                        INT_GRAPH_VALUE_03++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_03++;
                        }
                        break;

                    case BELIEF_PHASE_CODE_05:
                        INT_GRAPH_VALUE_04++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_04++;
                        }
                        break;

                    case PERSONALITY_PHASE_CODE_06:
                        INT_GRAPH_VALUE_05++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_05++;
                        }
                        break;

                    case LIFE_PHASE_CODE_07:
                        INT_GRAPH_VALUE_06++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_06++;
                        }
                        break;

                    case ACTION_PHASE_CODE_08:
                        INT_GRAPH_VALUE_07++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_07++;
                        }
                        break;

                    case REFLECTION_PHASE_CODE_09:
                        INT_GRAPH_VALUE_08++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_08++;
                        }
                        break;

                    case BIORHYTHM_PHASE_CODE_10:
                        INT_GRAPH_VALUE_09++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_09++;
                        }
                        break;

                    case CHALLENGE_PHASE_CODE_11:
                        INT_GRAPH_VALUE_10++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_10++;
                        }
                        break;

                    case DIARY_PHASE_CODE_12:
                        INT_GRAPH_VALUE_11++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_11++;
                        }
                        break;

                    case YOU_PHASE_CODE_19:
                        INT_GRAPH_VALUE_12++;
                        if (graphStatus.equals(STATUS_CLOSED)) {
                            INT_DONE_VALUE_12++;
                        }
                        break;

                    default:
                        String className = context.getClass().getName();
                        throw new IllegalStateException(context.getString(R.string.message_unexpected_value) + className + " " + graphPhaseCode);

                }

            } while (mCursor.moveToNext());

        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }
}