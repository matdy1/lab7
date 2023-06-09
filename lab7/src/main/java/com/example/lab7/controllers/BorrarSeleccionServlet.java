package com.example.lab7.controllers;

import java.awt.font.FontRenderContext;
import java.io.*;
import java.math.BigDecimal;

import com.example.lab7.models.Daos.EstadioDaos;
import com.example.lab7.models.Daos.JugadoresDaos;
import com.example.lab7.models.Daos.SeleccionesDao;
import com.example.lab7.models.beans.Jugador;
import com.example.lab7.models.beans.Seleccion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "BorrarSeleccionServlet", value = "/BorrarSeleccionServlet")
public class BorrarSeleccionServlet extends HttpServlet {
    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SeleccionesDao seleccionesDao = new SeleccionesDao();

        String id = request.getParameter("id"); //le pasare como parametro el id obtenido
        int id2 = Integer.parseInt(id);

        //primero me fijo que no este en la lista de equipos de futbol con partidos
        boolean flag_partidos = false;
        for (Seleccion seleccion_partidos : seleccionesDao.listarSelecciones()){
            if (seleccion_partidos.getIdSeleccion() == id2){
                flag_partidos = true;
            }
        }


        //si esta en la lista de partidos mme devuelve al registro de selecciones
        if (flag_partidos){
            response.sendRedirect(request.getContextPath() + "/RegistroSeleccionServlet");
        }else{

            JugadoresDaos jugadoresDaos = new JugadoresDaos();
            //ahora valido que si hay jugadores en esa sele
            boolean flag_jugador = false;
            for (Jugador jugador_analizado : jugadoresDaos.listarJugadores()){
                if (jugador_analizado.getIdSeleccion() == id2){
                    flag_jugador = true;
                }
            }


            //ahora habran dos opciones dependiendo de que suceda con las flags
            if (flag_jugador){
                jugadoresDaos.borrar_jugador(id);
                seleccionesDao.borrar_seleccion(id);
                response.sendRedirect(request.getContextPath() + "/RegistroSeleccionServlet");
            }else{
                seleccionesDao.borrar_seleccion(id);
                response.sendRedirect(request.getContextPath() + "/RegistroSeleccionServlet");
            }



        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

}
