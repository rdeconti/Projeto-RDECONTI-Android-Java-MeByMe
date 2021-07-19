package com.prosper.day.databasereset;

import android.annotation.SuppressLint;
import android.content.Context;

import org.joda.time.DateTime;
import org.joda.time.Days;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BIORHYTHM_PHASE_CODE_10_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.intNumberBiorhythmDays;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseUserId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsUserBirthdate;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasereset.ResetSupportPointsUser.resetSupportPointsUser;
import static com.prosper.day.databasesqlite.SqliteModuleBiorhythmAnswer.sqliteInsert;

public class ResetModuleBiorhythmAnswer {

    private static String mStringCurrentUpdatedDateTime;
    private static String recordUserId;
    private static String recordPhase;
    private static String recordNumber;
    private static String recordStatus;
    private static String recordExperience;
    private static double recordEmotional;
    private static double recordPhysical;
    private static double recordIntelectual;
    private static String recordNumberPoints;
    private static String recordNumberSharing;
    private static String recordNumberPhotos;
    private static String recordNumberActions;
    private static String recordDateEvent;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    private static int mIntCounterDays;

    private static Days numberOfDaysFromBirth;
    private static DateTime startDate;
    private static DateTime endDate;

    private static int mIntNumberDays;
    private static int mBirthYear;
    private static int mBirthMonth;
    private static int mBirthDay;

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("DefaultLocale")
    public static void resetModuleBiorhythmAnswer(Context context) {

        recordUserId = stringCurrentUserFirebaseUserId;
        recordPhase = BIORHYTHM_PHASE_CODE_10_OV;

        recordStatus = STATUS_NEW;

        recordNumberPoints = STRING_NUMBER_00;
        recordNumberSharing = STRING_NUMBER_00;
        recordNumberPhotos = STRING_NUMBER_00;
        recordNumberActions = STRING_NUMBER_00;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mBirthYear = Integer.parseInt(stringPreferredSettingsUserBirthdate.substring(0, 4));
        mBirthMonth = Integer.parseInt(stringPreferredSettingsUserBirthdate.substring(4, 6));
        mBirthDay = Integer.parseInt(stringPreferredSettingsUserBirthdate.substring(6, 8));

        startDate = new DateTime(mBirthYear, mBirthMonth, mBirthDay,0, 0, 0);
        endDate = new DateTime();

        for(mIntCounterDays = 0; mIntCounterDays < intNumberBiorhythmDays; mIntCounterDays++){

            numberOfDaysFromBirth = Days.daysBetween(startDate, endDate);
            mIntNumberDays = numberOfDaysFromBirth.getDays();

            recordDateEvent = String.valueOf(endDate);

            recordPhysical = Math.sin((2 * Math.PI * mIntNumberDays) / 23);
            recordEmotional = Math.sin((2 * Math.PI * mIntNumberDays) / 28);
            recordIntelectual = Math.sin((2 * Math.PI * mIntNumberDays) / 33);

            recordNumber = String.valueOf(mIntCounterDays);
            
            sqliteInsert(
                    context,
                    recordUserId,
                    recordPhase,
                    recordNumber,
                    recordStatus,
                    recordExperience,
                    recordEmotional,
                    recordPhysical,
                    recordIntelectual,
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
