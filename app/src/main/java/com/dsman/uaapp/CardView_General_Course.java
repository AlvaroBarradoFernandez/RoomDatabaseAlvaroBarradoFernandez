package com.dsman.uaapp;

import android.graphics.drawable.Drawable;

public class CardView_General_Course {
    private Drawable fotos ;
    private String nombres;

    public CardView_General_Course(Drawable fotos, String nombres) {
        this.fotos = fotos;
        this.nombres = nombres;
    }

    public void setFotos(Drawable fotos) {
        this.fotos = fotos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Drawable getFotos() {
        return fotos;
    }

    public String getNombres() {
        return nombres;
    }
}
