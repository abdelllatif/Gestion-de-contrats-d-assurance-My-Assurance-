package Controllers;

import Models.Contrat;
import Services.ContractService;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractController {
    private final ContractService contratService;

    public ContractController(ContractService contratService) {
        this.contratService = contratService;
    }

    // Ajouter un contrat
    public void ajouterContrat(Contrat contrat) {
        try {
            boolean added = contratService.addContrat(contrat);
            if (added) {
                System.out.println("Contrat ajouté avec succès !");
            } else {
                System.out.println("Échec lors de l'ajout du contrat.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }

    public void supprimerContrat(int id) {
        try {
            boolean deleted = contratService.deleteContrat(id);
            if (deleted) {
                System.out.println("Contrat supprimé avec succès !");
            } else {
                System.out.println("Aucun contrat trouvé avec cet ID.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }

    // Afficher tous les contrats
    public void afficherContrats() {
        try {
            ResultSet rs = contratService.afficherAll();
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                ", Date Début: " + rs.getDate("dateDebut") +
                                ", Date Fin: " + rs.getDate("dateFin") +
                                ", Type: " + rs.getString("typeContrat") +
                                ", Client ID: " + rs.getInt("clientId")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }
}
