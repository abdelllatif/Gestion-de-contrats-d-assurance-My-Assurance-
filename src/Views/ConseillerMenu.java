package Views;

import Controllers.ConseillerController;
import Models.Client;
import Models.Conseiller;
import Services.ConseillerService;

import java.util.HashMap;
import java.util.Scanner;

public class ConseillerMenu {


    String Border = "||===============================||";

    public  void afficherMenu() {
        int choix;
        String Border = "||===============================||";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(Border);
            System.out.println("\n===== Menu Conseillers =====");
            System.out.println(Border);
            System.out.println("1. Ajouter un conseiller");
            System.out.println("2. Supprimer un conseiller par ID");
            System.out.println("3. Rechercher un conseiller par ID");
            System.out.println("4. Afficher les clients d'un conseiller par ID");
            System.out.println("0. Retour");
            System.out.println(Border);
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    this.ajouterConseiller(sc);
                    break;
                    case 2:
                        this.deleteConseiller();
                        break;
                        case 3:
                            this.rechercheConseiller();
                            break;
                    case 4:
                        this.getClients(sc);
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez recommencer.");
            }
        } while (choix != 0);
    }

    public void ajouterConseiller(Scanner sc){
        System.out.println(Border);
        System.out.println("|| entrez les informations du conseiller ||");
        System.out.println(Border);
        System.out.println("enter le nom");
        String nom=sc.nextLine();
        System.out.println("enter le prenom");
        String prenom=sc.nextLine();
        System.out.println("enter l'email");
        String email=sc.nextLine();
        System.out.println("enter le telephone");
        String telephone=sc.nextLine();
        Conseiller conseiller = new Conseiller(nom, prenom, email, telephone);
        ConseillerController conseillerController = new ConseillerController();
        conseillerController.addConseiller(conseiller);

    }

    public void getClients(Scanner sc) {
        System.out.println(Border);
        System.out.print("Entrez l'ID du conseiller : ");
        int id = sc.nextInt();
        sc.nextLine();

        HashMap<Integer, Client> clients = new ConseillerController().getClients(id);

        for (Integer key : clients.keySet()) {
            Client c = clients.get(key);
            System.out.println("|| Client ID : " + key);
            System.out.println("|| Nom       : " + c.getNom());
            System.out.println("|| Prenom    : " + c.getPrenom());
            System.out.println("|| Email     : " + c.getEmail());
            System.out.println("|| Telephone : " + c.getTelephone());
        }


        System.out.println(Border);
    }

    public void deleteConseiller(){
        Scanner sc =new Scanner(System.in);
        System.out.println(Border);
        System.out.println("|| entrez l'ID du conseiller ||");
        System.out.println(Border);
        int idClient=sc.nextInt();
        sc.nextLine();
        ConseillerController conseillerController = new ConseillerController();
        conseillerController.deleteConseiller(idClient);
    }

    public Conseiller rechercheConseiller() {

        Scanner sc =new Scanner(System.in);
        System.out.println(Border);
        System.out.println("|| entrez l'ID du conseiller ||");
        System.out.println(Border);
        int id=sc.nextInt();
        sc.nextLine();
        ConseillerService conseillerService = new ConseillerService();
        return conseillerService.rechercheConseiller(id);
    }
}
