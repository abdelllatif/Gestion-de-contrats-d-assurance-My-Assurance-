package Services;

import DAOs.ConseillerDAO;
import Models.Conseiller;

public class ConseillerService {
    public ConseillerService() {}
    public void addConseiller(Conseiller conseiller) {
        try {
            if (conseiller.getNom() == null || conseiller.getNom().trim().isEmpty()) {
                throw new IllegalArgumentException("Nom is required and cannot be empty.");
            }
            if (conseiller.getPrenom() == null || conseiller.getPrenom().trim().isEmpty()) {
                throw new IllegalArgumentException("Prenom is required and cannot be empty.");
            }
            if (conseiller.getEmail() == null || !conseiller.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                throw new IllegalArgumentException("Invalid email format.");
            }
            if (conseiller.getTelephone() == null || !conseiller.getTelephone().matches("\\d+")) {
                throw new IllegalArgumentException("Telephone must be a number.");
            }
            ConseillerDAO conseillerDAO = new ConseillerDAO();
            conseillerDAO.addConseiller(conseiller);
            System.out.println("Conseiller Ajouter avec sucsess");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
