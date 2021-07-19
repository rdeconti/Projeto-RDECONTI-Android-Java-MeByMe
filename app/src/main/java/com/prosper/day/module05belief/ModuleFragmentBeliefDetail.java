package com.prosper.day.module05belief;

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

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.prosper.day.R;
import com.prosper.day.databasemodel.ModelModuleBeliefAnswer;
import com.prosper.day.databasesqlite.SqliteModuleBeliefAnswer;

import java.util.List;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionNumberValues.INT_NUMBER_00;

public class ModuleFragmentBeliefDetail extends Fragment {

    private Context mContext;

    private View mView;
    private TextView textViewMessage;
    private TextView textViewValuePhase;
    private TextView textViewValueName;
    private ImageView imageViewImage;
    private TextView textViewText;

    private Bitmap mBitmap;

    private String stringSign;
    private String stringImagePath;
    private String stringImageType;
    private String stringImageName;

    private String stringDay;
    private String stringMonth;
    private String stringYear;

    private int mIndex;

    private Uri uriImageLoad;

    List<ModelModuleBeliefAnswer> mListData;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentBeliefDetail() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {

        mContext = getContext();

        mView = inflater.inflate(R.layout.belief_detail_fragment, viewGroup, false);

        initializeView();

        mListData = SqliteModuleBeliefAnswer.sqliteGetOne(mContext, stringCurrentPhaseCode);

        textViewValuePhase.setVisibility(View.INVISIBLE);

        if (mListData.size() == INT_NUMBER_00) {

            imageViewImage.setVisibility(View.INVISIBLE);
            textViewValueName.setVisibility(View.INVISIBLE);
            textViewText.setVisibility(View.INVISIBLE);
            textViewMessage.setVisibility(View.VISIBLE);

        } else {

            imageViewImage.setVisibility(View.VISIBLE);
            textViewValueName.setVisibility(View.VISIBLE);
            textViewText.setVisibility(View.VISIBLE);
            textViewMessage.setVisibility(View.INVISIBLE);

        }

        for (mIndex = INT_NUMBER_00; mIndex < mListData.size(); mIndex++) {

            textViewValueName.setText(mListData.get(mIndex).getRecordAnswerName());
            textViewValuePhase.setText(mListData.get(mIndex).getRecordPhase());
            textViewText.setText(mListData.get(mIndex).getRecordAnswerDescription());

            byte[] byteArray = mListData.get(mIndex).getRecordImage();
            mBitmap = BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length);
            imageViewImage.setImageBitmap(mBitmap);

        }

        /*
        if (mListData.size() > INT_NUMBER_00) {

            String stringImageType = ".jpg";
            String stringImageName = stringImagePath + stringSign + stringImageType;
            Uri uriImageLoad = Uri.parse(stringImageName);

            Picasso.get()
                    .load(uriImageLoad)
                    .error(R.drawable.application_bitmap_small)
                    .resize(400, 600)
                    .into(imageViewImage);

        }
         */

        return mView;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void initializeView() {

        textViewMessage = mView.findViewById(R.id.textViewMessage);
        textViewValuePhase = mView.findViewById(R.id.mTextViewValuePhaseOverview);
        textViewValueName = mView.findViewById(R.id.mTextViewValueNameOverview);
        textViewText = mView.findViewById(R.id.textViewText);

        imageViewImage = mView.findViewById(R.id.imageViewImage);

    }
}
