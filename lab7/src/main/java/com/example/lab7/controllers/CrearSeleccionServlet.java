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

@WebServlet(name = "CrearSeleccionServlet", value = "/CrearSeleccionServlet")
public class    CrearSeleccionServlet extends HttpServlet {
    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EstadioDaos estadioDaos = new EstadioDaos();
        request.setAttribute("listaEstadios",estadioDaos.listarEstadios());
        request.getRequestDispatcher("nuevaSeleccion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SeleccionesDao seleccionesDao =new SeleccionesDao();

        Seleccion seleccion = parseSeleccion(request);


        boolean flag1 = false;
        for (Seleccion seleccion1: seleccionesDao.listarSelecciones()){
            if ((seleccion.getNombre().equalsIgnoreCase(seleccion1.getNombre()))){
                flag1 = true;
            }
        }
        if (!flag1){
            seleccionesDao.guardar(seleccion);

            response.sendRedirect(request.getContextPath() + "/SeleccionServlet");
        }else{
            response.sendRedirect(request.getContextPath() + "/CrearSeleccionServlet");
        }


    }

    public Seleccion parseSeleccion(HttpServletRequest request) {

        Seleccion seleccion = new Seleccion();
        String nombre = request.getParameter("nombre");
        String tecnico = request.getParameter("tecnico");
        String estadioStr = request.getParameter("estadios");


        try {

            int estadios = Integer.parseInt(estadioStr);
            seleccion.setNombre(nombre);
            seleccion.setTecnico(tecnico);
            seleccion.setIdEstadio(estadios);

            return seleccion;

        } catch (NumberFormatException e) {
        }
        return seleccion;
    }
}
