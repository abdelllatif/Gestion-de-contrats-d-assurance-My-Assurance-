package Controllers;

import Models.Sinistre;
import Services.SinistreService;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class SinistreController {
    private  final SinistreService sinistreService;
    public SinistreController() {
        this.sinistreService=new SinistreService();
    }
    public boolean addSinistre(Sinistre sinistre){
        return sinistreService.addSinistre(sinistre);
    }

    public void supprimerSinistre(int id) {
        try {
            boolean success = sinistreService.deleteById(id);
            if (success) {
                System.out.println("Contrat supprimé avec succès !");
            } else {
                System.out.println("Aucun contrat trouvé avec l'ID : " + id);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }


    public double calculerCoutsTotaux(int clientId) {
        return sinistreService.calculerCoutsTotaux(clientId);
    }

    public Sinistre rechercherSinistre(int id) {
        Optional<Sinistre> sinistreOpt = sinistreService.findSinistreById(id);

        if (sinistreOpt.isPresent()) {
            return sinistreOpt.get();
        } else {
            System.out.println("Aucun sinistre trouvé avec cet ID.");
            return null;
        }
    }

    public List<Sinistre> getContratSinistres(int idContrat){
        return sinistreService.getAllSinistres(idContrat);
    }

    public List<Sinistre> getContratSinistrescout(int idContrat) {
        return sinistreService.getAllSinistres(idContrat);
    }


    public List<Sinistre> getSinistresByClient(int clientId) {
        return sinistreService.getSinistresByClient(clientId);
    }

    public List<Sinistre> getSinistresBeforeDate(Timestamp date) {
        return sinistreService.getSinistresBeforeDate(date);
    }

    public List<Sinistre> getSinistresWithCoutGreaterThan(double montant) {
        return sinistreService.getSinistresWithCoutGreaterThan(montant);
    }

}
