package com.dsman.uaapp.Classes;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassObject implements Parcelable {
    private String nameclass;
    private int imgclass;

    public ClassObject(String nameclass, int imgclass) {
        this.nameclass = nameclass;
        this.imgclass = imgclass;
    }

    public ClassObject(Parcel in) {
        nameclass = in.readString();
        imgclass = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameclass);
        dest.writeInt(imgclass);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ClassObject> CREATOR = new Creator<ClassObject>() {
        @Override
        public ClassObject createFromParcel(Parcel in) {
            return new ClassObject(in);
        }

        @Override
        public ClassObject[] newArray(int size) {
            return new ClassObject[size];
        }
    };

    public String getNameclass() {
        return nameclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }

    public int getImgclass() {
        return imgclass;
    }

    public void setImgclass(int imgclass) {
        this.imgclass = imgclass;
    }
}
