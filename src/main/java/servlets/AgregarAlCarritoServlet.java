package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelos.Producto;
import utils.ConexionDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AgregarAlCarritoServlet")
public class AgregarAlCarritoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productoId = Integer.parseInt(request.getParameter("productoId"));

            // Buscar producto en la base de datos
            Producto producto = obtenerProductoPorId(productoId);

            if (producto == null) {
                // Si no se encuentra el producto, redirige con mensaje de error
                response.sendRedirect("menu.jsp?error=Producto no encontrado");
                return;
            }

            // Obtener el carrito de la sesión
            HttpSession session = request.getSession();
            List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

            if (carrito == null) {
                carrito = new ArrayList<>();
            }

            carrito.add(producto);
            session.setAttribute("carrito", carrito);

            response.sendRedirect("menu.jsp?mensaje=Producto agregado al carrito");
        } catch (NumberFormatException e) {
            // Maneja errores en caso de que el ID no sea un número
            response.sendRedirect("menu.jsp?error=ID de producto inválido");
        }
    }

    private Producto obtenerProductoPorId(int id) {
        Producto producto = null;
        try (Connection conn = ConexionDB.getConnection()) {
            String sql = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getString("imagen")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }
}
