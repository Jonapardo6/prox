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
import java.sql.*;
import java.util.List;

@WebServlet("/ConfirmarOrdenServlet")
public class ConfirmarOrdenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito != null && !carrito.isEmpty()) {
            double total = 0;
            for (Producto producto : carrito) {
                total += producto.getPrecio();
            }

            try (Connection conn = ConexionDB.getConnection()) {
                String sql = "INSERT INTO ordenes (cliente_nombre, total) VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, "Usuario"); // Esto se puede cambiar por el nombre del cliente si tienes un sistema de autenticación
                ps.setDouble(2, total);
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int ordenId = rs.getInt(1);

                    for (Producto producto : carrito) {
                        String detalleSql = "INSERT INTO detalles_orden (orden_id, producto_id, cantidad) VALUES (?, ?, ?)";
                        PreparedStatement psDetalle = conn.prepareStatement(detalleSql);
                        psDetalle.setInt(1, ordenId);
                        psDetalle.setInt(2, producto.getId());
                        psDetalle.setInt(3, 1); // Se puede modificar para que el usuario elija cantidades
                        psDetalle.executeUpdate();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            session.removeAttribute("carrito");
            response.sendRedirect("ordenConfirmada.jsp");
        }
    }
}
