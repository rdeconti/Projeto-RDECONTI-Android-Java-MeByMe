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
import com.prosper.day.databasemodel.ModelModuleRecognitionQuestion;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_RECOGNITION_QUESTION_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_RECOGNITION_QUESTION;
import static com.prosper.day.databasesqlite.SqliteModuleRecognitionQuestion.sqliteInsert;

public class ResetModuleRecognitionQuestion {

    private static FirebaseDatabase mFirebaseDatabase;
    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;

    private static String mStringCurrentUpdatedDateTime;

    private static String recordLanguage;
    private static String recordPhase;
    private static String recordNumber;
    private static String recordHeader;
    private static String recordDescription;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModuleRecognitionQuestion(Context context) {

        recordLanguage = sCurrentApplicationLanguage;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference(TABLE_MODULE_RECOGNITION_QUESTION);
        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_RECOGNITION_QUESTION_LANGUAGE).equalTo(sCurrentApplicationLanguage);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleRecognitionQuestion snapshotDetails = snapshot.getValue(ModelModuleRecognitionQuestion.class);

                        assert snapshotDetails != null;
                        recordPhase = snapshotDetails.getRecordPhase();
                        recordNumber = snapshotDetails.getRecordNumber();
                        recordHeader = snapshotDetails.getRecordHeader();
                        recordDescription = snapshotDetails.getRecordDescription();

                        sqliteInsert(
                                context,
                                recordLanguage,
                                recordPhase,
                                recordNumber,
                                recordHeader,
                                recordDescription,
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
