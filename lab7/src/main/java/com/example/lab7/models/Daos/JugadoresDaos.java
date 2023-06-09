package com.example.lab7.models.Daos;

import com.example.lab7.models.beans.Jugador;
import com.example.lab7.models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class JugadoresDaos extends DaosBase{

    public ArrayList<Jugador> listarJugadores() {

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

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
                jugador.setIdSeleccion(rs.getInt(6));
                Seleccion seleccion = new Seleccion();
                seleccion.setNombre(rs.getString(8));
                jugador.setSeleccion(seleccion);
                listaJugadores.add(jugador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaJugadores;
    }

    public void guardar(Jugador jugador) {

        String sql = "INSERT INTO jugador (nombre,edad,posicion,club,sn_idSeleccion) VALUES (?,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, jugador.getNombre_jugador());
            pstmt.setInt(2, jugador.getEdad());
            pstmt.setString(3, jugador.getPosicion());
            pstmt.setString(4, jugador.getClub());
            pstmt.setInt(5, jugador.getIdSeleccion());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
