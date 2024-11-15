package com.example.buscaminas_menu;

public class Bomba {

    private String  nombre;
    private int img;

    public Bomba(String nombre, int img) {
        this.nombre = nombre;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImg() {
        return img;
    }

}
