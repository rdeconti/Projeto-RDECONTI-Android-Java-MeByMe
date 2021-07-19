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
import com.prosper.day.databasemodel.ModelModuleBeliefCalendar;

import java.util.ArrayList;
import java.util.List;

import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_CREATION;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_DAY_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_DAY_TO;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_ID;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_MONTH_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_MONTH_TO;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_PHASE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_SIGN;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_SYNC;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_UPDATE;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_YEAR_FROM;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableFields.FIELD_BELIEF_CALENDAR_YEAR_TO;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_CALENDAR;

public class FirebaseModuleBeliefQuestionCalendar {

    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;
    private static String mStringClassName;

    // *********************************************************************************************
    // *********************************************************************************************
    public static boolean FirebaseResetBeliefCalendar(Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_CALENDAR);
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
    public static boolean FirebaseDeleteAllBeliefCalendar(String firebaseKey, Context context) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_CALENDAR);
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
    public static void firebaseDeleteOneBeliefCalendar(String mBeliefCalendarId) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_CALENDAR);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BELIEF_CALENDAR_ID).equalTo(mBeliefCalendarId);

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
    public static boolean FirebaseUpdateBeliefCalendar(
            Context context,
            final String recordId,
            final String recordPhase,
            final String recordSign,
            final String recordDayFrom,
            final String recordMonthFrom,
            final String recordYearFrom,
            final String recordDayTo,                           // Calendar from application
            final String recordMonthTo,                         // Calendar from application
            final String recordYearTo,                          // Calendar from user to question
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
            
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_CALENDAR);

            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_SIGN).setValue(recordSign);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_DAY_FROM).setValue(recordDayFrom);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_MONTH_FROM).setValue(recordMonthFrom);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_YEAR_FROM).setValue(recordYearFrom);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_DAY_TO).setValue(recordDayTo);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_MONTH_TO).setValue(recordMonthTo);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_YEAR_TO).setValue(recordYearTo);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_SYNC).setValue(recordDateSync);

            return true;

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);
            return false;

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void firebaseUpdateSingleBeliefCalendar(
            final String recordId,
            final String recordPhase,
            final String recordSign,
            final String recordDayFrom,
            final String recordMonthFrom,
            final String recordYearFrom,
            final String recordDayTo,                           // Calendar from application
            final String recordMonthTo,                         // Calendar from application
            final String recordYearTo,                          // Calendar from user to question
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_CALENDAR);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BELIEF_CALENDAR_ID).equalTo(recordId);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_ID).getRef().setValue(recordId);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_PHASE).getRef().setValue(recordPhase);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_SIGN).getRef().setValue(recordSign);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_DAY_FROM).getRef().setValue(recordDayFrom);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_MONTH_FROM).getRef().setValue(recordMonthFrom);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_YEAR_FROM).getRef().setValue(recordYearFrom);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_DAY_TO).getRef().setValue(recordDayTo);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_MONTH_TO).getRef().setValue(recordMonthTo);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_YEAR_TO).getRef().setValue(recordYearTo);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_CREATION).getRef().setValue(recordDateCreation);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_UPDATE).getRef().setValue(recordDateUpdate);
                        snapshot.child(recordId).child(FIELD_BELIEF_CALENDAR_SYNC).getRef().setValue(recordDateSync);

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
    public static void firebaseCreateBeliefCalendar(
            Context context,
            final String recordId,
            final String recordPhase,
            final String recordSign,
            final String recordDayFrom,
            final String recordMonthFrom,
            final String recordYearFrom,
            final String recordDayTo,                           // Calendar from application
            final String recordMonthTo,                         // Calendar from application
            final String recordYearTo,                          // Calendar from user to question
            final String recordDateCreation,
            final String recordDateUpdate,
            final String recordDateSync
    ) {

        try {

            mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_CALENDAR);

            String firebaseKey = mDatabaseReference.push().getKey();

            assert firebaseKey != null;

            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_ID).setValue(recordId);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_PHASE).setValue(recordPhase);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_SIGN).setValue(recordSign);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_DAY_FROM).setValue(recordDayFrom);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_MONTH_FROM).setValue(recordMonthFrom);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_YEAR_FROM).setValue(recordYearFrom);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_DAY_TO).setValue(recordDayTo);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_MONTH_TO).setValue(recordMonthTo);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_YEAR_TO).setValue(recordYearTo);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_CREATION).setValue(recordDateCreation);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_UPDATE).setValue(recordDateUpdate);
            mDatabaseReference.child(recordId).child(FIELD_BELIEF_CALENDAR_SYNC).setValue(recordDateSync);

        } catch (Exception error) {

            mStringClassName = String.class.getName();
            new SupportHandlingExceptionError(mStringClassName, error, context);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static List<ModelModuleBeliefCalendar> GetOneBeliefCalendar(String mBeliefCalendarId) {

        final List<ModelModuleBeliefCalendar> list = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_CALENDAR);

        mFirebaseQuery = mDatabaseReference.orderByChild(FIELD_BELIEF_CALENDAR_ID).equalTo(mBeliefCalendarId);

        mFirebaseQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleBeliefCalendar snapshotDetails = snapshot.getValue(ModelModuleBeliefCalendar.class);
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
    public static List<ModelModuleBeliefCalendar> ListGetAllBeliefCalendar() {

        final List<ModelModuleBeliefCalendar> list = new ArrayList<>();

        list.clear();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(TABLE_MODULE_BELIEF_CALENDAR);

        mFirebaseQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleBeliefCalendar snapshotDetails = snapshot.getValue(ModelModuleBeliefCalendar.class);
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
