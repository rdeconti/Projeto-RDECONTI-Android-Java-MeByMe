package com.prosper.day.module19you;

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
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportCheckNetworkAvailability;
import com.prosper.day.applicationsupportclasses.SupportGeneralDateTime;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseCodePhoto;
import com.prosper.day.applicationsupportclasses.SupportGeneratePhaseCodeSharing;
import com.prosper.day.applicationsupportclasses.SupportMessageToast;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelModuleYouAnswer;
import com.prosper.day.databasemodel.ModelSupportUser;
import com.prosper.day.databasesqlite.SqliteModulePhotoAnswer;
import com.prosper.day.databasesqlite.SqliteModuleSharingAnswer;
import com.prosper.day.databasesqlite.SqliteModuleYouAnswer;
import com.prosper.day.databasesqlite.SqliteSupportPointsUser;
import com.prosper.day.databasesqlite.SqliteSupportUser;
import com.prosper.day.module01main.ModuleControlMainActivity;
import com.prosper.day.module08action.ModuleFragmentActionCrud;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;
import static android.graphics.Bitmap.createBitmap;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_01;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_02;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_03;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_04;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_05;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_06;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_07;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_08;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_09;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_10;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_11;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_12;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_13;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_14;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_15;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.YOU_PHASE_CODE_19_16;
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
import static com.prosper.day.applicationsupportclasses.SupportGeneralDateTime.generateCurrentDateTime;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPoints;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPointsActions;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPointsPhotosDecrease;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPointsPhotosIncrease;
import static com.prosper.day.applicationsupportclasses.SupportGeneralPoints.generalNumberPointsSharing;

// *********************************************************************************************
// *********************************************************************************************
public class ModuleFragmentYouCrud extends Fragment implements TextToSpeech.OnInitListener {

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
    private String mStringCurrentUserLanguage;
    private String mStringCurrentUserFirstName;
    private String mStringCurrentUserLastName;
    private String mStringCurrentUserCompleteName;
    private String mStringCurrentUserNickName;
    private String mStringCurrentUserBirthdate;
    private String mStringCurrentUserBirthCountry;
    private String mStringCurrentUserGender;
    private String mStringCurrentUserSexualOption;
    private String mStringCurrentUserRace;
    private String mStringCurrentUserMaritalStatus;
    private String mStringCurrentUserReligion;
    private String mStringCurrentUserScholarity;
    private String mStringCurrentUserHeight;
    private String mStringCurrentUserWeight;
    private String mStringCurrentUserEmail;
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
    private TextView mTextViewValueHeader;
    private TextView mTextViewValueQuestion;
    private TextView mTextViewGradeValue;
    private TextView mTextViewPhotoValue;
    private TextView mTextViewStatusValue;
    private TextView mTextViewLength;
    private TextView mTextViewExperienceValue;
    private EditText mEditTextValueAnswer;

    private String mStringCrud;

    private int mIntCurrentRecordNumber;
    private String mStringCurrentAnswerUserId;
    private String mStringCurrentAnswerPhase;
    private String mStringCurrentAnswerNumber;
    private String mStringCurrentAnswerStatus;
    private String mStringCurrentAnswerExperience;
    private String mStringCurrentAnswerGrade;
    private String mStringCurrentAnswerQuestionTitle;
    private String mStringCurrentAnswerQuestionText;
    private String mStringCurrentAnswerText;
    private String mStringCurrentAnswerNumberPoints;
    private String mStringCurrentAnswerNumberSharing;
    private String mStringCurrentAnswerNumberPhotos;
    private String mStringCurrentAnswerNumberActions;
    private String mStringCurrentAnswerNumberFeedbackPositive;
    private String mStringCurrentAnswerNumberFeedbackNegative;
    private String mStringCurrentAnswerDateCreation;
    private String mStringCurrentAnswerDateUpdated;
    private String mStringCurrentAnswerDateSync;
    private String mStringCurrentQuestionTitle;
    private String mStringCurrentQuestionText;

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

    private List<ModelModuleYouAnswer> mArrayListAnswer;
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

    private Boolean booleanReturnCode = null;

    private String mStringUserAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
    private String mStringUrl01 = "https://www.houseofnames.com/Argentini-family-crest";
    private String mStringUrl02 = "https://www.dicionariodenomesproprios.com.br/rosemeire/";

    private String mStringLifeStage;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentYouCrud() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        readDataFromUserDatabase();
        readDataFromYouDatabase();

        switch (mStringCurrentAnswerPhase) {

            default:
            case YOU_PHASE_CODE_19_01:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_01_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_02:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_02_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_03:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_03_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_04:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_04_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_05:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_05_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_06:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_06_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_07:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_07_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_08:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_08_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_09:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_09_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_10:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_10_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_11:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_11_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_12:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_12_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_13:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_13_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_14:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_14_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_15:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_15_fragment, viewGroup, false);
                break;

            case YOU_PHASE_CODE_19_16:
                mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.you_crud_16_fragment, viewGroup, false);
                break;
        }

        initializeLayoutHeader();

        initializeNumberPoints();
        initializeNumberPhotos();
        initializeNumberActions();
        initializeNumberSharing();

        initializeButtons();
        initializeImageButtons();
        initializeFloatingActionButtons();

        initializeQuestionAnswer();
        initializeAnswerLength();

        initializePhotosHeader();
        initializePhotosData();

        initializeStatusHeader();
        initializeStatusData();
        initializeExperienceData();

        // *****************************************************************************************
        // *****************************************************************************************
        mEditTextValueAnswer.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {

                mStringCurrentAnswerText = mEditTextValueAnswer.getText().toString();
                updateUserAnswer();

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


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

                executeTextToSpeech(mStringCurrentQuestion + " " + mStringCurrentAnswer);

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

        switch (mStringCurrentAnswerPhase) {

            default:
            case YOU_PHASE_CODE_19_01:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString(R.string.label_meaning));
                break;

            case YOU_PHASE_CODE_19_02:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_origin_surname));
                break;

            case YOU_PHASE_CODE_19_03:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_coat_arms));
                break;

            case YOU_PHASE_CODE_19_04:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_live_days));
                break;

            case YOU_PHASE_CODE_19_05:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString(+ R.string.label_live_stage));
                break;

            case YOU_PHASE_CODE_19_06:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_heart_beats));
                break;

            case YOU_PHASE_CODE_19_07:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_respiratory_frequency));
                break;

            case YOU_PHASE_CODE_19_08:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_birthplace));
                break;

            case YOU_PHASE_CODE_19_09:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_gender));
                break;

            case YOU_PHASE_CODE_19_10:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_sexual_option));
                break;

            case YOU_PHASE_CODE_19_11:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_race));
                break;

            case YOU_PHASE_CODE_19_12:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_marital_status));
                break;

            case YOU_PHASE_CODE_19_13:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_religion));
                break;

            case YOU_PHASE_CODE_19_14:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_scholarity));
                break;

            case YOU_PHASE_CODE_19_15:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_body_mass_index));
                break;

            case YOU_PHASE_CODE_19_16:
                mStringCrud = (mContext.getString(R.string.label_you)) + "-" + (mContext.getString( R.string.label_life_expectancy));
                break;
        }

        mTextViewCrudTitle.setText(mStringCrud);

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
            mStringCurrentUserLanguage = mArrayListUser.get(mIntIndex).getRecordUserLanguage();
            mStringCurrentUserFirstName = mArrayListUser.get(mIntIndex).getRecordUserFirstName();
            mStringCurrentUserLastName = mArrayListUser.get(mIntIndex).getRecordUserLastName();
            mStringCurrentUserCompleteName = mArrayListUser.get(mIntIndex).getRecordUserCompleteName();
            mStringCurrentUserNickName = mArrayListUser.get(mIntIndex).getRecordUserNickName();
            mStringCurrentUserBirthdate = mArrayListUser.get(mIntIndex).getRecordUserBirthdate();
            mStringCurrentUserBirthCountry = mArrayListUser.get(mIntIndex).getRecordUserBirthCountry();
            mStringCurrentUserGender = mArrayListUser.get(mIntIndex).getRecordUserGender();
            mStringCurrentUserSexualOption = mArrayListUser.get(mIntIndex).getRecordUserSexualOption();
            mStringCurrentUserRace = mArrayListUser.get(mIntIndex).getRecordUserRace();
            mStringCurrentUserMaritalStatus = mArrayListUser.get(mIntIndex).getRecordUserMaritalStatus();
            mStringCurrentUserReligion = mArrayListUser.get(mIntIndex).getRecordUserReligion();
            mStringCurrentUserScholarity = mArrayListUser.get(mIntIndex).getRecordUserScholarity();
            mStringCurrentUserHeight = mArrayListUser.get(mIntIndex).getRecordUserHeight();
            mStringCurrentUserWeight = mArrayListUser.get(mIntIndex).getRecordUserWeight();
            mStringCurrentUserEmail = mArrayListUser.get(mIntIndex).getRecordUserEmail();
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

        generateYouAnswer();

        mEditTextValueAnswer = mView.findViewById(R.id.editTextValueAnswer);
        mEditTextValueAnswer.setText(mStringCurrentAnswerText, TextView.BufferType.EDITABLE);
        mEditTextValueAnswer.setMovementMethod(new ScrollingMovementMethod());

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouAnswer() {

        switch (mStringCurrentAnswerPhase) {

            case YOU_PHASE_CODE_19_01:
                generateYouMeaningOfName();
                break;

            case YOU_PHASE_CODE_19_02:
                generateYouOriginOfSurname();
                break;

            case YOU_PHASE_CODE_19_03:
                generateYouCoatOfArms();
                break;

            case YOU_PHASE_CODE_19_04:
                generateYouLiveDays();
                break;

            case YOU_PHASE_CODE_19_05:
                generateYouLiveStage();
                break;

            case YOU_PHASE_CODE_19_06:
                generateYouHeartBeats();
                break;

            case YOU_PHASE_CODE_19_07:
                generateYouRespiratoryFrequency();
                break;

            case YOU_PHASE_CODE_19_08:
                generateYouBirthplaceStatistics();
                break;

            case YOU_PHASE_CODE_19_09:
                generateYouGenderStatistics();
                break;

            case YOU_PHASE_CODE_19_10:
                generateYouSexualOptionStatistics();
                break;

            case YOU_PHASE_CODE_19_11:
                generateYouRaceStatistics();
                break;

            case YOU_PHASE_CODE_19_12:
                generateYouMaritalStatusStatistics();
                break;

            case YOU_PHASE_CODE_19_13:
                generateYouReligionStatistics();
                break;

            case YOU_PHASE_CODE_19_14:
                generateYouScholarityStatistics();
                break;

            case YOU_PHASE_CODE_19_15:
                generateYouImcIndex();
                break;

            case YOU_PHASE_CODE_19_16:
                generateYouLifeExpectancy();
                break;

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouMeaningOfName() {

        booleanReturnCode = SupportCheckNetworkAvailability.supportCheckNetworkAvailability(mView.getContext());

        if (!booleanReturnCode) {

            new SupportMessageToast(mView.getContext(), mView.getContext().getString(R.string.message_network_not_available));
            startActivity(new Intent(mView.getContext(), ModuleControlMainActivity.class));

        } else {

            new MeaningOfNameDataAsync().execute();

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouOriginOfSurname() {

        booleanReturnCode = SupportCheckNetworkAvailability.supportCheckNetworkAvailability(mView.getContext());

        if (!booleanReturnCode) {

            new SupportMessageToast(mView.getContext(), mView.getContext().getString(R.string.message_network_not_available));
            startActivity(new Intent(mView.getContext(), ModuleControlMainActivity.class));

        } else {

            new OriginOfSurnameDataAsync().execute();

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouCoatOfArms() {



    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouLiveDays() {

        Calendar dataNasc = Calendar.getInstance();
        dataNasc.set(Calendar.YEAR, 1964);
        dataNasc.set(Calendar.MONTH, Calendar.MAY);
        dataNasc.set(Calendar.DAY_OF_MONTH, 5);
        Date dateRepresentation = dataNasc.getTime();

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(dateRepresentation);
        Calendar hoje = Calendar.getInstance();

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        }
        else
        {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }

        mStringCurrentAnswerText = String.valueOf(idade);

        Log.w("MEBYME", "doInBackground: mStringCurrentAnswerText 5 " + mStringCurrentAnswerText );
        updateUserAnswer();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouLiveStage() {

        Calendar dataNasc = Calendar.getInstance();
        dataNasc.set(Calendar.YEAR, 1964);
        dataNasc.set(Calendar.MONTH, Calendar.MAY);
        dataNasc.set(Calendar.DAY_OF_MONTH, 5);
        Date dateRepresentation = dataNasc.getTime();

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(dateRepresentation);
        Calendar hoje = Calendar.getInstance();

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        }
        else
        {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }

        /*
        0 aos 7 anos (1º setênio): é nosso nascer físico no qual temos a consciência do Eu;
        7 aos 14 anos (2º setênio): é o nosso nascer emocional no qual temos a vivência do Eu;
        14 aos 21 anos (3º setênio): é o nosso nascer da identidade no qual temos a afirmação do Eu;
        21 aos 28 anos (4º setênio): é a fase de nos prepararmos para vida na qual experimentamos o mundo;
        28 aos 35 anos (5º setênio): é uma fase na qual questiono e organizo o mundo;
        35 aos 42 anos (6º setênio): é uma fase na qual vou em direção à minha essência e assim eu começo a questionar a mim mesmo;
        42 aos 49 anos (7º setênio): é um período em que eu crio uma nova visão sobre mim e sobre o mundo, aqui eu tenho minhas próprias respostas;
        49 aos 56 anos (8º setênio): é a chamada fase da sabedoria. Aqui eu tenho novos valores;
        56 aos 63 anos (9º setênio): é um período mais intuitivo no qual nos conectamos com uma nova missão;
        Após os 63 anos: ficamos livres das leis biográficas.
         */

        /*
        https://www.eusemfronteiras.com.br/setenios-e-nonenios-fases-da-vida/

        Teoria dos Setênios
        Na Teoria dos Setênios, a vida é divida em fases de sete anos. Mas, por que sete anos? O número possui enorme importância. Deus criou o mundo em sete dias. São sete dias na semana, sete planetas relacionados ao homem (Sol, Lua, Mercúrio, Vênus, Marte, Júpiter, Saturno) e sete metais (ouro, prata, mercúrio, cobre, ferro, estanho e chumbo). Os gregos e a tradicional medicina chinesa observavam e estudavam as alterações espirituais e biológicas no ser humano. A teoria revela as complexidades de cada etapa e como o corpo humano influencia as emoções e atitudes. A Teoria dos Setênios possui sete ciclos, os “setênios do corpo”.

        Primeiro Setênio: 0 a 7 anos – intercâmbio entre o individual (adormecido) e o hereditário
        Aqui, o lado espiritual da individualidade e a parte biológica se encontram. As células trazem as ações das forças herdadas. Estas ficam nos rins a vida toda e a fisionomia da pessoa mostra essa herança. Quando o pai ou a mãe não convive com a criança, o outro precisará compensar a ausência. Contudo, a mãe ainda é mais necessária. Após os sete anos, a criança ganha autonomia.

        Segundo Setênio: 7 aos 14 anos – autoridade amada
        Fase dos dentes permanentes e amadurecimento do coração e pulmão. O mundo externo nos encontra, forças entram e saem de nós. A grande marca é a troca. Neste setênio a autoridade de pais e professores tem enorme relevância, esses adultos orientam a conduta da criança. As atitudes desses mediadores influenciam como a criança verá o mundo. Autoritarismo mostra frieza e crueldade, permissividade leva a comportamentos inapropriados.

        Terceiro Setênio: 14 aos 21 anos – puberdade e crise de identidade
        A mulher menstrua e o homem entra em sua fase fértil. O ser humano sai da abstração da infância e desembarca no mundo terreno. Nesta crise de identidade, onde não se é mais criança nem adulto, o indivíduo quer liberdade. O mundo não está mais restrito a família e a escola. A pessoa deseja ser reconhecido como indivíduo e ser aceito por um grupo que reflita seus anseios.

        A marca deste setênio são as escolhas, qual profissão seguir e onde estudar. Nesta fase é onde a vida profissional tem início, dando parte da sonhada liberdade. O jovem pode distorcer as coisas e acreditar que o dinheiro é a chave de tudo. Existe a crença de que somos maduros o suficiente, que sabemos tudo e podemos emitir julgamentos racionais.

        Quarto Setênio: 21 aos 28 anos – experimentar limites
        Ossos e músculos fortes. Homem e mulher estão no auge da fertilidade. No quarto setênio é a fase das sensações e emoções. Momento de se perguntar se escolheu a profissão correta, se deixou de aprimorar alguma aptidão e se está em harmonia com o mundo, família e consigo. O “Eu” ainda está em fase de formação, porém, se mostra fortemente. O trabalho é muito importante para esta formação. Não atingir os objetivos causa frustrações.

        Quinto Setênio: 28 aos 35 anos – fase organizacional
        O baço-pâncreas não ampara a carne. O rosto revela as primeiras rugas. O indivíduo questiona se está no caminho certo. A pessoa também pergunta se consegue expressar seus sentimentos e pensamentos. A famosa “crise dos 30” traz angústia e vazio. A busca pelo seu lugar no mundo leva a pessoa a uma jornada espiritual. A harmonia demora a acontecer, pois, há cobranças para estabilidade material. Para a Antroposofia, após o 31 1/2, que é a metade do 63º ano de vida é o término das influências planetárias e zodiacais. Passada essa idade, conquistamos mais liberdade.

        Sexto Setênio: 35 aos 42 anos – crise de autenticidade
        O funcionamento do fígado não é mais o mesmo. Os cabelos embranquecem e começam a cair. Na fase da consciência, o indivíduo se pergunta o que virá, se foram adquiridos valores importantes e se encontrou  e exerce sua missão de vida. O sexto setênio tem conexão com o anterior, no que tange as crises. Este traz descontentamento e dúvidas se ainda conseguirá fazer algo novo e interessante.

        Sétimo Setênio: 42 aos 49 anos – altruísmo x manter a fase expansiva
        Começam a menopausa e a andropausa. O pulmão não oxigena mais o sangue como antes. A grande dúvida é se está desenvolvendo alguma habilidade. Questionamentos sobre o relacionamento conjugal e com os filhos ocupam a mente.  A crise dos 30 foi superada e tem início um período de recomeço. Nesta fase, o indivíduo está sedento por novidades, entretanto, as mudanças causam medo. Mas, a pessoa tem plena consciência de que “como está, não dá pra ficar”.

        Oitavo Setênio – dos 49 aos 56 anos – ouvir o mundo
        Menos vitalidade. Rins e fígado não eliminam mais toxinas como antes. O período inspirativo ou moral traz as seguintes questões: “Como está meu ritmo de vida?”, “O que preciso cortar da minha vida, para que o novo possa surgir?”. O oitavo setênio é marcado pela serenidade. A energia vital retorna para o centro do corpo, voltada para o bem-estar, moral, ética, questões universais e humanísticas. Este setênio é fisiologicamente parecido com o segundo setênio (7 aos 14 anos- intercâmbio entre o individual (adormecido) e o hereditário), pois, o ritmo precisa ser priorizado para começar uma nova rotina. É a fase de uma audição diferente, na qual ouvimos a voz do coração para a renovação ético e moral.

        Nono Setênio: 56 aos 63 anos – abnegação e sabedoria
        Dentes caem, visão e audição diminuem, a locomoção e reflexos alterados em decorrência da queda energética de órgãos como coração, baço-pâncreas, rins e fígado. O nono setênio é a fase da intuição. O nono setênio é equivalente ao primeiro (0 a 7 anos – intercâmbio entre o individual (adormecido) e o hereditário).

        No 56º aniversário ocorre uma mudança significativa na maneira como o indivíduo se relaciona com ele e com o mundo. Há uma preocupação sobre o tratamento dado ao corpo. É muito importante estimular o cérebro. Ler, fazer palavras cruzadas, andar por ruas que nunca andou. O cérebro, assim como qualquer órgão precisa ser estimulado para funcionar corretamente.

        Torna-se difícil a comunicação com o exterior (choque de gerações). A pessoa passa a prezar a reclusão, pois, sabe que a busca por autoconhecimento depende disso. Este afastamento traz aprimoramento da espiritualidade.

        Décimo setênio: 63 aos 70 anos
        É a fase do mestre. A criança tem ao seu redor uma luz ainda não definida. No décimo setênio essa luz está na alma do indivíduo e irradia. A luz brilha somente quando a saúde física e mental estão boas.
         */

        if (idade <= 7 ) {
            mStringLifeStage = getString(R.string.septenio01);
        }

        if (idade >= 7 && idade <=14 ) {
            mStringLifeStage = getString(R.string.septenio02);
        }

        if (idade >=14 && idade <=21 ) {
            mStringLifeStage = getString(R.string.septenio03);
        }

        if (idade >=21 && idade <=28 ) {
            mStringLifeStage = getString(R.string.septenio04);
        }

        if (idade >=28 && idade <=35 ) {
            mStringLifeStage = getString(R.string.septenio05);
        }

        if (idade >=35 && idade <=42 ) {
            mStringLifeStage = getString(R.string.septenio06);
        }

        if (idade >=42 && idade <=49 ) {
            mStringLifeStage = getString(R.string.septenio07);
        }

        if (idade >=49 && idade <=56 ) {
            mStringLifeStage = getString(R.string.septenio08);
        }

        if (idade >=56 && idade <=63 ) {
            mStringLifeStage = getString(R.string.septenio09);
        }

        if (idade >=63 ) {
            mStringLifeStage = getString(R.string.septenio10);
        }

        mStringCurrentAnswerText = mStringLifeStage;

        Log.w("MEBYME", "doInBackground: mStringCurrentAnswerText 6 " + mStringCurrentAnswerText );
        updateUserAnswer();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouHeartBeats() {

        /*
        1 minuto = 60 batimentos
        1 hora = 3600 batimentos
        1 dia = 86.400 batimentos
        1 ano (365 dias) = 31536000 batimentos
        90 anos = 2838240000 batimentos
         */

        int intHeartBeatsByMinute = 60;
        int intHeartBeatsByHour = 3600;
        int intHeartBeatsByDay = 86400;
        int intHeartBeatsByYear = 31536000;

        Calendar dataNasc = Calendar.getInstance();
        dataNasc.set(Calendar.YEAR, 1964);
        dataNasc.set(Calendar.MONTH, Calendar.MAY);
        dataNasc.set(Calendar.DAY_OF_MONTH, 5);
        Date dateRepresentation = dataNasc.getTime();

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(dateRepresentation);
        Calendar hoje = Calendar.getInstance();

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        }
        else
        {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }

        int intHeartBeats = idade * intHeartBeatsByYear;

        mStringCurrentAnswerText = String.valueOf(intHeartBeats);

        Log.w("MEBYME", "doInBackground: mStringCurrentAnswerText 7 " + mStringCurrentAnswerText );
        updateUserAnswer();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouRespiratoryFrequency() {

        /*
        https://revistagalileu.globo.com/Ciencia/noticia/2015/06/9-fatos-curiosos-sobre-o-seu-corpo.html

        1 minuto = 12 respiration
        1 hora = 730 respiration
        1 dia = 17280 respiration
        1 ano (365 dias) = 6220800 respiration
        90 anos = 2838240000 batimentos
         */

        int intRespiratoryFrequencyByMinute = 12;
        int intRespiratoryFrequencyByHour = 730;
        int intRespiratoryFrequencyByDay = 17280;
        int intRespiratoryFrequencyByYear = 6220800;

        Calendar dataNasc = Calendar.getInstance();
        dataNasc.set(Calendar.YEAR, 1964);
        dataNasc.set(Calendar.MONTH, Calendar.MAY);
        dataNasc.set(Calendar.DAY_OF_MONTH, 5);
        Date dateRepresentation = dataNasc.getTime();

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(dateRepresentation);
        Calendar hoje = Calendar.getInstance();

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        }
        else
        {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }

        int intRespiratoryFrequency = idade * intRespiratoryFrequencyByYear;

        mStringCurrentAnswerText = String.valueOf(intRespiratoryFrequency);

        Log.w("MEBYME", "doInBackground: mStringCurrentAnswerText 8 " + mStringCurrentAnswerText );
        updateUserAnswer();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouBirthplaceStatistics() {


    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouGenderStatistics() {


    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouSexualOptionStatistics() {


    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouRaceStatistics() {


    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouMaritalStatusStatistics() {


    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouReligionStatistics() {


    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouScholarityStatistics() {


    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouImcIndex() {


    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void generateYouLifeExpectancy() {


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
    private void updateNumberPhotosIncrease() {

        mStringCurrentUpdatedDateTime = generateCurrentDateTime();

        mStringCurrentAnswerNumberPhotos = generalNumberPointsPhotosIncrease(mStringCurrentAnswerNumberPhotos);
        mTextViewValueNumberPhotos.setText(mStringCurrentAnswerNumberPhotos);

        SqliteModuleYouAnswer.sqliteUpdateNumberPhotos(
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

        SqliteModuleYouAnswer.sqliteUpdateNumberPhotos(
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

        SqliteModuleYouAnswer.sqliteUpdateNumberPoints(
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

        SqliteModuleYouAnswer.sqliteUpdateNumberSharing(
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

        SqliteModuleYouAnswer.sqliteUpdateNumberActions(
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
    private void updateUserAnswer() {

        mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

        SqliteModuleYouAnswer.sqliteUpdateText(
                mContext,
                mIntCurrentRecordNumber,
                mStringCurrentAnswerText,
                mStringCurrentUpdatedDateTime);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void readDataFromYouDatabase() {

        mArrayListAnswer = new ArrayList<>();

        mArrayListAnswer = SqliteModuleYouAnswer.sqliteGetOne(
                mContext,
                stringCurrentAnswerId);

        for(mIntIndex = 0; mIntIndex < mArrayListAnswer.size() ; mIntIndex++){

            mIntCurrentRecordNumber = Integer.parseInt(mArrayListAnswer.get(mIntIndex).getRecordId());
            mStringCurrentAnswerUserId = mArrayListAnswer.get(mIntIndex).getRecordUserId();
            mStringCurrentAnswerPhase = mArrayListAnswer.get(mIntIndex).getRecordPhase();
            mStringCurrentAnswerNumber = mArrayListAnswer.get(mIntIndex).getRecordNumber();
            mStringCurrentAnswerStatus = mArrayListAnswer.get(mIntIndex).getRecordStatus();
            mStringCurrentAnswerExperience = mArrayListAnswer.get(mIntIndex).getRecordExperience();
            mStringCurrentAnswerText = mArrayListAnswer.get(mIntIndex).getRecordAnswer();
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
    private void readDataFromUserDatabase() {

        mArrayListAnswer = new ArrayList<>();

        mArrayListAnswer = SqliteModuleYouAnswer.sqliteGetOne(
                mContext,
                stringCurrentAnswerId);

        for(mIntIndex = 0; mIntIndex < mArrayListAnswer.size() ; mIntIndex++){

            mIntCurrentRecordNumber = Integer.parseInt(mArrayListAnswer.get(mIntIndex).getRecordId());
            mStringCurrentAnswerUserId = mArrayListAnswer.get(mIntIndex).getRecordUserId();
            mStringCurrentAnswerPhase = mArrayListAnswer.get(mIntIndex).getRecordPhase();
            mStringCurrentAnswerNumber = mArrayListAnswer.get(mIntIndex).getRecordNumber();
            mStringCurrentAnswerStatus = mArrayListAnswer.get(mIntIndex).getRecordStatus();
            mStringCurrentAnswerExperience = mArrayListAnswer.get(mIntIndex).getRecordExperience();
            mStringCurrentAnswerText = mArrayListAnswer.get(mIntIndex).getRecordAnswer();
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
    @SuppressLint("StaticFieldLeak")
    private class OriginOfSurnameDataAsync extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... strings) {

            Document document = null;
            try {
                document = Jsoup.connect(mStringUrl01)
                        .userAgent(mStringUserAgent)
                        .get();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Element description = Objects.requireNonNull(document).select("div.container.padding-bottom-3x.padding-top-1x.mb-2").first();
            checkElement("description ", description);

            Elements elements = Objects.requireNonNull(document).select("div.container.padding-bottom-3x.padding-top-1x.mb-2");

            for(Element element: elements){

                int intIndex1 = element.text().indexOf("Early Origins of the Argentini family");
                int intIndex2 = element.text().indexOf("PDF Coat of Arms and Extended History (Letter) $10.77 Wishlist To CartDetails ");

                mStringCurrentAnswerText = element.text().substring(intIndex1+37, intIndex2);

                Log.w("MEBYME", "doInBackground: mStringCurrentAnswerText 1 " + mStringCurrentAnswerText );

            }

            return mStringCurrentAnswerText;

        }

        void onProgressUpdate(String stringMessage) {
            super.onProgressUpdate();

        }

        @Override
        protected void onPostExecute(String result) {

            mStringCurrentAnswerText = result;
            updateUserAnswer();

            Log.w("MEBYME", "doInBackground: mStringCurrentAnswerText 2 " + mStringCurrentAnswerText );

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("StaticFieldLeak")
    private class MeaningOfNameDataAsync extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... strings) {

            Document document = null;
            try {
                document = Jsoup.connect(mStringUrl02)
                        .userAgent(mStringUserAgent)
                        .get();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Element description = Objects.requireNonNull(document).select("div#content.col-xs-12.col-sm-9.name-article.mt15").first();
            checkElement("description ", description);

            Elements elements = Objects.requireNonNull(document).select("div#content.col-xs-12.col-sm-9.name-article.mt15");

            for(Element element: elements){

                int intIndex1 = element.text().indexOf("Significado do Nome Rosemeire");
                int intIndex2 = element.text().indexOf("escrito ao contrário: ");

                mStringCurrentAnswerText = element.text().substring(intIndex1+29, intIndex2);

                Log.w("MEBYME", "doInBackground: mStringCurrentAnswerText 3 " + mStringCurrentAnswerText );

            }

            return mStringCurrentAnswerText;

        }

        void onProgressUpdate(String stringMessage) {
            super.onProgressUpdate();

        }

        @Override
        protected void onPostExecute(String result) {

            mStringCurrentAnswerText = result;
            updateUserAnswer();

            Log.w("MEBYME", "doInBackground: mStringCurrentAnswerText 4 " + mStringCurrentAnswerText );

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    public static void checkElement(String name, Element elem) {

        if (elem == null) {
            throw new RuntimeException("Unable to find " + name);
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

        mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

        SqliteModuleYouAnswer.sqliteUpdateStatus(
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

        SqliteModuleYouAnswer.sqliteUpdateExperience(
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

            mIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_recognition_title));
            mIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_recognition_body));

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