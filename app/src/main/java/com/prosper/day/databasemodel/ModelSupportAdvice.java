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

public class ModelSupportAdvice implements Parcelable {

    private String recordId;
    private String recordLanguage;
    private String recordNumber;
    private String recordAuthor;
    private String recordText;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;

    public ModelSupportAdvice() {

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

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getRecordAuthor() {
        return recordAuthor;
    }

    public void setRecordAuthor(String recordAuthor) {
        this.recordAuthor = recordAuthor;
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

    public ModelSupportAdvice(String recordId, String recordLanguage, String recordNumber, String recordAuthor, String recordText, String recordDateCreation, String recordDateUpdate, String recordDateSync) {
        this.recordId = recordId;
        this.recordLanguage = recordLanguage;
        this.recordNumber = recordNumber;
        this.recordAuthor = recordAuthor;
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
        dest.writeString(this.recordNumber);
        dest.writeString(this.recordAuthor);
        dest.writeString(this.recordText);
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
    }

    protected ModelSupportAdvice(Parcel in) {
        this.recordId = in.readString();
        this.recordLanguage = in.readString();
        this.recordNumber = in.readString();
        this.recordAuthor = in.readString();
        this.recordText = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
    }

    public static final Creator<ModelSupportAdvice> CREATOR = new Creator<ModelSupportAdvice>() {
        @Override
        public ModelSupportAdvice createFromParcel(Parcel source) {
            return new ModelSupportAdvice(source);
        }

        @Override
        public ModelSupportAdvice[] newArray(int size) {
            return new ModelSupportAdvice[size];
        }
    };
}
