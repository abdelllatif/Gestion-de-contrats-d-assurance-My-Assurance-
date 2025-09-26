package DAOs;

import Config.DbConnextion;
import Models.Sinistre;

import java.sql.*;

public class SinistreDAO {

    private final Connection connection;

    public SinistreDAO() {
        this.connection = new DbConnextion().getConnection();
    }

    public boolean addSinistre(Sinistre sinistre) throws SQLException {
        String sql = "INSERT INTO Sinistre (typeSinistre, dateTime, cout, description, contratId) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
}
