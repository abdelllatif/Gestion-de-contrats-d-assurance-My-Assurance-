package Views;

import Controllers.ClientController;
import Models.Client;
import Services.ClientService;

import java.util.Scanner;

public class ClientMenu {
    String Border="||===============================||";
    public ClientMenu() {}
    public void afficherMenu() {
        int choix;
        String Border="||===============================||";
        Scanner sc =new Scanner(System.in);
        do{
        System.out.println(Border);
        System.out.println("\n===== Menu Clients =====");
        System.out.println(Border);
        System.out.println("1. Ajouter un client");
        System.out.println("2. Supprimer un client par ID");
        System.out.println("3. Rechercher un client par nom de famille (tri alphabétique)");
        System.out.println("4. Rechercher un client par ID (Optional)");
        System.out.println("5. Afficher clients d’un conseiller (ID conseiller)");
        System.out.println("0. Retour");
        System.out.println(Border);
        System.out.print("Votre choix : ");
        choix=sc.nextInt();
        sc.nextLine();
        switch (choix){
            case 1:
              this.ajouterClient();
            break;
            case 2:
                System.out.println("Suppression d'un client");
                break;
            case 3:
                System.out.println("Recherche d'un client par nom de famille");
                break;
                case 4:
                System.out.println("Recherche d'un client par ID");
                break;
                case 5:
                System.out.println("Affichage des clients d'un conseiller");
                break;
                case 0:
                System.out.println("Retour au menu principal");
                break;
                default:
                System.out.println("Choix invalide, veuillez recommencer.");
        }
    }while(choix!=0);

    }


    public void ajouterClient(){
        Scanner sc =new Scanner(System.in);
        System.out.println(Border);
        System.out.println("|| entrez les informations du client ||");
        System.out.println(Border);
        System.out.println("enter le nom");
        String nom=sc.nextLine();
        System.out.println("enter le prenom");
        String prenom=sc.nextLine();
        System.out.println("enter l'email");
        String email=sc.nextLine();
        System.out.println("enter le telephone");
        String telephone=sc.nextLine();
        System.out.println("enter l'ID du conseiller");
        int conseiller=sc.nextInt();
        sc.nextLine();
        Client client = new Client(nom, prenom, email, telephone, conseiller);
        ClientController clientController = new ClientController();
        clientController.addClient(client);
    }
}
