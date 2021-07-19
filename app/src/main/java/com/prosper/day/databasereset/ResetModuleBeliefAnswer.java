package com.prosper.day.databasereset;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.prosper.day.R;
import com.prosper.day.databasesqlite.SqliteModuleBeliefCalendar;
import com.prosper.day.databasesqlite.SqliteModuleBeliefDescription;

import java.io.ByteArrayOutputStream;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.BELIEF_PHASE_CODE_05_13;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_NORMAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionFirestoreImages.PATH_BELIEF_PHASE_CODE_05_13;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.SIGN_FILE_TYPE;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseUserId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsUserBirthdate;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringPreferredSettingsUserId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.databasereset.ResetSupportPointsUser.resetSupportPointsUser;
import static com.prosper.day.databasesqlite.SqliteModuleBeliefAnswer.sqliteInsert;

public class ResetModuleBeliefAnswer {

    private static String mStringCurrentUpdatedDateTime;

    private static String recordUserId;
    private static String recordPhase;
    private static String recordSign;
    private static String recordStatus;
    private static String recordExperience;
    private static String recordAnswerName;
    private static String recordAnswerDescription;
    private static String recordNumberPoints;
    private static String recordNumberSharing;
    private static String recordNumberPhotos;
    private static String recordNumberActions;
    private static String recordDateCreation;
    private static String recordDateUpdate;
    private static String recordDateSync;
    private static byte[] recordImage;

    private static StorageReference mStorageReference;

    private static Bitmap mBitmap;
    private static byte[] mByte;

    private static String mStringPath;
    private static String mStringDay;
    private static String mStringMonth;
    private static String mStringYear;

    // *********************************************************************************************
    // *********************************************************************************************
    public static void resetModuleBeliefAnswer(Context context) {

        recordUserId = stringPreferredSettingsUserId;

        recordStatus = STATUS_NEW;
        recordExperience = EXPERIENCE_NORMAL;

        recordNumberPoints = STRING_NUMBER_00;
        recordNumberSharing = STRING_NUMBER_00;
        recordNumberPhotos = STRING_NUMBER_00;
        recordNumberActions = STRING_NUMBER_00;

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();
        recordDateCreation = mStringCurrentUpdatedDateTime;
        recordDateUpdate = mStringCurrentUpdatedDateTime;
        recordDateSync = mStringCurrentUpdatedDateTime;

        mStringDay = stringPreferredSettingsUserBirthdate.substring(6, 8);
        mStringMonth = stringPreferredSettingsUserBirthdate.substring(4, 6);
        mStringYear = stringPreferredSettingsUserBirthdate.substring(0, 4);

        recordPhase = BELIEF_PHASE_CODE_05_01;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_02;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_03;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_04;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_05;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_06;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_07;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_08;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_09;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_10;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_11;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_12;
        generateBeliefAnswer(context);

        recordPhase = BELIEF_PHASE_CODE_05_13;
        generateBeliefAnswer(context);

        SqliteModuleBeliefCalendar.sqliteDeleteAll(context);
        SqliteModuleBeliefDescription.sqliteDeleteAll(context);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private static void generateBeliefAnswer(Context context) {

        recordUserId = stringCurrentUserFirebaseUserId;

        recordSign = SqliteModuleBeliefCalendar.sqliteGetOne(context, recordPhase, mStringDay, mStringMonth, mStringYear);
        recordAnswerName = SqliteModuleBeliefDescription.sqliteGetOneName(context, recordPhase, recordSign);
        recordAnswerDescription = SqliteModuleBeliefDescription.sqliteGetOneDescription(context, recordPhase, recordSign);
        obtainImageFromFirebase(context);

        sqliteInsert(
                context,
                recordUserId,
                recordPhase,
                recordSign,
                recordStatus,
                recordExperience,
                recordAnswerName,
                recordAnswerDescription,
                recordNumberPoints,
                recordNumberSharing,
                recordNumberPhotos,
                recordNumberActions,
                recordDateCreation,
                recordDateUpdate,
                recordDateSync,
                recordImage);

        resetSupportPointsUser(context, recordUserId, recordPhase, recordSign);

    }

    /* ********************************************************************************************/
    /* ********************************************************************************************/
    private static void obtainImageFromFirebase(Context context) {

        switch (recordPhase) {

            case BELIEF_PHASE_CODE_05_01:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_01;
                break;

            case BELIEF_PHASE_CODE_05_02:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_02;
                break;

            case BELIEF_PHASE_CODE_05_03:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_03;
                break;

            case BELIEF_PHASE_CODE_05_04:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_04;
                break;

            case BELIEF_PHASE_CODE_05_05:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_05;
                break;

            case BELIEF_PHASE_CODE_05_06:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_06;
                break;

            case BELIEF_PHASE_CODE_05_07:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_07;
                break;

            case BELIEF_PHASE_CODE_05_08:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_08;
                break;

            case BELIEF_PHASE_CODE_05_09:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_09;
                break;

            case BELIEF_PHASE_CODE_05_10:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_10;
                break;

            case BELIEF_PHASE_CODE_05_11:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_11;
                break;

            case BELIEF_PHASE_CODE_05_12:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_12;
                break;

            case BELIEF_PHASE_CODE_05_13:
                mStringPath = PATH_BELIEF_PHASE_CODE_05_13;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + recordPhase);
        }

        mStorageReference = FirebaseStorage.getInstance().getReference().child(mStringPath).child(recordSign + SIGN_FILE_TYPE);

        Resources resources = context.getResources();
        Drawable drawable = resources.getDrawable(R.drawable.application_bitmap_small);
        mBitmap = ((BitmapDrawable)drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        mByte = stream.toByteArray();
        recordImage = mByte;

        final long oneMegabyte = 1024 * 1024;
        mStorageReference.getBytes(oneMegabyte).addOnSuccessListener(new
          OnSuccessListener<byte[]>() {
              @Override
              public void onSuccess(byte[] bytes) {

                  recordImage = bytes;

              }

          }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {

                // Handle any errors
            }
        });

    }
}
