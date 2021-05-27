package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.Medication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicationRepository extends JpaRepository<Medication, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
    Optional<Medication> findByName(String name);

    /**
     * Example: Write Custom Query
     */
    @Query(value = "SELECT p " +
            "FROM Medication p " +
            "WHERE p.name = :name ")
    Optional<Medication> findSeniorsByName(@Param("name") String name);
}
