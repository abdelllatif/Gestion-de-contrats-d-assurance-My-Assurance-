package Models;

import java.util.HashMap;

public class Conseiller extends Person{
    private HashMap<Integer,Client> clients;
    public Conseiller(String nom, String prenom, String email, String adresse, String telephone, String role, HashMap<Integer, Client> clients) {
        super(nom, prenom, email, adresse, telephone, role);
        this.clients = clients;
    }
    public Conseiller() {
    }
    public HashMap<Integer,Client> getClients() {
        return clients;
    }
    public void setClients(HashMap<Integer, Client> client) {
        this.clients = client;
    }
}
