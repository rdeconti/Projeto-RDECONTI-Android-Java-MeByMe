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
import com.prosper.day.databasemodel.ModelModuleBeliefDescription;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_DESCRIPTION;
import static com.prosper.day.databasefirebase.FirebaseModuleBeliefQuestionDescription.GetListByLanguage;
import static com.prosper.day.databasesqlite.SqliteModuleBeliefDescription.sqliteInsert;

public class ResetModuleBeliefQuestionDescription {

    private static FirebaseDatabase mFirebaseDatabase;
    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;

    private static int mIntIndex;
    private static String mStringCurrentUpdatedDateTime;

    private static String recordLanguage;
    private static String recordPhase;
    private static String recordSign;
    private static String recordName;
    private static String recordDescription;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    private static List<ModelModuleBeliefDescription> mArrayListAnswer;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModuleBeliefQuestionDescription(Context context) {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference(TABLE_MODULE_BELIEF_DESCRIPTION);
        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BELIEF_DESCRIPTION_LANGUAGE).equalTo(sCurrentApplicationLanguage);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleBeliefDescription snapshotDetails = snapshot.getValue(ModelModuleBeliefDescription.class);

                        assert snapshotDetails != null;
                        recordPhase = snapshotDetails.getRecordPhase();
                        recordSign = snapshotDetails.getRecordSign();
                        recordLanguage = snapshotDetails.getRecordLanguage();
                        recordName = snapshotDetails.getRecordName();
                        recordDescription = snapshotDetails.getRecordText();

                        sqliteInsert(
                                context,
                                recordPhase,
                                recordSign,
                                recordLanguage,
                                recordName,
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





        recordLanguage = sCurrentApplicationLanguage;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mArrayListAnswer = new ArrayList<>();
        mArrayListAnswer = GetListByLanguage();

        for(mIntIndex = 0; mIntIndex < mArrayListAnswer.size() ; mIntIndex++){

            recordPhase = mArrayListAnswer.get(mIntIndex).getRecordPhase();
            recordSign = mArrayListAnswer.get(mIntIndex).getRecordSign();
            recordName = mArrayListAnswer.get(mIntIndex).getRecordName();
            recordDescription = mArrayListAnswer.get(mIntIndex).getRecordText();

            sqliteInsert(
                    context,
                    recordPhase,
                    recordSign,
                    recordLanguage,
                    recordName,
                    recordDescription,
                    recordDateCreation,
                    recordDateUpdate,
                    recordDateSync);

        }
    }
}
