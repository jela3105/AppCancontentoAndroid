package com.example.loginregisterapp.pojos;

public class Servicio {
    private String nombre;
    String foto;
    String descripcion;

    public Servicio(String nombre, String foto, String descripcion) {
        this.nombre = nombre;
        this.foto = foto;
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
