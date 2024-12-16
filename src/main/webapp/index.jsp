<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurante Web</title>
    <!-- Incluir Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Bienvenido al Restaurante</h1>

    <!-- Botón para cerrar sesión -->
    <a href="LogoutServlet" class="btn btn-danger mb-3">Cerrar sesión</a>

    <!-- Mostrar los productos disponibles -->
    <h2>Menú de Productos</h2>
    <div class="row">
        <c:forEach var="producto" items="${productos}">
            <div class="col-md-3">
                <div class="card">
                    <img src="${producto.imagen}" class="card-img-top" alt="${producto.nombre}">
                    <div class="card-body">
                        <h5 class="card-title">${producto.nombre}</h5>
                        <p class="card-text">Precio: $${producto.precio}</p>
                        <form action="AgregarAlCarritoServlet" method="post">
                            <input type="hidden" name="productoId" value="${producto.id}">
                            <button type="submit" class="btn btn-primary">Añadir al carrito</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <!-- Mostrar el carrito de compras -->
    <h2 class="mt-5">Tu Carrito</h2>
    <c:if test="${not empty carrito}">
        <table class="table">
            <thead>
            <tr>
                <th>Producto</th>
                <th>Precio</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${carrito}">
                <tr>
                    <td>${item.nombre}</td>
                    <td>${item.precio}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="finalizarCompra.jsp" class="btn btn-success">Finalizar compra</a>
    </c:if>

    <c:if test="${empty carrito}">
        <p>No hay productos en el carrito.</p>
    </c:if>
</div>

<!-- Scripts de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
