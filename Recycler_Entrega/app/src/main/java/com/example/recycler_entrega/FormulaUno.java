package com.example.recycler_entrega;

public class FormulaUno {

    private int imagen;
    private String escuderia;
    private String pilotos;

    public FormulaUno(int imagen, String escuderia, String pilotos) {
        this.imagen = imagen;
        this.escuderia = escuderia;
        this.pilotos = pilotos;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public String getPilotos() {
        return pilotos;
    }

    public void setPilotos(String pilotos) {
        this.pilotos = pilotos;
    }
}
