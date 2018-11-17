package com.dsman.uaapp.Professor.Professor;

import android.graphics.drawable.Drawable;

public class CardView_Professor_Data {
    private Drawable fotos_subject ;
    private String nombres_subject;

    public CardView_Professor_Data(Drawable fotos, String nombres) {
        this.fotos_subject = fotos;
        this.nombres_subject = nombres;
    }

    public void setFotos_subject(Drawable fotos) {
        this.fotos_subject = fotos;
    }

    public void setNombres_subject(String nombres) {
        this.nombres_subject = nombres;
    }

    public Drawable getFotos_subject() {
        return fotos_subject;
    }

    public String getNombres_subject() {
        return nombres_subject;
    }
}
