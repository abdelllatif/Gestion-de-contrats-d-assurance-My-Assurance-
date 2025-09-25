package Models;
public class Sinistre {
    private int id;
    private String typeSinistre;
    private java.time.LocalDateTime dateTime;
    private double cout;
    private String description;
    private int contratId;

    public Sinistre() {
    }

    public Sinistre(String typeSinistre, java.time.LocalDateTime dateTime, double cout, String description, int contratId) {
        this.typeSinistre = typeSinistre;
        this.dateTime = dateTime;
        this.cout = cout;
        this.description = description;
        this.contratId = contratId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeSinistre() {
        return typeSinistre;
    }

    public void setTypeSinistre(String typeSinistre) {
        this.typeSinistre = typeSinistre;
    }

    public java.time.LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(java.time.LocalDateTime dateTime) {
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
