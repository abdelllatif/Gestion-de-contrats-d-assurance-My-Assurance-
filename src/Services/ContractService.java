package Services;

import DAOs.ContractDAO;
import Models.Contrat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ContractService {
    private final ContractDAO contratDAO;

    public ContractService() {
        this.contratDAO = new ContractDAO();
    }

    public boolean addContrat(Contrat contrat) throws SQLException {
        Timestamp debut = contrat.getDateDebut();
        Timestamp fin = contrat.getDateFin();

        if (debut == null || fin == null) {
            throw new IllegalArgumentException("Les dates ne peuvent pas être nulles");
        }

        if (debut.after(fin)) {
            throw new IllegalArgumentException("La date de début doit être avant la date de fin");
        }

        String type = contrat.getTypeContrat();
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Le type de contrat est obligatoire");
        }

        if (contrat.getClientId() == null || contrat.getClientId() <= 0) {
            throw new IllegalArgumentException("L'ID du client doit être valide");
        }

        return contratDAO.addContrat(contrat);
    }

    public boolean deleteContrat(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("L'ID doit être positif");
        }
        return contratDAO.deleteById(id);
    }

    public ResultSet afficherAll() throws SQLException {
        return contratDAO.afficherAll();
    }
}
