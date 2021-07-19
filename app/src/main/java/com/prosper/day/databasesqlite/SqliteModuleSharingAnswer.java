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
import com.prosper.day.databasemodel.ModelModuleSharingAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.SHARING_PHASE_CODE_15_19;
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
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_13;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_GRAPH_VALUE_TOTAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_QUOTES;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_WHERE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SHARING_ANSWER_DATE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SHARING_ANSWER_DATE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SHARING_ANSWER_DATE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SHARING_ANSWER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SHARING_ANSWER_IMAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SHARING_ANSWER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SHARING_ANSWER_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SHARING_ANSWER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_SHARING_ANSWER;

public class SqliteModuleSharingAnswer {

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
        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_MODULE_SHARING_ANSWER);
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
            String recordDateCreation,
            String recordDateUpdate,
            String recordDateSync,
            byte[] recordImage
    
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SHARING_ANSWER_USER_ID, recordUserId);
            mContentValues.put(FIELD_SHARING_ANSWER_PHASE, recordPhase);
            mContentValues.put(FIELD_SHARING_ANSWER_NUMBER, recordNumber);
            mContentValues.put(FIELD_SHARING_ANSWER_DATE_CREATION, recordDateCreation);
            mContentValues.put(FIELD_SHARING_ANSWER_DATE_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_SHARING_ANSWER_DATE_SYNC, recordDateSync);
            mContentValues.put(FIELD_SHARING_ANSWER_IMAGE, recordImage);

            mSqLiteDatabase.insert(TABLE_MODULE_SHARING_ANSWER, null, mContentValues);
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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_SHARING_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_ID));
                mSqLiteDatabase.delete(TABLE_MODULE_SHARING_ANSWER, FIELD_SHARING_ANSWER_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleSharingAnswer> sqliteGetAll(Context context) {
        
        List<ModelModuleSharingAnswer> list = new ArrayList<>();

        list.clear();
        
        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_SHARING_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleSharingAnswer(

                    mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_ID)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_USER_ID)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_PHASE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_NUMBER)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_DATE_CREATION)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_DATE_UPDATE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_DATE_SYNC)),
                    mCursor.getBlob(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_IMAGE))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleSharingAnswer> sqliteGetPhase(Context context, String stringPhase) {
        
        List<ModelModuleSharingAnswer> list = new ArrayList<>();

        list.clear();
        
        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_SHARING_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_SHARING_ANSWER_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleSharingAnswer(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_DATE_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_DATE_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_DATE_SYNC)),
                        mCursor.getBlob(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_IMAGE))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleSharingAnswer> sqliteGetOne(Context context, String mStringRecordId) {

        List<ModelModuleSharingAnswer> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_SHARING_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_SHARING_ANSWER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + mStringRecordId + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModuleSharingAnswer(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_DATE_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_DATE_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_DATE_SYNC)),
                        mCursor.getBlob(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_IMAGE))));

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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_SHARING_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_SHARING_ANSWER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + recordId + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mSqLiteDatabase.delete(TABLE_MODULE_SHARING_ANSWER, FIELD_SHARING_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});

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
        INT_GRAPH_VALUE_13 = 0;

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_SHARING_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphPhaseCode = mCursor.getString(mCursor.getColumnIndex(FIELD_SHARING_ANSWER_PHASE));

                INT_GRAPH_VALUE_TOTAL++;

                switch (graphPhaseCode) {

                    case SHARING_PHASE_CODE_15_02:
                        INT_GRAPH_VALUE_01++;
                        break;

                    case SHARING_PHASE_CODE_15_03:
                        INT_GRAPH_VALUE_02++;
                        break;

                    case SHARING_PHASE_CODE_15_04:
                        INT_GRAPH_VALUE_03++;
                        break;

                    case SHARING_PHASE_CODE_15_05:
                        INT_GRAPH_VALUE_04++;
                        break;

                    case SHARING_PHASE_CODE_15_06:
                        INT_GRAPH_VALUE_05++;
                        break;

                    case SHARING_PHASE_CODE_15_07:
                        INT_GRAPH_VALUE_06++;
                        break;

                    case SHARING_PHASE_CODE_15_09:
                        INT_GRAPH_VALUE_07++;
                        break;

                    case SHARING_PHASE_CODE_15_10:
                        INT_GRAPH_VALUE_10++;
                        break;

                    case SHARING_PHASE_CODE_15_11:
                        INT_GRAPH_VALUE_11++;
                        break;

                    case SHARING_PHASE_CODE_15_12:
                        INT_GRAPH_VALUE_12++;
                        break;

                    case SHARING_PHASE_CODE_15_19:
                        INT_GRAPH_VALUE_13++;
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