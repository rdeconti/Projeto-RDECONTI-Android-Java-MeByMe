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

public class ModelSupportUser implements Parcelable {

    private String recordId;
    private String recordUserLanguage;
    private String recordUserFirstName;
    private String recordUserLastName;
    private String recordUserCompleteName;
    private String recordUserNickName;
    private String recordUserBirthdate;
    private String recordUserBirthCountry;
    private String recordUserGender;
    private String recordUserSexualOption;
    private String recordUserRace;
    private String recordUserMaritalStatus;
    private String recordUserReligion;
    private String recordUserScholarity;
    private String recordUserHeight;
    private String recordUserWeight;
    private String recordUserEmail;
    private byte[] recordUserPhoto;
    private String recordPasswordChangeLast;
    private String recordPasswordChangeNext;
    private String recordPasswordChangeFrequency;
    private String recordPasswordBlocked;
    private String recordDatabaseSyncLast;
    private String recordDatabaseSyncNext;
    private String recordDatabaseReset;
    private String recordApplicationLanguage;
    private String recordApplicationVersion;
    private String recordApplicationType;
    private String recordApplicationDonationDate;
    private String recordApplicationDonationValue;
    private String recordApplicationEvaluationDate;
    private String recordApplicationEvaluationValue;
    private String recordDateCreation;
    private String recordDateUpdate;
    private String recordDateSync;

    public ModelSupportUser() {

    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordUserLanguage() {
        return recordUserLanguage;
    }

    public void setRecordUserLanguage(String recordUserLanguage) {
        this.recordUserLanguage = recordUserLanguage;
    }

    public String getRecordUserFirstName() {
        return recordUserFirstName;
    }

    public void setRecordUserFirstName(String recordUserFirstName) {
        this.recordUserFirstName = recordUserFirstName;
    }

    public String getRecordUserLastName() {
        return recordUserLastName;
    }

    public void setRecordUserLastName(String recordUserLastName) {
        this.recordUserLastName = recordUserLastName;
    }

    public String getRecordUserCompleteName() {
        return recordUserCompleteName;
    }

    public void setRecordUserCompleteName(String recordUserCompleteName) {
        this.recordUserCompleteName = recordUserCompleteName;
    }

    public String getRecordUserNickName() {
        return recordUserNickName;
    }

    public void setRecordUserNickName(String recordUserNickName) {
        this.recordUserNickName = recordUserNickName;
    }

    public String getRecordUserBirthdate() {
        return recordUserBirthdate;
    }

    public void setRecordUserBirthdate(String recordUserBirthdate) {
        this.recordUserBirthdate = recordUserBirthdate;
    }

    public String getRecordUserBirthCountry() {
        return recordUserBirthCountry;
    }

    public void setRecordUserBirthCountry(String recordUserBirthCountry) {
        this.recordUserBirthCountry = recordUserBirthCountry;
    }

    public String getRecordUserGender() {
        return recordUserGender;
    }

    public void setRecordUserGender(String recordUserGender) {
        this.recordUserGender = recordUserGender;
    }

    public String getRecordUserSexualOption() {
        return recordUserSexualOption;
    }

    public void setRecordUserSexualOption(String recordUserSexualOption) {
        this.recordUserSexualOption = recordUserSexualOption;
    }

    public String getRecordUserRace() {
        return recordUserRace;
    }

    public void setRecordUserRace(String recordUserRace) {
        this.recordUserRace = recordUserRace;
    }

    public String getRecordUserMaritalStatus() {
        return recordUserMaritalStatus;
    }

    public void setRecordUserMaritalStatus(String recordUserMaritalStatus) {
        this.recordUserMaritalStatus = recordUserMaritalStatus;
    }

    public String getRecordUserReligion() {
        return recordUserReligion;
    }

    public void setRecordUserReligion(String recordUserReligion) {
        this.recordUserReligion = recordUserReligion;
    }

    public String getRecordUserScholarity() {
        return recordUserScholarity;
    }

    public void setRecordUserScholarity(String recordUserScholarity) {
        this.recordUserScholarity = recordUserScholarity;
    }

    public String getRecordUserHeight() {
        return recordUserHeight;
    }

    public void setRecordUserHeight(String recordUserHeight) {
        this.recordUserHeight = recordUserHeight;
    }

    public String getRecordUserWeight() {
        return recordUserWeight;
    }

    public void setRecordUserWeight(String recordUserWeight) {
        this.recordUserWeight = recordUserWeight;
    }

    public String getRecordUserEmail() {
        return recordUserEmail;
    }

    public void setRecordUserEmail(String recordUserEmail) {
        this.recordUserEmail = recordUserEmail;
    }

    public byte[] getRecordUserPhoto() {
        return recordUserPhoto;
    }

    public void setRecordUserPhoto(byte[] recordUserPhoto) {
        this.recordUserPhoto = recordUserPhoto;
    }

    public String getRecordPasswordChangeLast() {
        return recordPasswordChangeLast;
    }

    public void setRecordPasswordChangeLast(String recordPasswordChangeLast) {
        this.recordPasswordChangeLast = recordPasswordChangeLast;
    }

    public String getRecordPasswordChangeNext() {
        return recordPasswordChangeNext;
    }

    public void setRecordPasswordChangeNext(String recordPasswordChangeNext) {
        this.recordPasswordChangeNext = recordPasswordChangeNext;
    }

    public String getRecordPasswordChangeFrequency() {
        return recordPasswordChangeFrequency;
    }

    public void setRecordPasswordChangeFrequency(String recordPasswordChangeFrequency) {
        this.recordPasswordChangeFrequency = recordPasswordChangeFrequency;
    }

    public String getRecordPasswordBlocked() {
        return recordPasswordBlocked;
    }

    public void setRecordPasswordBlocked(String recordPasswordBlocked) {
        this.recordPasswordBlocked = recordPasswordBlocked;
    }

    public String getRecordDatabaseSyncLast() {
        return recordDatabaseSyncLast;
    }

    public void setRecordDatabaseSyncLast(String recordDatabaseSyncLast) {
        this.recordDatabaseSyncLast = recordDatabaseSyncLast;
    }

    public String getRecordDatabaseSyncNext() {
        return recordDatabaseSyncNext;
    }

    public void setRecordDatabaseSyncNext(String recordDatabaseSyncNext) {
        this.recordDatabaseSyncNext = recordDatabaseSyncNext;
    }

    public String getRecordDatabaseReset() {
        return recordDatabaseReset;
    }

    public void setRecordDatabaseReset(String recordDatabaseReset) {
        this.recordDatabaseReset = recordDatabaseReset;
    }

    public String getRecordApplicationLanguage() {
        return recordApplicationLanguage;
    }

    public void setRecordApplicationLanguage(String recordApplicationLanguage) {
        this.recordApplicationLanguage = recordApplicationLanguage;
    }

    public String getRecordApplicationVersion() {
        return recordApplicationVersion;
    }

    public void setRecordApplicationVersion(String recordApplicationVersion) {
        this.recordApplicationVersion = recordApplicationVersion;
    }

    public String getRecordApplicationType() {
        return recordApplicationType;
    }

    public void setRecordApplicationType(String recordApplicationType) {
        this.recordApplicationType = recordApplicationType;
    }

    public String getRecordApplicationDonationDate() {
        return recordApplicationDonationDate;
    }

    public void setRecordApplicationDonationDate(String recordApplicationDonationDate) {
        this.recordApplicationDonationDate = recordApplicationDonationDate;
    }

    public String getRecordApplicationDonationValue() {
        return recordApplicationDonationValue;
    }

    public void setRecordApplicationDonationValue(String recordApplicationDonationValue) {
        this.recordApplicationDonationValue = recordApplicationDonationValue;
    }

    public String getRecordApplicationEvaluationDate() {
        return recordApplicationEvaluationDate;
    }

    public void setRecordApplicationEvaluationDate(String recordApplicationEvaluationDate) {
        this.recordApplicationEvaluationDate = recordApplicationEvaluationDate;
    }

    public String getRecordApplicationEvaluationValue() {
        return recordApplicationEvaluationValue;
    }

    public void setRecordApplicationEvaluationValue(String recordApplicationEvaluationValue) {
        this.recordApplicationEvaluationValue = recordApplicationEvaluationValue;
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

    public ModelSupportUser(String recordId, String recordUserLanguage, String recordUserFirstName, String recordUserLastName, String recordUserCompleteName, String recordUserNickName, String recordUserBirthdate, String recordUserBirthCountry, String recordUserGender, String recordUserSexualOption, String recordUserRace, String recordUserMaritalStatus, String recordUserReligion, String recordUserScholarity, String recordUserHeight, String recordUserWeight, String recordUserEmail, byte[] recordUserPhoto, String recordPasswordChangeLast, String recordPasswordChangeNext, String recordPasswordChangeFrequency, String recordPasswordBlocked, String recordDatabaseSyncLast, String recordDatabaseSyncNext, String recordDatabaseReset, String recordApplicationLanguage, String recordApplicationVersion, String recordApplicationType, String recordApplicationDonationDate, String recordApplicationDonationValue, String recordApplicationEvaluationDate, String recordApplicationEvaluationValue, String recordDateCreation, String recordDateUpdate, String recordDateSync) {
        this.recordId = recordId;
        this.recordUserLanguage = recordUserLanguage;
        this.recordUserFirstName = recordUserFirstName;
        this.recordUserLastName = recordUserLastName;
        this.recordUserCompleteName = recordUserCompleteName;
        this.recordUserNickName = recordUserNickName;
        this.recordUserBirthdate = recordUserBirthdate;
        this.recordUserBirthCountry = recordUserBirthCountry;
        this.recordUserGender = recordUserGender;
        this.recordUserSexualOption = recordUserSexualOption;
        this.recordUserRace = recordUserRace;
        this.recordUserMaritalStatus = recordUserMaritalStatus;
        this.recordUserReligion = recordUserReligion;
        this.recordUserScholarity = recordUserScholarity;
        this.recordUserHeight = recordUserHeight;
        this.recordUserWeight = recordUserWeight;
        this.recordUserEmail = recordUserEmail;
        this.recordUserPhoto = recordUserPhoto;
        this.recordPasswordChangeLast = recordPasswordChangeLast;
        this.recordPasswordChangeNext = recordPasswordChangeNext;
        this.recordPasswordChangeFrequency = recordPasswordChangeFrequency;
        this.recordPasswordBlocked = recordPasswordBlocked;
        this.recordDatabaseSyncLast = recordDatabaseSyncLast;
        this.recordDatabaseSyncNext = recordDatabaseSyncNext;
        this.recordDatabaseReset = recordDatabaseReset;
        this.recordApplicationLanguage = recordApplicationLanguage;
        this.recordApplicationVersion = recordApplicationVersion;
        this.recordApplicationType = recordApplicationType;
        this.recordApplicationDonationDate = recordApplicationDonationDate;
        this.recordApplicationDonationValue = recordApplicationDonationValue;
        this.recordApplicationEvaluationDate = recordApplicationEvaluationDate;
        this.recordApplicationEvaluationValue = recordApplicationEvaluationValue;
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
        dest.writeString(this.recordUserLanguage);
        dest.writeString(this.recordUserFirstName);
        dest.writeString(this.recordUserLastName);
        dest.writeString(this.recordUserCompleteName);
        dest.writeString(this.recordUserNickName);
        dest.writeString(this.recordUserBirthdate);
        dest.writeString(this.recordUserBirthCountry);
        dest.writeString(this.recordUserGender);
        dest.writeString(this.recordUserSexualOption);
        dest.writeString(this.recordUserRace);
        dest.writeString(this.recordUserMaritalStatus);
        dest.writeString(this.recordUserReligion);
        dest.writeString(this.recordUserScholarity);
        dest.writeString(this.recordUserHeight);
        dest.writeString(this.recordUserWeight);
        dest.writeString(this.recordUserEmail);
        dest.writeByteArray(this.recordUserPhoto);
        dest.writeString(this.recordPasswordChangeLast);
        dest.writeString(this.recordPasswordChangeNext);
        dest.writeString(this.recordPasswordChangeFrequency);
        dest.writeString(this.recordPasswordBlocked);
        dest.writeString(this.recordDatabaseSyncLast);
        dest.writeString(this.recordDatabaseSyncNext);
        dest.writeString(this.recordDatabaseReset);
        dest.writeString(this.recordApplicationLanguage);
        dest.writeString(this.recordApplicationVersion);
        dest.writeString(this.recordApplicationType);
        dest.writeString(this.recordApplicationDonationDate);
        dest.writeString(this.recordApplicationDonationValue);
        dest.writeString(this.recordApplicationEvaluationDate);
        dest.writeString(this.recordApplicationEvaluationValue);
        dest.writeString(this.recordDateCreation);
        dest.writeString(this.recordDateUpdate);
        dest.writeString(this.recordDateSync);
    }

    protected ModelSupportUser(Parcel in) {
        this.recordId = in.readString();
        this.recordUserLanguage = in.readString();
        this.recordUserFirstName = in.readString();
        this.recordUserLastName = in.readString();
        this.recordUserCompleteName = in.readString();
        this.recordUserNickName = in.readString();
        this.recordUserBirthdate = in.readString();
        this.recordUserBirthCountry = in.readString();
        this.recordUserGender = in.readString();
        this.recordUserSexualOption = in.readString();
        this.recordUserRace = in.readString();
        this.recordUserMaritalStatus = in.readString();
        this.recordUserReligion = in.readString();
        this.recordUserScholarity = in.readString();
        this.recordUserHeight = in.readString();
        this.recordUserWeight = in.readString();
        this.recordUserEmail = in.readString();
        this.recordUserPhoto = in.createByteArray();
        this.recordPasswordChangeLast = in.readString();
        this.recordPasswordChangeNext = in.readString();
        this.recordPasswordChangeFrequency = in.readString();
        this.recordPasswordBlocked = in.readString();
        this.recordDatabaseSyncLast = in.readString();
        this.recordDatabaseSyncNext = in.readString();
        this.recordDatabaseReset = in.readString();
        this.recordApplicationLanguage = in.readString();
        this.recordApplicationVersion = in.readString();
        this.recordApplicationType = in.readString();
        this.recordApplicationDonationDate = in.readString();
        this.recordApplicationDonationValue = in.readString();
        this.recordApplicationEvaluationDate = in.readString();
        this.recordApplicationEvaluationValue = in.readString();
        this.recordDateCreation = in.readString();
        this.recordDateUpdate = in.readString();
        this.recordDateSync = in.readString();
    }

    public static final Creator<ModelSupportUser> CREATOR = new Creator<ModelSupportUser>() {
        @Override
        public ModelSupportUser createFromParcel(Parcel source) {
            return new ModelSupportUser(source);
        }

        @Override
        public ModelSupportUser[] newArray(int size) {
            return new ModelSupportUser[size];
        }
    };
}
