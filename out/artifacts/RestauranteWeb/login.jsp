<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <!-- Enlace a la hoja de estilos de Bootstrap (CDN) -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Contenedor principal de la página -->
<div class="container mt-5">
  <h2 class="text-center">Iniciar Sesión</h2>


  <!-- Formulario de login -->
  <form action="login" method="post">
    <div class="mb-3">
      <label for="username" class="form-label">Usuario</label>
      <input type="text" class="form-control" id="username" name="username" required>
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">Contraseña</label>
      <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <button type="submit" class="btn btn-primary w-100">Ingresar</button>

  </form>

  <!-- Mensajes de error (se mostrará solo si hay error) -->
  <div id="errorMessage" class="alert alert-danger mt-3 d-none" role="alert">
    Usuario o contraseña incorrectos.
  </div>
</div>

<!-- Scripts de Bootstrap (Opcional) -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
