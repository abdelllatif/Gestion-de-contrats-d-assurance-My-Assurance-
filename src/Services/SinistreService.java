package Services;

import DAOs.ContractDAO;
import DAOs.SinistreDAO;
import Models.Contrat;
import Models.Sinistre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SinistreService {
private final SinistreDAO sinistreDAO;
private final ContractDAO contractDAO;
    public SinistreService() {
       this.sinistreDAO=new SinistreDAO();
       this.contractDAO=new ContractDAO();
    }

    public boolean addSinistre(Sinistre sinistre) {
        if (sinistre.getTypeSinistre() == null) {
            throw new IllegalArgumentException("Type sinistre is required.");
        }
        if (sinistre.getDateTime() == null) {
            throw new IllegalArgumentException("Date time is required.");
        }
        if (sinistre.getCout() <= 0) {
            throw new IllegalArgumentException("Cout must be greater than 0.");
        }
        if (sinistre.getDescription() == null) {
            throw new IllegalArgumentException("Description is required.");
        }
        if (sinistre.getContratId() <= 0) {
            throw new IllegalArgumentException("Contrat ID must be a positive integer.");
        }
        try {
            return sinistreDAO.addSinistre(sinistre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteById(int id) throws SQLException {
        return sinistreDAO.deleteById(id);
    }


    public double calculerCoutsTotaux(int clientId) {
        List<Sinistre> allSinistres = sinistreDAO.getAllSinistres();
        List<Integer> clientContractIds = new ArrayList<>();

        try (ResultSet rs = contractDAO.afficherAll(clientId)) {
            while (rs.next()) {
                clientContractIds.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        return allSinistres.stream()
                .filter(s -> clientContractIds.contains(s.getContratId()))
                .mapToDouble(Sinistre::getCout)
                .sum();
    }



    public Optional<Sinistre> findSinistreById(int id) {
        try {
            Sinistre sinistre = sinistreDAO.findById(id);
            return Optional.ofNullable(sinistre);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public List<Sinistre> getAllSinistres(int contratId) {
        List<Sinistre> sinistres = sinistreDAO.getAllSinistres();
        return sinistres.stream()
                .filter(s -> s.getContratId() == contratId)
                .collect(Collectors.toList());
    }

    public List<Sinistre> getAllSinistrescout(int contratId) {
        List<Sinistre> sinistres = sinistreDAO.getAllSinistres();
        return sinistres.stream()
                .filter(s -> s.getContratId() == contratId)
                .sorted((s1, s2) -> Double.compare(s2.getCout(), s1.getCout()))
                .collect(Collectors.toList());
    }





    public List<Sinistre> getSinistresByClient(int clientId) {
        List<Sinistre> allSinistres = sinistreDAO.getAllSinistres();
        List<Integer> clientContractIds = new ArrayList<>();
        try (ResultSet rs = contractDAO.afficherAll(clientId)) {
            while (rs.next()) {
                clientContractIds.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allSinistres.stream()
                .filter(s -> clientContractIds.contains(s.getContratId()))
                .collect(Collectors.toList());
    }

    public List<Sinistre> getSinistresBeforeDate(Timestamp date) {
        List<Sinistre> allSinistres = sinistreDAO.getAllSinistres();

        return allSinistres.stream()
                .filter(s -> s.getDateTime().before(date))
                .collect(Collectors.toList());
    }

    public List<Sinistre> getSinistresWithCoutGreaterThan(double montant) {
        List<Sinistre> allSinistres = sinistreDAO.getAllSinistres();

        return allSinistres.stream()
                .filter(s -> s.getCout() > montant)
                .collect(Collectors.toList());
    }




}
