<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Bienvenido"/>
</jsp:include>
<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value=""/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <h1 class='text-light'>Bienvenido, al Registro para el Mundial 2026:</h1>
        </div>
    </div>
    <div >
        <img src="img/mundial2026.jpg" width="1140px" height="400px"/>
    </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
