package com.dsman.uaapp.Comunities;

import android.graphics.drawable.Drawable;

public class CardView_Comunity_Data {
    private Drawable fotos_comunity ;
    private String nombres_comunity;

    public CardView_Comunity_Data(Drawable fotos, String nombres) {
        this.fotos_comunity = fotos;
        this.nombres_comunity = nombres;
    }

    public void setFotos_subject(Drawable fotos) {
        this.fotos_comunity = fotos;
    }

    public void setNombres_subject(String nombres) {
        this.nombres_comunity = nombres;
    }

    public Drawable getFotos_subject() {
        return fotos_comunity;
    }

    public String getNombres_subject() {
        return nombres_comunity;
    }
}
