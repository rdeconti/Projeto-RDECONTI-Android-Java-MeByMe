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

public class ModelModulePersonalityQuestion implements Parcelable {

    private String recordId;
    private String recordLanguage;
    private String recordPhase;
    private String recordNumber;
    private String recordGroup;
    private String recordText;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;

    public ModelModulePersonalityQuestion() {

    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordLanguage() {
        return recordLanguage;
    }

    public void setRecordLanguage(String recordLanguage) {
        this.recordLanguage = recordLanguage;
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

    public String getRecordText() {
        return recordText;
    }

    public void setRecordText(String recordText) {
        this.recordText = recordText;
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

    public ModelModulePersonalityQuestion(String recordId, String recordLanguage, String recordPhase, String recordNumber, String recordGroup, String recordText, String recordDateCreation, String recordDateUpdate, String recordDateSync) {
        this.recordId = recordId;
        this.recordLanguage = recordLanguage;
        this.recordPhase = recordPhase;
        this.recordNumber = recordNumber;
        this.recordGroup = recordGroup;
        this.recordText = recordText;
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
        dest.writeString(this.recordLanguage);
        dest.writeString(this.recordPhase);
        dest.writeString(this.recordNumber);
        dest.writeString(this.recordGroup);
        dest.writeString(this.recordText);
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
    }

    protected ModelModulePersonalityQuestion(Parcel in) {
        this.recordId = in.readString();
        this.recordLanguage = in.readString();
        this.recordPhase = in.readString();
        this.recordNumber = in.readString();
        this.recordGroup = in.readString();
        this.recordText = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
    }

    public static final Creator<ModelModulePersonalityQuestion> CREATOR = new Creator<ModelModulePersonalityQuestion>() {
        @Override
        public ModelModulePersonalityQuestion createFromParcel(Parcel source) {
            return new ModelModulePersonalityQuestion(source);
        }

        @Override
        public ModelModulePersonalityQuestion[] newArray(int size) {
            return new ModelModulePersonalityQuestion[size];
        }
    };
}


