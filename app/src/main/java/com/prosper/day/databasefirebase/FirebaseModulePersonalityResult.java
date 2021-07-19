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
import com.prosper.day.databasemodel.ModelModulePersonalityResult;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsLanguage;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_QUESTION_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_CHARACTERISTIC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_CODE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_GROUP;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PERSONALITY_RESULT_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_QUESTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PERSONALITY_RESULT;

public class FirebaseModulePersonalityResult {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mLanguage;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetPersonalityResult(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_RESULT);
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
    public static boolean FirebaseDeleteAllPersonalityResult(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_RESULT);
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
    public static void firebaseDeleteOnePersonalityResult(String mPersonalityResultId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_RESULT);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PERSONALITY_RESULT_ID).equalTo(mPersonalityResultId);

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
    public static boolean FirebaseUpdatePersonalityResult(
            Context context,
            final String recordId,
            final String recordLanguage,
            final String recordPhase,
            final String recordCode,
            final String recordName,
            final String recordGroup,
            final String recordCharacteristic,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync

    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_RESULT);

            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_CODE).setValue(recordCode);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_NAME).setValue(recordName);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_GROUP).setValue(recordGroup);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_CHARACTERISTIC).setValue(recordCharacteristic);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSinglePersonalityResult(
            final String recordId,
            final String recordLanguage,
            final String recordPhase,
            final String recordCode,
            final String recordName,
            final String recordGroup,
            final String recordCharacteristic,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_RESULT);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PERSONALITY_RESULT_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_LANGUAGE).getRef().setValue(recordLanguage);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_CODE).getRef().setValue(recordCode);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_NAME).getRef().setValue(recordName);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_GROUP).getRef().setValue(recordGroup);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_CHARACTERISTIC).getRef().setValue(recordCharacteristic);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_TEXT).getRef().setValue(recordText);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_PERSONALITY_RESULT_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreatePersonalityResult(
            Context context,
            final String recordId,
            final String recordLanguage,
            final String recordPhase,
            final String recordCode,
            final String recordName,
            final String recordGroup,
            final String recordCharacteristic,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_RESULT);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_CODE).setValue(recordCode);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_NAME).setValue(recordName);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_GROUP).setValue(recordGroup);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_CHARACTERISTIC).setValue(recordCharacteristic);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_PERSONALITY_RESULT_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModulePersonalityResult> GetOnePersonalityResult(String mPersonalityResultId) {

        final List<ModelModulePersonalityResult> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_RESULT);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PERSONALITY_RESULT_ID).equalTo(mPersonalityResultId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModulePersonalityResult snapshotDetails = snapshot.getValue(ModelModulePersonalityResult.class);
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
    public static List<ModelModulePersonalityResult> ListGetAllPersonalityResult() {

        final List<ModelModulePersonalityResult> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_RESULT);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModulePersonalityResult snapshotDetails = snapshot.getValue(ModelModulePersonalityResult.class);
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
    public static List<ModelModulePersonalityResult> GetPersonalityListLanguageResult() {

        final List<ModelModulePersonalityResult> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PERSONALITY_QUESTION);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PERSONALITY_QUESTION_LANGUAGE).equalTo(sCurrentApplicationLanguage);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        mLanguage = snapshot.child(FIELD_PERSONALITY_QUESTION_LANGUAGE).getValue(String.class);

                        if (mLanguage != null) {

                            if (!mLanguage.equals(stringPreferredSettingsLanguage)) {

                                ModelModulePersonalityResult snapshotDetails = snapshot.getValue(ModelModulePersonalityResult.class);
                                list.add(snapshotDetails);

                            }
                        }
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
