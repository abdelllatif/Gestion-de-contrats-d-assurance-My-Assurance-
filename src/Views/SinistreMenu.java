package Views;

import Controllers.SinistreController;
import Models.Sinistre;
import Services.SinistreService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SinistreMenu {
    private final String Border = "||===============================||";
    private final SinistreController sinistreController;

    public SinistreMenu() {
        this.sinistreController = new SinistreController();
    }

    public void afficherMenu() {
        int choix;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(Border);
            System.out.println("\n===== Menu Sinistres =====");
            System.out.println(Border);
            System.out.println("1. Ajouter un sinistre");
            System.out.println("2. Supprimer un sinistre par ID");
            System.out.println("3. Rechercher un sinistre par ID");
            System.out.println("4. Calculer les coûts totaux des sinistres d’un client");
            System.out.println("5. Afficher les sinistres par ID d’un client");
            System.out.println("6. Afficher les sinistres avant une date donnée");
            System.out.println("7. Afficher les sinistres dont le coût est supérieur à un montant donné");
            System.out.println("0. Retour");
            System.out.println(Border);
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1 :
                    ajouterSinistre();
                    break;
                case 2 :
                    supprimerSinistre();
                break;
                case 3 :
                    rechercherSinistre();
                    break;
                case 4 :
                    teauxCout();
                    break;
                case 5 :
                    afficherSinistresParClient();
                    break;
                case 6 :
                    afficherSinistresAvantDate();
                    break;
                case 7 :
                    afficherSinistresCoutSuperieur();
                    break;
                case 0 :
                    System.out.println("Retour au menu principal...");
                    break;
                default : System.out.println("Choix invalide, veuillez recommencer.");
            }
        } while (choix != 0);
    }


       public void ajouterSinistre() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Border);
        System.out.println("|| Entrez les informations du sinistre ||");
        System.out.println(Border);

        System.out.print("Type de sinistre (VOITURE, MAISON, MALADIE): ");
        String typeStr = sc.nextLine().toUpperCase();

        Sinistre.TypeSinistre type;
        try {
            type = Sinistre.TypeSinistre.valueOf(typeStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Type de sinistre invalide !");
            return;
        }

        System.out.print("Date du sinistre (format: yyyy-MM-dd HH:mm:ss): ");
        String dateStr = sc.nextLine();

        System.out.print("Coût du sinistre: ");
        double cout = sc.nextDouble();
        sc.nextLine();

        System.out.print("Description: ");
        String description = sc.nextLine();

        System.out.print("ID du contrat associé: ");
        int contratId = sc.nextInt();
        sc.nextLine();

        Sinistre sinistre = new Sinistre();
        sinistre.setTypeSinistre(type);

        sinistre.setDateTime(Timestamp.valueOf(dateStr));
        sinistre.setCout(cout);
        sinistre.setDescription(description);
        sinistre.setContratId(contratId);

        sinistreController.addSinistre(sinistre);
    }

    private void supprimerSinistre() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Border);
        System.out.println("|| Entrez l'ID du sinistre à supprimer ||");
        System.out.println(Border);

        int id = sc.nextInt();
        sc.nextLine();

        sinistreController.supprimerSinistre(id);
    }

    private void teauxCout(){
        System.out.println(Border);
        System.out.println("|| Taux de cout du sinistre ||");
        System.out.println(Border);
        System.out.print("entrerez l'id du client");
        int id=new Scanner(System.in).nextInt();
        double total = sinistreController.calculerCoutsTotaux(id);
        System.out.println("Le coût total des sinistres du client " + id + " est: " + total);
    }


    public void rechercherSinistre() {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Sinistre sinistre = sinistreController.rechercherSinistre(id);

        System.out.println("|||||||||||||||||||||||||||");
        System.out.println("Synistre  "+sinistre.getTypeSinistre());
        System.out.println("Date: "+sinistre.getDateTime());
        System.out.println("Cout: "+sinistre.getCout());
        System.out.println("Description: "+sinistre.getDescription());
        System.out.println("Of Contrat: "+sinistre.getContratId());
    }


    private void afficherSinistresParClient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'ID du client : ");
        int clientId = sc.nextInt();
        sc.nextLine();

        List<Sinistre> sinistres = sinistreController.getSinistresByClient(clientId);
        System.out.println(Border);
        sinistres.forEach(s -> System.out.println(
                "ID: " + s.getId() +
                        ", Type: " + s.getTypeSinistre() +
                        ", Date: " + s.getDateTime() +
                        ", Cout: " + s.getCout() +
                        ", Description: " + s.getDescription() +
                        ", ContratID: " + s.getContratId()
        ));
    }

    private void afficherSinistresAvantDate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez la date limite (yyyy-MM-dd HH:mm:ss) : ");
        String dateStr = sc.nextLine();

        Timestamp date;
        try {
            date = Timestamp.valueOf(dateStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Format de date invalide !");
            return;
        }

        List<Sinistre> sinistres = sinistreController.getSinistresBeforeDate(date);
        System.out.println(Border);
        sinistres.forEach(s -> System.out.println(
                "ID: " + s.getId() +
                        ", Type: " + s.getTypeSinistre() +
                        ", Date: " + s.getDateTime() +
                        ", Cout: " + s.getCout() +
                        ", Description: " + s.getDescription() +
                        ", ContratID: " + s.getContratId()
        ));
    }

    private void afficherSinistresCoutSuperieur() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le montant minimum : ");
        double montant = sc.nextDouble();
        sc.nextLine();

        List<Sinistre> sinistres = sinistreController.getSinistresWithCoutGreaterThan(montant);
        System.out.println(Border);
        sinistres.forEach(s -> System.out.println(
                "ID: " + s.getId() +
                        ", Type: " + s.getTypeSinistre() +
                        ", Date: " + s.getDateTime() +
                        ", Cout: " + s.getCout() +
                        ", Description: " + s.getDescription() +
                        ", ContratID: " + s.getContratId()
        ));
    }

}
