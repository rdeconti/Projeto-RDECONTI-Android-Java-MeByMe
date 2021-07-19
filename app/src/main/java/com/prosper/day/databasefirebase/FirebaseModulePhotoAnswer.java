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
import com.prosper.day.databasemodel.ModelModulePhotoAnswer;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_DATE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_DATE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_DATE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_IMAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_PHOTO_ANSWER_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_PHOTO_ANSWER;

public class FirebaseModulePhotoAnswer {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetPhotoAnswer(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PHOTO_ANSWER);
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
    public static boolean FirebaseDeleteAllPhotoAnswer(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PHOTO_ANSWER);
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
    public static void firebaseDeleteOnePhotoAnswer(String mPhotoAnswerId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PHOTO_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PHOTO_ANSWER_ID).equalTo(mPhotoAnswerId);

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
    public static boolean FirebaseUpdatePhotoAnswer(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync,
            final byte[] recordImage
            
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PHOTO_ANSWER);

            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_DATE_SYNC).setValue(recordDateSync);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_IMAGE).setValue(recordImage);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSinglePhotoAnswer(
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync,
            final byte[] recordImage
    ) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PHOTO_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PHOTO_ANSWER_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_PHOTO_ANSWER_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_PHOTO_ANSWER_USER_ID).getRef().setValue(recordUserId);
                        snapshot.child(recordId).child(FIELD_PHOTO_ANSWER_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_PHOTO_ANSWER_NUMBER).getRef().setValue(recordNumber);
                        snapshot.child(recordId).child(FIELD_PHOTO_ANSWER_DATE_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_PHOTO_ANSWER_DATE_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_PHOTO_ANSWER_DATE_SYNC).getRef().setValue(recordDateSync);
                        snapshot.child(recordId).child(FIELD_PHOTO_ANSWER_IMAGE).getRef().setValue(recordImage);

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
    public static void firebaseCreatePhotoAnswer(
            Context context,
            final String recordId,
            final String recordUserId,
            final String recordPhase,
            final String recordNumber,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync,
            final byte[] recordImage
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PHOTO_ANSWER);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_USER_ID).setValue(recordUserId);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_DATE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_DATE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_DATE_SYNC).setValue(recordDateSync);
            mDatabaseReference.child(recordId).child(FIELD_PHOTO_ANSWER_IMAGE).setValue(recordImage);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModulePhotoAnswer> GetOnePhotoAnswer(String mPhotoAnswerId) {

        final List<ModelModulePhotoAnswer> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PHOTO_ANSWER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_PHOTO_ANSWER_ID).equalTo(mPhotoAnswerId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModulePhotoAnswer snapshotDetails = snapshot.getValue(ModelModulePhotoAnswer.class);
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
    public static List<ModelModulePhotoAnswer> ListGetAllPhotoAnswer() {

        final List<ModelModulePhotoAnswer> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_PHOTO_ANSWER);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModulePhotoAnswer snapshotDetails = snapshot.getValue(ModelModulePhotoAnswer.class);
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
