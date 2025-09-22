package Models;

public class Contrat {
    private int id;
    private String dateDebut;
    private String dateFin;
    private enum TypeContrat{
        AUTOMOBILE,
        MALADI,
        IMOBILITIE,
    }
    private TypeContrat typeContrat;

    public Contrat(int id, String dateDebut, String dateFin, TypeContrat typeContrat) {
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

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }
}
