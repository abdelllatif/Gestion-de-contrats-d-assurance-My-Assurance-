package Models;

import java.sql.Date;

public class Contrat {
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private String typeContrat;
    private int clientId;

    public Contrat(int id, Date dateDebut, Date dateFin, String typeContrat) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.typeContrat = typeContrat;
    }
    public Contrat() {
    }

    public int getId() {
        return id;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }
    public Integer getClientId() {
        return clientId;
    }
    public void setClientId(Integer client) {
        this.clientId = client;
    }

}
