package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CaregiverRepository extends JpaRepository<Caregiver, UUID> {
    Optional<Caregiver> findByName(String name);

    /**
     * Example: Write Custom Query
     */
    @Query(value = "SELECT p " +
            "FROM Caregiver p " +
            "WHERE p.name = :name ")
    Optional<Caregiver> findSeniorsByName(@Param("name") String name);
}
