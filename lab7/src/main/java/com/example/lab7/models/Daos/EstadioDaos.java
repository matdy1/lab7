package com.example.lab7.models.Daos;

import com.example.lab7.models.beans.Estadio;
import com.example.lab7.models.beans.Jugador;
import com.example.lab7.models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class EstadioDaos extends DaosBase {

    public ArrayList<Estadio> listarEstadios() {

        ArrayList<Estadio> listaEstadios = new ArrayList<>();

        String sql = "SELECT * FROM Estadio";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estadio estadio =new Estadio();
                estadio.setIdEstadio(rs.getInt(1));
                estadio.setNombre(rs.getString(2));
                estadio.setProvincia(rs.getString(3));
                estadio.setClub(rs.getString(4));
                listaEstadios.add(estadio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaEstadios;
    }
}