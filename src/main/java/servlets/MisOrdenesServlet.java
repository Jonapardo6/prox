package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Orden;
import utils.ConexionDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/misOrdenes")
public class MisOrdenesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Orden> ordenes = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection()) {
            String sql = "SELECT * FROM ordenes WHERE cliente_nombre = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Usuario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Orden orden = new Orden(
                        rs.getInt("id"),
                        rs.getString("cliente_nombre"),
                        rs.getDouble("total"),
                        rs.getTimestamp("fecha")
                );
                ordenes.add(orden);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("ordenes", ordenes);
        request.getRequestDispatcher("/misOrdenes.jsp").forward(request, response);
    }
}

