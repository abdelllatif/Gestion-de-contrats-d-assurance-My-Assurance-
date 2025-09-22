package DAOs;

import Models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    public ClientDAO(Connection connection) {
         this.connection = connection;
    }
    public void addClient(Client client) {
        try{
            String sql = "INSERT INTO client VALUES (?,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
        }
        catch(NullPointerException | SQLException e){
            throw new RuntimeException("couldnt add client because" + e.getMessage());
        }


    }
}
