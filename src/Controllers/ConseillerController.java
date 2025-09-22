package Controllers;

import Models.Conseiller;
import Services.ConseillerService;

public class ConseillerController {
    public ConseillerController() {
    }
    public void addConseiller(Conseiller conseiller) {
        ConseillerService conseillerService = new ConseillerService();
        conseillerService.addConseiller(conseiller);
    }
}
