package com.example.loginregisterapp.pojos;

import java.util.Date;

public class Cita {
    private String cliente;
    private String fecha;
    private String hora;
    //1:en espera; 2:confirmada 3:cancelada 4:finalizada
    private int status;
    private String codigo;

    public Cita() {
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.status = status;
        this.codigo = codigo;
        this.fincita = fincita;
        this.mascota = mascota;
        this.servicio = servicio;
    }


    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFincita() {
        return fincita;
    }

    public void setFincita(String fincita) {
        this.fincita = fincita;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    private String fincita;

    private String mascota;

    private String servicio;

}
