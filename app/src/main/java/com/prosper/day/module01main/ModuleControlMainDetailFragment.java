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

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.prosper.day.R;

public class ModuleControlMainDetailFragment extends Fragment {

    private Context mContext;

    public ModuleControlMainDetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        mContext = getContext();

        View mView = inflater.inflate(R.layout.main_module_control_main_fragment_tabs, viewGroup, false);
        TextView mTextViewFragment = mView.findViewById(R.id.textViewFragment);
        mTextViewFragment.setText(mContext.getString(R.string.label_personality));

        return mView;
    }
}
