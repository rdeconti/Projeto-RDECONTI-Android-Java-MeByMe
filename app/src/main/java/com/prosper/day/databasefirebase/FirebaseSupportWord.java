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
import com.prosper.day.databasemodel.ModelSupportWord;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsLanguage;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_WORD_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_WORD_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_WORD_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_WORD_NUMBER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_WORD_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_WORD_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_WORD_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_WORD;

public class FirebaseSupportWord {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mLanguage;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetSupportWord(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);
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
    public static boolean FirebaseDeleteAllSupportWord(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);
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
    public static void firebaseDeleteOneSupportWord(String mSupportWordId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_WORD_ID).equalTo(mSupportWordId);

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
    public static boolean FirebaseUpdateSupportWord(
            Context context,
            final String recordId,
            final String recordLanguage,
            final String recordNumber,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleSupportWord(
            final String recordId,
            final String recordLanguage,
            final String recordNumber,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_WORD_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_SUPPORT_WORD_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_SUPPORT_WORD_LANGUAGE).getRef().setValue(recordLanguage);
                        snapshot.child(recordId).child(FIELD_SUPPORT_WORD_NUMBER).getRef().setValue(recordNumber);
                        snapshot.child(recordId).child(FIELD_SUPPORT_WORD_TEXT).getRef().setValue(recordText);
                        snapshot.child(recordId).child(FIELD_SUPPORT_WORD_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_SUPPORT_WORD_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_SUPPORT_WORD_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateSupportWord(
            Context context,
            final String recordId,
            final String recordLanguage,
            final String recordNumber,
            final String recordText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_NUMBER).setValue(recordNumber);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_TEXT).setValue(recordText);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_WORD_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportWord> GetOneSupportWord(String mSupportWordId) {

        final List<ModelSupportWord> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_WORD_ID).equalTo(mSupportWordId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportWord snapshotDetails = snapshot.getValue(ModelSupportWord.class);
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
    public static List<ModelSupportWord> ListGetAllSupportWord() {

        final List<ModelSupportWord> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportWord snapshotDetails = snapshot.getValue(ModelSupportWord.class);
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
    public static List<ModelSupportWord> GetListByLanguage() {

        final List<ModelSupportWord> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_WORD);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_WORD_LANGUAGE).equalTo(sCurrentApplicationLanguage);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        mLanguage = snapshot.child(FIELD_SUPPORT_WORD_LANGUAGE).getValue(String.class);

                        if (mLanguage != null) {

                            if (!mLanguage.equals(stringPreferredSettingsLanguage)) {

                                ModelSupportWord snapshotDetails = snapshot.getValue(ModelSupportWord.class);
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
