package com.prosper.day.databasefirebase;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.prosper.day.applicationsupportclasses.SupportHandlingDatabaseError;
import com.prosper.day.applicationsupportclasses.SupportHandlingExceptionError;
import com.prosper.day.databasemodel.ModelModulePersonalityChoice;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_DATE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_DATE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_DATE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_QUESTION_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_CHOICE_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_CHOICE;

public class FirebaseModulePersonalityChoice {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetPersonalityChoice(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_CHOICE);
            mDatabaseReference.removeValue();
            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseDeleteAllPersonalityChoice(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_CHOICE);
            mDatabaseReference.child(firebaseKey).removeValue();
            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseDeleteOnePersonalityChoice(String mPersonalityChoiceId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_CHOICE);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PERSONALITY_CHOICE_ID).equalTo(mPersonalityChoiceId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.getRef().removeValue();

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                new SupportHandlingDatabaseError(this.getClass().getSimpleName(), databaseError);

            }
        });
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseUpdatePersonalityChoice(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordQuestion,
            final String recordChoiceText,                    // Choice from user to question
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_CHOICE);

            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_QUESTION_TEXT).setValue(recordQuestion);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_TEXT).setValue(recordChoiceText);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_DATE_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSinglePersonalityChoice(
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordQuestion,
            final String recordChoiceText,                    // Choice from user to question
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_CHOICE);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PERSONALITY_CHOICE_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_USER_ID).getRef().setValue(recordUserId);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_NUMBER).getRef().setValue(recordNumber);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_STATUS).getRef().setValue(recordStatus);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_QUESTION_TEXT).getRef().setValue(recordQuestion);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_TEXT).getRef().setValue(recordChoiceText);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_DATE_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_DATE_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_CHOICE_DATE_SYNC).getRef().setValue(recordDateSync);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                new SupportHandlingDatabaseError(this.getClass().getSimpleName(), databaseError);

            }
        });
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseCreatePersonalityChoice(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordQuestion,
            final String recordChoiceText,                    // Choice from user to question
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_CHOICE);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_QUESTION_TEXT).setValue(recordQuestion);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_TEXT).setValue(recordChoiceText);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_CHOICE_DATE_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModulePersonalityChoice> GetOnePersonalityChoice(String mPersonalityChoiceId) {

        final List<ModelModulePersonalityChoice> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_CHOICE);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PERSONALITY_CHOICE_ID).equalTo(mPersonalityChoiceId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModulePersonalityChoice snapshotDetails = snapshot.getValue(ModelModulePersonalityChoice.class);
                        list.add(snapshotDetails);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                new SupportHandlingDatabaseError(this.getClass().getSimpleName(), databaseError);
            }
        });

        return list;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModulePersonalityChoice> ListGetAllPersonalityChoice() {

        final List<ModelModulePersonalityChoice> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_CHOICE);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModulePersonalityChoice snapshotDetails = snapshot.getValue(ModelModulePersonalityChoice.class);
                        list.add(snapshotDetails);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                new SupportHandlingDatabaseError(this.getClass().getSimpleName(), databaseError);
            }

        });

        return list;
    }
}
