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

public class ModelModuleBeliefDescription implements Parcelable {

    private String recordId;
    private String recordPhase;
    private String recordSign;
    private String recordLanguage;
    private String recordName;
    private String recordText;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;

    public ModelModuleBeliefDescription() {

    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordPhase() {
        return recordPhase;
    }

    public void setRecordPhase(String recordPhase) {
        this.recordPhase = recordPhase;
    }

    public String getRecordSign() {
        return recordSign;
    }

    public void setRecordSign(String recordSign) {
        this.recordSign = recordSign;
    }

    public String getRecordLanguage() {
        return recordLanguage;
    }

    public void setRecordLanguage(String recordLanguage) {
        this.recordLanguage = recordLanguage;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
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

    public ModelModuleBeliefDescription(String recordId, String recordPhase, String recordSign, String recordLanguage, String recordName, String recordText, String recordDateCreation, String recordDateUpdate, String recordDateSync) {
        this.recordId = recordId;
        this.recordPhase = recordPhase;
        this.recordSign = recordSign;
        this.recordLanguage = recordLanguage;
        this.recordName = recordName;
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
        dest.writeString(this.recordPhase);
        dest.writeString(this.recordSign);
        dest.writeString(this.recordLanguage);
        dest.writeString(this.recordName);
        dest.writeString(this.recordText);
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
    }

    protected ModelModuleBeliefDescription(Parcel in) {
        this.recordId = in.readString();
        this.recordPhase = in.readString();
        this.recordSign = in.readString();
        this.recordLanguage = in.readString();
        this.recordName = in.readString();
        this.recordText = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
    }

    public static final Creator<ModelModuleBeliefDescription> CREATOR = new Creator<ModelModuleBeliefDescription>() {
        @Override
        public ModelModuleBeliefDescription createFromParcel(Parcel source) {
            return new ModelModuleBeliefDescription(source);
        }

        @Override
        public ModelModuleBeliefDescription[] newArray(int size) {
            return new ModelModuleBeliefDescription[size];
        }
    };
}
