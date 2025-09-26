package Models;

import java.util.HashMap;

 public class Client extends Person {
    private Integer conseiller;

    public Client(String nom, String prenom, String email, String telephone, Integer conseiller) {
        super(nom, prenom, email, telephone);
        this.conseiller = conseiller;
    }

    public Client() {
    }

    public Integer getConseiller() {
        return conseiller;
    }

    public void setConseiller(Integer conseiller) {
        this.conseiller = conseiller;
    }
}
