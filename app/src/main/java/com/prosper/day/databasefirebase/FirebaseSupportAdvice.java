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
import com.prosper.day.databasemodel.ModelSupportAdvice;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsLanguage;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_ADVICE_AUTHOR;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_ADVICE_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_ADVICE_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_ADVICE_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_ADVICE_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_ADVICE_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_ADVICE_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_ADVICE_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_ADVICE;

public class FirebaseSupportAdvice {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mLanguage;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetSupportAdvice(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_ADVICE);
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
    public static boolean FirebaseDeleteAllSupportAdvice(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_ADVICE);
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
    public static void firebaseDeleteOneSupportAdvice(String mSupportAdviceId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_ADVICE);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_ADVICE_ID).equalTo(mSupportAdviceId);

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
    public static boolean FirebaseUpdateSupportAdvice(
            Context context,
            final String recordId,
            final String recordLanguage,
            final String recordNumber,
            final String recordAuthor,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_ADVICE);

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_AUTHOR).setValue(recordAuthor);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleSupportAdvice(
            final String recordId,
            final String recordLanguage,
            final String recordNumber,
            final String recordAuthor,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_ADVICE);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_ADVICE_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_SUPPORT_ADVICE_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_SUPPORT_ADVICE_LANGUAGE).getRef().setValue(recordLanguage);
                        snapshot.child(recordId).child(FIELD_SUPPORT_ADVICE_NUMBER).getRef().setValue(recordNumber);
                        snapshot.child(recordId).child(FIELD_SUPPORT_ADVICE_AUTHOR).getRef().setValue(recordAuthor);
                        snapshot.child(recordId).child(FIELD_SUPPORT_ADVICE_TEXT).getRef().setValue(recordText);
                        snapshot.child(recordId).child(FIELD_SUPPORT_ADVICE_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_SUPPORT_ADVICE_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_SUPPORT_ADVICE_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateSupportAdvice(
            Context context,
            final String recordId,
            final String recordLanguage,
            final String recordNumber,
            final String recordAuthor,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_ADVICE);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_AUTHOR).setValue(recordAuthor);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_ADVICE_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportAdvice> GetOneSupportAdvice(String mSupportAdviceId) {

        final List<ModelSupportAdvice> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_ADVICE);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_ADVICE_ID).equalTo(mSupportAdviceId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportAdvice snapshotDetails = snapshot.getValue(ModelSupportAdvice.class);
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
    public static List<ModelSupportAdvice> ListGetAllSupportAdvice() {

        final List<ModelSupportAdvice> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_ADVICE);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportAdvice snapshotDetails = snapshot.getValue(ModelSupportAdvice.class);
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
    public static List<ModelSupportAdvice> GetListByLanguage() {

        final List<ModelSupportAdvice> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_ADVICE);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_ADVICE_LANGUAGE).equalTo(sCurrentApplicationLanguage);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        mLanguage = snapshot.child(FIELD_SUPPORT_ADVICE_LANGUAGE).getValue(String.class);

                        if (mLanguage != null) {

                            if (!mLanguage.equals(stringPreferredSettingsLanguage)) {

                                ModelSupportAdvice snapshotDetails = snapshot.getValue(ModelSupportAdvice.class);
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
