package Services;

import DAOs.ContractDAO;
import Models.Contrat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        if (contrat.getTypeContrat() == null) {
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

    public List<Contrat> afficherAll(Integer clientId) throws SQLException {
        ResultSet rs = contratDAO.afficherAll(clientId);
        List<Contrat> contrats = new ArrayList<>();
        while (rs.next()) {
            Contrat contrat = new Contrat(
                    rs.getInt("id"),
                    rs.getTimestamp("dateDebut"),
                    rs.getTimestamp("dateFin"),
                    Contrat.TypeContrat.valueOf(rs.getString("typeContrat")),
                    rs.getInt("client_id")
            );
            contrats.add(contrat);
        }
        return contrats;
    }

    public Optional<Contrat> getContratById(int id) {
        Contrat contrat = contratDAO.findById(id);
        return Optional.ofNullable(contrat); // Optional géré ici
    }


}
