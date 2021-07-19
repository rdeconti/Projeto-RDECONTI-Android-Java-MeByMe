package com.prosper.day.databasereset;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.prosper.day.R;

import java.io.ByteArrayOutputStream;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.APPLICATION_TYPE_BASIC;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_MONTHLY;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.UNACQUAINTED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasesqlite.SqliteSupportUser.sqliteInsert;

public class ResetSupportUser {

    private static String mStringCurrentUpdatedDateTime;

    private static String recordId;
    private static String recordUserLanguage;
    private static String recordUserFirstName;
    private static String recordUserLastName;
    private static String recordUserCompleteName;
    private static String recordUserNickName;
    private static String recordUserBirthdate;
    private static String recordUserBirthCountry;
    private static String recordUserGender;
    private static String recordUserSexualOption;
    private static String recordUserRace;
    private static String recordUserMaritalStatus;
    private static String recordUserReligion;
    private static String recordUserScholarity;
    private static String recordUserHeight;
    private static String recordUserWeight;
    private static String recordUserEmail;
    private static byte[] recordUserPhoto;
    private static String recordPasswordChangeLast;
    private static String recordPasswordChangeNext;
    private static String recordPasswordChangeFrequency;
    private static String recordPasswordBlocked;
    private static String recordDatabaseSyncLast;
    private static String recordDatabaseSyncNext;
    private static String recordDatabaseReset;
    private static String recordApplicationLanguage;
    private static String recordApplicationVersion;
    private static String recordApplicationType;
    private static String recordApplicationDonationDate;
    private static String recordApplicationDonationValue;
    private static String recordApplicationEvaluationDate;
    private static String recordApplicationEvaluationValue;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetSupportUser(Context context) {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.user_photo_small);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        
        recordUserLanguage = UNACQUAINTED;
        recordUserFirstName = UNACQUAINTED;
        recordUserLastName = UNACQUAINTED;
        recordUserCompleteName = UNACQUAINTED;
        recordUserNickName = UNACQUAINTED;
        recordUserBirthdate = UNACQUAINTED;
        recordUserBirthCountry = UNACQUAINTED;
        recordUserGender = UNACQUAINTED;
        recordUserSexualOption = UNACQUAINTED;
        recordUserRace = UNACQUAINTED;
        recordUserMaritalStatus = UNACQUAINTED;
        recordUserReligion = UNACQUAINTED;
        recordUserScholarity = UNACQUAINTED;
        recordUserHeight = UNACQUAINTED;
        recordUserWeight = UNACQUAINTED;
        recordUserEmail = UNACQUAINTED;
        recordUserPhoto = byteArray;
        recordPasswordChangeLast = mStringCurrentUpdatedDateTime;
        recordPasswordChangeNext = mStringCurrentUpdatedDateTime;
        recordPasswordChangeFrequency = FREQUENCY_MONTHLY;
        recordPasswordBlocked = mStringCurrentUpdatedDateTime;
        recordDatabaseSyncLast = mStringCurrentUpdatedDateTime;
        recordDatabaseSyncNext = mStringCurrentUpdatedDateTime;
        recordDatabaseReset = mStringCurrentUpdatedDateTime;
        recordApplicationLanguage = UNACQUAINTED;
        recordApplicationVersion = UNACQUAINTED;
        recordApplicationType = APPLICATION_TYPE_BASIC;
        recordApplicationDonationDate = mStringCurrentUpdatedDateTime;
        recordApplicationDonationValue = STRING_NUMBER_00;
        recordApplicationEvaluationDate= mStringCurrentUpdatedDateTime;
        recordApplicationEvaluationValue = STRING_NUMBER_00;
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        sqliteInsert(
                context,
                recordUserLanguage,
                recordUserFirstName,
                recordUserLastName,
                recordUserCompleteName,
                recordUserNickName,
                recordUserBirthdate,
                recordUserBirthCountry,
                recordUserGender,
                recordUserSexualOption,
                recordUserRace,
                recordUserMaritalStatus,
                recordUserReligion,
                recordUserScholarity,
                recordUserHeight,
                recordUserWeight,
                recordUserEmail,
                recordUserPhoto,
                recordPasswordChangeLast,
                recordPasswordChangeNext,
                recordPasswordChangeFrequency,
                recordPasswordBlocked,
                recordDatabaseSyncLast,
                recordDatabaseSyncNext,
                recordDatabaseReset,
                recordApplicationLanguage,
                recordApplicationVersion,
                recordApplicationType,
                recordApplicationDonationDate,
                recordApplicationDonationValue,
                recordApplicationEvaluationDate,
                recordApplicationEvaluationValue,
                recordDateCreation,
                recordDateUpdate,
                recordDateSync);

    }
}
