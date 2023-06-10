<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lab7.models.beans.Seleccion" %>
<%@ page import="com.example.lab7.models.beans.Estadio" %>
<jsp:useBean id="lista" scope="request" type="java.util.ArrayList<com.example.lab7.models.beans.Seleccion>"/>
<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Selecciones"/>
</jsp:include>
<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="selecciones"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <h1 class='text-light'>Selecciones registradas</h1>
        </div>
        <div class="col-lg-3">
            <a class="btn btn-info" href="<%=request.getContextPath()%>/SeleccionServlet">Ver selecciones con partidos</a>
        </div>

        <div class="col-lg-2">
            <a class="btn btn-success" href="<%=request.getContextPath()%>/CrearSeleccionServlet">Crear Seleccion Nueva</a>
        </div>

    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>idSeleccion</th>
                <th>NOMBRE</th>
                <th>TECNICO</th>
                <th>ESTADIO</th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <% for (Seleccion s : lista) { %>
            <tr>
                <td><%=s.getIdSeleccion()%>
                </td>
                <td><%=s.getNombre()%>
                </td>
                <td><%=s.getTecnico()%>
                </td>
                <td><%=s.getEstadio().getNombre()%>
                </td>
                <td><a onclick="return confirm('Estas seguro de borrar :( ?')" class="btn btn-danger"
                       href="<%=request.getContextPath()%>/BorrarSeleccionServlet?id=<%=s.getIdSeleccion()%>">Borrar</a>
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

