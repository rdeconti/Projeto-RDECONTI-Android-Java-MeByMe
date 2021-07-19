package com.prosper.day.databasereset;

import android.annotation.SuppressLint;
import android.content.Context;

import com.prosper.day.R;

import org.joda.time.DateTime;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MOOD_PHASE_CODE_02_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_NORMAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.intNumberDiaryDays;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseUserId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasereset.ResetSupportPointsUser.resetSupportPointsUser;
import static com.prosper.day.databasesqlite.SqliteModuleMoodAnswer.sqliteInsert;

public class ResetModuleMoodAnswer {

    private static String mStringCurrentUpdatedDateTime;
    private static String recordUserId;
    private static String recordPhase;
    private static String recordNumber;
    private static String recordStatus;
    private static String recordExperience;
    private static String recordAnswer;
    private static String recordNumberPoints;
    private static String recordNumberSharing;
    private static String recordNumberPhotos;
    private static String recordNumberActions;
    private static String recordDateEvent;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    private static int mIntCounterDays;

    private static DateTime endDate;

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("DefaultLocale")
    public static void resetModuleMoodAnswer(Context context) {

        recordUserId = stringCurrentUserFirebaseUserId;

        recordPhase = MOOD_PHASE_CODE_02_03;

        recordStatus = STATUS_NEW;
        recordExperience = EXPERIENCE_NORMAL;

        recordAnswer = context.getString(R.string.label_none);

        recordNumberPoints = STRING_NUMBER_00;
        recordNumberSharing = STRING_NUMBER_00;
        recordNumberPhotos = STRING_NUMBER_00;
        recordNumberActions = STRING_NUMBER_00;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        endDate = new DateTime();

        for(mIntCounterDays = 0; mIntCounterDays < intNumberDiaryDays; mIntCounterDays++) {

            recordNumber = String.valueOf(mIntCounterDays);
            recordDateEvent = String.valueOf(endDate);

            sqliteInsert(
                    context,
                    recordUserId,
                    recordPhase,
                    recordNumber,
                    recordStatus,
                    recordExperience,
                    recordAnswer,
                    recordNumberPoints,
                    recordNumberSharing,
                    recordNumberPhotos,
                    recordNumberActions,
                    recordDateEvent,
                    recordDateCreation,
                    recordDateUpdate,
                    recordDateSync);

            resetSupportPointsUser(context, recordUserId, recordPhase, recordNumber);

            endDate = endDate.plusDays(1);

        }
    }
}
