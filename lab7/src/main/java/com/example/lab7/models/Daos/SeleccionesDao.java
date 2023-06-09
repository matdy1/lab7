package com.example.lab7.models.Daos;

import com.example.lab7.models.beans.Estadio;
import com.example.lab7.models.beans.Jugador;
import com.example.lab7.models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionesDao extends DaosBase{

    public ArrayList<Seleccion> listarSelecciones() {

        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();

        String sql = "select s.idSeleccion, s.nombre, s.tecnico, e.nombre as estadio, concat(sl.nombre, ' vs ', sv.nombre) as partido\n" +
                "from seleccion s, partido p, estadio e, seleccion sl, seleccion sv\n" +
                "where (p.seleccionLocal = s.idSeleccion or p.seleccionVisitante = s.idSeleccion) and p.fecha = (select min(fecha) from partido where seleccionLocal = s.idSeleccion or seleccionVisitante = s.idSeleccion)\n" +
                "and e.idEstadio = s.estadio_idEstadio\n" +
                "and sl.idSeleccion = p.seleccionLocal\n" +
                "and sv.idSeleccion = p.seleccionVisitante;\n";


        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));

                Estadio estadio = new Estadio();
                estadio.setNombre(rs.getString(4));

                seleccion.setEstadio(estadio);

                seleccion.setPrimer_partido(rs.getString(5));
                listaSelecciones.add(seleccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaSelecciones;
    }

    public void guardar(Seleccion seleccion) {

        String sql = "INSERT INTO seleccion (nombre,tecnico,estadio_idEstadio) VALUES (?,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, seleccion.getNombre());
            pstmt.setString(2, seleccion.getTecnico());
            pstmt.setInt(3, seleccion.getIdEstadio());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
