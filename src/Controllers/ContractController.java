package Controllers;

import Models.Contrat;
import Services.ContractService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractController {
    private final ContractService contratService;

    public ContractController(ContractService contratService) {
        this.contratService = contratService;
    }

    public void ajouterContrat(Contrat contrat) {
        try {
            boolean success = contratService.addContrat(contrat);
            if (success) {
                System.out.println(" Contrat ajouté avec succès !");
            } else {
                System.out.println(" Échec de l'ajout du contrat.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(" Erreur de validation : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println(" Erreur SQL : " + e.getMessage());
        }
    }

    // Supprimer un contrat
    public void supprimerContrat(int id) {
        try {
            boolean success = contratService.deleteContrat(id);
            if (success) {
                System.out.println(" Contrat supprimé avec succès !");
            } else {
                System.out.println(" Aucun contrat trouvé avec l'ID : " + id);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(" Erreur de validation : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println(" Erreur SQL : " + e.getMessage());
        }
    }

    // Afficher tous les contrats
    public void afficherContrats() {
        try (ResultSet rs = contratService.afficherAll()) {
            System.out.println(" Liste des contrats :");
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("typeContrat");
                String debut = rs.getTimestamp("dateDebut").toString();
                String fin = rs.getTimestamp("dateFin").toString();
                int clientId = rs.getInt("clientId");

                System.out.println("ID: " + id +
                        " | Type: " + type +
                        " | Début: " + debut +
                        " | Fin: " + fin +
                        " | ClientID: " + clientId);
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Erreur SQL : " + e.getMessage());
        }
    }
}
