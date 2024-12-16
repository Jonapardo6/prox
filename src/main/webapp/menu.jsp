<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html>
<head>
    <title>Menú del Restaurante</title>
</head>
<body>
<%-- Verifica si el usuario está autenticado --%>
<%
    String usuario = (String) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>


<h2>Bienvenido, ${usuario}</h2>

<div id="menu">
    <%-- Asegúrate de que la lista de productos esté disponible --%>
    <c:if test="${not empty productos}">
        <c:forEach var="producto" items="${productos}">
            <div class="producto">
                <img src="${producto.imagenUrl}" alt="${producto.nombre}" width="150" height="150">
                <h3>${producto.nombre}</h3>
                <p>${producto.descripcion}</p>
                <p>$${producto.precio}</p>
                <form action="agregarAlCarrito" method="POST">
                    <input type="hidden" name="productoId" value="${producto.id}">
                    <input type="number" name="cantidad" value="1" min="1">
                    <button type="submit">Agregar al carrito</button>
                </form>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${empty productos}">
        <p>No hay productos disponibles en el menú.</p>
    </c:if>
        <c:if test="${param.error != null}">
            <div style="color: red;">${param.error}</div>
        </c:if>
        <c:if test="${param.mensaje != null}">
            <div style="color: green;">${param.mensaje}</div>
        </c:if>

        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }

            #menu {
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
            }

            .producto {
                border: 1px solid #ccc;
                padding: 10px;
                text-align: center;
                width: 200px;
            }

            .producto img {
                max-width: 100%;
                height: auto;
                margin-bottom: 10px;
            }

            .producto h3 {
                font-size: 18px;
                margin: 5px 0;
            }

            .producto p {
                margin: 5px 0;
            }

            form {
                margin-top: 10px;
            }

            button {
                background-color: #4CAF50;
                color: white;
                border: none;
                padding: 10px;
                cursor: pointer;
            }

            button:hover {
                background-color: #45a049;
            }
        </style>

</div>

<a href="logout">Cerrar sesión</a>

</body>
</html>
