package fr.dawan.bibliotheque.services;

import java.util.List;

import fr.dawan.bibliotheque.dtos.BookDto;
import fr.dawan.bibliotheque.entities.Book;
import jakarta.validation.Valid;

public interface IBookService {


	
    BookDto getById(long id);
    
    List<Book> getByName(String name);

    List<Book> getAll();

    BookDto addBook(BookDto bookDto);


    void deleteById(long id);


    BookDto update( BookDto dto);
}
