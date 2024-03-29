package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.PrescripedDrug;

import java.util.UUID;

public interface PrescripedDrugRepository extends JpaRepository<PrescripedDrug, UUID>{
}
