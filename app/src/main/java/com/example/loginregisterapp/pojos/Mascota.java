package com.example.loginregisterapp.pojos;

public class Mascota {
    private int fotoMascota;
    private String nombreMascota;
    private String descripcion;

    public Mascota(int fotoMascota, String nombreMascota, String descripcion) {
        this.fotoMascota = fotoMascota;
        this.nombreMascota = nombreMascota;
        this.descripcion = descripcion;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
