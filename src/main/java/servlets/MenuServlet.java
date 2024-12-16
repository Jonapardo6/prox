package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Producto;
import utils.ConexionDB;

import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> productos = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection()) {
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getString("imagen")
                );
                productos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("/menu.jsp").forward(request, response);

    }
}
