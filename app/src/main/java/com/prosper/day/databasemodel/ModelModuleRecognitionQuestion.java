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

public class ModelModuleRecognitionQuestion implements Parcelable {

    private String recordId;
    private String recordLanguage;
    private String recordPhase;
    private String recordNumber;
    private String recordHeader;
    private String recordDescription;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;

    public ModelModuleRecognitionQuestion() {

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

    public String getRecordHeader() {
        return recordHeader;
    }

    public void setRecordHeader(String recordHeader) {
        this.recordHeader = recordHeader;
    }

    public String getRecordDescription() {
        return recordDescription;
    }

    public void setRecordDescription(String recordDescription) {
        this.recordDescription = recordDescription;
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

    public ModelModuleRecognitionQuestion(String recordId, String recordLanguage, String recordPhase, String recordNumber, String recordHeader, String recordDescription, String recordDateCreation, String recordDateUpdate, String recordDateSync) {
        this.recordId = recordId;
        this.recordLanguage = recordLanguage;
        this.recordPhase = recordPhase;
        this.recordNumber = recordNumber;
        this.recordHeader = recordHeader;
        this.recordDescription = recordDescription;
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
        dest.writeString(this.recordHeader);
        dest.writeString(this.recordDescription);
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
    }

    protected ModelModuleRecognitionQuestion(Parcel in) {
        this.recordId = in.readString();
        this.recordLanguage = in.readString();
        this.recordPhase = in.readString();
        this.recordNumber = in.readString();
        this.recordHeader = in.readString();
        this.recordDescription = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
    }

    public static final Creator<ModelModuleRecognitionQuestion> CREATOR = new Creator<ModelModuleRecognitionQuestion>() {
        @Override
        public ModelModuleRecognitionQuestion createFromParcel(Parcel source) {
            return new ModelModuleRecognitionQuestion(source);
        }

        @Override
        public ModelModuleRecognitionQuestion[] newArray(int size) {
            return new ModelModuleRecognitionQuestion[size];
        }
    };
}
