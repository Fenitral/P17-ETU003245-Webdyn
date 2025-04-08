package dao;

import models.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private Connexion connexion = new Connexion();

    public boolean verifierLogin(String nom, String mdp) throws SQLException {
        String sql = "SELECT COUNT(*) FROM login WHERE nom = ? AND mdp = ?";
        try (Connection conn = connexion.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, mdp);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Retourne true si un utilisateur est trouvé
                }
            }
        }
        return false;
    }
}