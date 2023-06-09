package com.example.lab7.controllers;

import com.example.lab7.models.Daos.JugadoresDaos;
import com.example.lab7.models.Daos.SeleccionesDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import com.example.lab7.models.Daos.SeleccionesDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistroSeleccionServlet", value = "/RegistroSeleccionServlet")
public class RegistroSeleccionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        SeleccionesDao seleccionesDao = new SeleccionesDao();
        request.setAttribute("lista",seleccionesDao.listarSelecciones_agrupadas());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarRegistroSelecciones.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}