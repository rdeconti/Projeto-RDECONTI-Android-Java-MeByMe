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
import com.prosper.day.databasemodel.ModelModuleLifeQuestion;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_DATE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_DATE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_DATE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_EXPERIENCE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_GRADE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_NUMBER_ACTIONS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_NUMBER_PHOTOS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_NUMBER_POINTS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_NUMBER_SHARING;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_ANSWER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_LIFE_ANSWER;

public class FirebaseModuleLifeAnswer {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetLifeQuestion(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_ANSWER);
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
    public static boolean FirebaseDeleteAllLifeQuestion(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_ANSWER);
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
    public static void firebaseDeleteOneLifeQuestion(String mLifeQuestionId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_LIFE_ANSWER_ID).equalTo(mLifeQuestionId);

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
    public static boolean FirebaseUpdateLifeQuestion(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordExperience,
            final String recordGrade,
            final String recordQuestion,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_ANSWER);

            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_EXPERIENCE).setValue(recordExperience);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_GRADE).setValue(recordGrade);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_QUESTION).setValue(recordQuestion);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_POINTS).setValue(recordNumberPoints);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_SHARING).setValue(recordNumberSharing);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_PHOTOS).setValue(recordNumberPhotos);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_ACTIONS).setValue(recordNumberActions);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_DATE_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleLifeQuestion(
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordExperience,
            final String recordGrade,
            final String recordQuestion,
            final String recordAnswer,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_LIFE_ANSWER_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_USER_ID).getRef().setValue(recordUserId);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER).getRef().setValue(recordNumber);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_STATUS).getRef().setValue(recordStatus);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_EXPERIENCE).getRef().setValue(recordExperience);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_GRADE).getRef().setValue(recordGrade);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_QUESTION).getRef().setValue(recordQuestion);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_POINTS).getRef().setValue(recordNumberPoints);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_SHARING).getRef().setValue(recordNumberSharing);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_PHOTOS).getRef().setValue(recordNumberPhotos);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_ACTIONS).getRef().setValue(recordNumberActions);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_DATE_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_DATE_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_LIFE_ANSWER_DATE_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateLifeQuestion(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordExperience,
            final String recordGrade,
            final String recordQuestion,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_ANSWER);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_EXPERIENCE).setValue(recordExperience);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_GRADE).setValue(recordGrade);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_QUESTION).setValue(recordQuestion);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_POINTS).setValue(recordNumberPoints);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_SHARING).setValue(recordNumberSharing);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_PHOTOS).setValue(recordNumberPhotos);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_NUMBER_ACTIONS).setValue(recordNumberActions);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_ANSWER_DATE_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleLifeQuestion> GetOneLifeQuestion(String mLifeQuestionId) {

        final List<ModelModuleLifeQuestion> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_LIFE_ANSWER_ID).equalTo(mLifeQuestionId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleLifeQuestion snapshotDetails = snapshot.getValue(ModelModuleLifeQuestion.class);
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
    public static List<ModelModuleLifeQuestion> ListGetAllLifeQuestion() {

        final List<ModelModuleLifeQuestion> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_ANSWER);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleLifeQuestion snapshotDetails = snapshot.getValue(ModelModuleLifeQuestion.class);
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
