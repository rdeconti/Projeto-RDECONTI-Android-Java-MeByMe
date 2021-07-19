package com.prosper.day.databasereset;

import android.content.Context;

import com.prosper.day.databasefirebase.FirebaseModuleActionAnswer;

public class ResetModuleDeleteFirebase {

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModuleDeleteFirebase(Context context) {

        // TODO DELETE ALL ANSWER FROM USER FROM ALL TABLES - CHECK THE RESULT ON FIREBASE MONITOR
        FirebaseModuleActionAnswer.firebaseResetDataFromUser(context);

    }
}
