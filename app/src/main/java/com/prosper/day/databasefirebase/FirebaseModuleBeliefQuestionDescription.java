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
import com.prosper.day.databasemodel.ModelModuleBeliefDescription;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_SIGN;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_DESCRIPTION_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_DESCRIPTION;

public class FirebaseModuleBeliefQuestionDescription {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetBeliefDescription(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_DESCRIPTION);
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
    public static boolean FirebaseDeleteAllBeliefDescription(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_DESCRIPTION);
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
    public static void firebaseDeleteOneBeliefDescription(String mBeliefDescriptionId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_DESCRIPTION);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BELIEF_DESCRIPTION_ID).equalTo(mBeliefDescriptionId);

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
    public static boolean FirebaseUpdateBeliefDescription(
            Context context,
            final String recordId,
            final String recordPhase,
            final String recordSign,
            final String recordLanguage,
            final String recordName,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_DESCRIPTION);

            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_SIGN).setValue(recordSign);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_NAME).setValue(recordName);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleBeliefDescription(
            final String recordId,
            final String recordPhase,
            final String recordSign,
            final String recordLanguage,
            final String recordName,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_DESCRIPTION);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BELIEF_DESCRIPTION_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_BELIEF_DESCRIPTION_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_BELIEF_DESCRIPTION_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_BELIEF_DESCRIPTION_SIGN).getRef().setValue(recordSign);
                        snapshot.child(recordId).child(FIELD_BELIEF_DESCRIPTION_LANGUAGE).getRef().setValue(recordLanguage);
                        snapshot.child(recordId).child(FIELD_BELIEF_DESCRIPTION_NAME).getRef().setValue(recordName);
                        snapshot.child(recordId).child(FIELD_BELIEF_DESCRIPTION_TEXT).getRef().setValue(recordText);
                        snapshot.child(recordId).child(FIELD_BELIEF_DESCRIPTION_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_BELIEF_DESCRIPTION_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_BELIEF_DESCRIPTION_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateBeliefDescription(
            Context context,
            final String recordId,
            final String recordPhase,
            final String recordSign,
            final String recordLanguage,
            final String recordName,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_DESCRIPTION);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_SIGN).setValue(recordSign);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_NAME).setValue(recordName);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_DESCRIPTION_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleBeliefDescription> GetOneBeliefDescription(String mBeliefDescriptionId) {

        final List<ModelModuleBeliefDescription> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_DESCRIPTION);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BELIEF_DESCRIPTION_ID).equalTo(mBeliefDescriptionId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleBeliefDescription snapshotDetails = snapshot.getValue(ModelModuleBeliefDescription.class);
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
    public static List<ModelModuleBeliefDescription> ListGetAllBeliefDescription() {

        final List<ModelModuleBeliefDescription> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_DESCRIPTION);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleBeliefDescription snapshotDetails = snapshot.getValue(ModelModuleBeliefDescription.class);
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
    public static List<ModelModuleBeliefDescription> GetListByLanguage() {

        final List<ModelModuleBeliefDescription> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_DESCRIPTION);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BELIEF_DESCRIPTION_LANGUAGE).equalTo(sCurrentApplicationLanguage);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleBeliefDescription snapshotDetails = snapshot.getValue(ModelModuleBeliefDescription.class);
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
