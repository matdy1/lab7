package com.example.lab7.controllers;

import java.io.*;

import com.example.lab7.models.Daos.JugadoresDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "JugadorServlet", value = "/JugadorServlet")
public class JugadorServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        JugadoresDaos jugadoresDaos = new JugadoresDaos();
        request.setAttribute("lista",jugadoresDaos.listarJugadores());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarJugador.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}