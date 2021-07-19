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

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_QUESTION_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_QUESTION_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_QUESTION_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_QUESTION_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_QUESTION_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_QUESTION_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_QUESTION_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_LIFE_QUESTION_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_LIFE_QUESTION;

public class FirebaseModuleLifeQuestion {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetLifeQuestion(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_QUESTION);
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

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_QUESTION);
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

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_QUESTION);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_LIFE_QUESTION_ID).equalTo(mLifeQuestionId);

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
            final String recordLanguage,
            final String recordPhase,
            final String recordNumber,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_QUESTION);

            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_SYNC).setValue(recordDateSync);

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
            final String recordLanguage,
            final String recordPhase,
            final String recordNumber,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_QUESTION);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_LIFE_QUESTION_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_LIFE_QUESTION_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_LIFE_QUESTION_LANGUAGE).getRef().setValue(recordLanguage);
                        snapshot.child(recordId).child(FIELD_LIFE_QUESTION_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_LIFE_QUESTION_NUMBER).getRef().setValue(recordNumber);
                        snapshot.child(recordId).child(FIELD_LIFE_QUESTION_TEXT).getRef().setValue(recordText);
                        snapshot.child(recordId).child(FIELD_LIFE_QUESTION_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_LIFE_QUESTION_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_LIFE_QUESTION_SYNC).getRef().setValue(recordDateSync);

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
            final String recordLanguage,
            final String recordPhase,
            final String recordNumber,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_QUESTION);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_LIFE_QUESTION_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleLifeQuestion> GetOneLifeQuestion(String mLifeQuestionId) {

        final List<ModelModuleLifeQuestion> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_QUESTION);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_LIFE_QUESTION_ID).equalTo(mLifeQuestionId);

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

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_QUESTION);

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

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleLifeQuestion> GetListByLanguage() {

        final List<ModelModuleLifeQuestion> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_LIFE_QUESTION);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_LIFE_QUESTION_LANGUAGE).equalTo(sCurrentApplicationLanguage);

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
}
