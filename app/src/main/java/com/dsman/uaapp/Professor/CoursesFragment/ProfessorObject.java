package com.dsman.uaapp.Professor.CoursesFragment;

import android.os.Parcel;
import android.os.Parcelable;

public class ProfessorObject implements Parcelable {
    private String nameprofessor;
    private int imgprofessor;

    public ProfessorObject(String nameprofessor, int imgprofessor) {
        this.nameprofessor = nameprofessor;
        this.imgprofessor = imgprofessor;
    }

    public ProfessorObject(Parcel in) {
        nameprofessor = in.readString();
        imgprofessor = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameprofessor);
        dest.writeInt(imgprofessor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProfessorObject> CREATOR = new Creator<ProfessorObject>() {
        @Override
        public ProfessorObject createFromParcel(Parcel in) {
            return new ProfessorObject(in);
        }

        @Override
        public ProfessorObject[] newArray(int size) {
            return new ProfessorObject[size];
        }
    };

    public String getNameprofessor() {
        return nameprofessor;
    }

    public void setNameprofessor(String nameprofessor) {
        this.nameprofessor = nameprofessor;
    }

    public int getImgprofessor() {
        return imgprofessor;
    }

    public void setImgprofessor(int imgclass) {
        this.imgprofessor = imgprofessor;
    }
}
