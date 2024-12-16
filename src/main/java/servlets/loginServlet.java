package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



    @WebServlet("/login")
    public class loginServlet extends HttpServlet {
        private static final String ADMIN_USER = "admin";
        private static final String ADMIN_PASS = "2005";

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (ADMIN_USER.equals(username) && ADMIN_PASS.equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", username); // Cambiado para que coincida con el JSP
                response.sendRedirect("menu.jsp"); // Redirige al menú
            } else {
                response.sendRedirect("error.jsp"); // Redirige a una página de error si las credenciales no coinciden
            }
        }
    }
