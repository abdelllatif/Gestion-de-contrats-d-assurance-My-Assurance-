package Services;

import DAOs.ConseillerDAO;
import Models.Client;
import Models.Conseiller;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConseillerService {
    private HashMap<Integer, String> clients = new HashMap<>();
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

    public HashMap<Integer, Client> getClients(int conseillerId) {
        if (conseillerId <= 0) {
            throw new IllegalArgumentException("Conseiller ID must be a positive integer.");
        }

        HashMap<Integer, Client> clients = new HashMap<>();

        try {
            ConseillerDAO conseillerDAO = new ConseillerDAO();
            ResultSet rs = conseillerDAO.getClients();

            while (rs.next()) {
                int idClient = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int consId = rs.getInt("conseiller_id");
                String telephone = rs.getString("telephone");

                clients.put(idClient, new Client(nom, prenom, email, telephone, consId));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des clients : " + e.getMessage());
        }

        return clients.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getConseiller() == conseillerId)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,       // <--- return the full Client
                        (v1, v2) -> v1,
                        HashMap::new
                ));
    }

    public void deleteClient(int idClient){
        if (idClient <= 0) {
            throw new IllegalArgumentException("Client ID must be a positive integer.");
        }
        try {
            ConseillerDAO conseillerDAO = new ConseillerDAO();
            if(conseillerDAO.deleteConseiller(idClient)){
                System.out.println("Client supprimer avec sucsess");
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression du client : " + e.getMessage());
        }

    }

    public Conseiller rechercheConseiller(int id) {
        HashMap<Integer, Conseiller> conseillers = new HashMap<>();
        ConseillerDAO conseillerDAO = new ConseillerDAO();

        ResultSet rs = conseillerDAO.afficherAll();
        try {
            while (rs.next()) {
                int idConseiller = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                conseillers.put(idConseiller, new Conseiller(nom, prenom, email, telephone));

            }

        }
        catch (Exception e){
         throw new RuntimeException("not working because of " + e.getMessage() + "");
    }
        return conseillers.values().stream().filter(c->c.getId()==id).findFirst().orElse(null);

    }

}
