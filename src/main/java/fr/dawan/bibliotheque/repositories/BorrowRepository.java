package fr.dawan.bibliotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.bibliotheque.entities.Borrow;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    List<Borrow> getByBorrowDate(LocalDate borrowDate);

    List<Borrow> findByBorrowReturnDate(LocalDate borrowReturnDate);

    int removeById(long id);

}
