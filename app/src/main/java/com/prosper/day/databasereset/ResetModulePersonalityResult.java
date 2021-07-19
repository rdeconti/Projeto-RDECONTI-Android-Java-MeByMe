package com.prosper.day.databasereset;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.prosper.day.applicationsupportclasses.SupportHandlingDatabaseError;
import com.prosper.day.databasemodel.ModelModulePersonalityResult;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_RESULT;
import static com.prosper.day.databasesqlite.SqliteModulePersonalityResult.sqliteInsert;

public class ResetModulePersonalityResult {

    private static FirebaseDatabase mFirebaseDatabase;
    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;

    private static String mStringCurrentUpdatedDateTime;
    
    private static String recordLanguage;
    private static String recordPhase;
    private static String recordCode;
    private static String recordName;
    private static String recordGroup;
    private static String recordCharacteristic;
    private static String recordText;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModulePersonalityQuestionResult(Context context) {

        recordLanguage = sCurrentApplicationLanguage;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference(TABLE_MODULE_PERSONALITY_RESULT);
        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PERSONALITY_RESULT_LANGUAGE).equalTo(sCurrentApplicationLanguage);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModulePersonalityResult snapshotDetails = snapshot.getValue(ModelModulePersonalityResult.class);

                        assert snapshotDetails != null;
                        recordPhase = snapshotDetails.getRecordPhase();
                        recordCode = snapshotDetails.getRecordCode();
                        recordName = snapshotDetails.getRecordName();
                        recordGroup = snapshotDetails.getRecordGroup();
                        recordCharacteristic = snapshotDetails.getRecordCharacteristic();
                        recordText = snapshotDetails.getRecordText();

                        sqliteInsert(
                                context,
                                recordLanguage,
                                recordPhase,
                                recordCode,
                                recordName,
                                recordGroup,
                                recordCharacteristic,
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
