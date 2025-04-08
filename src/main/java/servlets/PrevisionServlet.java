package servlets;

import dao.PrevisionDAO;
import models.Prevision;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PrevisionServlet extends HttpServlet {
    private PrevisionDAO previsionDAO = new PrevisionDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String libelle = request.getParameter("libelle");
        int montant = Integer.parseInt(request.getParameter("montant"));

        Prevision prevision = new Prevision(libelle, montant);
        try {
            previsionDAO.addPrevision(prevision);
            response.sendRedirect("DepenseServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("erreur", "Erreur lors de l'ajout de la prévision");
            request.getRequestDispatcher("AjoutPrevision.jsp").forward(request, response);
        }
    }
}