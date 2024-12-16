package servlets;


import java.io.*;
import dao.OrdenDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RealizarPedidoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int usuarioId = (int) session.getAttribute("usuarioId");

        OrdenDAO ordenDAO = new OrdenDAO();
        ordenDAO.crearOrden(usuarioId);

        // Vaciar el carrito (opcional)
        response.sendRedirect("menu.jsp");
    }
}
