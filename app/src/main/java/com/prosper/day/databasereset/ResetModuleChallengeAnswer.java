package com.prosper.day.databasereset;

import android.content.Context;

import com.prosper.day.R;
import com.prosper.day.databasemodel.ModelModuleChallengeQuestion;
import com.prosper.day.databasesqlite.SqliteModuleChallengeAnswer;
import com.prosper.day.databasesqlite.SqliteModuleChallengeQuestion;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.CHALLENGE_PHASE_CODE_11_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.COSTS_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_NORMAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.FREQUENCY_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.PRIORITY_NONE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseUserId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasereset.ResetSupportPointsUser.resetSupportPointsUser;

public class ResetModuleChallengeAnswer {

    private static String mStringCurrentUpdatedDateTime;

    private static String recordUserId;
    private static String recordNumber;
    private static String recordStatus;
    private static String recordExperience;
    private static String recordPriority;
    private static String recordFrequency;
    private static String recordCosts;
    private static String recordAnswer;
    private static String recordNumberPoints;
    private static String recordNumberSharing;
    private static String recordNumberPhotos;
    private static String recordNumberActions;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    private static int mIntIndex;
    private static List<ModelModuleChallengeQuestion> mArrayListQuestions;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModuleChallengeAnswer(Context context) {

        recordUserId = stringCurrentUserFirebaseUserId;

        recordStatus = STATUS_NEW;
        recordExperience = EXPERIENCE_NORMAL;
        recordCosts = COSTS_NONE;
        recordPriority = PRIORITY_NONE;
        recordFrequency = FREQUENCY_NONE;

        recordAnswer = context.getString(R.string.label_none);

        recordNumberPoints = STRING_NUMBER_00;
        recordNumberSharing = STRING_NUMBER_00;
        recordNumberPhotos = STRING_NUMBER_00;
        recordNumberActions = STRING_NUMBER_00;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mArrayListQuestions = new ArrayList<>();
        mArrayListQuestions = SqliteModuleChallengeQuestion.sqliteGetAll(context);

        for(mIntIndex = 0; mIntIndex < mArrayListQuestions.size() ; mIntIndex++){

            recordNumber = mArrayListQuestions.get(mIntIndex).getRecordNumber();
            recordAnswer = mArrayListQuestions.get(mIntIndex).getRecordText();

            SqliteModuleChallengeAnswer.sqliteInsert(
                    context,
                    recordUserId,
                    recordNumber,
                    recordStatus,
                    recordExperience,
                    recordPriority,
                    recordFrequency,
                    recordCosts,
                    recordAnswer,
                    recordNumberPoints,
                    recordNumberSharing,
                    recordNumberPhotos,
                    recordNumberActions,
                    recordDateCreation,
                    recordDateUpdate,
                    recordDateSync);

            resetSupportPointsUser(context, recordUserId, CHALLENGE_PHASE_CODE_11_OV, recordNumber);

        }
    }
}
