package com.prosper.day.module13user;

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
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportGeneralDateTime;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasemodel.ModelSupportUser;
import com.prosper.day.databasesqlite.SqliteSupportUser;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.UNACQUAINTED;

// *********************************************************************************************
// *********************************************************************************************
public class ModuleFragmentUserCrud extends Fragment {

    private View mView;
    private Context mContext;
    private Intent mIntent;

    private Uri mUri;
    private Bitmap mBitmap;
    private ByteArrayOutputStream mByteArrayOutputStream;

    private List<ModelSupportUser> mArrayListUser;

    private Button mButtonPhotoDevice;
    private Button mButtonPhotoCamera;
    private Button mButtonPhotoRemove;
    
    private Spinner mSpinnerUserLanguage;
    private Spinner mSpinnerUserBirthCountry;
    private Spinner mSpinnerUserGender;
    private Spinner mSpinnerUserSexualOption;
    private Spinner mSpinnerUserRace;
    private Spinner mSpinnerUserMaritalStatus;
    private Spinner mSpinnerUserReligion;
    private Spinner mSpinnerUserScholarity;

    private ArrayAdapter <CharSequence> mArrayAdapterUserLanguage;
    private ArrayAdapter <CharSequence> mArrayAdapterUserBirthCountry;
    private ArrayAdapter <CharSequence> mArrayAdapterUserGender;
    private ArrayAdapter <CharSequence> mArrayAdapterUserSexualOption;
    private ArrayAdapter <CharSequence> mArrayAdapterUserRace;
    private ArrayAdapter <CharSequence> mArrayAdapterUserMaritalStatus;
    private ArrayAdapter <CharSequence> mArrayAdapterUserReligion;
    private ArrayAdapter <CharSequence> mArrayAdapterUserScholarity;

    int intSpinnerPosition;

    private EditText mEditTextUserFirstName;
    private EditText mEditTextUserLastName;
    private EditText mEditTextUserCompleteName;
    private EditText mEditTextUserNickName;
    private EditText mEditTextUserBirthDate;
    private EditText mEditTextUserHeight;
    private EditText mEditTextUserWeight;

    private ImageView mImageViewUserPhoto;

    private String mStringCurrentRecordId;
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
    private byte[] mByteCurrentUserPhoto;

    private String mStringImagePath;
    private String mStringCurrentUpdatedDateTime;

    private int mIntIndex;
    private final int mIntRequestImageCapture = 1;
    private final int mIntRequestImagePick = 2;

    private final Calendar myCalendar = Calendar.getInstance();

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentUserCrud() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_crud_fragment, viewGroup, false);

        readDataFromDatabase();

        initializeLayoutHeader();
        initializeLayoutBody();
        initializeButtons();

        // *****************************************************************************************
        // *****************************************************************************************
        mSpinnerUserLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                intSpinnerPosition = mSpinnerUserLanguage.getSelectedItemPosition();
                mStringCurrentUserLanguage = mSpinnerUserLanguage.getSelectedItem().toString();

                SqliteSupportUser.sqliteUpdateLanguage(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserLanguage,
                        mStringCurrentUpdatedDateTime);
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mSpinnerUserBirthCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                intSpinnerPosition = mSpinnerUserBirthCountry.getSelectedItemPosition();
                mStringCurrentUserBirthCountry = mSpinnerUserBirthCountry.getSelectedItem().toString();

                SqliteSupportUser.sqliteUpdateUserBirthCountry(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserBirthCountry,
                        mStringCurrentUpdatedDateTime);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mSpinnerUserGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                intSpinnerPosition = mSpinnerUserGender.getSelectedItemPosition();
                mStringCurrentUserGender = mSpinnerUserGender.getSelectedItem().toString();

                SqliteSupportUser.sqliteUpdateUserGender(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserGender,
                        mStringCurrentUpdatedDateTime);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mSpinnerUserSexualOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                intSpinnerPosition = mSpinnerUserSexualOption.getSelectedItemPosition();
                mStringCurrentUserSexualOption = mSpinnerUserSexualOption.getSelectedItem().toString();

                SqliteSupportUser.sqliteUpdateUserSexualOption(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserSexualOption,
                        mStringCurrentUpdatedDateTime);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mSpinnerUserRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                intSpinnerPosition = mSpinnerUserRace.getSelectedItemPosition();
                mStringCurrentUserRace = mSpinnerUserRace.getSelectedItem().toString();

                SqliteSupportUser.sqliteUpdateUserRace(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserRace,
                        mStringCurrentUpdatedDateTime);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mSpinnerUserMaritalStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                intSpinnerPosition = mSpinnerUserMaritalStatus.getSelectedItemPosition();
                mStringCurrentUserMaritalStatus = mSpinnerUserMaritalStatus.getSelectedItem().toString();

                SqliteSupportUser.sqliteUpdateUserMaritalStatus(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserMaritalStatus,
                        mStringCurrentUpdatedDateTime);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mSpinnerUserReligion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                intSpinnerPosition = mSpinnerUserReligion.getSelectedItemPosition();
                mStringCurrentUserReligion = mSpinnerUserReligion.getSelectedItem().toString();

                SqliteSupportUser.sqliteUpdateUserReligion(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserReligion,
                        mStringCurrentUpdatedDateTime);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mSpinnerUserScholarity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                intSpinnerPosition = mSpinnerUserScholarity.getSelectedItemPosition();
                mStringCurrentUserScholarity = mSpinnerUserScholarity.getSelectedItem().toString();

                SqliteSupportUser.sqliteUpdateUserScholarity(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserScholarity,
                        mStringCurrentUpdatedDateTime);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mEditTextUserFirstName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();
                mStringCurrentUserCompleteName = mEditTextUserFirstName.getText().toString();

                SqliteSupportUser.sqliteUpdateUserFirstName(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserCompleteName,
                        mStringCurrentUpdatedDateTime);

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
        mEditTextUserLastName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();
                mStringCurrentUserLastName = mEditTextUserLastName.getText().toString();

                SqliteSupportUser.sqliteUpdateUserLastName(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserLastName,
                        mStringCurrentUpdatedDateTime);

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
        mEditTextUserCompleteName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();
                mStringCurrentUserCompleteName = mEditTextUserCompleteName.getText().toString();

                SqliteSupportUser.sqliteUpdateUserCompleteName(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserCompleteName,
                        mStringCurrentUpdatedDateTime);

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
        mEditTextUserNickName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();
                mStringCurrentUserNickName = mEditTextUserNickName.getText().toString();

                SqliteSupportUser.sqliteUpdateUserNickName(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserNickName,
                        mStringCurrentUpdatedDateTime);

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
        mEditTextUserBirthDate.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();
                mStringCurrentUserBirthdate = mEditTextUserBirthDate.getText().toString();

                SqliteSupportUser.sqliteUpdateUserBirthdate(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserBirthdate,
                        mStringCurrentUpdatedDateTime);

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
        mEditTextUserHeight.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();
                mStringCurrentUserHeight = mEditTextUserHeight.getText().toString();

                SqliteSupportUser.sqliteUpdateUserHeight(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserHeight,
                        mStringCurrentUpdatedDateTime);

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
        mEditTextUserWeight.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();
                mStringCurrentUserWeight = mEditTextUserWeight.getText().toString();

                SqliteSupportUser.sqliteUpdateUserWeight(
                        mContext,
                        mStringCurrentRecordId,
                        mStringCurrentUserWeight,
                        mStringCurrentUpdatedDateTime);

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

                mStringCurrentUpdatedDateTime = SupportGeneralDateTime.generateCurrentDateTime();

                mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.application_bitmap_small);
                mByteArrayOutputStream = new ByteArrayOutputStream();
                mBitmap.compress(Bitmap.CompressFormat.WEBP,25,mByteArrayOutputStream);
                mByteCurrentUserPhoto = mByteArrayOutputStream.toByteArray();

                SqliteSupportUser.sqliteUpdateUserPhoto(
                        mContext,
                        mStringCurrentRecordId,
                        mByteCurrentUserPhoto,
                        mStringCurrentUpdatedDateTime);

                updateScreenPhotoData();

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

                updateScreenPhotoData();

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

                updateScreenPhotoData();

            }

        });

        return mView;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeLayoutHeader() {

        TextView mTextViewCrudTitle = mView.findViewById(R.id.textViewCrudTitle);
        mTextViewCrudTitle.setText(mContext.getString(R.string.label_user));

        TextView mTextViewValueApplicationName = mView.findViewById(R.id.mTextViewValueApplicationName);
        String appName = mContext.getString(R.string.app_name);
        String appGoal = mContext.getString(R.string.app_goal);
        String appTitle = appName + " - " + appGoal;
        mTextViewValueApplicationName.setText(appTitle);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeLayoutBody() {

        // *****************************************************************************************
        mSpinnerUserLanguage = mView.findViewById(R.id.spinnerUserLanguage);

        mArrayAdapterUserLanguage = (ArrayAdapter) mSpinnerUserLanguage.getAdapter();
        intSpinnerPosition = mArrayAdapterUserLanguage.getPosition(mStringCurrentUserLanguage);
        mSpinnerUserLanguage.setSelection(intSpinnerPosition);

        // *****************************************************************************************
        mSpinnerUserBirthCountry = mView.findViewById(R.id.spinnerUserBirthCountry);

        mArrayAdapterUserBirthCountry = (ArrayAdapter) mSpinnerUserBirthCountry.getAdapter();
        intSpinnerPosition = mArrayAdapterUserBirthCountry.getPosition(mStringCurrentUserBirthCountry);
        mSpinnerUserBirthCountry.setSelection(intSpinnerPosition);

        // *****************************************************************************************
        mSpinnerUserGender = mView.findViewById(R.id.spinnerUserGender);

        mArrayAdapterUserGender = (ArrayAdapter) mSpinnerUserGender.getAdapter();
        intSpinnerPosition = mArrayAdapterUserGender.getPosition(mStringCurrentUserGender);
        mSpinnerUserGender.setSelection(intSpinnerPosition);
        
        // *****************************************************************************************
        mSpinnerUserSexualOption = mView.findViewById(R.id.spinnerUserSexualOption);

        mArrayAdapterUserSexualOption = (ArrayAdapter) mSpinnerUserSexualOption.getAdapter();
        intSpinnerPosition = mArrayAdapterUserSexualOption.getPosition(mStringCurrentUserSexualOption);
        mSpinnerUserSexualOption.setSelection(intSpinnerPosition);

        // *****************************************************************************************
        mSpinnerUserRace = mView.findViewById(R.id.spinnerUserRace);

        mArrayAdapterUserRace = (ArrayAdapter) mSpinnerUserRace.getAdapter();
        intSpinnerPosition = mArrayAdapterUserRace.getPosition(mStringCurrentUserRace);
        mSpinnerUserRace.setSelection(intSpinnerPosition);

        // *****************************************************************************************
        mSpinnerUserMaritalStatus = mView.findViewById(R.id.spinnerUserMaritalStatus);

        mArrayAdapterUserMaritalStatus = (ArrayAdapter) mSpinnerUserMaritalStatus.getAdapter();
        intSpinnerPosition = mArrayAdapterUserMaritalStatus.getPosition(mStringCurrentUserMaritalStatus);
        mSpinnerUserMaritalStatus.setSelection(intSpinnerPosition);

        // *****************************************************************************************
        mSpinnerUserReligion = mView.findViewById(R.id.spinnerUserReligion);

        mArrayAdapterUserReligion = (ArrayAdapter) mSpinnerUserReligion.getAdapter();
        intSpinnerPosition = mArrayAdapterUserReligion.getPosition(mStringCurrentUserReligion);
        mSpinnerUserReligion.setSelection(intSpinnerPosition);

        // *****************************************************************************************
        mSpinnerUserScholarity = mView.findViewById(R.id.spinnerUserScholarity);

        mArrayAdapterUserScholarity = (ArrayAdapter) mSpinnerUserScholarity.getAdapter();
        intSpinnerPosition = mArrayAdapterUserScholarity.getPosition(mStringCurrentUserScholarity);
        mSpinnerUserScholarity.setSelection(intSpinnerPosition);

        // *****************************************************************************************
        mEditTextUserFirstName = mView.findViewById(R.id.editTextUserFirstName);

        if (!mStringCurrentUserFirstName.equals(UNACQUAINTED)) {
            mEditTextUserFirstName.setText(mStringCurrentUserFirstName);
        } else {
            mEditTextUserFirstName.setText(mContext.getString(R.string.label_type_your_data_here));
        }

        // *****************************************************************************************
        mEditTextUserLastName = mView.findViewById(R.id.editTextUserLastName);

        if (!mStringCurrentUserLastName.equals(UNACQUAINTED)) {
            mEditTextUserLastName.setText(mStringCurrentUserLastName);
        } else {
            mEditTextUserLastName.setText(mContext.getString(R.string.label_type_your_data_here));
        }

        // *****************************************************************************************
        mEditTextUserCompleteName = mView.findViewById(R.id.editTextUserCompleteName);

        if (!mStringCurrentUserCompleteName.equals(UNACQUAINTED)) {
            mEditTextUserCompleteName.setText(mStringCurrentUserCompleteName);
        } else {
            mEditTextUserCompleteName.setText(mContext.getString(R.string.label_type_your_data_here));
        }

        // *****************************************************************************************
        mEditTextUserNickName = mView.findViewById(R.id.editTextUserNickName);

        if (!mStringCurrentUserNickName.equals(UNACQUAINTED)) {
            mEditTextUserNickName.setText(mStringCurrentUserNickName);
        } else {
            mEditTextUserNickName.setText(mContext.getString(R.string.label_type_your_data_here));
        }

        // *****************************************************************************************
        mEditTextUserBirthDate = mView.findViewById(R.id.editTextUserBirthdate);

        if (!mStringCurrentUserBirthdate.equals(UNACQUAINTED)) {
            mEditTextUserBirthDate.setText(mStringCurrentUserBirthdate);
        } else {
            mEditTextUserBirthDate.setText(mContext.getString(R.string.label_type_your_data_here));
        }

        // *****************************************************************************************
        mEditTextUserHeight = mView.findViewById(R.id.editTextUserHeight);

        if (!mStringCurrentUserHeight.equals(UNACQUAINTED)) {
            mEditTextUserHeight.setText(mStringCurrentUserHeight);
        } else {
            mEditTextUserHeight.setText(mContext.getString(R.string.label_type_your_data_here));
        }

        // *****************************************************************************************
        mEditTextUserWeight = mView.findViewById(R.id.editTextUserWeight);

        if (!mStringCurrentUserWeight.equals(UNACQUAINTED)) {
            mEditTextUserWeight.setText(mStringCurrentUserWeight);
        } else {
            mEditTextUserWeight.setText(mContext.getString(R.string.label_type_your_data_here));
        }

        // *****************************************************************************************
        mImageViewUserPhoto = mView.findViewById(R.id.imageViewPhoto);
        
        updateScreenPhotoData();

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
    private void updateScreenPhotoData() {

        if (mByteCurrentUserPhoto != null  && mByteCurrentUserPhoto.length > 0) {

            mBitmap = BitmapFactory.decodeByteArray(mByteCurrentUserPhoto, 0, mByteCurrentUserPhoto.length);
            mByteArrayOutputStream = new ByteArrayOutputStream();
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, mByteArrayOutputStream);
            mStringImagePath = MediaStore.Images.Media.insertImage(mContext.getContentResolver(), mBitmap, "Title", null);
            mUri = Uri.parse(mStringImagePath);

            Picasso.get()
                    .load(mUri)
                    .error(R.drawable.user_photo_small)
                    .centerInside()
                    .fit()
                    .noFade()
                    .into(mImageViewUserPhoto);

        }

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void readDataFromDatabase() {

        mArrayListUser = new ArrayList<>();
        mArrayListUser = SqliteSupportUser.sqliteGetOne(mContext);

        for(mIntIndex = 0; mIntIndex < mArrayListUser.size() ; mIntIndex++){

            mStringCurrentRecordId = mArrayListUser.get(mIntIndex).getRecordId();
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
            mByteCurrentUserPhoto = mArrayListUser.get(mIntIndex).getRecordUserPhoto();

        }

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
            mByteCurrentUserPhoto = byteArrayOutputStream.toByteArray();

            SqliteSupportUser.sqliteUpdateUserPhoto(
                    mContext,
                    mStringCurrentRecordId,
                    mByteCurrentUserPhoto,
                    mStringCurrentUpdatedDateTime);

            updateScreenPhotoData();

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
            mByteCurrentUserPhoto = byteArrayOutputStream.toByteArray();

            SqliteSupportUser.sqliteUpdateUserPhoto(
                    mContext,
                    mStringCurrentRecordId,
                    mByteCurrentUserPhoto,
                    mStringCurrentUpdatedDateTime);

            updateScreenPhotoData();

        }
    }
}