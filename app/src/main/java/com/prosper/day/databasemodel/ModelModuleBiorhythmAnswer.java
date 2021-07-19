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

public class ModelModuleBiorhythmAnswer implements Parcelable {

    private String recordId;
    private String recordUserId;
    private String recordPhase;
    private String recordNumber;
    private String recordStatus;
    private String recordExperience;
    private double recordEmotional;
    private double recordPhysical;
    private double recordIntelectual;
    private String recordNumberPoints;
    private String recordNumberSharing;
    private String recordNumberPhotos;
    private String recordNumberActions;
    private String recordDateEvent;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;

    public ModelModuleBiorhythmAnswer() {

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

    public double getRecordEmotional() {
        return recordEmotional;
    }

    public void setRecordEmotional(double recordEmotional) {
        this.recordEmotional = recordEmotional;
    }

    public double getRecordPhysical() {
        return recordPhysical;
    }

    public void setRecordPhysical(double recordPhysical) {
        this.recordPhysical = recordPhysical;
    }

    public double getRecordIntelectual() {
        return recordIntelectual;
    }

    public void setRecordIntelectual(double recordIntelectual) {
        this.recordIntelectual = recordIntelectual;
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

    public String getRecordDateEvent() {
        return recordDateEvent;
    }

    public void setRecordDateEvent(String recordDateEvent) {
        this.recordDateEvent = recordDateEvent;
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

    public ModelModuleBiorhythmAnswer(String recordId, String recordUserId, String recordPhase, String recordNumber, String recordStatus, String recordExperience, double recordEmotional, double recordPhysical, double recordIntelectual, String recordNumberPoints, String recordNumberSharing, String recordNumberPhotos, String recordNumberActions, String recordDateEvent, String recordDateCreation, String recordDateUpdate, String recordDateSync) {
        this.recordId = recordId;
        this.recordUserId = recordUserId;
        this.recordPhase = recordPhase;
        this.recordNumber = recordNumber;
        this.recordStatus = recordStatus;
        this.recordExperience = recordExperience;
        this.recordEmotional = recordEmotional;
        this.recordPhysical = recordPhysical;
        this.recordIntelectual = recordIntelectual;
        this.recordNumberPoints = recordNumberPoints;
        this.recordNumberSharing = recordNumberSharing;
        this.recordNumberPhotos = recordNumberPhotos;
        this.recordNumberActions = recordNumberActions;
        this.recordDateEvent = recordDateEvent;
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
        dest.writeString(this.recordStatus);
        dest.writeString(this.recordExperience);
        dest.writeDouble(this.recordEmotional);
        dest.writeDouble(this.recordPhysical);
        dest.writeDouble(this.recordIntelectual);
        dest.writeString(this.recordNumberPoints);
        dest.writeString(this.recordNumberSharing);
        dest.writeString(this.recordNumberPhotos);
        dest.writeString(this.recordNumberActions);
        dest.writeString(this.recordDateEvent);
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
    }

    protected ModelModuleBiorhythmAnswer(Parcel in) {
        this.recordId = in.readString();
        this.recordUserId = in.readString();
        this.recordPhase = in.readString();
        this.recordNumber = in.readString();
        this.recordStatus = in.readString();
        this.recordExperience = in.readString();
        this.recordEmotional = in.readDouble();
        this.recordPhysical = in.readDouble();
        this.recordIntelectual = in.readDouble();
        this.recordNumberPoints = in.readString();
        this.recordNumberSharing = in.readString();
        this.recordNumberPhotos = in.readString();
        this.recordNumberActions = in.readString();
        this.recordDateEvent = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
    }

    public static final Creator<ModelModuleBiorhythmAnswer> CREATOR = new Creator<ModelModuleBiorhythmAnswer>() {
        @Override
        public ModelModuleBiorhythmAnswer createFromParcel(Parcel source) {
            return new ModelModuleBiorhythmAnswer(source);
        }

        @Override
        public ModelModuleBiorhythmAnswer[] newArray(int size) {
            return new ModelModuleBiorhythmAnswer[size];
        }
    };
}
