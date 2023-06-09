package com.example.lab7.models.beans;

public class Seleccion {

    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private int idEstadio;
    private Estadio estadio;

    private String primer_partido;


    public String getPrimer_partido() {
        return primer_partido;
    }

    public void setPrimer_partido(String primer_partido) {
        this.primer_partido = primer_partido;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }
}
