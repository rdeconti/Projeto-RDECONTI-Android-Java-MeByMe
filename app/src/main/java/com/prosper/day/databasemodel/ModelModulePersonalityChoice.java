package com.prosper.day.databasemodel;

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

import android.os.Parcel;
import android.os.Parcelable;

public class ModelModulePersonalityChoice implements Parcelable {

    private String recordId;
    private String recordUserId;
    private String recordPhase;
    private String recordNumber;
    private String recordGroup;
    private String recordStatus;
    private String recordQuestion;
    private String recordAnswer;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;

    public ModelModulePersonalityChoice() {

    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(String recordUserId) {
        this.recordUserId = recordUserId;
    }

    public String getRecordPhase() {
        return recordPhase;
    }

    public void setRecordPhase(String recordPhase) {
        this.recordPhase = recordPhase;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getRecordGroup() {
        return recordGroup;
    }

    public void setRecordGroup(String recordGroup) {
        this.recordGroup = recordGroup;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRecordQuestionText() {
        return recordQuestion;
    }

    public void setRecordQuestionText(String recordQuestion) {
        this.recordQuestion = recordQuestion;
    }

    public String getRecordAnswerText() {
        return recordAnswer;
    }

    public void setRecordAnswerText(String recordAnswer) {
        this.recordAnswer = recordAnswer;
    }

    public String getRecordDateCreation() {
        return recordDateCreation;
    }

    public void setRecordDateCreation(String recordDateCreation) {
        this.recordDateCreation = recordDateCreation;
    }

    public String getRecordDateUpdate() {
        return recordDateUpdate;
    }

    public void setRecordDateUpdate(String recordDateUpdate) {
        this.recordDateUpdate = recordDateUpdate;
    }

    public String getRecordDateSync() {
        return recordDateSync;
    }

    public void setRecordDateSync(String recordDateSync) {
        this.recordDateSync = recordDateSync;
    }

    public ModelModulePersonalityChoice(String recordId, String recordUserId, String recordPhase, String recordNumber, String recordGroup, String recordStatus, String recordQuestion, String recordAnswer, String recordDateCreation, String recordDateUpdate, String recordDateSync) {
        this.recordId = recordId;
        this.recordUserId = recordUserId;
        this.recordPhase = recordPhase;
        this.recordNumber = recordNumber;
        this.recordGroup = recordGroup;
        this.recordStatus = recordStatus;
        this.recordQuestion = recordQuestion;
        this.recordAnswer = recordAnswer;
        this.recordDateCreation = recordDateCreation;
        this.recordDateUpdate = recordDateUpdate;
        this.recordDateSync = recordDateSync;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.recordId);
        dest.writeString(this.recordUserId);
        dest.writeString(this.recordPhase);
        dest.writeString(this.recordNumber);
        dest.writeString(this.recordGroup);
        dest.writeString(this.recordStatus);
        dest.writeString(this.recordQuestion);
        dest.writeString(this.recordAnswer);
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
    }

    protected ModelModulePersonalityChoice(Parcel in) {
        this.recordId = in.readString();
        this.recordUserId = in.readString();
        this.recordPhase = in.readString();
        this.recordNumber = in.readString();
        this.recordGroup = in.readString();
        this.recordStatus = in.readString();
        this.recordQuestion = in.readString();
        this.recordAnswer = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
    }

    public static final Creator<ModelModulePersonalityChoice> CREATOR = new Creator<ModelModulePersonalityChoice>() {
        @Override
        public ModelModulePersonalityChoice createFromParcel(Parcel source) {
            return new ModelModulePersonalityChoice(source);
        }

        @Override
        public ModelModulePersonalityChoice[] newArray(int size) {
            return new ModelModulePersonalityChoice[size];
        }
    };
}
