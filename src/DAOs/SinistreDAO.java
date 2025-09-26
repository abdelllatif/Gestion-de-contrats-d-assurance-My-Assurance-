package DAOs;

import Config.DbConnextion;
import Models.Sinistre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinistreDAO {

    private final Connection connection;

    public SinistreDAO() {
        this.connection = new DbConnextion().getConnection();
    }

    public boolean addSinistre(Sinistre sinistre) throws SQLException {
        String sql = "INSERT INTO Sinistre (typeSinistre, dateTime, cout, description, contrat_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, sinistre.getTypeSinistre().name());
            ps.setTimestamp(2, sinistre.getDateTime());
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


    public List<Sinistre> getAllSinistres() {
        List<Sinistre> sinistres = new ArrayList<>();
        String sql = "SELECT * FROM Sinistre";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Sinistre s = new Sinistre();
                s.setId(rs.getInt("id"));
                s.setTypeSinistre(Sinistre.TypeSinistre.valueOf(rs.getString("typeSinistre")));
                s.setDateTime(rs.getTimestamp("dateTime"));
                s.setCout(rs.getDouble("cout"));
                s.setDescription(rs.getString("description"));
                s.setContratId(rs.getInt("contrat_id"));
                sinistres.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sinistres;
    }

    public Sinistre findById(int id) throws SQLException {
        String sql = "SELECT * FROM Sinistre WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Sinistre(
                        Sinistre.TypeSinistre.valueOf(rs.getString("typeSinistre")),
                        rs.getTimestamp("dateTime"),
                        rs.getDouble("cout"),
                        rs.getString("description"),
                        rs.getInt("contrat_id")
                );
            }
        }
        return null;
    }
    public ResultSet findAllSinistres() throws SQLException {
        String sql = "SELECT * FROM Sinistre";
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }



}
