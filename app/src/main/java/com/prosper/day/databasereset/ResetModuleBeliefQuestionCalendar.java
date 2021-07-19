package com.prosper.day.databasereset;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.prosper.day.applicationsupportclasses.SupportHandlingDatabaseError;
import com.prosper.day.databasemodel.ModelModuleBeliefCalendar;

import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasedefinition.SqliteDatabaseTableNames.TABLE_MODULE_BELIEF_CALENDAR;
import static com.prosper.day.databasesqlite.SqliteModuleBeliefCalendar.sqliteInsert;

public class ResetModuleBeliefQuestionCalendar {

    private static FirebaseDatabase mFirebaseDatabase;
    private static DatabaseReference mDatabaseReference;
    private static Query mFirebaseQuery;

    private static String mStringCurrentUpdatedDateTime;
    
    private static String recordPhase;
    private static String recordSign;
    private static String recordDayFrom;
    private static String recordMonthFrom;
    private static String recordYearFrom;
    private static String recordDayTo;
    private static String recordMonthTo;
    private static String recordYearTo;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModuleBeliefQuestionCalendar(Context context) {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference(TABLE_MODULE_BELIEF_CALENDAR);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        ModelModuleBeliefCalendar snapshotDetails = snapshot.getValue(ModelModuleBeliefCalendar.class);

                        assert snapshotDetails != null;
                        recordPhase = snapshotDetails.getRecordPhase();
                        recordSign = snapshotDetails.getRecordSign();
                        recordDayFrom = snapshotDetails.getRecordDayFrom();
                        recordMonthFrom = snapshotDetails.getRecordMonthFrom();
                        recordYearFrom = snapshotDetails.getRecordYearFrom();
                        recordDayTo = snapshotDetails.getRecordDayTo();
                        recordMonthTo = snapshotDetails.getRecordMonthTo();
                        recordYearTo = snapshotDetails.getRecordYearTo();

                        sqliteInsert(
                                context,
                                recordPhase,
                                recordSign,
                                recordDayFrom,
                                recordMonthFrom,
                                recordYearFrom,
                                recordDayTo,
                                recordMonthTo,
                                recordYearTo,
                                recordDateCreation,
                                recordDateUpdate,
                                recordDateSync);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                new SupportHandlingDatabaseError(this.getClass().getSimpleName(), databaseError);

            }
        });
    }
}
