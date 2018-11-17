package com.dsman.uaapp.Courses.Classes;

import android.graphics.drawable.Drawable;

public class CardView_Class_Data {
    private Drawable fotos_course ;
    private String nombres_course;

    public CardView_Class_Data(Drawable fotos, String nombres) {
        this.fotos_course = fotos;
        this.nombres_course = nombres;
    }

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
}
