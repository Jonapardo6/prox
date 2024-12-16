<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Finalizar compra</title>
  <!-- Incluir Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h1>Revisión de tu compra</h1>

  <c:if test="${not empty carrito}">
    <table class="table">
      <thead>
      <tr>
        <th>Producto</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="item" items="${carrito}">
        <tr>
          <td>${item}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <form action="finalizarCompra" method="post">
      <button type="submit" class="btn btn-success">Confirmar compra</button>
    </form>
  </c:if>

  <c:if test="${empty carrito}">
    <p>No hay productos en el carrito.</p>
    <a href="productos.jsp" class="btn btn-primary">Volver a productos</a>
  </c:if>
</div>
</body>
</html>
