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

public class ModelModuleSharingAnswer implements Parcelable {

    private String recordId;
    private String recordUserId;
    private String recordPhase;
    private String recordNumber;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;
    private byte[] recordImage;

    public ModelModuleSharingAnswer() {

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

    public byte[] getRecordImage() {
        return recordImage;
    }

    public void setRecordImage(byte[] recordImage) {
        this.recordImage = recordImage;
    }

    public ModelModuleSharingAnswer(String recordId, String recordUserId, String recordPhase, String recordNumber, String recordDateCreation, String recordDateUpdate, String recordDateSync, byte[] recordImage) {
        this.recordId = recordId;
        this.recordUserId = recordUserId;
        this.recordPhase = recordPhase;
        this.recordNumber = recordNumber;
        this.recordDateCreation = recordDateCreation;
        this.recordDateUpdate = recordDateUpdate;
        this.recordDateSync = recordDateSync;
        this.recordImage = recordImage;
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
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
        dest.writeByteArray(this.recordImage);
    }

    protected ModelModuleSharingAnswer(Parcel in) {
        this.recordId = in.readString();
        this.recordUserId = in.readString();
        this.recordPhase = in.readString();
        this.recordNumber = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
        this.recordImage = in.createByteArray();
    }

    public static final Creator<ModelModuleSharingAnswer> CREATOR = new Creator<ModelModuleSharingAnswer>() {
        @Override
        public ModelModuleSharingAnswer createFromParcel(Parcel source) {
            return new ModelModuleSharingAnswer(source);
        }

        @Override
        public ModelModuleSharingAnswer[] newArray(int size) {
            return new ModelModuleSharingAnswer[size];
        }
    };
}
