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
import com.prosper.day.databasemodel.ModelModulePhotoAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.PHOTO_PHASE_CODE_14_19;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.globalStringArrayList;
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
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_AND;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_QUOTES;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_WHERE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_DATE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_DATE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_DATE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_IMAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PHOTO_ANSWER;

public class SqliteModulePhotoAnswer {

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
        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_MODULE_PHOTO_ANSWER);
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

            mContentValues.put(FIELD_PHOTO_ANSWER_USER_ID, recordUserId);
            mContentValues.put(FIELD_PHOTO_ANSWER_PHASE, recordPhase);
            mContentValues.put(FIELD_PHOTO_ANSWER_NUMBER, recordNumber);
            mContentValues.put(FIELD_PHOTO_ANSWER_DATE_CREATION, recordDateCreation);
            mContentValues.put(FIELD_PHOTO_ANSWER_DATE_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_PHOTO_ANSWER_DATE_SYNC, recordDateSync);
            mContentValues.put(FIELD_PHOTO_ANSWER_IMAGE, recordImage);

            mSqLiteDatabase.insert(TABLE_MODULE_PHOTO_ANSWER, null, mContentValues);
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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PHOTO_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_ID));
                mSqLiteDatabase.delete(TABLE_MODULE_PHOTO_ANSWER, FIELD_PHOTO_ANSWER_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModulePhotoAnswer> sqliteGetAll(Context context) {

        List<ModelModulePhotoAnswer> list = new ArrayList<>();

        list.clear();
        
        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PHOTO_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModulePhotoAnswer(

                    mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_ID)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_USER_ID)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_PHASE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_NUMBER)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_CREATION)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_UPDATE)),
                    mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_SYNC)),
                    mCursor.getBlob(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_IMAGE))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModulePhotoAnswer> sqliteGetPhase(Context context, String stringPhase) {
        
        List<ModelModulePhotoAnswer> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PHOTO_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_PHOTO_ANSWER_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhase + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModulePhotoAnswer(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_SYNC)),
                        mCursor.getBlob(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_IMAGE))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModulePhotoAnswer> sqliteGetOne(Context context, String mStringRecordId) {
        
        List<ModelModulePhotoAnswer> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PHOTO_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_PHOTO_ANSWER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + mStringRecordId + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModulePhotoAnswer(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_PHASE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_NUMBER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_SYNC)),
                        mCursor.getBlob(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_IMAGE))));

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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PHOTO_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_PHOTO_ANSWER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + recordId + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mSqLiteDatabase.delete(TABLE_MODULE_PHOTO_ANSWER, FIELD_PHOTO_ANSWER_ID + " = ?", new String[]{String.valueOf(recordId)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static ArrayList<byte[]> sqliteGetImage(Context context, String stringPhotoPhase, String stringPhotoNumber) {

        globalStringArrayList = new ArrayList<>();
        globalStringArrayList.clear();

        ArrayList<byte[]> photoArrayList = new ArrayList<>();
        photoArrayList.clear();

        List<ModelModulePhotoAnswer> list = new ArrayList<>();
        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PHOTO_ANSWER
                + SQLITE_COMMAND_WHERE + FIELD_PHOTO_ANSWER_PHASE + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhotoPhase + SQLITE_COMMAND_QUOTES
                + SQLITE_COMMAND_AND + FIELD_PHOTO_ANSWER_NUMBER + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + stringPhotoNumber + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelModulePhotoAnswer(

                mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_ID)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_USER_ID)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_PHASE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_NUMBER)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_CREATION)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_UPDATE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_DATE_SYNC)),
                mCursor.getBlob(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_IMAGE))));

                globalStringArrayList.add(mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_ID)));
                photoArrayList.add(mCursor.getBlob(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_IMAGE)));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return photoArrayList;

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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_MODULE_PHOTO_ANSWER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                String graphPhaseCode = mCursor.getString(mCursor.getColumnIndex(FIELD_PHOTO_ANSWER_PHASE));

                INT_GRAPH_VALUE_TOTAL++;

                switch (graphPhaseCode) {

                    case PHOTO_PHASE_CODE_14_02:
                        INT_GRAPH_VALUE_01++;
                        break;

                    case PHOTO_PHASE_CODE_14_03:
                        INT_GRAPH_VALUE_02++;
                        break;

                    case PHOTO_PHASE_CODE_14_04:
                        INT_GRAPH_VALUE_03++;
                        break;

                    case PHOTO_PHASE_CODE_14_05:
                        INT_GRAPH_VALUE_04++;
                        break;

                    case PHOTO_PHASE_CODE_14_06:
                        INT_GRAPH_VALUE_05++;
                        break;

                    case PHOTO_PHASE_CODE_14_07:
                        INT_GRAPH_VALUE_06++;
                        break;

                    case PHOTO_PHASE_CODE_14_09:
                        INT_GRAPH_VALUE_07++;
                        break;

                    case PHOTO_PHASE_CODE_14_10:
                        INT_GRAPH_VALUE_10++;
                        break;

                    case PHOTO_PHASE_CODE_14_11:
                        INT_GRAPH_VALUE_11++;
                        break;

                    case PHOTO_PHASE_CODE_14_12:
                        INT_GRAPH_VALUE_12++;
                        break;

                    case PHOTO_PHASE_CODE_14_19:
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