package fr.dawan.bibliotheque.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.bibliotheque.entities.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByNameLike(String name);

    int removeById(long id);


    Page<Author> findByBookNumbers(int bookNumbers, Pageable page);


    boolean existsByName(String name);
}
