package com.example.loginregisterapp.pojos;

public class DescripcionCita extends Cita{
    int foto;
    String descripcion;

    public DescripcionCita(int foto, String descripcion) {
        super();
        this.foto = foto;
        this.descripcion = descripcion;
    }

    public DescripcionCita() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
