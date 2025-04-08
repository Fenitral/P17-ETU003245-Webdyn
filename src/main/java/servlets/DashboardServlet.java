package servlets;

import dao.PrevisionDAO;
import dao.DepenseDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DashboardServlet extends HttpServlet {
    private PrevisionDAO previsionDAO = new PrevisionDAO();
    private DepenseDAO depenseDAO = new DepenseDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            List<models.Prevision> previsions = previsionDAO.getAllPrevisions();
            List<models.Depense> depenses = depenseDAO.getAllDepenses();
            request.setAttribute("previsions", previsions);
            request.setAttribute("depenses", depenses);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}