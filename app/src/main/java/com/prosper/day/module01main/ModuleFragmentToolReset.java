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
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.prosper.day.R;
import com.prosper.day.applicationsupportclasses.SupportCheckNetworkAvailability;
import com.prosper.day.applicationsupportclasses.SupportMessageToast;

import static com.prosper.day.applicationdefinition.ApplicationDefinitionCodePhase.MAIN_PHASE_CODE_01_OV;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionCurrentValues.stringCurrentPhaseCode;
import static com.prosper.day.applicationdefinition.ApplicationDefinitionGeneral.intThreadSleep;
import static com.prosper.day.databasereset.ResetModuleAutobiographyQuestion.resetModuleAutobiographyQuestion;
import static com.prosper.day.databasereset.ResetModuleBeliefQuestionCalendar.resetModuleBeliefQuestionCalendar;
import static com.prosper.day.databasereset.ResetModuleBeliefQuestionDescription.resetModuleBeliefQuestionDescription;
import static com.prosper.day.databasereset.ResetModuleChallengeQuestion.resetModuleChallengeQuestion;
import static com.prosper.day.databasereset.ResetModuleDeleteFirebase.resetModuleDeleteFirebase;
import static com.prosper.day.databasereset.ResetModuleDeleteSqlite.resetModuleDeleteSqlite;
import static com.prosper.day.databasereset.ResetModuleLifeQuestion.resetModuleLifeQuestion;
import static com.prosper.day.databasereset.ResetModulePersonalityQuestion.resetModulePersonalityQuestion;
import static com.prosper.day.databasereset.ResetModulePersonalityResult.resetModulePersonalityQuestionResult;
import static com.prosper.day.databasereset.ResetModuleRecognitionQuestion.resetModuleRecognitionQuestion;
import static com.prosper.day.databasereset.ResetModuleReflectionQuestion.resetModuleReflectionQuestion;
import static com.prosper.day.databasereset.ResetModuleYouQuestion.resetModuleYouQuestion;
import static com.prosper.day.databasereset.ResetSupportAdvice.resetSupportAdvice;
import static com.prosper.day.databasereset.ResetSupportHelp.resetSupportHelp;
import static com.prosper.day.databasereset.ResetSupportPhrase.resetSupportPhrase;
import static com.prosper.day.databasereset.ResetSupportUser.resetSupportUser;
import static com.prosper.day.databasereset.ResetSupportWord.resetSupportWord;

public class ModuleFragmentToolReset extends Fragment {

    private Button buttonReset;
    private Button buttonBack;
    private ProgressBar mProgressBar;
    private TextView mTextViewMessage;
    private View mView;
    private Context mContext;
    private AppCompatActivity mAppCompatActivity;
    private Boolean booleanReturnCode = null;

    private String mMessage;

    // *********************************************************************************************
    // *********************************************************************************************
    public ModuleFragmentToolReset() {

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {

        mContext = getContext();

        mView = inflater.inflate(R.layout.main_module_fragment_tool_reset, viewGroup, false);

        buttonReset = mView.findViewById(R.id.imageButton_reset);
        buttonBack = mView.findViewById(R.id.imageButton_back);

        buttonBack.setVisibility(View.VISIBLE);
        buttonReset.setVisibility(View.VISIBLE);

        mTextViewMessage = mView.findViewById((R.id.textViewMessage));
        mTextViewMessage.setVisibility(View.INVISIBLE);

        mProgressBar = mView.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);

        getUserConfirmation();

        // *****************************************************************************************
        // *****************************************************************************************
        buttonReset.setOnClickListener(view -> {

            buttonBack.setVisibility(View.INVISIBLE);
            buttonReset.setVisibility(View.INVISIBLE);

            booleanReturnCode = SupportCheckNetworkAvailability.supportCheckNetworkAvailability(mView.getContext());

            if (!booleanReturnCode) {

                new SupportMessageToast(mView.getContext(), mView.getContext().getString(R.string.message_network_not_available));
                startActivity(new Intent(mView.getContext(), ModuleControlMainActivity.class));

            } else {

                new ResetDataAsync().execute("");

            }

        });

        // *****************************************************************************************
        // *****************************************************************************************
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_OV;

                mAppCompatActivity = (AppCompatActivity) mView.getContext();
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleControlMainActivityFragment(), null)
                        .commit();

            }
        });

        return mView;
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void getUserConfirmation() {

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.AlertDialogTheme);

        builder.setTitle(R.string.label_alert_dialog_reset_title);
        builder.setMessage(R.string.message_confirm_reset);
        builder.setIcon(R.drawable.application_bitmap_small);

        builder.setNegativeButton(R.string.label_alert_dialog_reset_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                stringCurrentPhaseCode = MAIN_PHASE_CODE_01_OV;

                mAppCompatActivity = (AppCompatActivity) mView.getContext();
                mAppCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_container_module_control_main_content, new ModuleControlMainActivityFragment(), null)
                        .commit();

            }
        });

        builder.setPositiveButton(R.string.label_alert_dialog_reset_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

        });

        builder.show();

    }

    // *********************************************************************************************
    // *********************************************************************************************
    @SuppressLint("StaticFieldLeak")
    private class ResetDataAsync extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

            buttonBack.setVisibility(View.INVISIBLE);
            buttonReset.setVisibility(View.INVISIBLE);

            mProgressBar.setVisibility(View.VISIBLE);
            mTextViewMessage.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... strings) {

            Log.w("MEBYME", "RESET: PHASE DELETE FIREBASE ");
            mMessage = getString(R.string.phase_reset ) + " - " + getString(R.string.label_delete);
            onProgressUpdate(mMessage);
            resetModuleDeleteFirebase(mContext);

            Log.w("MEBYME", "RESET: PHASE DELETE SQLITE ");
            mMessage = getString(R.string.phase_reset ) + " - " + getString(R.string.label_delete);
            onProgressUpdate(mMessage);
            resetModuleDeleteSqlite(mContext);

            Log.w("MEBYME", "RESET: PHASE AUTOBIOGRAPHY ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_autobiography);
            onProgressUpdate(mMessage);
            resetModuleAutobiographyQuestion(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE BELIEF CALENDAR ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_belief);
            resetModuleBeliefQuestionCalendar(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE BELIEF DESCRIPTION ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_belief);
            onProgressUpdate(mMessage);
            resetModuleBeliefQuestionDescription(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE CHALLENGE ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_challenge);
            onProgressUpdate(mMessage);
            resetModuleChallengeQuestion(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE LIFE ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_life);
            onProgressUpdate(mMessage);
            resetModuleLifeQuestion(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE PERSONALITY QUESTIONS ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_personality);
            onProgressUpdate(mMessage);
            resetModulePersonalityQuestion(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE PERSONALITY RESULTS ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_personality);
            onProgressUpdate(mMessage);
            resetModulePersonalityQuestionResult(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE RECOGNITION ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_recognition);
            onProgressUpdate(mMessage);
            resetModuleRecognitionQuestion(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE REFLECTION ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_reflection);
            onProgressUpdate(mMessage);
            resetModuleReflectionQuestion(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE YOU ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_you);
            onProgressUpdate(mMessage);
            resetModuleYouQuestion(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE SUPPORT ADVICE ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_advice);
            onProgressUpdate(mMessage);
            resetSupportAdvice(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE SUPPORT HELP ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_help);
            onProgressUpdate(mMessage);
            resetSupportHelp(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE SUPPORT PHRASE ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_phrase);
            onProgressUpdate(mMessage);
            resetSupportPhrase(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE SUPPORT WORD ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_word);
            onProgressUpdate(mMessage);
            resetSupportWord(mContext);
            waitFirebaseProcessing();

            Log.w("MEBYME", "RESET: PHASE SUPPORT USER ");
            mMessage = getString(R.string.phase_reset) + " - " + getString(R.string.label_user);
            onProgressUpdate(mMessage);
            resetSupportUser(mContext);
            waitFirebaseProcessing();

            return "Executed";
        }

        void onProgressUpdate(String stringMessage) {

            /// TODO NOT WORKING!!!
            /// mTextViewMessage.setText(stringMessage);
            
        }

        @Override
        protected void onPostExecute(String result) {

            mTextViewMessage.setText(R.string.message_process_done);

            mProgressBar.setVisibility(View.INVISIBLE);

            buttonBack.setVisibility(View.VISIBLE);
            buttonReset.setVisibility(View.INVISIBLE);

        }
    }

    // *********************************************************************************************
    // *********************************************************************************************
    private void waitFirebaseProcessing() {

        try {
            Thread.sleep(intThreadSleep);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
