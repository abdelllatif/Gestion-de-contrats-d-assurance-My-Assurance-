package DAOs;

import Models.Sinistre;

import java.sql.*;

public class SinistreDAO {

    private final Connection connection;

    public SinistreDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addSinistre(Sinistre sinistre) throws SQLException {
        String sql = "INSERT INTO Sinistre (typeSinistre, dateTime, cout, description, contratId) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, sinistre.getTypeSinistre().name());
            ps.setDate(2, sinistre.getDateTime());
            ps.setDouble(3, sinistre.getCout());
            ps.setString(4, sinistre.getDescription());
            ps.setInt(5, sinistre.getContratId());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(int id) throws SQLException {
        String sql = "DELETE FROM Sinistre WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // Rechercher un sinistre par ID
    public ResultSet findById(int id) throws SQLException {
        String sql = "SELECT * FROM Sinistre WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeQuery();
    }

    // Afficher tous les sinistres
    public ResultSet afficherAll() throws SQLException {
        String sql = "SELECT * FROM Sinistre";
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }

    // Afficher les sinistres d’un contrat par ID contrat
    public ResultSet findByContratId(int contratId) throws SQLException {
        String sql = "SELECT * FROM Sinistre WHERE contratId = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, contratId);
        return ps.executeQuery();
    }

    // Afficher les sinistres par ID client (via jointure avec Contrat)
    public ResultSet findByClientId(int clientId) throws SQLException {
        String sql = "SELECT s.* FROM Sinistre s " +
                "JOIN Contrat c ON s.contratId = c.id " +
                "WHERE c.clientId = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, clientId);
        return ps.executeQuery();
    }
}
