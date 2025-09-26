package Controllers;

import Models.Contrat;
import Services.ContractService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ContractController {
    private final ContractService contratService;

    public ContractController(ContractService contratService) {
        this.contratService = contratService;
    }

    public void ajouterContrat(Contrat contrat) {
        try {
            boolean success = contratService.addContrat(contrat);
            if (success) {
                System.out.println("Contrat ajouté avec succès !");
            } else {
                System.out.println("Échec de l'ajout du contrat.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }

    public void supprimerContrat(int id) {
        try {
            boolean success = contratService.deleteContrat(id);
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

    public List<Contrat> afficherContrats(Integer idClient) {
        try {
            List<Contrat> contrats = contratService.afficherAll(idClient);
            return contrats;
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
        return null;
    }

    public Optional<Contrat> getContratById(int id) {
        return contratService.getContratById(id);
    }
}
