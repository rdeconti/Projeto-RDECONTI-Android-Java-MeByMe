package com.prosper.day.databasereset;

import android.content.Context;

import com.prosper.day.databasesqlite.SqliteSupportPointsUser;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.OPINION_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_99;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;

public class ResetSupportPointsUser {

    private static String mStringCurrentUpdatedDateTime;

    private static String recordUserId;
    private static String recordPhase;
    private static String recordNumber;
    private static String recordStatus;
    private static String recordOpinion;
    private static String recordGrade;
    private static String recordNumberPoints;
    private static String recordNumberSharing;
    private static String recordNumberPhotos;
    private static String recordNumberActions;
    private static String recordNumberFeedbackPositive;
    private static String recordNumberFeedbackNegative;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetSupportPointsUser(
            Context context,
            String stringUserId,
            String stringPhase,
            String stringNumber) {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        recordUserId = stringUserId;
        recordPhase = stringPhase;
        recordNumber = stringNumber;
        recordStatus = STATUS_NEW;
        recordOpinion = OPINION_NONE;
        recordGrade = STRING_NUMBER_99;
        recordNumberPoints = STRING_NUMBER_00;
        recordNumberSharing = STRING_NUMBER_00;
        recordNumberPhotos = STRING_NUMBER_00;
        recordNumberActions = STRING_NUMBER_00;
        recordNumberFeedbackPositive = STRING_NUMBER_00;
        recordNumberFeedbackNegative = STRING_NUMBER_00;
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        SqliteSupportPointsUser.sqliteInsert(
                context,
                recordUserId,
                recordPhase,
                recordNumber,
                recordStatus,
                recordNumberPoints,
                recordNumberSharing,
                recordNumberPhotos,
                recordNumberActions,
                recordDateCreation,
                recordDateUpdate,
                recordDateSync);

    }
}
