package DAOs;

import Config.DbConnextion;
import Models.Client;
import Models.Contrat;

import java.sql.*;

public class ContractDAO {

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public ContractDAO() {
        this.connection = new DbConnextion().getConnection();
    }

    public Boolean addContrat(Contrat contrat) throws SQLException {
        String sql = "INSERT INTO Contrat (dateDebut, dateFin, typeContrat, client_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, contrat.getDateDebut());
            ps.setTimestamp(2, contrat.getDateFin());
            ps.setString(3, contrat.getTypeContrat().name()); // convert enum to String
            if (contrat.getClientId() != null) {
                ps.setInt(4, contrat.getClientId());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(int id) throws SQLException {
        String sql = "DELETE FROM Contrat WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public ResultSet afficherAll(Integer ClientId) throws SQLException {
        String sql = "SELECT * FROM Contrat where client_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, ClientId);
        return preparedStatement.executeQuery();
    }

    public Contrat findById(int id) {
        String sql = "SELECT * FROM Contrat WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Contrat.TypeContrat type = Contrat.TypeContrat.valueOf(rs.getString("typeContrat"));

                return new Contrat(
                        rs.getInt("id"),
                        rs.getTimestamp("dateDebut"),
                        rs.getTimestamp("dateFin"),
                        type,
                        rs.getInt("client_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
