package Services;

import DAOs.SinistreDAO;
import Models.Sinistre;

public class SinistreService {

    public SinistreService() {
    }

    public void addSinistre(Sinistre sinistre) {
     if(sinistre.getTypeSinistre() != null){
         throw new IllegalArgumentException("Type sinistre is required.");
     }
     if(sinistre.getDateTime() == null){
         throw new IllegalArgumentException("Date time is required.");
     }
     if(sinistre.getCout() <= 0){
         throw new IllegalArgumentException("Cout must be greater than 0.");
     }
     if(sinistre.getDescription() == null){
         throw new IllegalArgumentException("Description is required.");
     }
     if(sinistre.getContratId() <= 0){
         throw new IllegalArgumentException("Contrat ID must be a positive integer.");
     }

    }
}
