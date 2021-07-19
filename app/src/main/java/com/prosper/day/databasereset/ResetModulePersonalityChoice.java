package com.prosper.day.databasereset;

import android.content.Context;

import com.prosper.day.databasemodel.ModelModulePersonalityQuestion;
import com.prosper.day.databasesqlite.SqliteModulePersonalityChoice;
import com.prosper.day.databasesqlite.SqliteModulePersonalityQuestion;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseUserId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_99;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasereset.ResetSupportPointsUser.resetSupportPointsUser;

public class ResetModulePersonalityChoice {

    private static String mStringCurrentUpdatedDateTime;

    private static String recordUserId;
    private static String recordPhase;
    private static String recordNumber;
    private static String recordGroup;
    private static String recordStatus;
    private static String recordQuestion;
    private static String recordChoiceText;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    private static int mIntIndex;
    private static List<ModelModulePersonalityQuestion> mArrayListQuestions;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModulePersonalityChoice(Context context) {

        recordUserId = stringCurrentUserFirebaseUserId;

        recordStatus = STATUS_NEW;

        recordChoiceText = STRING_NUMBER_99;

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
            recordQuestion = mArrayListQuestions.get(mIntIndex).getRecordText();

            SqliteModulePersonalityChoice.sqliteInsert(
                    context,
                    recordUserId,
                    recordPhase,
                    recordNumber,
                    recordGroup,
                    recordStatus,
                    recordQuestion,
                    recordChoiceText,
                    recordDateCreation,
                    recordDateUpdate,
                    recordDateSync);

            resetSupportPointsUser(context, recordUserId, recordPhase, recordNumber);

        }
    }
}
