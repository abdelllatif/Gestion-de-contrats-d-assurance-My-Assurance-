package Views;

import Controllers.ContractController;
import Models.Contrat;
import Services.ContractService;

import java.sql.Timestamp;
import java.util.Scanner;

public class ContractMenu {
    private final String Border = "||===============================||";
    private final ContractController contractController;

    public ContractMenu() {
        this.contractController = new ContractController(new ContractService());
    }

    public void afficherMenu() {
        int choix;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(Border);
            System.out.println("\n===== Menu Contrats =====");
            System.out.println(Border);
            System.out.println("1. Ajouter un contrat");
            System.out.println("2. Afficher un contrat par ID");
            System.out.println("3. Supprimer un contrat par ID");
            System.out.println("4. Afficher tous les contrats d’un client (ID client)");
            System.out.println("0. Retour");
            System.out.println(Border);
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1 :
                    ajouterContrat();
                    break;
                    case 2 :
                    break;
                    case 3 :
                    supprimerContrat();
                    break;
                    case 4 :
                    afficherContratsParClient();
                    break;
                    case 0 :
                    System.out.println("Au revoir !");
                    break;
                    default :
                    System.out.println("Choix invalide, veuillez recommencer.");
            }
        } while (choix != 0);
    }

    private void ajouterContrat() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Border);
        System.out.println("|| Entrez les informations du contrat ||");
        System.out.println(Border);

        System.out.print("Type de contrat : ");
        String type = sc.nextLine();

        System.out.print("Date début (format: yyyy-MM-dd HH:mm:ss) : ");
        String debutStr = sc.nextLine();
        System.out.print("Date fin (format: yyyy-MM-dd HH:mm:ss) : ");
        String finStr = sc.nextLine();

        System.out.print("ID du client : ");
        int clientId = sc.nextInt();
        sc.nextLine();

        Contrat contrat = new Contrat();
        contrat.setTypeContrat(type);
        contrat.setDateDebut(Timestamp.valueOf(debutStr));
        contrat.setDateFin(Timestamp.valueOf(finStr));
        contrat.setClientId(clientId);

        contractController.ajouterContrat(contrat);
    }


    private void supprimerContrat() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Border);
        System.out.println("|| Entrez l'ID du contrat à supprimer ||");
        System.out.println(Border);

        int id = sc.nextInt();
        sc.nextLine();

        contractController.supprimerContrat(id);
    }

    private void afficherContratsParClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Border);
        System.out.println("|| Entrez l'ID du client ||");
        System.out.println(Border);

        int clientId = sc.nextInt();
        sc.nextLine();

       // contractController.afficherContratsParClient(clientId);
    }
}
