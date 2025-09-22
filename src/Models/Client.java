package Models;

import java.util.HashMap;

public class Client extends Person{
    private HashMap<Integer, String> contrats;
    private String conseiller;
    public Client(String nom, String prenom, String email, String adresse, String telephone, String role, HashMap<Integer, String> contrats, String conseiller) {
        super(nom, prenom, email, adresse, telephone, role);
        this.contrats = contrats;
        this.conseiller = conseiller;
    }
    public Client() {
    }
    public HashMap<Integer, String> getContrats() {
        return contrats;
    }

    public void setContrats(HashMap<Integer, String> contrats) {
        this.contrats = contrats;
    }

    public String getConseiller() {
        return conseiller;
    }

    public void setConseiller(String conseiller) {
        this.conseiller = conseiller;
    }
}
