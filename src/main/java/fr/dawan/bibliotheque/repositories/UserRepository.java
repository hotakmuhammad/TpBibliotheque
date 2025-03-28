package fr.dawan.bibliotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.bibliotheque.entities.Users;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findByDateOfBirth(LocalDate localDate);

    List<Users> findByNameLike(String name);

    int removeById(long id);
}
