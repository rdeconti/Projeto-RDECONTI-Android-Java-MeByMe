package com.prosper.day.databasereset;

import android.content.Context;

import com.prosper.day.R;
import com.prosper.day.databasemodel.ModelModulePersonalityQuestion;
import com.prosper.day.databasesqlite.SqliteModulePersonalityAnswer;
import com.prosper.day.databasesqlite.SqliteModulePersonalityQuestion;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_NORMAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseUserId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasereset.ResetSupportPointsUser.resetSupportPointsUser;

public class ResetModulePersonalityAnswer {

    private static String mStringCurrentUpdatedDateTime;

    private static String recordUserId;
    private static String recordPhase;
    private static String recordNumber;
    private static String recordGroup;
    private static String recordStatus;
    private static String recordExperience;
    private static String recordText;
    private static String recordAnswer;
    private static String recordNumberPoints;
    private static String recordNumberSharing;
    private static String recordNumberPhotos;
    private static String recordNumberActions;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    private static int mIntIndex;
    private static List<ModelModulePersonalityQuestion> mArrayListQuestions;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModulePersonalityAnswer(Context context) {

        recordUserId = stringCurrentUserFirebaseUserId;

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

        mArrayListQuestions = new ArrayList<>();
        mArrayListQuestions = SqliteModulePersonalityQuestion.sqliteGetAll(context);

        for(mIntIndex = 0; mIntIndex < mArrayListQuestions.size() ; mIntIndex++){

            recordPhase = mArrayListQuestions.get(mIntIndex).getRecordPhase();
            recordNumber = mArrayListQuestions.get(mIntIndex).getRecordNumber();
            recordGroup = mArrayListQuestions.get(mIntIndex).getRecordGroup();
            recordText = mArrayListQuestions.get(mIntIndex).getRecordText();

            SqliteModulePersonalityAnswer.sqliteInsert(
                    context,
                    recordUserId,
                    recordPhase,
                    recordNumber,
                    recordGroup,
                    recordStatus,
                    recordExperience,
                    recordText,
                    recordAnswer,
                    recordNumberPoints,
                    recordNumberSharing,
                    recordNumberPhotos,
                    recordNumberActions,
                    recordDateCreation,
                    recordDateUpdate,
                    recordDateSync);

            resetSupportPointsUser(context, recordUserId, recordPhase, recordNumber);

        }
    }
}
