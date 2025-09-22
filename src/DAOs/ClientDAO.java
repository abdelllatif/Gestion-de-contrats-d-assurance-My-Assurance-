package DAOs;

import Config.DbConnextion;
import Models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public ClientDAO() {
        this.connection = new DbConnextion().getConnection();
    }


    public boolean addClient(Client client) {
        String sql = "INSERT INTO client (nom, prenom, email, telephone, conseiller_id) VALUES (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getTelephone());
            preparedStatement.setInt(5, client.getConseiller());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("couldn't add client because " + e.getMessage(), e);
        }

    }

}
