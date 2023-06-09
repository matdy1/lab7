package com.example.lab7.models.Daos;

import com.example.lab7.models.beans.Jugador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JugadoresDaos extends DaosBase{

    public ArrayList<Jugador> listarJugadores() {

        ArrayList<Jugador> listaEmpleados = new ArrayList<>();

        String sql = "SELECT * FROM jugador j\n" +
                "inner join seleccion s on j.sn_idSeleccion=s.idSeleccion";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setIdjugador(rs.getInt(1));
                jugador.setNombre_jugador(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));
                jugador.setNombre_seleccion(rs.getString(8));
                listaEmpleados.add(jugador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaEmpleados;
    }


}
