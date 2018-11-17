package com.dsman.uaapp.Notifications;

import android.os.Parcel;
import android.os.Parcelable;

public class NotificationObject implements Parcelable {
    private String nameclass;

    public NotificationObject(String nameclass) {
        this.nameclass = nameclass;
    }

    public NotificationObject(Parcel in) {
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

    public static final Creator<NotificationObject> CREATOR = new Creator<NotificationObject>() {
        @Override
        public NotificationObject createFromParcel(Parcel in) {
            return new NotificationObject(in);
        }

        @Override
        public NotificationObject[] newArray(int size) {
            return new NotificationObject[size];
        }
    };

    public String getNameclass() {
        return nameclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }
}
