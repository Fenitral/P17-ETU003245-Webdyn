package servlets;

import dao.PrevisionDAO;
import dao.DepenseDAO;
import models.Prevision;
import models.Depense;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DepenseServlet extends HttpServlet {
    private PrevisionDAO previsionDAO = new PrevisionDAO();
    private DepenseDAO depenseDAO = new DepenseDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    try {
        List<Prevision> previsions = previsionDAO.getAllPrevisions();
        System.out.println("Nombre de prévisions : " + previsions.size()); // Debug
        request.setAttribute("previsions", previsions);
        request.getRequestDispatcher("ajoutDepense.jsp").forward(request, response);
    } catch (SQLException e) {
        e.printStackTrace();
        request.setAttribute("erreur", "Erreur de base de données : " + e.getMessage());
        request.getRequestDispatcher("ajoutDepense.jsp").forward(request, response);
    }
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int idPrevision = Integer.parseInt(request.getParameter("idPrevision"));
        int montant = Integer.parseInt(request.getParameter("montant"));

        try {
            Prevision prevision = previsionDAO.getPrevisionById(idPrevision);
            int sommeDepenses = depenseDAO.getSommeDepensesByPrevision(idPrevision);

            if (sommeDepenses + montant > prevision.getMontant()) {
                request.setAttribute("erreur", "Le montant dépasse le budget prévu !");
                request.setAttribute("previsions", previsionDAO.getAllPrevisions());
                request.getRequestDispatcher("ajoutDepense.jsp").forward(request, response);
            } else {
                Depense depense = new Depense(montant, idPrevision);
                depenseDAO.addDepense(depense);
                response.sendRedirect("DashboardServlet");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("erreur", "Erreur lors de l'ajout de la dépense");
            request.getRequestDispatcher("ajoutDepense.jsp").forward(request, response);
        }
    }
}