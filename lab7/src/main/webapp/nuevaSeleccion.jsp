<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lab7.models.beans.Estadio" %>
<%@ page import="com.example.lab7.models.beans.Seleccion" %>
<jsp:useBean id="listaEstadios" type="java.util.ArrayList<com.example.lab7.models.beans.Estadio>" scope="request"/>
<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Nueva Seleccion"/>
</jsp:include>
<body>
<div class='container'>
  <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="selecciones"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
    <div class="col-lg-10">
      <h1 class='text-light'>Crear una nueva Seleccion</h1>
    </div>
  </div>
  <div class="container">
    <form method="POST" action="<%=request.getContextPath()%>/CrearSeleccionServlet">
      <div class="mb-3">
        <label class='text-light' for="nombre">Nombre</label>
        <input type="text" class="form-control" name="nombre" id="nombre">
      </div>
      <div class="mb-3">
        <label class='text-light' for="tecnico">Tecnico</label>
        <input type="text" class="form-control" name="tecnico" id="tecnico">
      </div>
      <div class="mb-3">
        <label class='text-light' for="estadios">Estadios</label>
        <select class="form-select" name="estadios" id="estadios">
          <% for (Estadio e : listaEstadios) { %>
          <option value="<%=e.getIdEstadio()%>">
            <%=e.getNombre()%>
          </option>
          <% } %>
        </select>
      </div>
      <a class="btn btn-danger" href="<%=request.getContextPath()%>/SeleccionServlet">Cancelar</a>
      <button type="submit" class="btn btn-primary">Guardar Seleccion</button>
    </form>
  </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>