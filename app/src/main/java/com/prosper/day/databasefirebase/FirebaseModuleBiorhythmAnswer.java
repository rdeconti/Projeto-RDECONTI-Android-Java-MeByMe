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
import com.prosper.day.databasemodel.ModelModuleBiorhythmAnswer;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_DATE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_DATE_EVENT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_DATE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_DATE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_EMOTIONAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_EXPERIENCE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_INTELECTUAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_NUMBER_ACTIONS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_NUMBER_PHOTOS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_NUMBER_POINTS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_NUMBER_SHARING;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_PHYSICAL;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BIORHYTHM_ANSWER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BIORHYTHM_ANSWER;

public class FirebaseModuleBiorhythmAnswer {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetBiorhythmAnswer(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BIORHYTHM_ANSWER);
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
    public static boolean FirebaseDeleteAllBiorhythmAnswer(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BIORHYTHM_ANSWER);
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
    public static void firebaseDeleteOneBiorhythmAnswer(String mBiorhythmAnswerId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BIORHYTHM_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BIORHYTHM_ANSWER_ID).equalTo(mBiorhythmAnswerId);

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
    public static boolean FirebaseUpdateBiorhythmAnswer(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordExperience,
            final double recordEmotional,
            final double recordPhysical,
            final double recordIntelectual,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateEvent,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BIORHYTHM_ANSWER);

            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_EXPERIENCE).setValue(recordExperience);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_EMOTIONAL).setValue(recordEmotional);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_PHYSICAL).setValue(recordPhysical);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_INTELECTUAL).setValue(recordIntelectual);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_POINTS).setValue(recordNumberPoints);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_SHARING).setValue(recordNumberSharing);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_PHOTOS).setValue(recordNumberPhotos);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_ACTIONS).setValue(recordNumberActions);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_EVENT).setValue(recordDateEvent);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleBiorhythmAnswer(
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordExperience,
            final double recordEmotional,
            final double recordPhysical,
            final double recordIntelectual,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateEvent,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BIORHYTHM_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BIORHYTHM_ANSWER_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_USER_ID).getRef().setValue(recordUserId);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER).getRef().setValue(recordNumber);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_STATUS).getRef().setValue(recordStatus);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_EXPERIENCE).getRef().setValue(recordExperience);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_EMOTIONAL).getRef().setValue(recordEmotional);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_PHYSICAL).getRef().setValue(recordPhysical);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_INTELECTUAL).getRef().setValue(recordIntelectual);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_POINTS).getRef().setValue(recordNumberPoints);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_SHARING).getRef().setValue(recordNumberSharing);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_PHOTOS).getRef().setValue(recordNumberPhotos);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_ACTIONS).getRef().setValue(recordNumberActions);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_EVENT).getRef().setValue(recordDateEvent);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateBiorhythmAnswer(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordExperience,
            final double recordEmotional,
            final double recordPhysical,
            final double recordIntelectual,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateEvent,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BIORHYTHM_ANSWER);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_EXPERIENCE).setValue(recordExperience);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_EMOTIONAL).setValue(recordEmotional);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_PHYSICAL).setValue(recordPhysical);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_INTELECTUAL).setValue(recordIntelectual);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_POINTS).setValue(recordNumberPoints);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_SHARING).setValue(recordNumberSharing);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_PHOTOS).setValue(recordNumberPhotos);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_NUMBER_ACTIONS).setValue(recordNumberActions);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_EVENT).setValue(recordDateEvent);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_BIORHYTHM_ANSWER_DATE_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleBiorhythmAnswer> GetOneBiorhythmAnswer(String mBiorhythmAnswerId) {

        final List<ModelModuleBiorhythmAnswer> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BIORHYTHM_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BIORHYTHM_ANSWER_ID).equalTo(mBiorhythmAnswerId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleBiorhythmAnswer snapshotDetails = snapshot.getValue(ModelModuleBiorhythmAnswer.class);
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
    public static List<ModelModuleBiorhythmAnswer> ListGetAllBiorhythmAnswer() {

        final List<ModelModuleBiorhythmAnswer> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BIORHYTHM_ANSWER);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleBiorhythmAnswer snapshotDetails = snapshot.getValue(ModelModuleBiorhythmAnswer.class);
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
