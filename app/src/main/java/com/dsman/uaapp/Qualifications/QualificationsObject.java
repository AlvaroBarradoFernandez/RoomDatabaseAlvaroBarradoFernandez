package com.dsman.uaapp.Qualifications;

import android.os.Parcel;
import android.os.Parcelable;

public class QualificationsObject implements Parcelable {
    private String nameclass;

    public QualificationsObject(String nameclass) {
        this.nameclass = nameclass;
    }

    public QualificationsObject(Parcel in) {
        nameclass = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameclass);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QualificationsObject> CREATOR = new Creator<QualificationsObject>() {
        @Override
        public QualificationsObject createFromParcel(Parcel in) {
            return new QualificationsObject(in);
        }

        @Override
        public QualificationsObject[] newArray(int size) {
            return new QualificationsObject[size];
        }
    };

    public String getNameclass() {
        return nameclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }
}
