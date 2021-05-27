package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.entities.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
    Optional<Patient> findByName(String name);
    public List<Patient> findByCaregiverName(String caregiverName);
    /**
     * Example: Write Custom Query
     */
    @Query(value = "SELECT p " +
            "FROM Person p " +
            "WHERE p.name = :name " +
            "AND p.age >= 60  ")
    Optional<Patient> findSeniorsByName(@Param("name") String name);

}
