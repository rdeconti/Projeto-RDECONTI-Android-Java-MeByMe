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
import com.prosper.day.databasemodel.ModelSupportPhrase;

import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_PHRASE_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_PHRASE;
import static com.prosper.day.databasesqlite.SqliteSupportPhrase.sqliteInsert;

public class ResetSupportPhrase {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mLanguage;

    private static int mIntIndex;

    private static String mStringCurrentUpdatedDateTime;
    private static String recordLanguage;
    private static String recordNumber;
    private static String recordAuthor;
    private static String recordText;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    private static List<ModelSupportPhrase> mArrayListAnswer;

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("DefaultLocale")
    public static void resetSupportPhrase(Context context) {

        recordLanguage = sCurrentApplicationLanguage;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_PHRASE);
        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_PHRASE_LANGUAGE).equalTo(sCurrentApplicationLanguage);
        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if (dataSnapshot.exists()) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    ModelSupportPhrase snapshotDetails = snapshot.getValue(ModelSupportPhrase.class);

                    assert snapshotDetails != null;
                    recordNumber = snapshotDetails.getRecordNumber();
                    recordAuthor = snapshotDetails.getRecordAuthor();
                    recordText = snapshotDetails.getRecordText();

                    sqliteInsert(
                            context,
                            recordLanguage,
                            recordNumber,
                            recordAuthor,
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
