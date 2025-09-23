package Controllers;

import Models.Client;
import Services.ClientService;

public class ClientController {

    public ClientController() {
    }

    public void addClient(Client client) {
        ClientService clientService = new ClientService();
        clientService.addClient(client);
    }
    public void deleteClient(int idClient){
        ClientService clientService = new ClientService();
        clientService.deleteClient(idClient);
    }
}