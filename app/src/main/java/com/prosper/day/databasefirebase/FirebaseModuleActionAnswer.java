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
import com.prosper.day.databasemodel.ModelModuleActionAnswer;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseUserId;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_COSTS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_DATE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_DATE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_DATE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_EXPERIENCE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_FREQUENCY;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_NUMBER_ACTIONS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_NUMBER_PHOTOS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_NUMBER_POINTS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_NUMBER_SHARING;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_PRIORITY;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_ACTION_ANSWER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_ACTION_ANSWER;

public class FirebaseModuleActionAnswer {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String recordId;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseResetDataFromUser(Context context) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_ACTION_ANSWER);
        mDatabaseReference.removeValue();

        try {

            recordId = mDatabaseReference.child(TABLE_MODULE_ACTION_ANSWER).push().getKey();
            mDatabaseReference.child(TABLE_MODULE_ACTION_ANSWER).child(recordId).setValue(stringCurrentUserFirebaseUserId);
            mDatabaseReference.child(TABLE_MODULE_ACTION_ANSWER).child(recordId).removeValue();

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetActionAnswer(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_ACTION_ANSWER);
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
    public static boolean FirebaseDeleteAllActionAnswer(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_ACTION_ANSWER);
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
    public static void firebaseDeleteOneActionAnswer(String mActionAnswerId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_ACTION_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_ACTION_ANSWER_ID).equalTo(mActionAnswerId);

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
    public static boolean FirebaseUpdateActionAnswer(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordAnswer,
            final String recordStatus,
            final String recordExperience,
            final String recordPriority,
            final String recordFrequency,
            final String recordCosts,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
            
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_ACTION_ANSWER);

            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_TEXT).setValue(recordAnswer);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_EXPERIENCE).setValue(recordExperience);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_PRIORITY).setValue(recordPriority);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_FREQUENCY).setValue(recordFrequency);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_COSTS).setValue(recordCosts);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_POINTS).setValue(recordNumberPoints);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_SHARING).setValue(recordNumberSharing);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_PHOTOS).setValue(recordNumberPhotos);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_ACTIONS).setValue(recordNumberActions);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_DATE_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleActionAnswer(
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordAnswer,
            final String recordStatus,
            final String recordExperience,
            final String recordPriority,
            final String recordFrequency,
            final String recordCosts,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_ACTION_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_ACTION_ANSWER_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_USER_ID).getRef().setValue(recordUserId);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER).getRef().setValue(recordNumber);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_TEXT).getRef().setValue(recordAnswer);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_STATUS).getRef().setValue(recordStatus);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_EXPERIENCE).getRef().setValue(recordExperience);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_PRIORITY).getRef().setValue(recordPriority);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_FREQUENCY).getRef().setValue(recordFrequency);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_COSTS).getRef().setValue(recordCosts);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_POINTS).getRef().setValue(recordNumberPoints);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_SHARING).getRef().setValue(recordNumberSharing);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_PHOTOS).getRef().setValue(recordNumberPhotos);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_ACTIONS).getRef().setValue(recordNumberActions);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_DATE_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_DATE_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_ACTION_ANSWER_DATE_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateActionAnswer(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordAnswer,
            final String recordStatus,
            final String recordExperience,
            final String recordPriority,
            final String recordFrequency,
            final String recordCosts,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_ACTION_ANSWER);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_TEXT).setValue(recordAnswer);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_EXPERIENCE).setValue(recordExperience);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_PRIORITY).setValue(recordPriority);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_FREQUENCY).setValue(recordFrequency);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_COSTS).setValue(recordCosts);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_TEXT).setValue(recordAnswer);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_POINTS).setValue(recordNumberPoints);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_SHARING).setValue(recordNumberSharing);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_PHOTOS).setValue(recordNumberPhotos);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_NUMBER_ACTIONS).setValue(recordNumberActions);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_ACTION_ANSWER_DATE_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleActionAnswer> GetOneActionAnswer(String mActionAnswerId) {

        final List<ModelModuleActionAnswer> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_ACTION_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_ACTION_ANSWER_ID).equalTo(mActionAnswerId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleActionAnswer snapshotDetails = snapshot.getValue(ModelModuleActionAnswer.class);
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
    public static List<ModelModuleActionAnswer> ListGetAllActionAnswer() {

        final List<ModelModuleActionAnswer> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_ACTION_ANSWER);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleActionAnswer snapshotDetails = snapshot.getValue(ModelModuleActionAnswer.class);
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
