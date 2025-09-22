package Services;

import DAOs.ClientDAO;
import Models.Client;

public class ClientService {



    public ClientService() {}



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
}
