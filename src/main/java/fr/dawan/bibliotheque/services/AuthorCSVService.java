package fr.dawan.bibliotheque.services;

import fr.dawan.bibliotheque.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorCSVService {

    @Autowired
    private AuthorRepository authorRepository;
}
