package dao;

import models.Connexion;
import models.Depense;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepenseDAO {
    private Connexion connexion = new Connexion();

    public void addDepense(Depense depense) throws SQLException {
        String sql = "INSERT INTO depense (montant, idPrevision) VALUES (?, ?)";
        try (Connection conn = connexion.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, depense.getMontant());
            stmt.setInt(2, depense.getIdPrevision());
            stmt.executeUpdate();
        }
    }

    public List<Depense> getAllDepenses() throws SQLException {
        List<Depense> depenses = new ArrayList<>();
        String sql = "SELECT * FROM depense";
        try (Connection conn = connexion.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                depenses.add(new Depense(rs.getInt("idDepense"), 
                                       rs.getInt("montant"), 
                                       rs.getInt("idPrevision")));
            }
        }
        return depenses;
    }

    public int getSommeDepensesByPrevision(int idPrevision) throws SQLException {
        String sql = "SELECT SUM(montant) as total FROM depense WHERE idPrevision = ?";
        try (Connection conn = connexion.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPrevision);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        }
        return 0;
    }
}
