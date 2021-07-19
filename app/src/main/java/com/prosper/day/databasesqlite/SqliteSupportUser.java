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
import android.util.Log;

import com.prosper.day.applicationsupportclasses.SupportHandlingExceptionError;
import com.prosper.day.databasedefinition.SqliteConnectionFactory;
import com.prosper.day.databasemodel.ModelSupportUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_ASTERISK;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_EQUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_QUOTES;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_SELECT;
import static com.prosper.day.databasedefinition.SqliteDatabaseCommand.SQLITE_COMMAND_WHERE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_TYPE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_VERSION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_BIRTHDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_BIRTH_COUNTRY;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_COMPLETE_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_EMAIL;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_FIRST_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_GENDER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_HEIGHT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_LAST_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_MARITAL_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_NICKNAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PASSWORD_BLOCKED;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PASSWORD_FREQUENCY;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PHOTO;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_RACE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_RELIGION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_RESET_LAST;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SCHOLARSHIP;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SEXUAL_OPTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SYNC_LAST;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SYNC_NEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_WEIGHT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_USER;

public class SqliteSupportUser {

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
        mLongRecordCounter = DatabaseUtils.queryNumEntries(mSqLiteDatabase, TABLE_SUPPORT_USER);

        return mLongRecordCounter;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void sqliteInsert(
            Context context,
            String recordUserLanguage,
            String recordUserFirstName,
            String recordUserLastName,
            String recordUserCompleteName,
            String recordUserNickName,
            String recordUserBirthdate,
            String recordUserBirthCountry,
            String recordUserGender,
            String recordUserSexualOption,
            String recordUserRace,
            String recordUserMaritalStatus,
            String recordUserReligion,
            String recordUserScholarity,
            String recordUserHeight,
            String recordUserWeight,
            String recordUserEmail,
            byte[] recordUserPhoto,
            String recordPasswordChangeLast,
            String recordPasswordChangeNext,
            String recordPasswordChangeFrequency,
            String recordPasswordBlocked,
            String recordDatabaseSyncLast,
            String recordDatabaseSyncNext,
            String recordDatabaseReset,
            String recordApplicationLanguage,
            String recordApplicationVersion,
            String recordApplicationType,
            String recordApplicationDonationDate,
            String recordApplicationDonationValue,
            String recordApplicationEvaluationDate,
            String recordApplicationEvaluationValue,
            String recordDateCreation,
            String recordDateUpdate,
            String recordDateSync

    ) {
        
        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();
    
            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_LANGUAGE, recordUserLanguage);
            mContentValues.put(FIELD_SUPPORT_USER_FIRST_NAME, recordUserFirstName);
            mContentValues.put(FIELD_SUPPORT_USER_LAST_NAME, recordUserLastName);
            mContentValues.put(FIELD_SUPPORT_USER_COMPLETE_NAME, recordUserCompleteName);
            mContentValues.put(FIELD_SUPPORT_USER_NICKNAME, recordUserNickName);
            mContentValues.put(FIELD_SUPPORT_USER_BIRTHDATE, recordUserBirthdate);
            mContentValues.put(FIELD_SUPPORT_USER_BIRTH_COUNTRY, recordUserBirthCountry);
            mContentValues.put(FIELD_SUPPORT_USER_GENDER, recordUserGender);
            mContentValues.put(FIELD_SUPPORT_USER_SEXUAL_OPTION, recordUserSexualOption);
            mContentValues.put(FIELD_SUPPORT_USER_RACE, recordUserRace);
            mContentValues.put(FIELD_SUPPORT_USER_MARITAL_STATUS, recordUserMaritalStatus);
            mContentValues.put(FIELD_SUPPORT_USER_RELIGION, recordUserReligion);
            mContentValues.put(FIELD_SUPPORT_USER_SCHOLARSHIP, recordUserScholarity);
            mContentValues.put(FIELD_SUPPORT_USER_HEIGHT, recordUserHeight);
            mContentValues.put(FIELD_SUPPORT_USER_WEIGHT, recordUserWeight);
            mContentValues.put(FIELD_SUPPORT_USER_EMAIL, recordUserEmail);
            mContentValues.put(FIELD_SUPPORT_USER_PHOTO, recordUserPhoto);
            mContentValues.put(FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE, recordPasswordChangeLast);
            mContentValues.put(FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE, recordPasswordChangeNext);
            mContentValues.put(FIELD_SUPPORT_USER_PASSWORD_FREQUENCY, recordPasswordChangeFrequency);
            mContentValues.put(FIELD_SUPPORT_USER_PASSWORD_BLOCKED, recordPasswordBlocked);
            mContentValues.put(FIELD_SUPPORT_USER_SYNC_LAST, recordDatabaseSyncLast);
            mContentValues.put(FIELD_SUPPORT_USER_SYNC_NEXT, recordDatabaseSyncNext);
            mContentValues.put(FIELD_SUPPORT_USER_RESET_LAST, recordDatabaseReset);
            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_LANGUAGE, recordApplicationLanguage);
            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_VERSION, recordApplicationVersion);
            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_TYPE, recordApplicationType);
            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE, recordApplicationDonationDate);
            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE, recordApplicationDonationValue);
            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE, recordApplicationEvaluationDate);
            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE, recordApplicationEvaluationValue);
            mContentValues.put(FIELD_SUPPORT_USER_CREATION, recordDateCreation);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);
            mContentValues.put(FIELD_SUPPORT_USER_SYNC, recordDateSync);

            mSqLiteDatabase.insert(TABLE_SUPPORT_USER, null, mContentValues);
            mSqLiteDatabase.setTransactionSuccessful();

            Log.w("MEBYME", "sqliteInsert: " + " USER WAS CREATED" );

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
    public static void sqliteUpdateUserLanguage(
            Context context,
            String recordId,
            String recordUserLanguage,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_LANGUAGE, recordUserLanguage);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserFirstName(
            Context context,
            String recordId,
            String recordUserFirstName,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_FIRST_NAME, recordUserFirstName);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserLastName(
            Context context,
            String recordId,
            String recordUserLastName,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_LAST_NAME, recordUserLastName);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserCompleteName(
            Context context,
            String recordId,
            String recordUserCompleteName,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_COMPLETE_NAME, recordUserCompleteName);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserNickName(
            Context context,
            String recordId,
            String recordUserNickName,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_NICKNAME, recordUserNickName);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateLanguage(
            Context context,
            String recordId,
            String recordLanguage,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_LANGUAGE, recordLanguage);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserBirthdate(
            Context context,
            String recordId,
            String recordUserBirthdate,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_BIRTHDATE, recordUserBirthdate);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserBirthCountry(
            Context context,
            String recordId,
            String recordUserBirthCountry,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_BIRTH_COUNTRY, recordUserBirthCountry);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserGender(
            Context context,
            String recordId,
            String recordUserGender,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_GENDER, recordUserGender);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserSexualOption(
            Context context,
            String recordId,
            String recordUserSexualOption,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_SEXUAL_OPTION, recordUserSexualOption);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserRace(
            Context context,
            String recordId,
            String recordUserRace,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_RACE, recordUserRace);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserMaritalStatus(
            Context context,
            String recordId,
            String recordUserMaritalStatus,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_MARITAL_STATUS, recordUserMaritalStatus);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserReligion(
            Context context,
            String recordId,
            String recordUserReligion,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_RELIGION, recordUserReligion);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserScholarity(
            Context context,
            String recordId,
            String recordUserScholarity,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_SCHOLARSHIP, recordUserScholarity);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserHeight(
            Context context,
            String recordId,
            String recordUserHeight,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_HEIGHT, recordUserHeight);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserWeight(
            Context context,
            String recordId,
            String recordUserWeight,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_WEIGHT, recordUserWeight);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserEmail(
            Context context,
            String recordId,
            String recordUserEmail,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_EMAIL, recordUserEmail);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateUserPhoto(
            Context context,
            String recordId,
            byte[] recordUserPhoto,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_PHOTO, recordUserPhoto);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdatePasswordDate(
            Context context,
            String recordId,
            String recordPasswordChangeLast,
            String recordPasswordChangeNext,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE, recordPasswordChangeLast);
            mContentValues.put(FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE, recordPasswordChangeNext);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdatePasswordChangeFrequency(
            Context context,
            String recordId,
            String recordPasswordChangeFrequency,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_PASSWORD_FREQUENCY, recordPasswordChangeFrequency);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdatePasswordBlocked(
            Context context,
            String recordId,
            String recordPasswordBlocked,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_PASSWORD_BLOCKED, recordPasswordBlocked);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateDatabaseSyncDate(
            Context context,
            String recordId,
            String recordDatabaseSyncLast,
            String recordDatabaseSyncNext,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_SYNC_LAST, recordDatabaseSyncLast);
            mContentValues.put(FIELD_SUPPORT_USER_SYNC_NEXT, recordDatabaseSyncNext);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateDatabaseReset(
            Context context,
            String recordId,
            String recordDatabaseReset,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_RESET_LAST, recordDatabaseReset);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateApplicationLanguage(
            Context context,
            String recordId,
            String recordApplicationLanguage,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_LANGUAGE, recordApplicationLanguage);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateApplicationVersion(
            Context context,
            String recordId,
            String recordApplicationVersion,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_VERSION, recordApplicationVersion);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateApplicationType(
            Context context,
            String recordId,
            String recordApplicationType,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_TYPE, recordApplicationType);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateApplicationDonation(
            Context context,
            String recordId,
            String recordApplicationDonationDate,
            String recordApplicationDonationValue,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE, recordApplicationDonationValue);
            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE, recordApplicationDonationDate);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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
    public static void sqliteUpdateEvaluation(
            Context context,
            String recordId,
            String recordApplicationEvaluationDate,
            String recordApplicationEvaluationValue,
            String recordDateUpdate
    ) {

        try {

            mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();
            mSqLiteDatabase.beginTransaction();

            mContentValues = new ContentValues();

            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE, recordApplicationEvaluationValue);
            mContentValues.put(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE, recordApplicationEvaluationDate);
            mContentValues.put(FIELD_SUPPORT_USER_UPDATE, recordDateUpdate);

            mSqLiteDatabase.update(TABLE_SUPPORT_USER, mContentValues, FIELD_SUPPORT_USER_ID + " = ?", new String[]{recordId});
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

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_USER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mIntKeyFromSqlite = mCursor.getInt(mCursor.getColumnIndex(FIELD_SUPPORT_USER_ID));
                mSqLiteDatabase.delete(TABLE_SUPPORT_USER, FIELD_SUPPORT_USER_ID + " = ?", new String[]{String.valueOf(mIntKeyFromSqlite)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportUser> sqliteModuleGetSupportUserAll(Context context) {
        
        List<ModelSupportUser> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_USER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelSupportUser(

                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_ID)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_LANGUAGE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_FIRST_NAME)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_LAST_NAME)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_COMPLETE_NAME)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_NICKNAME)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_BIRTHDATE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_BIRTH_COUNTRY)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_GENDER)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SEXUAL_OPTION)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_RACE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_MARITAL_STATUS)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_RELIGION)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SCHOLARSHIP)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_HEIGHT)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_WEIGHT)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_EMAIL)),
                mCursor.getBlob(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PHOTO)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PASSWORD_FREQUENCY)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PASSWORD_BLOCKED)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_LANGUAGE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_VERSION)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_TYPE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SYNC_LAST)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SYNC_NEXT)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_RESET_LAST)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_CREATION)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_UPDATE)),
                mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SYNC))));

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

        return list;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportUser> sqliteGetOne(Context context) {
        
        List<ModelSupportUser> list = new ArrayList<>();

        list.clear();

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_USER;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionReadable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                list.add(new ModelSupportUser(

                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_ID)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_LANGUAGE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_FIRST_NAME)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_LAST_NAME)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_COMPLETE_NAME)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_NICKNAME)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_BIRTHDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_BIRTH_COUNTRY)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_GENDER)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SEXUAL_OPTION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_RACE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_MARITAL_STATUS)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_RELIGION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SCHOLARSHIP)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_HEIGHT)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_WEIGHT)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_EMAIL)),
                        mCursor.getBlob(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PHOTO)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PASSWORD_FREQUENCY)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_PASSWORD_BLOCKED)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_LANGUAGE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_VERSION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_TYPE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SYNC_LAST)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SYNC_NEXT)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_RESET_LAST)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_CREATION)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_UPDATE)),
                        mCursor.getString(mCursor.getColumnIndex(FIELD_SUPPORT_USER_SYNC))));

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
        

        mStringSelectQuery = SQLITE_COMMAND_SELECT + SQLITE_COMMAND_ASTERISK + SQLITE_COMMAND_FROM + TABLE_SUPPORT_USER
                + SQLITE_COMMAND_WHERE + FIELD_SUPPORT_USER_ID + SQLITE_COMMAND_EQUAL + SQLITE_COMMAND_QUOTES + recordId + SQLITE_COMMAND_QUOTES;

        mSqLiteDatabase = new SqliteConnectionFactory(context).databaseConnectionWritable();

        mCursor = mSqLiteDatabase.rawQuery(mStringSelectQuery, null);

        if (mCursor != null && mCursor.moveToFirst()) {

            do {

                mSqLiteDatabase.delete(TABLE_SUPPORT_USER, FIELD_SUPPORT_USER_ID + " = ?", new String[]{String.valueOf(recordId)});

            } while (mCursor.moveToNext());
        }

        Objects.requireNonNull(mCursor).close();
        mSqLiteDatabase.close();

    }
}