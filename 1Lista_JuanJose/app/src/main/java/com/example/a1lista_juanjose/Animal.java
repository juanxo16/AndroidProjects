package com.example.a1lista_juanjose;

/*
Autor:Juan José Hernández Montoya
Clase animal que contiene los atributos, constructor y metodos getter y setters
 */

public class Animal {

    private String nombre;
    private int imagen;

    public Animal(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
