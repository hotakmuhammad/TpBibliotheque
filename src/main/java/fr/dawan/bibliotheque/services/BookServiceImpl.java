package fr.dawan.bibliotheque.services;


import java.util.List;
import java.util.Optional;

import fr.dawan.bibliotheque.entities.exceptions.IdNotFoundException;
import fr.dawan.bibliotheque.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import fr.dawan.bibliotheque.dtos.BookDto;
import fr.dawan.bibliotheque.entities.Book;
import fr.dawan.bibliotheque.repositories.BookRepository;
import jakarta.validation.Valid;

@Service
@Transactional
@Validated
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookMapper bookMapper;

	@Override
	public BookDto getById(long id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		if(bookOptional.isEmpty()) {
			System.out.println(("id not found"));
			return null;
		}

		Book book = bookOptional.get();
		return bookMapper.toDto(book);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> getByName(String name){
		List<Book> books = bookRepository.findByNameLike(name + "%");
		return books;
		
	}

	@Override
	public void deleteById(long id) {
		if(bookRepository.removeById (id) == 0) {
			throw new IdNotFoundException();
		}
	}


	@Override
	public BookDto update(BookDto bDto) {
		Book book = bookRepository.findById(bDto.getId()).orElseThrow(() -> new IdNotFoundException("Book with ID " + bDto.getId() + " not found"));
		bookMapper.update(bDto, book);

		return bookMapper.toDto(bookRepository.save(book));
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = bookRepository.findAll();
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public BookDto addBook(BookDto bookDto) {
		//Convertir le DTO passé en parametre en entité
		// Parce que le repository travailles que avec les models
		Book book = bookMapper.toEntity(bookDto);

		//Utiliser book pour save en bdd
		Book  savedBook = bookRepository.saveAndFlush(book);

		//convertir en DTO
		BookDto resultDto = bookMapper.toDto(savedBook);
		return resultDto;

	}


}
