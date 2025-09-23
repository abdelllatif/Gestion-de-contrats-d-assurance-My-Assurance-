package DAOs;

import Config.DbConnextion;
import Models.Conseiller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class ConseillerDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String drivers = "com.mysql.cj.jdbc.Driver";
    public ConseillerDAO() {
        this.connection = new DbConnextion().getConnection();
    }

    public boolean addConseiller(Conseiller conseiller) {
        String sql = "INSERT INTO conseiller (nom, prenom, email, telephone) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, conseiller.getNom());
            preparedStatement.setString(2, conseiller.getPrenom());
            preparedStatement.setString(3, conseiller.getEmail());
            preparedStatement.setString(4, conseiller.getTelephone());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("erreur lors de l'ajout du conseiller car" + e.getMessage());
        }
    }
    public ResultSet getClients() {
        String sql = "SELECT * FROM client";
        try {
            preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des clients : " + e.getMessage());
        }
    }

}
