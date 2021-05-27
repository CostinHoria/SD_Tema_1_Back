package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.MedicationPlan;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.entities.PrescripedDrug;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, UUID> {

    //Optional<MedicationPlan> findByPatientName(String patient_name);

    /*@Query(value = "SELECT p " +
            "FROM MedicationPlan p " +
            "WHERE p.patient_name = :patient_name ")
    List<MedicationPlan> findMedicationPlansByName(@Param("patient_name") String patient_name);*/
}
