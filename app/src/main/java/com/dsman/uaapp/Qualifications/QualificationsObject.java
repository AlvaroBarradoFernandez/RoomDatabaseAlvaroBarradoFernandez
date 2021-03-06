package com.dsman.uaapp.Qualifications;

import android.os.Parcel;
import android.os.Parcelable;

public class QualificationsObject implements Parcelable {
    private String date;
    private String classes;
    private String notes;
    private String exercise;

    public QualificationsObject(String date, String classes, String notes, String exercise) {
        this.date = date;
        this.classes = classes;
        this.notes = notes;
        this.exercise = exercise;
    }

    protected QualificationsObject(Parcel in) {
        date = in.readString();
        classes = in.readString();
        notes = in.readString();
        exercise = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(classes);
        dest.writeString(notes);
        dest.writeString(exercise);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }
}
