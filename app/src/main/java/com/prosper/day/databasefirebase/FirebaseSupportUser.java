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
import com.prosper.day.databasemodel.ModelSupportUser;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_TYPE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_APPLICATION_VERSION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_BIRTHDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_BIRTH_COUNTRY;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_COMPLETE_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_EMAIL;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_FIRST_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_GENDER;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_HEIGHT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_LANGUAGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_LAST_NAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_MARITAL_STATUS;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_NICKNAME;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PASSWORD_BLOCKED;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PASSWORD_FREQUENCY;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_PHOTO;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_RACE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_RELIGION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_RESET_LAST;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SCHOLARSHIP;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SEXUAL_OPTION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SYNC_LAST;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_SYNC_NEXT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_SUPPORT_USER_WEIGHT;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_SUPPORT_USER;

public class FirebaseSupportUser {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetSupportUser(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_USER);
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
    public static boolean FirebaseDeleteAllSupportUser(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_USER);
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
    public static void firebaseDeleteOneSupportUser(String mSupportUserId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_USER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_USER_ID).equalTo(mSupportUserId);

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
    public static boolean FirebaseUpdateSupportUser(
            Context context,
            final String recordId,
            final String recordUserLanguage,
            final String recordUserFirstName,
            final String recordUserLastName,
            final String recordUserCompleteName,
            final String recordUserNickName,
            final String recordUserBirthdate,
            final String recordUserBirthCountry,
            final String recordUserGender,
            final String recordUserSexualOption,
            final String recordUserRace,
            final String recordUserMaritalStatus,
            final String recordUserReligion,
            final String recordUserScholarity,
            final String recordUserHeight,
            final String recordUserWeight,
            final String recordUserEmail,
            final byte[] recordUserPhoto,
            final String recordPasswordChangeLast,
            final String recordPasswordChangeNext,
            final String recordPasswordChangeFrequency,
            final String recordPasswordBlocked,
            final String recordDatabaseSyncLast,
            final String recordDatabaseSyncNext,
            final String recordDatabaseReset,
            final String recordApplicationLanguage,
            final String recordApplicationVersion,
            final String recordApplicationType,
            final String recordApplicationDonationDate,
            final String recordApplicationDonationValue,
            final String recordApplicationEvaluationDate,
            final String recordApplicationEvaluationValue,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync

        ) {
        
        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_USER);

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_LANGUAGE).setValue(recordUserLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_FIRST_NAME).setValue(recordUserFirstName);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_LAST_NAME).setValue(recordUserLastName);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_COMPLETE_NAME).setValue(recordUserCompleteName);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_NICKNAME).setValue(recordUserNickName);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_BIRTHDATE).setValue(recordUserBirthdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_BIRTH_COUNTRY).setValue(recordUserBirthCountry);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_GENDER).setValue(recordUserGender);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SEXUAL_OPTION).setValue(recordUserSexualOption);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_RACE).setValue(recordUserRace);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_MARITAL_STATUS).setValue(recordUserMaritalStatus);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_RELIGION).setValue(recordUserReligion);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SCHOLARSHIP).setValue(recordUserScholarity);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_HEIGHT).setValue(recordUserHeight);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_WEIGHT).setValue(recordUserWeight);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_EMAIL).setValue(recordUserEmail);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PHOTO).setValue(recordUserPhoto);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE).setValue(recordPasswordChangeLast);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE).setValue(recordPasswordChangeNext);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_FREQUENCY).setValue(recordPasswordChangeFrequency);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_BLOCKED).setValue(recordPasswordBlocked);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SYNC_LAST).setValue(recordDatabaseSyncLast);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SYNC_NEXT).setValue(recordDatabaseSyncNext);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_RESET_LAST).setValue(recordDatabaseReset);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_LANGUAGE).setValue(recordApplicationLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_VERSION).setValue(recordApplicationVersion);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_TYPE).setValue(recordApplicationType);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE).setValue(recordApplicationDonationDate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE).setValue(recordApplicationDonationValue);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE).setValue(recordApplicationEvaluationDate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE).setValue(recordApplicationEvaluationValue);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleSupportUser(
            final String recordId,
            final String recordUserLanguage,
            final String recordUserFirstName,
            final String recordUserLastName,
            final String recordUserCompleteName,
            final String recordUserNickName,
            final String recordUserBirthdate,
            final String recordUserBirthCountry,
            final String recordUserGender,
            final String recordUserSexualOption,
            final String recordUserRace,
            final String recordUserMaritalStatus,
            final String recordUserReligion,
            final String recordUserScholarity,
            final String recordUserHeight,
            final String recordUserWeight,
            final String recordUserEmail,
            final byte[] recordUserPhoto,
            final String recordPasswordChangeLast,
            final String recordPasswordChangeNext,
            final String recordPasswordChangeFrequency,
            final String recordPasswordBlocked,
            final String recordDatabaseSyncLast,
            final String recordDatabaseSyncNext,
            final String recordDatabaseReset,
            final String recordApplicationLanguage,
            final String recordApplicationVersion,
            final String recordApplicationType,
            final String recordApplicationDonationDate,
            final String recordApplicationDonationValue,
            final String recordApplicationEvaluationDate,
            final String recordApplicationEvaluationValue,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync

    ) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_USER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_USER_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_LANGUAGE).getRef().setValue(recordUserLanguage);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_FIRST_NAME).getRef().setValue(recordUserFirstName);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_LAST_NAME).getRef().setValue(recordUserLastName);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_COMPLETE_NAME).getRef().setValue(recordUserCompleteName);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_NICKNAME).getRef().setValue(recordUserNickName);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_BIRTHDATE).getRef().setValue(recordUserBirthdate);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_BIRTH_COUNTRY).getRef().setValue(recordUserBirthCountry);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_GENDER).getRef().setValue(recordUserGender);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_SEXUAL_OPTION).getRef().setValue(recordUserSexualOption);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_RACE).getRef().setValue(recordUserRace);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_MARITAL_STATUS).getRef().setValue(recordUserMaritalStatus);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_RELIGION).getRef().setValue(recordUserReligion);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_SCHOLARSHIP).getRef().setValue(recordUserScholarity);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_HEIGHT).getRef().setValue(recordUserHeight);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_WEIGHT).getRef().setValue(recordUserWeight);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_EMAIL).getRef().setValue(recordUserEmail);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_PHOTO).getRef().setValue(recordUserPhoto);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE).getRef().setValue(recordPasswordChangeLast);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE).getRef().setValue(recordPasswordChangeNext);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_FREQUENCY).getRef().setValue(recordPasswordChangeFrequency);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_BLOCKED).getRef().setValue(recordPasswordBlocked);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_SYNC_LAST).getRef().setValue(recordDatabaseSyncLast);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_SYNC_NEXT).getRef().setValue(recordDatabaseSyncNext);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_RESET_LAST).getRef().setValue(recordDatabaseReset);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_LANGUAGE).getRef().setValue(recordApplicationLanguage);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_VERSION).getRef().setValue(recordApplicationVersion);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_TYPE).getRef().setValue(recordApplicationType);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE).getRef().setValue(recordApplicationDonationDate);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE).getRef().setValue(recordApplicationDonationValue);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE).getRef().setValue(recordApplicationEvaluationDate);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE).getRef().setValue(recordApplicationEvaluationValue);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_SUPPORT_USER_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateSupportUser(
            Context context,
            final String recordId,
            final String recordUserLanguage,
            final String recordUserFirstName,
            final String recordUserLastName,
            final String recordUserCompleteName,
            final String recordUserNickName,
            final String recordUserBirthdate,
            final String recordUserBirthCountry,
            final String recordUserGender,
            final String recordUserSexualOption,
            final String recordUserRace,
            final String recordUserMaritalStatus,
            final String recordUserReligion,
            final String recordUserScholarity,
            final String recordUserHeight,
            final String recordUserWeight,
            final String recordUserEmail,
            final byte[] recordUserPhoto,
            final String recordPasswordChangeLast,
            final String recordPasswordChangeNext,
            final String recordPasswordChangeFrequency,
            final String recordPasswordBlocked,
            final String recordDatabaseSyncLast,
            final String recordDatabaseSyncNext,
            final String recordDatabaseReset,
            final String recordApplicationLanguage,
            final String recordApplicationVersion,
            final String recordApplicationType,
            final String recordApplicationDonationDate,
            final String recordApplicationDonationValue,
            final String recordApplicationEvaluationDate,
            final String recordApplicationEvaluationValue,
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync

    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_USER);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_LANGUAGE).setValue(recordUserLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_FIRST_NAME).setValue(recordUserFirstName);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_LAST_NAME).setValue(recordUserLastName);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_COMPLETE_NAME).setValue(recordUserCompleteName);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_NICKNAME).setValue(recordUserNickName);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_BIRTHDATE).setValue(recordUserBirthdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_BIRTH_COUNTRY).setValue(recordUserBirthCountry);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_GENDER).setValue(recordUserGender);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SEXUAL_OPTION).setValue(recordUserSexualOption);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_RACE).setValue(recordUserRace);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_MARITAL_STATUS).setValue(recordUserMaritalStatus);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_RELIGION).setValue(recordUserReligion);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SCHOLARSHIP).setValue(recordUserScholarity);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_HEIGHT).setValue(recordUserHeight);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_WEIGHT).setValue(recordUserWeight);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_EMAIL).setValue(recordUserEmail);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PHOTO).setValue(recordUserPhoto);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_LAST_CHANGE).setValue(recordPasswordChangeLast);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_NEXT_CHANGE).setValue(recordPasswordChangeNext);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_FREQUENCY).setValue(recordPasswordChangeFrequency);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_PASSWORD_BLOCKED).setValue(recordPasswordBlocked);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SYNC_LAST).setValue(recordDatabaseSyncLast);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SYNC_NEXT).setValue(recordDatabaseSyncNext);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_RESET_LAST).setValue(recordDatabaseReset);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_LANGUAGE).setValue(recordApplicationLanguage);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_VERSION).setValue(recordApplicationVersion);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_TYPE).setValue(recordApplicationType);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_DONATION_DATE).setValue(recordApplicationDonationDate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_DONATION_VALUE).setValue(recordApplicationDonationValue);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_DATE).setValue(recordApplicationEvaluationDate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_APPLICATION_EVALUATION_VALUE).setValue(recordApplicationEvaluationValue);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_SUPPORT_USER_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelSupportUser> GetOneSupportUser(String mSupportUserId) {

        final List<ModelSupportUser> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_USER);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_SUPPORT_USER_ID).equalTo(mSupportUserId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportUser snapshotDetails = snapshot.getValue(ModelSupportUser.class);
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
    public static List<ModelSupportUser> ListGetAllSupportUser() {

        final List<ModelSupportUser> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_SUPPORT_USER);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelSupportUser snapshotDetails = snapshot.getValue(ModelSupportUser.class);
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
