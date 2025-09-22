package Models;

import java.util.HashMap;

public class Client extends Person {
    private HashMap<Integer, Contrat> contrats;  // بدلنا String ب Contrat
    private String conseiller;

    public Client(String nom, String prenom, String email, String adresse, String telephone, String role,
                  HashMap<Integer, Contrat> contrats, String conseiller) {
        super(nom, prenom, email, adresse, telephone, role);
        this.contrats = contrats;
        this.conseiller = conseiller;
    }

    public Client() {
    }

    public HashMap<Integer, Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(HashMap<Integer, Contrat> contrats) {
        this.contrats = contrats;
    }

    public String getConseiller() {
        return conseiller;
    }

    public void setConseiller(String conseiller) {
        this.conseiller = conseiller;
    }
}
