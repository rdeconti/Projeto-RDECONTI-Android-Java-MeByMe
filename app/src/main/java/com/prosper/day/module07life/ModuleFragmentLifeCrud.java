package com.prosper.day.module07life;

 /* ****************************************************************************
 /* Copyright (C) 2016 The Android Open Source Project
 /*
 /* Licensed under the Apache License, Version 2.0 (the "License");
 /* you may not use this file except in compliance with the License.
 /* You may obtain a copy of the License at
 /*
 /*     http://www.apache.org/licenses/LICENSE-2.0
 /*
 /* Unless required by applicable law or agreed to in writing, software
 /* distributed under the License is distributed on an "AS IS" BASIS,
 /* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 /* See the License for the specific language governing permissions and
 /* limitations under the License.
 /* ****************************************************************************
 /* Created by Rosemeire Deconti on 2019 / July
 /* ****************************************************************************/

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportGeneralDateTime;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseCodePhoto;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseCodeSharing;
import com.prosper.day.applicationsupportclasses.SupportMessageToast;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelModuleLifeAnswer;
import com.prosper.day.databasemodel.ModelSupportUser;
import com.prosper.day.databasesqlite.SqliteModuleLifeAnswer;
import com.prosper.day.databasesqlite.SqliteModulePhotoAnswer;
import com.prosper.day.databasesqlite.SqliteModuleSharingAnswer;
import com.prosper.day.databasesqlite.SqliteSupportPointsUser;
import com.prosper.day.databasesqlite.SqliteSupportUser;
import com.prosper.day.module08action.ModuleFragmentActionCrud;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;
import static android.graphics.Bitmap.createBitmap;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_BAD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_GOOD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_NORMAL;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_VERY_BAD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.EXPERIENCE_VERY_GOOD;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_CLOSED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_IGNORED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_NEW;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_PENDING;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodeStatus.STATUS_POSTPONED;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.globalStringArrayList;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentAnswerId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.CRUD_C;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCrudType;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.stringCurrentUserFirebaseUserId;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_00;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.STRING_NUMBER_NN;
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPoints;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPointsActions;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPointsPhotosDecrease;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPointsPhotosIncrease;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPointsSharing;

// *********************************************************************************************
// *********************************************************************************************
public class ModuleFragmentLifeCrud extends Fragment implements TextToSpeech.OnInitListener {

    private View mView;
    private Context mContext;
    private AppCompatActivity mAppCompatActivity;
    private FrameLayout frameLayout;
    private Intent mIntent;
    private Drawable mDrawable;

    private File mFile;
    private Uri mUri;
    private Bitmap mBitmap;
    private ByteArrayOutputStream mByteArrayOutputStream;
    private FileOutputStream mFileOutputStream;
    private TextToSpeech textToSpeech;

    private byte[] mByte;

    private List<ModelSupportUser> mArrayListUser;
    private String mStringCurrentUserName;
    private byte[] mByteCurrentUserPhoto;

    private ImageView mImageViewPhoto;
    private ImageView mImageViewStatus;

    private ImageButton mImageButtonSpeakerQuestion;
    private ImageButton mImageButtonRecorderAnswer;
    private ImageButton mImageButtonPhotoPrevious;
    private ImageButton mImageButtonPhotoNext;

    private Button mButtonPhotoDevice;
    private Button mButtonPhotoCamera;
    private Button mButtonPhotoRemove;

    private TextView mTextViewValueNumberPoints;
    private TextView mTextViewValueNumberPhotos;
    private TextView mTextViewValueNumberActions;
    private TextView mTextViewValueNumberSharing;
    private TextView mTextViewValueQuestion;
    private TextView mTextViewGradeValue;
    private TextView mTextViewPhotoValue;
    private TextView mTextViewStatusValue;
    private TextView mTextViewLength;
    private TextView mTextViewExperienceValue;
    private EditText mEditTextValueAnswer;

    private RadioGroup mRadioGroupGrade;
    private RadioButton mRadioButtonGrade00;
    private RadioButton mRadioButtonGrade01;
    private RadioButton mRadioButtonGrade02;
    private RadioButton mRadioButtonGrade03;
    private RadioButton mRadioButtonGrade04;
    private RadioButton mRadioButtonGrade05;
    private RadioButton mRadioButtonGrade06;
    private RadioButton mRadioButtonGrade07;
    private RadioButton mRadioButtonGrade08;
    private RadioButton mRadioButtonGrade09;
    private RadioButton mRadioButtonGrade10;

    private int mIntCurrentRecordNumber;
    private String mStringCurrentAnswerUserId;
    private String mStringCurrentAnswerPhase;
    private String mStringCurrentAnswerNumber;
    private String mStringCurrentAnswerStatus;
    private String mStringCurrentAnswerExperience;
    private String mStringCurrentAnswerGrade;
    private String mStringCurrentQuestionText;
    private String mStringCurrentAnswerNumberPoints;
    private String mStringCurrentAnswerNumberSharing;
    private String mStringCurrentAnswerNumberPhotos;
    private String mStringCurrentAnswerNumberActions;
    private String mStringCurrentAnswerDateCreation;
    private String mStringCurrentAnswerDateUpdated;
    private String mStringCurrentAnswerDateSync;
    private String mStringCurrentQuestionTitle;

    private String mStringImagePath;
    private String mStringPhotoController;
    private String mStringFormattedDateTime;
    private String mStringCurrentPhotoId;
    private String mStringCurrentAnswer;
    private String mStringCurrentQuestion;
    private String mStringCurrentFragment;
    private String mStringCurrentUpdatedDateTime;
    private String mStringPhotoPhaseCode;
    private String mStringSharingPhaseCode;

    private int mIntIndex;
    private int mIntPhotoNumberTotal;
    private int mIntPhotoNumberCounter;
    private int mIntPhotoNumberCurrent;
    private int mIntNumberCounter;
    private final int mIntRequestImageCapture = 1;
    private final int mIntRequestImagePick = 2;
    private int mIntCurrentPhotoId;

    private List<ModelModuleLifeAnswer> mArrayListAnswer;
    private ArrayList<byte[]> mPhotoArrayListByte;

    private FloatingActionButton mFloatingActionButtonMaster;
    private FloatingActionButton mFloatingActionButtonShare;
    private FloatingActionButton mFloatingActionButtonExperience;
    private FloatingActionButton mFloatingActionButtonAction;
    private FloatingActionButton mFloatingActionButtonStatus;

    private TextView mTextViewStatus;
    private TextView mTextViewExperience;
    private TextView mTextViewAction;
    private TextView mTextViewShare;

    private Boolean isFloatingActionButtonOpen = false;

    private Animation mAnimationFloatingActionButtonOpen;
    private Animation mAnimationFloatingActionButtonClose;
    private Animation mAnimationFloatingActionButtonOpenRotateForward;
    private Animation mAnimationFloatingActionButtonOpenRotateBackward;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentLifeCrud() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.life_crud_fragment, viewGroup, false);

        initializeLayoutHeader();

        readDataFromDatabase();

        initializeNumberPoints();
        initializeNumberPhotos();
        initializeNumberActions();
        initializeNumberSharing();

        initializeButtons();
        initializeImageButtons();
        initializeFloatingActionButtons();

        initializeQuestionAnswer();
        initializeAnswerLength();
        initializeGrade();

        initializePhotosHeader();
        initializePhotosData();

        initializeStatusHeader();
        initializeStatusData();
        initializeExperienceData();

        // *****************************************************************************************
        // *****************************************************************************************
        mRadioGroupGrade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                mRadioButtonGrade00.setActivated(false);
                mRadioButtonGrade01.setActivated(false);
                mRadioButtonGrade02.setActivated(false);
                mRadioButtonGrade03.setActivated(false);
                mRadioButtonGrade04.setActivated(false);
                mRadioButtonGrade05.setActivated(false);
                mRadioButtonGrade06.setActivated(false);
                mRadioButtonGrade07.setActivated(false);
                mRadioButtonGrade08.setActivated(false);
                mRadioButtonGrade09.setActivated(false);
                mRadioButtonGrade10.setActivated(false);

                mRadioButtonGrade00.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade01.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade02.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade03.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade04.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade05.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade06.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade07.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade08.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade09.setBackgroundColor(Color.TRANSPARENT);
                mRadioButtonGrade10.setBackgroundColor(Color.TRANSPARENT);

                switch (checkedId) {

                    case R.id.radioGrade00:
                        mStringCurrentAnswerGrade = STRING_NUMBER_00;
                        mRadioButtonGrade00.setChecked(true);
                        mRadioButtonGrade00.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade01:
                        mStringCurrentAnswerGrade = STRING_NUMBER_01;
                        mRadioButtonGrade01.setChecked(true);
                        mRadioButtonGrade01.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade02:
                        mStringCurrentAnswerGrade = STRING_NUMBER_02;
                        mRadioButtonGrade02.setChecked(true);
                        mRadioButtonGrade02.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade03:
                        mStringCurrentAnswerGrade = STRING_NUMBER_03;
                        mRadioButtonGrade03.setChecked(true);
                        mRadioButtonGrade03.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade04:
                        mStringCurrentAnswerGrade = STRING_NUMBER_04;
                        mRadioButtonGrade04.setChecked(true);
                        mRadioButtonGrade04.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade05:
                        mStringCurrentAnswerGrade = STRING_NUMBER_05;
                        mRadioButtonGrade05.setChecked(true);
                        mRadioButtonGrade05.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade06:
                        mStringCurrentAnswerGrade = STRING_NUMBER_06;
                        mRadioButtonGrade06.setChecked(true);
                        mRadioButtonGrade06.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade07:
                        mStringCurrentAnswerGrade = STRING_NUMBER_07;
                        mRadioButtonGrade07.setChecked(true);
                        mRadioButtonGrade07.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade08:
                        mStringCurrentAnswerGrade = STRING_NUMBER_08;
                        mRadioButtonGrade08.setChecked(true);
                        mRadioButtonGrade08.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade09:
                        mStringCurrentAnswerGrade = STRING_NUMBER_09;
                        mRadioButtonGrade09.setChecked(true);
                        mRadioButtonGrade09.setBackgroundColor(Color.LTGRAY);
                        break;

                    case R.id.radioGrade10:
                        mStringCurrentAnswerGrade = STRING_NUMBER_10;
                        mRadioButtonGrade10.setChecked(true);
                        mRadioButtonGrade10.setBackgroundColor(Color.LTGRAY);
                        break;

                }

                mTextViewGradeValue.setText(mStringCurrentAnswerGrade);

                updateDatabaseGrade();

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhotoRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mIntPhotoNumberTotal > INT_NUMBER_00) {

                    mIntCurrentPhotoId = Integer.parseInt(globalStringArrayList.get(mIntPhotoNumberCurrent));

                    updateNumberPoints();
                    updateNumberPhotosDecrease();

                    SqliteModulePhotoAnswer.sqliteDeleteOne(
                            mContext,
                            mIntCurrentPhotoId);

                    initializePhotosData();

                }
            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhotoCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                }

                mIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(mIntent, mIntRequestImageCapture);

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonPhotoDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mIntent = new Intent();
                mIntent.setType("image/*");
                mIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(mIntent, "Select Picture"), mIntRequestImagePick);

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mImageButtonSpeakerQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                executeTextToSpeech(mStringCurrentQuestion);

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mImageButtonRecorderAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO DEVELOP mImageButtonRecorderAnswer

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mImageButtonPhotoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mIntPhotoNumberTotal > INT_NUMBER_00) {

                    mIntPhotoNumberCurrent++;
                    mIntPhotoNumberCounter++;

                    if (mIntPhotoNumberCurrent < mIntPhotoNumberTotal) {

                        updateScreenPhotoData();

                    } else {

                        mIntPhotoNumberCounter--;
                        mIntPhotoNumberCurrent--;

                    }

                    mStringPhotoController = mIntPhotoNumberCounter + " / " + mIntPhotoNumberTotal;
                    mTextViewPhotoValue.setText(mStringPhotoController);

                }

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        mImageButtonPhotoPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mIntPhotoNumberTotal > INT_NUMBER_00) {

                    mIntPhotoNumberCurrent--;
                    mIntPhotoNumberCounter--;

                    if (mIntPhotoNumberCurrent >= INT_NUMBER_00) {

                        updateScreenPhotoData();

                    } else {

                        mIntPhotoNumberCounter++;
                        mIntPhotoNumberCurrent++;

                    }

                    mStringPhotoController = mIntPhotoNumberCounter + " / " + mIntPhotoNumberTotal;
                    mTextViewPhotoValue.setText(mStringPhotoController);

                }
            }

        });

        return mView;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeAnswerLength() {

        mTextViewLength = mView.findViewById(R.id.textViewLength);

        int intLength = mEditTextValueAnswer.getText().length();
        String stringLength = String.valueOf(intLength);

        mTextViewLength.setText(stringLength);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateStatusPending() {

        if (mStringCurrentAnswerStatus.equals(STATUS_NEW)) {

            mStringCurrentAnswerStatus = STATUS_PENDING;
            mTextViewStatusValue.setText(STATUS_PENDING);
            updateDatabaseStatus();

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeStatusHeader() {

        mTextViewStatusValue = mView.findViewById(R.id.textViewStatusValue);
        updateStatusPending();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeLayoutHeader() {

        TextView mTextViewCrudTitle = mView.findViewById(R.id.textViewCrudTitle);
        mTextViewCrudTitle.setText(mContext.getString(R.string.label_diary));

        TextView mTextViewValueApplicationName = mView.findViewById(R.id.mTextViewValueApplicationName);
        String appName = mContext.getString(R.string.app_name);
        String appGoal = mContext.getString(R.string.app_goal);
        String appTitle = appName + " - " + appGoal;
        mTextViewValueApplicationName.setText(appTitle);

        ImageView mImageViewUserPhoto = mView.findViewById(R.id.imageViewUserPhoto);
        TextView mTextViewUserValue = mView.findViewById(R.id.textViewUserValue);

        mArrayListUser = new ArrayList<>();
        mArrayListUser = SqliteSupportUser.sqliteGetOne(mContext);

        for(mIntIndex = 0; mIntIndex < mArrayListUser.size() ; mIntIndex++){

            mStringCurrentUserName = mArrayListUser.get(mIntIndex).getRecordUserCompleteName();
            mByteCurrentUserPhoto = mArrayListUser.get(mIntIndex).getRecordUserPhoto();
            mTextViewUserValue.setText(mStringCurrentUserName);

        }

        if (mByteCurrentUserPhoto != null  && mByteCurrentUserPhoto.length > 0) {

            mBitmap = BitmapFactory.decodeByteArray(mByteCurrentUserPhoto, 0, mByteCurrentUserPhoto.length);
            mByteArrayOutputStream = new ByteArrayOutputStream();
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, mByteArrayOutputStream);
            mStringImagePath = MediaStore.Images.Media.insertImage(mContext.getContentResolver(), mBitmap, "Title", null);
            mUri = Uri.parse(mStringImagePath);

            Picasso.get()
                    .load(mUri)
                    .error(R.drawable.application_bitmap_small)
                    .centerCrop()
                    .fit()
                    .noFade()
                    .into(mImageViewUserPhoto);

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeNumberPoints() {

        mTextViewValueNumberPoints = mView.findViewById(R.id.mTextViewValueNumberPoints);
        mTextViewValueNumberPoints.setText(mStringCurrentAnswerNumberPoints);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeNumberPhotos() {

        mTextViewValueNumberPhotos = mView.findViewById(R.id.mTextViewValueNumberPhotos);
        mTextViewValueNumberPhotos.setText(mStringCurrentAnswerNumberPhotos);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeNumberSharing() {

        mTextViewValueNumberSharing = mView.findViewById(R.id.mTextViewValueNumberSharing);
        mTextViewValueNumberSharing.setText(mStringCurrentAnswerNumberSharing);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeNumberActions() {

        mTextViewValueNumberActions = mView.findViewById(R.id.mTextViewValueNumberActions);
        mTextViewValueNumberActions.setText(mStringCurrentAnswerNumberActions);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeQuestionAnswer() {

        mTextViewValueQuestion = mView.findViewById(R.id.mTextViewValueQuestion);
        mTextViewValueQuestion.setText(mStringCurrentQuestionText);
        mTextViewValueQuestion.setMovementMethod(new ScrollingMovementMethod());

        mEditTextValueAnswer = mView.findViewById(R.id.editTextValueAnswer);
        mEditTextValueAnswer.setText(mStringCurrentAnswer);
        mEditTextValueAnswer.setMovementMethod(new ScrollingMovementMethod());

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeGrade() {

        mRadioGroupGrade = mView.findViewById(R.id.radioGroupGrade);

        mRadioButtonGrade00 = mView.findViewById(R.id.radioGrade00);
        mRadioButtonGrade01 = mView.findViewById(R.id.radioGrade01);
        mRadioButtonGrade02 = mView.findViewById(R.id.radioGrade02);
        mRadioButtonGrade03 = mView.findViewById(R.id.radioGrade03);
        mRadioButtonGrade04 = mView.findViewById(R.id.radioGrade04);
        mRadioButtonGrade05 = mView.findViewById(R.id.radioGrade05);
        mRadioButtonGrade06 = mView.findViewById(R.id.radioGrade06);
        mRadioButtonGrade07 = mView.findViewById(R.id.radioGrade07);
        mRadioButtonGrade08 = mView.findViewById(R.id.radioGrade08);
        mRadioButtonGrade09 = mView.findViewById(R.id.radioGrade09);
        mRadioButtonGrade10 = mView.findViewById(R.id.radioGrade10);

        mTextViewGradeValue = mView.findViewById(R.id.textViewGradeValue);

        updateScreenGrade();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializePhotosHeader() {

        mImageViewPhoto = mView.findViewById(R.id.imageViewPhoto);
        mTextViewPhotoValue = mView.findViewById(R.id.textViewPhotoValue);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializePhotosData() {

        mStringPhotoPhaseCode = SupportGeneratePhaseCodePhoto.supportGeneratePhaseCodePhoto(mStringCurrentAnswerPhase);

        mPhotoArrayListByte = new ArrayList<>();
        mPhotoArrayListByte = SqliteModulePhotoAnswer.sqliteGetImage(mContext, mStringPhotoPhaseCode, mStringCurrentAnswerNumber);

        mIntPhotoNumberCurrent = 0;
        mIntPhotoNumberTotal = mPhotoArrayListByte.size();

        if (mIntPhotoNumberTotal > INT_NUMBER_00) {
            mIntPhotoNumberCounter = mIntPhotoNumberCurrent + 1;
        } else {
            mIntPhotoNumberCounter = 0;
        }

        mStringPhotoController = mIntPhotoNumberCounter + " / " + mIntPhotoNumberTotal;

        mTextViewPhotoValue.setText(mStringPhotoController);

        if (mIntPhotoNumberTotal == INT_NUMBER_00) {

            Picasso.get()
                    .load(R.drawable.application_bitmap_small)
                    .into(mImageViewPhoto);

        } else {

            updateScreenPhotoData();

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeStatusData() {

        mTextViewStatusValue = mView.findViewById(R.id.textViewStatusValue);

        switch (mStringCurrentAnswerStatus) {

            default:
            case STATUS_NEW:
                mTextViewStatusValue.setText(mContext.getString(R.string.label_status_new));
                break;

            case STATUS_PENDING:
                mTextViewStatusValue.setText(mContext.getString(R.string.label_status_pending));
                break;

            case STATUS_CLOSED:
                mTextViewStatusValue.setText(mContext.getString(R.string.label_status_closed));
                break;

            case STATUS_POSTPONED:
                mTextViewStatusValue.setText(mContext.getString(R.string.label_status_postponed));
                break;

            case STATUS_IGNORED:
                mTextViewStatusValue.setText(mContext.getString(R.string.label_status_ignored));
                break;

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeExperienceData() {

        mTextViewExperienceValue = mView.findViewById(R.id.textViewExperienceValue);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeButtons() {

        mButtonPhotoRemove = mView.findViewById(R.id.buttonPhotoRemove);
        mButtonPhotoCamera = mView.findViewById(R.id.buttonPhotoCamera);
        mButtonPhotoDevice = mView.findViewById(R.id.buttonPhotoDevice);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeImageButtons() {

        mImageButtonSpeakerQuestion = mView.findViewById(R.id.imageButtonSpeaker);
        mImageButtonRecorderAnswer = mView.findViewById(R.id.imageButtonRecorder);
        mImageButtonPhotoNext = mView.findViewById(R.id.imageButtonPhotoNext);
        mImageButtonPhotoPrevious = mView.findViewById(R.id.imageButtonPhotoPrevious);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeFloatingActionButtons() {

        mTextViewStatus = mView.findViewById(R.id.textViewStatus);
        mTextViewExperience = mView.findViewById(R.id.textViewExperience);
        mTextViewAction = mView.findViewById(R.id.textViewAction);
        mTextViewShare = mView.findViewById(R.id.textViewShare);

        mFloatingActionButtonMaster = mView.findViewById(R.id.floatingActionButtonMaster);
        mFloatingActionButtonShare = mView.findViewById(R.id.floatingActionButtonShare);
        mFloatingActionButtonExperience = mView.findViewById(R.id.floatingActionButtonExperience);
        mFloatingActionButtonAction = mView.findViewById(R.id.floatingActionButtonAction);
        mFloatingActionButtonStatus = mView.findViewById(R.id.floatingActionButtonStatus);

        mFloatingActionButtonMaster.setVisibility(View.VISIBLE);
        mFloatingActionButtonShare.setVisibility(View.INVISIBLE);
        mFloatingActionButtonExperience.setVisibility(View.INVISIBLE);
        mFloatingActionButtonAction.setVisibility(View.INVISIBLE);
        mFloatingActionButtonStatus.setVisibility(View.INVISIBLE);

        mFloatingActionButtonMaster.setOnClickListener(clickListener);
        mFloatingActionButtonShare.setOnClickListener(clickListener);
        mFloatingActionButtonExperience.setOnClickListener(clickListener);
        mFloatingActionButtonAction.setOnClickListener(clickListener);
        mFloatingActionButtonStatus.setOnClickListener(clickListener);

        mAnimationFloatingActionButtonOpen = AnimationUtils.loadAnimation(mContext, R.anim.floating_action_button_open);
        mAnimationFloatingActionButtonClose = AnimationUtils.loadAnimation(mContext,R.anim.floating_action_button_close);
        mAnimationFloatingActionButtonOpenRotateForward = AnimationUtils.loadAnimation(mContext,R.anim.floating_action_button_rotate_forward);
        mAnimationFloatingActionButtonOpenRotateBackward = AnimationUtils.loadAnimation(mContext,R.anim.floating_action_button_rotate_backward);

        closeFloatingActionButtonMenu();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatFloatingActionButtonStatus() {

        switch (mStringCurrentAnswerStatus) {

            case STATUS_NEW:
                mTextViewStatus.setText(mContext.getString(R.string.label_fab_status_new));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_new_white_24dp);
                break;

            case STATUS_PENDING:
                mTextViewStatus.setText(mContext.getString(R.string.label_fab_status_pending));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_pending_white_24dp);
                break;

            case STATUS_POSTPONED:
                mTextViewStatus.setText(mContext.getString(R.string.label_fab_status_postponed));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_postponed_white_24dp);
                break;

            case STATUS_IGNORED:
                mTextViewStatus.setText(mContext.getString(R.string.label_fab_status_ignored));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_ignored_white_24dp);
                break;

            case STATUS_CLOSED:
                mTextViewStatus.setText(mContext.getString(R.string.label_fab_status_closed));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.status_icon_closed_white_24dp);
                break;

            default:
                String className = getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + mStringCurrentAnswerStatus);

        }

        mFloatingActionButtonStatus.setImageDrawable(mDrawable);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void formatFloatingActionButtonExperience() {

        switch (mStringCurrentAnswerExperience) {

            case EXPERIENCE_VERY_BAD:
                mTextViewExperience.setText(mContext.getString(R.string.label_fab_experience_very_bad));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.experience_icon_very_bad_white_24dp);
                break;

            case EXPERIENCE_BAD:
                mTextViewExperience.setText(mContext.getString(R.string.label_fab_experience_bad));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.experience_icon_bad_white_24dp);
                break;

            case EXPERIENCE_NORMAL:
                mTextViewExperience.setText(mContext.getString(R.string.label_fab_experience_normal));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.experience_icon_normal_white_24dp);
                break;

            case EXPERIENCE_GOOD:
                mTextViewExperience.setText(mContext.getString(R.string.label_fab_experience_good));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.experience_icon_good_white_24dp);
                break;

            case EXPERIENCE_VERY_GOOD:
                mTextViewExperience.setText(mContext.getString(R.string.label_fab_experience_very_good));
                mDrawable = ContextCompat.getDrawable(mContext, R.drawable.experience_icon_very_good_white_24dp);
                break;

            default:
                String className = getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + mStringCurrentAnswerStatus);

        }

        mFloatingActionButtonExperience.setImageDrawable(mDrawable);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateScreenPhotoData() {

        mByte = mPhotoArrayListByte.get(mIntPhotoNumberCurrent);

        mBitmap = BitmapFactory.decodeByteArray(mByte, 0, mByte.length);
        mByteArrayOutputStream = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, mByteArrayOutputStream);
        mStringImagePath = MediaStore.Images.Media.insertImage(mContext.getContentResolver(), mBitmap, "Title", null);
        mUri = Uri.parse(mStringImagePath);

        Picasso.get()
                .load(mUri)
                .error(R.drawable.application_bitmap_small)
                .centerCrop()
                .fit()
                .noFade()
                .into(mImageViewPhoto);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateScreenGrade() {

        mRadioButtonGrade00.setActivated(false);
        mRadioButtonGrade01.setActivated(false);
        mRadioButtonGrade02.setActivated(false);
        mRadioButtonGrade03.setActivated(false);
        mRadioButtonGrade04.setActivated(false);
        mRadioButtonGrade05.setActivated(false);
        mRadioButtonGrade06.setActivated(false);
        mRadioButtonGrade07.setActivated(false);
        mRadioButtonGrade08.setActivated(false);
        mRadioButtonGrade09.setActivated(false);
        mRadioButtonGrade10.setActivated(false);

        mRadioButtonGrade00.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade01.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade02.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade03.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade04.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade05.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade06.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade07.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade08.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade09.setBackgroundColor(Color.TRANSPARENT);
        mRadioButtonGrade10.setBackgroundColor(Color.TRANSPARENT);

        mTextViewGradeValue.setText(STRING_NUMBER_NN);

        switch (mStringCurrentAnswerGrade) {

            case STRING_NUMBER_00:
                mRadioGroupGrade.check(R.id.radioGrade00);
                mTextViewGradeValue.setText(STRING_NUMBER_00);
                mRadioButtonGrade00.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_01:
                mRadioGroupGrade.check(R.id.radioGrade01);
                mTextViewGradeValue.setText(STRING_NUMBER_01);
                mRadioButtonGrade01.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_02:
                mRadioGroupGrade.check(R.id.radioGrade02);
                mTextViewGradeValue.setText(STRING_NUMBER_02);
                mRadioButtonGrade02.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_03:
                mRadioGroupGrade.check(R.id.radioGrade03);
                mTextViewGradeValue.setText(STRING_NUMBER_03);
                mRadioButtonGrade03.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_04:
                mRadioGroupGrade.check(R.id.radioGrade04);
                mTextViewGradeValue.setText(STRING_NUMBER_04);
                mRadioButtonGrade04.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_05:
                mRadioGroupGrade.check(R.id.radioGrade05);
                mTextViewGradeValue.setText(STRING_NUMBER_05);
                mRadioButtonGrade05.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_06:
                mRadioGroupGrade.check(R.id.radioGrade06);
                mTextViewGradeValue.setText(STRING_NUMBER_06);
                mRadioButtonGrade06.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_07:
                mRadioGroupGrade.check(R.id.radioGrade07);
                mTextViewGradeValue.setText(STRING_NUMBER_07);
                mRadioButtonGrade07.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_08:
                mRadioGroupGrade.check(R.id.radioGrade08);
                mTextViewGradeValue.setText(STRING_NUMBER_08);
                mRadioButtonGrade08.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_09:
                mRadioGroupGrade.check(R.id.radioGrade09);
                mTextViewGradeValue.setText(STRING_NUMBER_09);
                mRadioButtonGrade09.setBackgroundColor(Color.LTGRAY);
                break;

            case STRING_NUMBER_10:
                mTextViewGradeValue.setText(STRING_NUMBER_10);
                mRadioGroupGrade.check(R.id.radioGrade10);
                mRadioButtonGrade10.setBackgroundColor(Color.LTGRAY);
                break;

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateNumberPhotosIncrease() {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        mStringCurrentAnswerNumberPhotos = generalNumberPointsPhotosIncrease(mStringCurrentAnswerNumberPhotos);
        mTextViewValueNumberPhotos.setText(mStringCurrentAnswerNumberPhotos);

        SqliteModuleLifeAnswer.sqliteUpdateNumberPhotos(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerNumberPhotos,
                mStringCurrentUpdatedDateTime);

        SqliteSupportPointsUser.sqliteUpdateNumberPhotos(
                mContext,
                mStringCurrentAnswerPhase,
                mStringCurrentAnswerNumber,
                mStringCurrentAnswerNumberPhotos,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateNumberPhotosDecrease() {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        mStringCurrentAnswerNumberPhotos = generalNumberPointsPhotosDecrease(mStringCurrentAnswerNumberPhotos);
        mTextViewValueNumberPhotos.setText(mStringCurrentAnswerNumberPhotos);

        SqliteModuleLifeAnswer.sqliteUpdateNumberPhotos(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerNumberPhotos,
                mStringCurrentUpdatedDateTime);

        SqliteSupportPointsUser.sqliteUpdateNumberPhotos(
                mContext,
                mStringCurrentAnswerPhase,
                mStringCurrentAnswerNumber,
                mStringCurrentAnswerNumberPhotos,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateNumberPoints() {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        mStringCurrentAnswerNumberPoints = generalNumberPoints(mContext, mStringCurrentAnswerNumberPhotos);
        mTextViewValueNumberPoints.setText(mStringCurrentAnswerNumberPoints);

        SqliteModuleLifeAnswer.sqliteUpdateNumberPoints(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerNumberPoints,
                mStringCurrentUpdatedDateTime);

        SqliteSupportPointsUser.sqliteUpdateNumberPoints(
                mContext,
                mStringCurrentAnswerPhase,
                mStringCurrentAnswerNumber,
                mStringCurrentAnswerNumberPoints,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateNumberSharing() {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        mStringCurrentAnswerNumberSharing = generalNumberPointsSharing(mStringCurrentAnswerNumberSharing);
        mTextViewValueNumberSharing.setText(mStringCurrentAnswerNumberSharing);

        SqliteModuleLifeAnswer.sqliteUpdateNumberSharing(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerNumberSharing,
                mStringCurrentUpdatedDateTime);

        SqliteSupportPointsUser.sqliteUpdateNumberSharing(
                mContext,
                mStringCurrentAnswerPhase,
                mStringCurrentAnswerNumber,
                mStringCurrentAnswerNumberSharing,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateNumberActions() {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        mStringCurrentAnswerNumberActions = generalNumberPointsActions(mStringCurrentAnswerNumberActions);
        mTextViewValueNumberActions.setText(mStringCurrentAnswerNumberActions);

        SqliteModuleLifeAnswer.sqliteUpdateNumberActions(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerNumberActions,
                mStringCurrentUpdatedDateTime);

        SqliteSupportPointsUser.sqliteUpdateNumberActions(
                mContext,
                mStringCurrentAnswerPhase,
                mStringCurrentAnswerNumber,
                mStringCurrentAnswerNumberActions,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void readDataFromDatabase() {

        mArrayListAnswer = new ArrayList<>();

        mArrayListAnswer = SqliteModuleLifeAnswer.sqliteGetOne(
                mContext,
                stringCurrentAnswerId);

        for(mIntIndex = 0; mIntIndex < mArrayListAnswer.size() ; mIntIndex++){

            mIntCurrentRecordNumber = Integer.parseInt(mArrayListAnswer.get(mIntIndex).getRecordId());
            mStringCurrentAnswerUserId = mArrayListAnswer.get(mIntIndex).getRecordUserId();
            mStringCurrentAnswerPhase = mArrayListAnswer.get(mIntIndex).getRecordPhase();
            mStringCurrentAnswerNumber = mArrayListAnswer.get(mIntIndex).getRecordNumber();
            mStringCurrentAnswerStatus = mArrayListAnswer.get(mIntIndex).getRecordStatus();
            mStringCurrentAnswerExperience = mArrayListAnswer.get(mIntIndex).getRecordExperience();
            mStringCurrentAnswerGrade = mArrayListAnswer.get(mIntIndex).getRecordGrade();
            mStringCurrentQuestionText = mArrayListAnswer.get(mIntIndex).getRecordQuestion();
            mStringCurrentAnswerNumberPoints = mArrayListAnswer.get(mIntIndex).getRecordNumberPoints();
            mStringCurrentAnswerNumberSharing = mArrayListAnswer.get(mIntIndex).getRecordNumberSharing();
            mStringCurrentAnswerNumberPhotos = mArrayListAnswer.get(mIntIndex).getRecordNumberPhotos();
            mStringCurrentAnswerNumberActions = mArrayListAnswer.get(mIntIndex).getRecordNumberActions();
            mStringCurrentAnswerDateCreation = mArrayListAnswer.get(mIntIndex).getRecordDateCreation();
            mStringCurrentAnswerDateUpdated = mArrayListAnswer.get(mIntIndex).getRecordDateUpdate();
            mStringCurrentAnswerDateSync = mArrayListAnswer.get(mIntIndex).getRecordDateSync();
            mStringCurrentQuestionText = mArrayListAnswer.get(mIntIndex).getRecordQuestion();

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateDatabasePhotos() {

        updateNumberPoints();
        updateNumberPhotosIncrease();

        mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

        mStringPhotoPhaseCode = SupportGeneratePhaseCodePhoto.supportGeneratePhaseCodePhoto(mStringCurrentAnswerPhase);

        SqliteModulePhotoAnswer.sqliteInsert(
                mContext,
                stringCurrentUserFirebaseUserId,
                mStringPhotoPhaseCode,
                mStringCurrentAnswerNumber,
                mStringCurrentUpdatedDateTime,
                mStringCurrentUpdatedDateTime,
                mStringCurrentUpdatedDateTime,
                mByte);

        initializePhotosData();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateDatabaseStatus() {

        updateNumberPoints();

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        SqliteModuleLifeAnswer.sqliteUpdateStatus(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerStatus,
                mStringCurrentUpdatedDateTime);

        SqliteSupportPointsUser.sqliteUpdateStatus(
                mContext,
                mStringCurrentAnswerPhase,
                mStringCurrentAnswerNumber,
                mStringCurrentAnswerStatus,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateDatabaseExperience() {

        updateNumberPoints();

        mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

        SqliteModuleLifeAnswer.sqliteUpdateExperience(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerExperience,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateDatabaseSharing() {

        updateNumberPoints();

        mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();
        mStringSharingPhaseCode = SupportGeneratePhaseCodeSharing.supportGeneratePhaseCodeSharing(mStringCurrentAnswerPhase);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        mByte = byteArrayOutputStream.toByteArray();

        SqliteModuleSharingAnswer.sqliteInsert(
                mContext,
                stringCurrentUserFirebaseUserId,
                mStringSharingPhaseCode,
                mStringCurrentAnswerNumber,
                mStringCurrentUpdatedDateTime,
                mStringCurrentUpdatedDateTime,
                mStringCurrentUpdatedDateTime,
                mByte);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void updateDatabaseGrade() {

        updateNumberPoints();

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        SqliteModuleLifeAnswer.sqliteUpdateGrade(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerGrade,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == mIntRequestImageCapture && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            mBitmap = (Bitmap) Objects.requireNonNull(extras).get("data");

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            mBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            mByte = byteArrayOutputStream.toByteArray();

            updateDatabasePhotos();

        }

        if (requestCode == mIntRequestImagePick && resultCode == RESULT_OK) {

            mUri = data.getData();

            try {
                mBitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), mUri);

            } catch (IOException e) {
                e.printStackTrace();
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            mBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            mByte = byteArrayOutputStream.toByteArray();

            updateDatabasePhotos();

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private Bitmap getBitmapFromView() {

        mBitmap = createBitmap(frameLayout.getWidth(), frameLayout.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(mBitmap);
        Drawable drawable = frameLayout.getForeground();

        if (drawable != null) {

            drawable.draw(canvas);

        } else {

            canvas.drawColor(Color.WHITE);
        }

        frameLayout.draw(canvas);

        return mBitmap;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void shareSaveBitmapToCache() {

        try {

            mFile = new File(mContext.getCacheDir(), getString(R.string.share_options_title));
            mFile.mkdirs();
            mFileOutputStream = new FileOutputStream(mFile + getString(R.string.share_options_image_png));
            mBitmap = getBitmapFromView();
            mBitmap.compress(Bitmap.CompressFormat.PNG, 100, mFileOutputStream);
            mFileOutputStream.close();

        } catch (IOException error) {
            error.printStackTrace();

        }

        mFile = new File(mContext.getCacheDir(), getString(R.string.share_options_title));
        mFile = new File(mFile, getString(R.string.share_options_image_png));
        mUri = FileProvider.getUriForFile(mContext, getString(R.string.share_options_authority), mFile);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void shareBitmapToSocialMedia() {

        if (mUri != null) {

            mIntent = new Intent();
            mIntent.setAction(Intent.ACTION_SEND);

            mIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            mIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_life_title));
            mIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_life_body));

            mIntent.setDataAndType(mUri, mContext.getContentResolver().getType(mUri));
            mIntent.putExtra(Intent.EXTRA_STREAM, mUri);
            mIntent.setType(getString(R.string.share_options_type));

            startActivity(Intent.createChooser(mIntent, getString(R.string.label_alert_dialog_sharing_message)));

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void executeTextToSpeech(String stringTextToSpeech) {

        textToSpeech = new TextToSpeech(mContext.getApplicationContext(), this);
        textToSpeech.speak(stringTextToSpeech, TextToSpeech.QUEUE_ADD,null,null);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = textToSpeech.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {

                new SupportMessageToast(mContext.getApplicationContext(), Objects.requireNonNull(mContext.getApplicationContext()).getString(R.string.message_text_to_speech_language_error));

            } else {

                textToSpeech = new TextToSpeech(mContext.getApplicationContext(), this);
                textToSpeech.speak(mStringCurrentQuestion, TextToSpeech.QUEUE_ADD,null,null);
            }

        } else {

            new SupportMessageToast(mContext.getApplicationContext(), Objects.requireNonNull(mContext.getApplicationContext()).getString(R.string.message_text_to_speech_language_error));

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                default:
                case R.id.floatingActionButtonMaster:
                    treatFloatingActionButtonMaster();
                    break;

                case R.id.floatingActionButtonShare:
                    treatFloatingActionButtonShare();
                    break;

                case R.id.floatingActionButtonExperience:
                    treatFloatingActionButtonExperience();
                    break;

                case R.id.floatingActionButtonAction:
                    treatFloatingActionButtonAction();
                    break;

                case R.id.floatingActionButtonStatus:
                    treatFloatingActionButtonStatus();
                    break;

            }
        }
    };

    // *********************************************************************************************
    // *********************************************************************************************
    private void openFloatingActionButtonMenu(){

        isFloatingActionButtonOpen = true;

        mFloatingActionButtonMaster.setVisibility(View.VISIBLE);
        mFloatingActionButtonMaster.setImageResource(R.drawable.floating_action_button_close);

        mFloatingActionButtonShare.setVisibility(View.VISIBLE);
        mFloatingActionButtonExperience.setVisibility(View.VISIBLE);
        mFloatingActionButtonAction.setVisibility(View.VISIBLE);
        mFloatingActionButtonStatus.setVisibility(View.VISIBLE);

        mTextViewShare.setVisibility(View.VISIBLE);
        mTextViewExperience.setVisibility(View.VISIBLE);
        mTextViewAction.setVisibility(View.VISIBLE);
        mTextViewStatus.setVisibility(View.VISIBLE);

        mFloatingActionButtonMaster.setAnimation(mAnimationFloatingActionButtonOpenRotateForward);

        mFloatingActionButtonShare.setAnimation(mAnimationFloatingActionButtonOpen);
        mFloatingActionButtonExperience.setAnimation(mAnimationFloatingActionButtonOpen);
        mFloatingActionButtonAction.setAnimation(mAnimationFloatingActionButtonOpen);
        mFloatingActionButtonStatus.setAnimation(mAnimationFloatingActionButtonOpen);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void closeFloatingActionButtonMenu(){

        isFloatingActionButtonOpen = false;

        mFloatingActionButtonMaster.setVisibility(View.VISIBLE);
        mFloatingActionButtonMaster.setImageResource(R.drawable.floating_action_button_open);

        mFloatingActionButtonShare.setVisibility(View.INVISIBLE);
        mFloatingActionButtonExperience.setVisibility(View.INVISIBLE);
        mFloatingActionButtonAction.setVisibility(View.INVISIBLE);
        mFloatingActionButtonStatus.setVisibility(View.INVISIBLE);

        mTextViewShare.setVisibility(View.INVISIBLE);
        mTextViewExperience.setVisibility(View.INVISIBLE);
        mTextViewAction.setVisibility(View.INVISIBLE);
        mTextViewStatus.setVisibility(View.INVISIBLE);

        mFloatingActionButtonMaster.setAnimation(mAnimationFloatingActionButtonOpenRotateBackward);

        mFloatingActionButtonShare.setAnimation(mAnimationFloatingActionButtonClose);
        mFloatingActionButtonExperience.setAnimation(mAnimationFloatingActionButtonClose);
        mFloatingActionButtonAction.setAnimation(mAnimationFloatingActionButtonClose);
        mFloatingActionButtonStatus.setAnimation(mAnimationFloatingActionButtonClose);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void treatFloatingActionButtonMaster() {

        if(!isFloatingActionButtonOpen){

            openFloatingActionButtonMenu();

        } else {

            closeFloatingActionButtonMenu();

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void treatFloatingActionButtonShare() {

        updateNumberPoints();
        updateNumberSharing();

        shareSaveBitmapToCache();
        updateDatabaseSharing();
        shareBitmapToSocialMedia();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void treatFloatingActionButtonExperience() {

        switch (mStringCurrentAnswerExperience) {

            case EXPERIENCE_VERY_BAD:
                mStringCurrentAnswerExperience = EXPERIENCE_BAD;
                break;

            case EXPERIENCE_BAD:
                mStringCurrentAnswerExperience = EXPERIENCE_NORMAL;
                break;

            case EXPERIENCE_NORMAL:
                mStringCurrentAnswerExperience = EXPERIENCE_GOOD;
                break;

            case EXPERIENCE_GOOD:
                mStringCurrentAnswerExperience = EXPERIENCE_VERY_GOOD;
                break;

            case EXPERIENCE_VERY_GOOD:
                mStringCurrentAnswerExperience = EXPERIENCE_VERY_BAD;
                break;

            default:
                String className = getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + mStringCurrentAnswerExperience);

        }

        updateDatabaseExperience();
        initializeExperienceData();
        formatFloatingActionButtonExperience();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void treatFloatingActionButtonAction() {

        updateNumberPoints();
        updateNumberActions();

        stringCrudType = CRUD_C;

        mStringCurrentFragment = "ModuleFragmentDiaryCrud";

        mAppCompatActivity = (AppCompatActivity) mView.getContext();

        mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainConstraintLayout, new ModuleFragmentActionCrud(), mStringCurrentFragment)
                .addToBackStack(mStringCurrentFragment)
                .commit();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void treatFloatingActionButtonStatus() {

        switch (mStringCurrentAnswerStatus) {

            case STATUS_NEW:
                mStringCurrentAnswerStatus = STATUS_PENDING;
                break;

            case STATUS_PENDING:
                mStringCurrentAnswerStatus = STATUS_POSTPONED;
                break;

            case STATUS_POSTPONED:
                mStringCurrentAnswerStatus = STATUS_IGNORED;
                break;

            case STATUS_IGNORED:
                mStringCurrentAnswerStatus = STATUS_CLOSED;
                break;

            case STATUS_CLOSED:
                mStringCurrentAnswerStatus = STATUS_NEW;
                break;

            default:
                String className = getClass().getName();
                throw new IllegalStateException(mContext.getString(R.string.message_unexpected_value) + className + " " + mStringCurrentAnswerStatus);

        }

        updateDatabaseStatus();
        initializeStatusData();
        formatFloatingActionButtonStatus();

    }
}