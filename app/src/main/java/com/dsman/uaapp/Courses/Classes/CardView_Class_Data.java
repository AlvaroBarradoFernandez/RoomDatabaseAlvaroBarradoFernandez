package com.dsman.uaapp.Courses.Classes;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class CardView_Class_Data implements Parcelable{
    private Drawable fotos_course ;
    private String nombres_course;
    private static ClassObject data;

    public CardView_Class_Data(Drawable fotos, String nombres) {
        this.fotos_course = fotos;
        this.nombres_course = nombres;
    }

    public CardView_Class_Data() {

    }

    public CardView_Class_Data(ClassObject data) {
        this.data = data;
    }

    protected CardView_Class_Data(Parcel in) {
        nombres_course = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombres_course);
    }

    public static final Creator<CardView_Class_Data> CREATOR = new Creator<CardView_Class_Data>() {
        @Override
        public CardView_Class_Data createFromParcel(Parcel in) {
            return new CardView_Class_Data(in);
        }

        @Override
        public CardView_Class_Data[] newArray(int size) {
            return new CardView_Class_Data[size];
        }
    };

    public void setFotos_subject(Drawable fotos) {
        this.fotos_course = fotos;
    }

    public void setNombres_subject(String nombres) {
        this.nombres_course = nombres;
    }

    public Drawable getFotos_subject() {
        return fotos_course;
    }

    public String getNombres_subject() {
        return nombres_course;
    }

    public ClassObject getData() {
        return data;
    }

    public void setData(ClassObject data) {
        this.data = data;
    }

    public int describeContents() {
        return 0;
    }
}
