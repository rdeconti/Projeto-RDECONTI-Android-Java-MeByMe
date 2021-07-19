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
import com.prosper.day.databasemodel.ModelSupportWord;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_WORD_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_WORD;
import static com.prosper.day.databasesqlite.SqliteSupportWord.sqliteInsert;

public class ResetSupportWord {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;

    private static String mStringCurrentUpdatedDateTime;
    private static String recordLanguage;
    private static String recordNumber;
    private static String recordText;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("DefaultLocale")
    public static void resetSupportWord(Context context) {

        recordLanguage = sCurrentApplicationLanguage;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);
        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_WORD_LANGUAGE).equalTo(sCurrentApplicationLanguage);
        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if (dataSnapshot.exists()) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    ModelSupportWord snapshotDetails = snapshot.getValue(ModelSupportWord.class);

                    assert snapshotDetails != null;
                    recordNumber = snapshotDetails.getRecordNumber();
                    recordText = snapshotDetails.getRecordText();

                    sqliteInsert(
                            context,
                            recordLanguage,
                            recordNumber,
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
