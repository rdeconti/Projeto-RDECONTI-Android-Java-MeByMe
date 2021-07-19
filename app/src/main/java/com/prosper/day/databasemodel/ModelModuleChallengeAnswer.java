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

public class ModelModuleChallengeAnswer implements Parcelable {

    private String recordId;
    private String recordUserId;
    private String recordNumber;
    private String recordStatus;
    private String recordExperience;
    private String recordPriority;
    private String recordFrequency;
    private String recordCosts;
    private String recordQuestion;
    private String recordNumberPoints;
    private String recordNumberSharing;
    private String recordNumberPhotos;
    private String recordNumberActions;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;

    public ModelModuleChallengeAnswer() {

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

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRecordExperience() {
        return recordExperience;
    }

    public void setRecordExperience(String recordExperience) {
        this.recordExperience = recordExperience;
    }

    public String getRecordPriority() {
        return recordPriority;
    }

    public void setRecordPriority(String recordPriority) {
        this.recordPriority = recordPriority;
    }

    public String getRecordFrequency() {
        return recordFrequency;
    }

    public void setRecordFrequency(String recordFrequency) {
        this.recordFrequency = recordFrequency;
    }

    public String getRecordCosts() {
        return recordCosts;
    }

    public void setRecordCosts(String recordCosts) {
        this.recordCosts = recordCosts;
    }

    public String getRecordQuestion() {
        return recordQuestion;
    }

    public void setRecordQuestion(String recordQuestion) {
        this.recordQuestion = recordQuestion;
    }

    public String getRecordNumberPoints() {
        return recordNumberPoints;
    }

    public void setRecordNumberPoints(String recordNumberPoints) {
        this.recordNumberPoints = recordNumberPoints;
    }

    public String getRecordNumberSharing() {
        return recordNumberSharing;
    }

    public void setRecordNumberSharing(String recordNumberSharing) {
        this.recordNumberSharing = recordNumberSharing;
    }

    public String getRecordNumberPhotos() {
        return recordNumberPhotos;
    }

    public void setRecordNumberPhotos(String recordNumberPhotos) {
        this.recordNumberPhotos = recordNumberPhotos;
    }

    public String getRecordNumberActions() {
        return recordNumberActions;
    }

    public void setRecordNumberActions(String recordNumberActions) {
        this.recordNumberActions = recordNumberActions;
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

    public ModelModuleChallengeAnswer(String recordId, String recordUserId, String recordNumber, String recordStatus, String recordExperience, String recordPriority, String recordFrequency, String recordCosts, String recordQuestion, String recordNumberPoints, String recordNumberSharing, String recordNumberPhotos, String recordNumberActions, String recordDateCreation, String recordDateUpdate, String recordDateSync) {
        this.recordId = recordId;
        this.recordUserId = recordUserId;
        this.recordNumber = recordNumber;
        this.recordStatus = recordStatus;
        this.recordExperience = recordExperience;
        this.recordPriority = recordPriority;
        this.recordFrequency = recordFrequency;
        this.recordCosts = recordCosts;
        this.recordQuestion = recordQuestion;
        this.recordNumberPoints = recordNumberPoints;
        this.recordNumberSharing = recordNumberSharing;
        this.recordNumberPhotos = recordNumberPhotos;
        this.recordNumberActions = recordNumberActions;
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
        dest.writeString(this.recordNumber);
        dest.writeString(this.recordStatus);
        dest.writeString(this.recordExperience);
        dest.writeString(this.recordPriority);
        dest.writeString(this.recordFrequency);
        dest.writeString(this.recordCosts);
        dest.writeString(this.recordQuestion);
        dest.writeString(this.recordNumberPoints);
        dest.writeString(this.recordNumberSharing);
        dest.writeString(this.recordNumberPhotos);
        dest.writeString(this.recordNumberActions);
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
    }

    protected ModelModuleChallengeAnswer(Parcel in) {
        this.recordId = in.readString();
        this.recordUserId = in.readString();
        this.recordNumber = in.readString();
        this.recordStatus = in.readString();
        this.recordExperience = in.readString();
        this.recordPriority = in.readString();
        this.recordFrequency = in.readString();
        this.recordCosts = in.readString();
        this.recordQuestion = in.readString();
        this.recordNumberPoints = in.readString();
        this.recordNumberSharing = in.readString();
        this.recordNumberPhotos = in.readString();
        this.recordNumberActions = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
    }

    public static final Creator<ModelModuleChallengeAnswer> CREATOR = new Creator<ModelModuleChallengeAnswer>() {
        @Override
        public ModelModuleChallengeAnswer createFromParcel(Parcel source) {
            return new ModelModuleChallengeAnswer(source);
        }

        @Override
        public ModelModuleChallengeAnswer[] newArray(int size) {
            return new ModelModuleChallengeAnswer[size];
        }
    };
}
