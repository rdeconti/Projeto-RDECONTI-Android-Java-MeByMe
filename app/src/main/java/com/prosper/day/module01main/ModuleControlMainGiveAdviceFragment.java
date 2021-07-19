package com.prosper.day.module01main;

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

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportSettingLocalization;
import com.prosper.day.applicationsupportclasses.SupportSharedPreferencesGet;
import com.prosper.day.databasesqlite.SqliteSupportPhrase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import static android.graphics.Bitmap.createBitmap;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_BORDER;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberPoints.NUMBER_PHRASE;

public class ModuleControlMainGiveAdviceFragment extends Fragment {

    private View mView;
    private Context mContext;
    private TextView mTextViewValueAdvice;
    private TextView mTextViewValueAuthor;
    private TextView mTextViewMessage;
    private LinearLayout mLinearLayoutAdviceData;
    private ConstraintLayout mConstraintLayout;
    private Intent mIntent;

    private File mFile;
    private Uri mUri;
    private Bitmap mBitmap;
    private ByteArrayOutputStream mByteArrayOutputStream;
    private FileOutputStream mFileOutputStream;
    private TextToSpeech textToSpeech;

    private Button mButtonShare;
    private Button mButtonRefresh;

    private long recordCounter;

    private Random mRandom;

    private String mStringBorder;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleControlMainGiveAdviceFragment() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {

        mContext = getContext();

        new SupportSharedPreferencesGet(mContext);
        new SupportSettingLocalization(mContext);

        mView = inflater.inflate(R.layout.main_module_control_main_fragment_advice, viewGroup, false);

        initializeConstraintLayout();
        initializeTextViews();
        initializeButtons();

        initializeBorder();
        initializePhaseData();
        initializePhraseAdvice();

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shareSaveBitmapToCache();
                shareBitmapToSocialMedia();

            }
        });

        // *****************************************************************************************
        // *****************************************************************************************
        mButtonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initializeBorder();
                initializePhraseAdvice();

            }
        });

        return mView;

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializePhaseData() {

            // TODO REVIEW IF ADVICE CAN BE CREATE WITH DATA

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeConstraintLayout() {

        mConstraintLayout = mView.findViewById(R.id.constraintLayout);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeButtons() {

        mButtonShare = mView.findViewById(R.id.buttonShare);
        mButtonRefresh = mView.findViewById(R.id.buttonRefresh);

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeTextViews() {

        mLinearLayoutAdviceData = mView.findViewById(R.id.linearLayoutAdviceData);

        mTextViewMessage = mView.findViewById(R.id.textViewMessage);
        mTextViewMessage.setVisibility(View.INVISIBLE);

        mTextViewValueAdvice = mView.findViewById(R.id.mTextViewValueAdvice);
        mTextViewValueAdvice.setVisibility(View.INVISIBLE);

        mTextViewValueAuthor = mView.findViewById(R.id.mTextViewValueAuthor);
        mTextViewValueAuthor.setVisibility(View.INVISIBLE);

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

            mIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_autobiography_title));
            mIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_autobiography_body));

            mIntent.setDataAndType(mUri, mContext.getContentResolver().getType(mUri));
            mIntent.putExtra(Intent.EXTRA_STREAM, mUri);
            mIntent.setType(getString(R.string.share_options_type));

            startActivity(Intent.createChooser(mIntent, getString(R.string.label_alert_dialog_sharing_message)));

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private Bitmap getBitmapFromView() {

        mBitmap = createBitmap(mConstraintLayout.getWidth(), mConstraintLayout.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(mBitmap);
        Drawable drawable = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            drawable = mConstraintLayout.getForeground();
        }

        if (drawable != null) {

            drawable.draw(canvas);

        } else {

            canvas.drawColor(Color.WHITE);
        }

        mConstraintLayout.draw(canvas);

        return mBitmap;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeBorder() {

        mRandom = new Random();
        int intBorder = mRandom.nextInt(NUMBER_BORDER - 1000) + 1000;
        @SuppressLint("DefaultLocale") String stringNumber = String.format("%04d", intBorder);

        mStringBorder = getString(R.string.label_border) + stringNumber;

        int drawableResourceId = mContext.getResources().getIdentifier(mStringBorder, "drawable", mContext.getPackageName());

        mLinearLayoutAdviceData.setBackground(ContextCompat.getDrawable(mContext, drawableResourceId));

    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializePhraseAdvice() {

        recordCounter = SqliteSupportPhrase.sqliteCounter(mContext);

        if (recordCounter > 0 ) {

            Random random = new Random();
            int intPhrase = random.nextInt(NUMBER_PHRASE - 1) + 1;
            @SuppressLint("DefaultLocale") String stringNumber = String.format("%03d", intPhrase);

            String stringPhrase = SqliteSupportPhrase.sqliteGetPhrase(mContext, stringNumber);
            String stringAuthor = SqliteSupportPhrase.sqliteGetAuthor(mContext, stringNumber);

            mTextViewMessage.setVisibility(View.INVISIBLE);

            mTextViewValueAdvice.setVisibility(View.VISIBLE);
            mTextViewValueAdvice.setText(stringPhrase);

            mTextViewValueAuthor.setVisibility(View.VISIBLE);
            mTextViewValueAuthor.setText(stringAuthor);

        } else {

            mTextViewValueAdvice.setVisibility(View.INVISIBLE);
            mTextViewValueAuthor.setVisibility(View.INVISIBLE);
            mTextViewMessage.setVisibility(View.VISIBLE);

        }
    }
}
