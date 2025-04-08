package servlets;

import dao.LoginDAO;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private LoginDAO loginDAO = new LoginDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String mdp = request.getParameter("mdp");

        try {
            if (loginDAO.verifierLogin(nom, mdp)) {
                // Connexion réussie, redirection vers ajoutPrevision.jsp
                response.sendRedirect("ajoutPrevision.jsp");
            } else {
                // Échec de la connexion, retour à index.html avec un message d'erreur
                request.setAttribute("erreur", "Nom ou mot de passe incorrect");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("erreur", "Erreur de connexion à la base de données");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}