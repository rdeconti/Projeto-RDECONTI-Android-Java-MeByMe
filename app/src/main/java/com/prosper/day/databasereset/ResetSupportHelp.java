package com.prosper.day.databasereset;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.prosper.day.applicationsupportclasses.SupportHandlingDatabaseError;
import com.prosper.day.databasemodel.ModelSupportHelp;

import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_HELP_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_HELP;
import static com.prosper.day.databasesqlite.SqliteSupportHelp.sqliteInsert;

public class ResetSupportHelp {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mLanguage;

    private static int mIntIndex;

    private static String mStringCurrentUpdatedDateTime;
    private static String recordLanguage;
    private static String recordPhase;
    private static String recordText;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    private static List<ModelSupportHelp> mArrayListAnswer;

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("DefaultLocale")
    public static void resetSupportHelp(Context context) {

        recordLanguage = sCurrentApplicationLanguage;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);
        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_HELP_LANGUAGE).equalTo(sCurrentApplicationLanguage);
        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if (dataSnapshot.exists()) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    ModelSupportHelp snapshotDetails = snapshot.getValue(ModelSupportHelp.class);

                    assert snapshotDetails != null;
                    recordPhase = snapshotDetails.getRecordPhase();
                    recordText = snapshotDetails.getRecordText();

                    sqliteInsert(
                            context,
                            recordLanguage,
                            recordPhase,                         // Phase
                            recordText,
                            recordDateCreation,
                            recordDateUpdate,
                            recordDateSync);

                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            new SupportHandlingDatabaseError(this.getClass().getSimpleName(), databaseError);
        }

    });
    }
}
