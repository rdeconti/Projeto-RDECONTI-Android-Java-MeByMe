package com.prosper.day.databasereset;

import android.content.Context;

import com.prosper.day.databasesqlite.SqliteModuleActionAnswer;
import com.prosper.day.databasesqlite.SqliteModuleAutobiographyAnswer;
import com.prosper.day.databasesqlite.SqliteModuleAutobiographyQuestion;
import com.prosper.day.databasesqlite.SqliteModuleBeliefAnswer;
import com.prosper.day.databasesqlite.SqliteModuleBeliefCalendar;
import com.prosper.day.databasesqlite.SqliteModuleBeliefDescription;
import com.prosper.day.databasesqlite.SqliteModuleBiorhythmAnswer;
import com.prosper.day.databasesqlite.SqliteModuleChallengeAnswer;
import com.prosper.day.databasesqlite.SqliteModuleChallengeQuestion;
import com.prosper.day.databasesqlite.SqliteModuleDiaryAnswer;
import com.prosper.day.databasesqlite.SqliteModuleLifeAnswer;
import com.prosper.day.databasesqlite.SqliteModuleLifeQuestion;
import com.prosper.day.databasesqlite.SqliteModuleMoodAnswer;
import com.prosper.day.databasesqlite.SqliteModulePersonalityAnswer;
import com.prosper.day.databasesqlite.SqliteModulePersonalityChoice;
import com.prosper.day.databasesqlite.SqliteModulePersonalityQuestion;
import com.prosper.day.databasesqlite.SqliteModulePersonalityResult;
import com.prosper.day.databasesqlite.SqliteModulePhotoAnswer;
import com.prosper.day.databasesqlite.SqliteModuleRecognitionAnswer;
import com.prosper.day.databasesqlite.SqliteModuleRecognitionQuestion;
import com.prosper.day.databasesqlite.SqliteModuleReflectionAnswer;
import com.prosper.day.databasesqlite.SqliteModuleReflectionQuestion;
import com.prosper.day.databasesqlite.SqliteModuleSharingAnswer;
import com.prosper.day.databasesqlite.SqliteModuleYouAnswer;
import com.prosper.day.databasesqlite.SqliteModuleYouQuestion;
import com.prosper.day.databasesqlite.SqliteSupportAdvice;
import com.prosper.day.databasesqlite.SqliteSupportHelp;
import com.prosper.day.databasesqlite.SqliteSupportPhrase;
import com.prosper.day.databasesqlite.SqliteSupportPointsUser;
import com.prosper.day.databasesqlite.SqliteSupportUser;
import com.prosper.day.databasesqlite.SqliteSupportWord;

public class ResetModuleDeleteSqlite {

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModuleDeleteSqlite(Context context) {

        SqliteModuleActionAnswer.sqliteDeleteAll(context);
        
        SqliteModuleAutobiographyQuestion.sqliteDeleteAll(context);
        SqliteModuleAutobiographyAnswer.sqliteDeleteAll(context);

        SqliteModuleBeliefDescription.sqliteDeleteAll(context);
        SqliteModuleBeliefCalendar.sqliteDeleteAll(context);
        SqliteModuleBeliefAnswer.sqliteDeleteAll(context);

        SqliteModuleBiorhythmAnswer.sqliteDeleteAll(context);

        SqliteModuleChallengeAnswer.sqliteDeleteAll(context);
        SqliteModuleChallengeQuestion.sqliteDeleteAll(context);

        SqliteModuleDiaryAnswer.sqliteDeleteAll(context);

        SqliteModuleLifeQuestion.sqliteDeleteAll(context);
        SqliteModuleLifeAnswer.sqliteDeleteAll(context);

        SqliteModuleMoodAnswer.sqliteDeleteAll(context);

        SqliteModulePersonalityAnswer.sqliteDeleteAll(context);
        SqliteModulePersonalityChoice.sqliteDeleteAll(context);
        SqliteModulePersonalityQuestion.sqliteDeleteAll(context);
        SqliteModulePersonalityResult.sqliteDeleteAll(context);

        SqliteModulePhotoAnswer.sqliteDeleteAll(context);

        SqliteModuleRecognitionAnswer.sqliteDeleteAll(context);
        SqliteModuleRecognitionQuestion.sqliteDeleteAll(context);

        SqliteModuleReflectionAnswer.sqliteDeleteAll(context);
        SqliteModuleReflectionQuestion.sqliteDeleteAll(context);

        SqliteModuleSharingAnswer.sqliteDeleteAll(context);

        SqliteModuleYouAnswer.sqliteDeleteAll(context);
        SqliteModuleYouQuestion.sqliteDeleteAll(context);

        SqliteSupportAdvice.sqliteDeleteAll(context);
        SqliteSupportHelp.sqliteDeleteAll(context);
        SqliteSupportPhrase.sqliteDeleteAll(context);
        SqliteSupportPointsUser.sqliteDeleteAll(context);
        SqliteSupportUser.sqliteDeleteAll(context);
        SqliteSupportWord.sqliteDeleteAll(context);

    }
}
