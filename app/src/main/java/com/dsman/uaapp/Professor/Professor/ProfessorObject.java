package com.dsman.uaapp.Professor.Professor;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "ProfessorData")
public class ProfessorObject implements Parcelable {

    @PrimaryKey
    @NonNull
    private int id;

    @ColumnInfo (name = "nameprofessor")
    private String nameprofessor;
    @ColumnInfo (name = "imgprofessor")
    private int imgprofessor;
    @ColumnInfo (name = "surnameprofessor")
    private String surnameprofessor;
    @ColumnInfo (name = "textdescprofessor")
    private String textDescProfessor;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getTextDescProfessor() {
        return textDescProfessor;
    }

    public void setTextDescProfessor(String textDescProfessor) {
        this.textDescProfessor = textDescProfessor;
    }

    public String getSurnameprofessor() {
        return surnameprofessor;
    }

    public void setSurnameprofessor(String surnameprofessor) {
        this.surnameprofessor = surnameprofessor;
    }

    public ProfessorObject() {
    }

    public ProfessorObject(String nameprofessor, int imgprofessor, String surnameprofessor, String textDescProfessor) {
        this.nameprofessor = nameprofessor;
        this.imgprofessor = imgprofessor;
        this.surnameprofessor = surnameprofessor;
        this.textDescProfessor = textDescProfessor;
    }

    public ProfessorObject(Parcel in) {
        nameprofessor = in.readString();
        imgprofessor = in.readInt();
        surnameprofessor = in.readString();
        textDescProfessor = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameprofessor);
        dest.writeInt(imgprofessor);
        dest.writeString(surnameprofessor);
        dest.writeString(textDescProfessor);
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
