package com.example.loginregisterapp.pojos;

public class DescripcionCita extends Cita{
    String foto;
    String descripcion;

    public DescripcionCita(String foto, String descripcion) {
        super();
        this.foto = foto;
        this.descripcion = descripcion;
    }

    public DescripcionCita() {

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
}
