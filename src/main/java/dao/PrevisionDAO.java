package dao;

import models.Connexion;
import models.Prevision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PrevisionDAO {
    private Connexion connexion = new Connexion();

    public void addPrevision(Prevision prevision) throws SQLException {
        String sql = "INSERT INTO prevision (libelle, montant) VALUES (?, ?)";
        try (Connection conn = connexion.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prevision.getNom());
            stmt.setInt(2, prevision.getMontant());
            stmt.executeUpdate();
        }
    }

    public List<Prevision> getAllPrevisions() throws SQLException {
        List<Prevision> previsions = new ArrayList<>();
        String sql = "SELECT * FROM prevision";
        try (Connection conn = connexion.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                previsions.add(new Prevision(rs.getInt("idPrevision"), 
                                           rs.getString("libelle"), 
                                           rs.getInt("montant")));
            }
        }
        return previsions;
    }

    public Prevision getPrevisionById(int id) throws SQLException {
        String sql = "SELECT * FROM prevision WHERE idPrevision = ?";
        try (Connection conn = connexion.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Prevision(rs.getInt("idPrevision"), 
                                       rs.getString("libelle"), 
                                       rs.getInt("montant"));
                }
            }
        }
        return null;
    }
}