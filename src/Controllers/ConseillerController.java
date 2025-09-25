package Controllers;

import Models.Client;
import Models.Conseiller;
import Services.ConseillerService;

import java.util.HashMap;

public class ConseillerController {
    public ConseillerController() {
    }
    public void addConseiller(Conseiller conseiller) {
        ConseillerService conseillerService = new ConseillerService();
        conseillerService.addConseiller(conseiller);
    }

    public HashMap<Integer, Client> getClients(int id) {
        ConseillerService conseillerService = new ConseillerService();
        return conseillerService.getClients(id);
    }

    public void deleteConseiller(int id){
        ConseillerService conseillerService = new ConseillerService();
        conseillerService.deleteClient(id);
    }
}
