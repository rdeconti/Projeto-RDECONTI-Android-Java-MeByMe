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
import com.prosper.day.databasemodel.ModelSupportHelp;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.sCurrentApplicationLanguage;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsLanguage;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_HELP_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_HELP_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_HELP_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_HELP_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_HELP_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_HELP_TEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_HELP_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_HELP;

public class FirebaseSupportHelp {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mLanguage;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetSupportHelp(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);
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
    public static boolean FirebaseDeleteAllSupportHelp(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);
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
    public static void firebaseDeleteOneSupportHelp(String mSupportHelpId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_HELP_ID).equalTo(mSupportHelpId);

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
    public static boolean FirebaseUpdateSupportHelp(
            Context context,
            final String recordId,
            final String recordLanguage,
            final String recordPhase,
            final String recordHelpText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_TEXT).setValue(recordHelpText);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleSupportHelp(
            final String recordId,
            final String recordLanguage,
            final String recordPhase,
            final String recordHelpText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_HELP_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_SUPPORT_HELP_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_SUPPORT_HELP_LANGUAGE).getRef().setValue(recordLanguage);
                        snapshot.child(recordId).child(FIELD_SUPPORT_HELP_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_SUPPORT_HELP_TEXT).getRef().setValue(recordHelpText);
                        snapshot.child(recordId).child(FIELD_SUPPORT_HELP_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_SUPPORT_HELP_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_SUPPORT_HELP_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateSupportHelp(
            Context context,
            final String recordId,
            final String recordLanguage,
            final String recordPhase,
            final String recordHelpText,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_LANGUAGE).setValue(recordLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_TEXT).setValue(recordHelpText);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_HELP_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportHelp> GetOneSupportHelp(String mSupportHelpId) {

        final List<ModelSupportHelp> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_HELP_ID).equalTo(mSupportHelpId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportHelp snapshotDetails = snapshot.getValue(ModelSupportHelp.class);
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
    public static List<ModelSupportHelp> ListGetAllSupportHelp() {

        final List<ModelSupportHelp> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportHelp snapshotDetails = snapshot.getValue(ModelSupportHelp.class);
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
    public static List<ModelSupportHelp> GetListByLanguage() {

        final List<ModelSupportHelp> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_HELP);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_HELP_LANGUAGE).equalTo(sCurrentApplicationLanguage);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        mLanguage = snapshot.child(FIELD_SUPPORT_HELP_LANGUAGE).getValue(String.class);

                        if (mLanguage != null) {

                            if (!mLanguage.equals(stringPreferredSettingsLanguage)) {

                                ModelSupportHelp snapshotDetails = snapshot.getValue(ModelSupportHelp.class);
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
