<%--

  NO TOCAR!


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar sticky-top navbar-expand-lg navbar-dark">
  <a class="navbar-brand" href="#">Clasificatorias Sudamericanas Mundial 2026</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link <%=request.getParameter("page").equals("jugadores")? "active": "" %>" href="<%=request.getContextPath()%>/JugadorServlet">Jugadores</a>
      </li>
      <li class="nav-item">
        <a class="nav-link <%=request.getParameter("page").equals("bandas")? "active": "" %>" href="<%=request.getContextPath()%>/listaBandas">Bandas</a>
      </li>
      <li class="nav-item">
        <a class="nav-link <%=request.getParameter("page").equals("tpc")? "active": "" %>" href="<%=request.getContextPath()%>/listaToursporCiudad">Ciudades y Fechas</a>
      </li>
      <li class="nav-item">
        <a class="nav-link <%=request.getParameter("page").equals("canciones")? "active": "" %>" href="<%=request.getContextPath()%>/listaCanciones">Canciones</a>
      </li>
      <li class="nav-item">
        <a class="nav-link <%=request.getParameter("page").equals("artistas")? "active": "" %>" href="<%=request.getContextPath()%>/listaArtistas">Artistas</a>
      </li>
    </ul>
  </div>
</nav>

