package Services;

import DAOs.ClientDAO;
import DAOs.ConseillerDAO;
import Models.Client;

import java.sql.ResultSet;
import java.util.HashMap;

public class ClientService {


    public ClientService() {
    }


    public Boolean addClient(Client client) {
        try {
            if (client.getNom() == null || client.getNom().trim().isEmpty()) {
                throw new IllegalArgumentException("Nom is required and cannot be empty.");
            }
            if (client.getPrenom() == null || client.getPrenom().trim().isEmpty()) {
                throw new IllegalArgumentException("Prenom is required and cannot be empty.");
            }
            if (client.getEmail() == null || !client.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                throw new IllegalArgumentException("Invalid email format.");
            }
            if (client.getTelephone() == null || !client.getTelephone().matches("\\d+")) {
                throw new IllegalArgumentException("Telephone must be a number.");
            }
            if (client.getConseiller() <= 0) {
                throw new IllegalArgumentException("Conseiller ID must be a positive integer.");
            }

            ClientDAO clientDAO = new ClientDAO();
            clientDAO.addClient(client);
            System.out.println("Client Ajouter avec sucsess");
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteClient(int idClient) {
        if (idClient <= 0) {
            throw new IllegalArgumentException("Client ID must be a positive integer.");
        }
        try {
            ClientDAO clientDAO = new ClientDAO();
            clientDAO.deleteClient(idClient);
            System.out.println("Client supprimer avec sucsess");
        } catch( Exception e){
          throw new RuntimeException("Erreur lors de la suppression du client : " + e.getMessage());
        }
    }

    public Client ShowClientParNomDeFamille(String nomDeFamille){
        HashMap<Integer, Client> clients = new HashMap<>();

        try {
            ConseillerDAO conseillerDAO = new ConseillerDAO();
            ResultSet rs = conseillerDAO.getClients();
            while(rs.next()){
                int idClient = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int consId = rs.getInt("conseiller_id");
                String telephone = rs.getString("telephone");
                clients.put(idClient, new Client(nom, prenom, email, telephone, consId));
            }
            return clients.values().stream().filter(client -> client.getNom().equals(nomDeFamille)).findFirst().orElse(null);

        }
        catch (Exception e) {
            throw new RuntimeException("couldn't find client with name " + nomDeFamille + "");
        }
    }
}