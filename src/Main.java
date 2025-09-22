import Views.ClientMenu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Gérer les Clients");
            System.out.println("2. Gérer les Contrats");
            System.out.println("3. Gérer les Conseillers");
            System.out.println("4. Gérer les Sinistres");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide !");
                scanner.next();
                System.out.print("Votre choix : ");
            }
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    ClientMenu clientMenu = new ClientMenu();
                    clientMenu.afficherMenu();
                    break;
                case 2:
                    System.out.println("=== Gestion des Contrats ===");
                    break;
                case 3:
                    System.out.println("=== Gestion des Conseillers ===");
                    break;
                case 4:
                    System.out.println("=== Gestion des Sinistres ===");
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, essayez encore.");
            }

        } while (choix != 0);

        scanner.close();
    }

}