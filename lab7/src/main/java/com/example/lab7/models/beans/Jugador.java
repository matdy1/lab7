package com.example.lab7.models.beans;

public class Jugador {

    private int idjugador;
    private String nombre_jugador;
    private int edad;
    private String posicion;
    private String club;
    private int idSeleccion;
    private String nombre_seleccion;


    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public int getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(int idjugador) {
        this.idjugador = idjugador;
    }

    public String getNombre_jugador() {
        return nombre_jugador;
    }

    public void setNombre_jugador(String nombre_jugador) {
        this.nombre_jugador = nombre_jugador;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getNombre_seleccion() {
        return nombre_seleccion;
    }

    public void setNombre_seleccion(String nombre_seleccion) {
        this.nombre_seleccion = nombre_seleccion;
    }
}
