<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Productos</title>
  <!-- Incluir Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h1>Productos disponibles</h1>
  <div class="row">
    <div class="col-md-4">
      <div class="card">
        <img src="producto1.jpg" class="card-img-top" alt="Producto 1">
        <div class="card-body">
          <h5 class="card-title">Producto 1</h5>
          <p class="card-text">Descripción del producto 1.</p>
          <form action="agregarAlCarrito" method="post">
            <input type="hidden" name="producto" value="Producto 1">
            <input type="hidden" name="precio" value="10.00">
            <button type="submit" class="btn btn-primary">Agregar al carrito</button>
          </form>
        </div>
      </div>
    </div>
    <!-- Puedes agregar más productos aquí de manera similar -->
  </div>
  <a href="verCarrito.jsp" class="btn btn-success mt-3">Ver carrito</a>
</div>
</body>
</html>
