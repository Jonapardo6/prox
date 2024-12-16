package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/finalizarCompra")
public class FinalizarCompraServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> carrito = (List<String>) session.getAttribute("carrito");

        if (carrito != null && !carrito.isEmpty()) {
            // Simulamos un proceso de compra
            session.removeAttribute("carrito");
            response.sendRedirect("compraExitosa.jsp");
        } else {
            response.sendRedirect("productos.jsp");
        }
    }
}


