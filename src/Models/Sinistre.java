package Models;

import java.sql.Date;

public class Sinistre {

    public enum TypeSinistre {
        ACCIDENT_VOITURE,
        ACCIDENT_MAISON,
        MALADIE
    }

    private int id;
    private TypeSinistre typeSinistre;
    private Date dateTime;
    private double cout;
    private String description;
    private int contratId;


    public Sinistre(TypeSinistre typeSinistre, Date dateTime, double cout, String description, int contratId) {
        this.typeSinistre = typeSinistre;
        this.dateTime = dateTime;
        this.cout = cout;
        this.description = description;
        this.contratId = contratId;
    }

    public int getId() {
        return id;
    }


    public TypeSinistre getTypeSinistre() {
        return typeSinistre;
    }

    public void setTypeSinistre(TypeSinistre typeSinistre) {
        this.typeSinistre = typeSinistre;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getContratId() {
        return contratId;
    }

    public void setContratId(int contratId) {
        this.contratId = contratId;
    }
}
