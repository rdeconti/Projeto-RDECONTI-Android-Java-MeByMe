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
import com.prosper.day.databasemodel.ModelSupportPointsUser;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_POINTS_USER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_POINTS_USER;

public class FirebaseSupportPointsUser {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetSupportPointsUser(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_POINTS_USER);
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
    public static boolean FirebaseDeleteAllSupportPointsUser(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_POINTS_USER);
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
    public static void firebaseDeleteOneSupportPointsUser(String mSupportPointsUserId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_POINTS_USER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_POINTS_USER_ID).equalTo(mSupportPointsUserId);

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
    public static boolean FirebaseUpdateSupportPointsUser(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync

    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_POINTS_USER);

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS).setValue(recordNumberPoints);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS).setValue(recordNumberSharing);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS).setValue(recordNumberPhotos);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS).setValue(recordNumberActions);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleSupportPointsUser(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync

    ) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_POINTS_USER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_POINTS_USER_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_USER_ID).getRef().setValue(recordUserId);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER).getRef().setValue(recordNumber);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_STATUS).getRef().setValue(recordStatus);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS).getRef().setValue(recordNumberPoints);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS).getRef().setValue(recordNumberSharing);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS).getRef().setValue(recordNumberPhotos);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS).getRef().setValue(recordNumberActions);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_SUPPORT_POINTS_USER_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateSupportPointsUser(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordStatus,
            final String recordNumberPoints,
            final String recordNumberSharing,
            final String recordNumberPhotos,
            final String recordNumberActions,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync

    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_POINTS_USER);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_STATUS).setValue(recordStatus);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_POINTS).setValue(recordNumberPoints);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_SHARINGS).setValue(recordNumberSharing);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_PHOTOS).setValue(recordNumberPhotos);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_NUMBER_ACTIONS).setValue(recordNumberActions);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_POINTS_USER_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportPointsUser> GetOneSupportPointsUser(String mSupportPointsUserId) {

        final List<ModelSupportPointsUser> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_POINTS_USER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_POINTS_USER_ID).equalTo(mSupportPointsUserId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportPointsUser snapshotDetails = snapshot.getValue(ModelSupportPointsUser.class);
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
    public static List<ModelSupportPointsUser> ListGetAllSupportPointsUser() {

        final List<ModelSupportPointsUser> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_POINTS_USER);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportPointsUser snapshotDetails = snapshot.getValue(ModelSupportPointsUser.class);
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
