<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lab7.models.beans.Jugador" %>
<%@ page import="com.example.lab7.models.beans.Seleccion" %>
<jsp:useBean id="listaSelecciones" type="java.util.ArrayList<com.example.lab7.models.beans.Seleccion>" scope="request"/>
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
      <h1 class='text-light'>Crear un nuevo Jugador</h1>
    </div>
  </div>
  <div class="container">
    <form method="POST" action="<%=request.getContextPath()%>/CrearJugadorServlet">
      <div class="mb-3">
        <label class='text-light' for="nombre">Nombre</label>
        <input type="text" class="form-control" name="nombre" id="nombre">
      </div>
      <div class="mb-3">
        <label class='text-light' for="edad">Edad</label>
        <input type="text" class="form-control" name="edad" id="edad">
      </div>
      <div class="mb-3">
        <label class='text-light' for="posicion">Posicion</label>
        <input type="text" class="form-control" name="posicion" id="posicion">
      </div>
      <div class="mb-3">
        <label class='text-light' for="club">Club</label>
        <input type="text" class="form-control" name="club" id="club">
      </div>
      <div class="mb-3">
        <label class='text-light' for="selecciones">Selecciones</label>
        <select class="form-select" name="selecciones" id="selecciones">
          <% for (Seleccion s : listaSelecciones) { %>
          <option value="<%=s.getIdSeleccion()%>">
            <%=s.getNombre()%>
          </option>
          <% } %>
        </select>
      </div>
      <a class="btn btn-danger" href="<%=request.getContextPath()%>/JugadorServlet">Cancelar</a>
      <button type="submit" class="btn btn-primary">Guardar Jugador</button>
    </form>
  </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>