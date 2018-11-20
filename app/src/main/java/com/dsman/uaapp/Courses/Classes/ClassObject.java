package com.dsman.uaapp.Courses.Classes;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassObject implements Parcelable {
    private String nameclass;
    private int imgclass;
    private String course;

    public ClassObject(String nameclass, int imgclass, String course) {
        this.nameclass = nameclass;
        this.imgclass = imgclass;
        this.course = course;
    }

    public ClassObject(Parcel in) {
        nameclass = in.readString();
        imgclass = in.readInt();
        course = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameclass);
        dest.writeInt(imgclass);
        dest.writeString(course);
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
