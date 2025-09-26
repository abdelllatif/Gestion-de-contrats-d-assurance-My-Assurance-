package Models;

import java.sql.Timestamp;

public class Contrat {

    public enum TypeContrat {
        MALADIE,
        VOITURE,
        MAISON
    }

    private int id;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private TypeContrat typeContrat;
    private Integer clientId;

    public Contrat() {}

    public Contrat(int id, Timestamp dateDebut, Timestamp dateFin, TypeContrat typeContrat, Integer clientId) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.typeContrat = typeContrat;
        this.clientId = clientId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Timestamp getDateDebut() { return dateDebut; }
    public void setDateDebut(Timestamp dateDebut) { this.dateDebut = dateDebut; }

    public Timestamp getDateFin() { return dateFin; }
    public void setDateFin(Timestamp dateFin) { this.dateFin = dateFin; }

    public TypeContrat getTypeContrat() { return typeContrat; } // return enum
    public void setTypeContrat(TypeContrat typeContrat) { this.typeContrat = typeContrat; }

    public Integer getClientId() { return clientId; }
    public void setClientId(Integer clientId) { this.clientId = clientId; }
}
