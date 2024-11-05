package com.example.listview_entreno;

public class Coches {

    private String marca;
    private String modelo;
    private int imagen;

    public Coches(String marca, String modelo, int imagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.imagen = imagen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
