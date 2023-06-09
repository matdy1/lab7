<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lab7.models.beans.Jugador" %>
<jsp:useBean id="lista" scope="request" type="java.util.ArrayList<com.example.lab7.models.beans.Jugador>"/>
<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Bienvenido"/>
</jsp:include>
<body>
<div class='container'>
  <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="jugadores"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
    <div class="col-lg-10">
      <h1 class='text-light'>Jugadores</h1>
    </div>
    <div class="col-lg-2">
      <a class="btn btn-success" href="<%=request.getContextPath()%>/CrearJugadorServlet">Crear Jugadores Nuevos</a>
    </div>
  </div>
  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <tr>
        <th>idJugador</th>
        <th>NOMBRE</th>
        <th>EDAD</th>
        <th>POSICION</th>
        <th>CLUB</th>
        <th>SELECCION</th>
      </tr>
      </thead>

      <tbody>
      <% for (Jugador j : lista) { %>
      <tr>
        <td><%=j.getIdjugador()%>
        </td>
        <td><%=j.getNombre_jugador()%>
        </td>
        <td><%=j.getEdad()%>
        </td>
        <td><%=j.getPosicion()%>
        </td>
        <td><%=j.getClub()%>
        </td>
        <td><%=j.getSeleccion().getNombre()%>
        </td>
      </tr>
      <% } %>
      </tbody>
    </table>
  </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
