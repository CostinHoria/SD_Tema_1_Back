package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.Users;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {

    @Query(value = "SELECT p " +
            "FROM Users p " +
            "WHERE p.username = :username " +
            "AND p.password = :password ")
    Optional<Users> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
