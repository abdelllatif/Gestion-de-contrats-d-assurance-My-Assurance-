package DAOs;

import Config.DbConnextion;
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

    public ResultSet afficherAll() throws SQLException {
        String sql = "SELECT * FROM Contrat";
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    // Optional: method to convert ResultSet row to Contrat object
    public Contrat mapToContrat(ResultSet rs) throws SQLException {
        Contrat contrat = new Contrat();
        contrat.setId(rs.getInt("id"));
        contrat.setDateDebut(rs.getTimestamp("dateDebut"));
        contrat.setDateFin(rs.getTimestamp("dateFin"));
        // convert String from DB back to enum
        contrat.setTypeContrat(Contrat.TypeContrat.valueOf(rs.getString("typeContrat")));
        contrat.setClientId(rs.getInt("client_id"));
        if (rs.wasNull()) contrat.setClientId(null);
        return contrat;
    }
}
