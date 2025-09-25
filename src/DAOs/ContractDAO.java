package DAOs;

import Models.Contrat;

import java.sql.*;

public class ContractDAO {


    private final Connection connection;
    private PreparedStatement preparedStatement;

    public ContractDAO(Connection connection) {
        this.connection = connection;
    }

    public Boolean addContrat(Contrat contrat) throws SQLException {
        String sql = "INSERT INTO Contrat (dateDebut, dateFin, typeContrat, clientId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(contrat.getDateDebut()));
            ps.setDate(2, Date.valueOf(contrat.getDateFin()));
            ps.setString(3, contrat.getTypeContrat());
            ps.setInt(4, contrat.getClientId());
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


}
