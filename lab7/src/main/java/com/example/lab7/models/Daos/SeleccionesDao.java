package com.example.lab7.models.Daos;

import com.example.lab7.models.beans.Jugador;
import com.example.lab7.models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionesDao extends DaosBase{

    public ArrayList<Seleccion> listarSelecciones() {

        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();

        String sql = "SELECT * FROM seleccion";


        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));
                seleccion.setIdEstadio(rs.getInt(4));
                listaSelecciones.add(seleccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaSelecciones;
    }

}
