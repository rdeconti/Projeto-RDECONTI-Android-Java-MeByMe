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

public class ModelModuleBeliefCalendar implements Parcelable {

    private String recordId;
    private String recordPhase;
    private String recordSign;
    private String recordDayFrom;
    private String recordMonthFrom;
    private String recordYearFrom;
    private String recordDayTo;
    private String recordMonthTo;
    private String recordYearTo;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;

    public ModelModuleBeliefCalendar() {

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

    public String getRecordDayFrom() {
        return recordDayFrom;
    }

    public void setRecordDayFrom(String recordDayFrom) {
        this.recordDayFrom = recordDayFrom;
    }

    public String getRecordMonthFrom() {
        return recordMonthFrom;
    }

    public void setRecordMonthFrom(String recordMonthFrom) {
        this.recordMonthFrom = recordMonthFrom;
    }

    public String getRecordYearFrom() {
        return recordYearFrom;
    }

    public void setRecordYearFrom(String recordYearFrom) {
        this.recordYearFrom = recordYearFrom;
    }

    public String getRecordDayTo() {
        return recordDayTo;
    }

    public void setRecordDayTo(String recordDayTo) {
        this.recordDayTo = recordDayTo;
    }

    public String getRecordMonthTo() {
        return recordMonthTo;
    }

    public void setRecordMonthTo(String recordMonthTo) {
        this.recordMonthTo = recordMonthTo;
    }

    public String getRecordYearTo() {
        return recordYearTo;
    }

    public void setRecordYearTo(String recordYearTo) {
        this.recordYearTo = recordYearTo;
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

    public ModelModuleBeliefCalendar(String recordId, String recordPhase, String recordSign, String recordDayFrom, String recordMonthFrom, String recordYearFrom, String recordDayTo, String recordMonthTo, String recordYearTo, String recordDateCreation, String recordDateUpdate, String recordDateSync) {
        this.recordId = recordId;
        this.recordPhase = recordPhase;
        this.recordSign = recordSign;
        this.recordDayFrom = recordDayFrom;
        this.recordMonthFrom = recordMonthFrom;
        this.recordYearFrom = recordYearFrom;
        this.recordDayTo = recordDayTo;
        this.recordMonthTo = recordMonthTo;
        this.recordYearTo = recordYearTo;
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
        dest.writeString(this.recordDayFrom);
        dest.writeString(this.recordMonthFrom);
        dest.writeString(this.recordYearFrom);
        dest.writeString(this.recordDayTo);
        dest.writeString(this.recordMonthTo);
        dest.writeString(this.recordYearTo);
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
    }

    protected ModelModuleBeliefCalendar(Parcel in) {
        this.recordId = in.readString();
        this.recordPhase = in.readString();
        this.recordSign = in.readString();
        this.recordDayFrom = in.readString();
        this.recordMonthFrom = in.readString();
        this.recordYearFrom = in.readString();
        this.recordDayTo = in.readString();
        this.recordMonthTo = in.readString();
        this.recordYearTo = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
    }

    public static final Creator<ModelModuleBeliefCalendar> CREATOR = new Creator<ModelModuleBeliefCalendar>() {
        @Override
        public ModelModuleBeliefCalendar createFromParcel(Parcel source) {
            return new ModelModuleBeliefCalendar(source);
        }

        @Override
        public ModelModuleBeliefCalendar[] newArray(int size) {
            return new ModelModuleBeliefCalendar[size];
        }
    };
}
