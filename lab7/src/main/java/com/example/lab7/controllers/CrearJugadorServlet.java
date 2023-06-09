package com.example.lab7.controllers;

import java.io.*;
import java.math.BigDecimal;

import com.example.lab7.models.Daos.JugadoresDaos;
import com.example.lab7.models.Daos.SeleccionesDao;
import com.example.lab7.models.beans.Jugador;
import com.example.lab7.models.beans.Seleccion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CrearJugadorServlet", value = "/CrearJugadorServlet")
public class CrearJugadorServlet extends HttpServlet {
    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SeleccionesDao seleccionesDao = new SeleccionesDao();
        request.setAttribute("listaSelecciones",seleccionesDao.listarSelecciones());
        request.getRequestDispatcher("nuevoJugador.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JugadoresDaos jugadoresDaos =new JugadoresDaos();

        Jugador jugador = parseJob(request);
        jugadoresDaos.guardar(jugador);

        response.sendRedirect(request.getContextPath() + "/JugadorServlet");
    }

    public Jugador parseJob(HttpServletRequest request) {

        Jugador jugador = new Jugador();
        String nombre = request.getParameter("nombre");
        String edadStr = request.getParameter("edad");
        String posicion = request.getParameter("posicion");
        String club = request.getParameter("club");
        String seleccionStr = request.getParameter("selecciones");

        try {
            int edad = Integer.parseInt(edadStr);
            int seleccion = Integer.parseInt(seleccionStr);

            jugador.setNombre_jugador(nombre);
            jugador.setEdad(edad);
            jugador.setPosicion(posicion);
            jugador.setClub(club);
            jugador.setIdSeleccion(seleccion);

            return jugador;

        } catch (NumberFormatException e) {
            String errorMessage = "Ingrese una edad válida";
            request.setAttribute("errorMessage", errorMessage);
            return null;
        }
    }
}