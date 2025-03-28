package fr.dawan.bibliotheque.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.dawan.bibliotheque.dtos.BookDto;
import fr.dawan.bibliotheque.entities.Book;
import fr.dawan.bibliotheque.entities.exceptions.IdNotFoundException;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import fr.dawan.bibliotheque.services.IBookService;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/api/biblio")
public class BookController {

	@Autowired
	private IBookService bookService;

	@Autowired
	private ObjectMapper objectMapper;

	// find a book by id
	@GetMapping(value = "/{id:[0-4]}", produces =MediaType.APPLICATION_JSON_VALUE)
	 public BookDto getById(
		@Parameter(description = "L``id de book", required = true)
		 @PathVariable long id) {
		 return bookService.getById(id);

	 }
	
	// FInd a book by name
	@GetMapping(value = "/{name:[A-Za-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getByName(@PathVariable String name) {
		return bookService.getByName(name);
	}
	
	
	 @GetMapping(value = "/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAll() {
		return bookService.getAll();
	}


	@PostMapping(value = "/add")
	public BookDto addBook(@RequestBody BookDto bookDto) {

		//System.out.println(bookDto);
		return bookService.addBook(bookDto);

	}
	@PutMapping (value = "/update")//, consumes = "application/json", produces = "application/json")
	public BookDto updateBook(@RequestBody BookDto updateBook) throws IOException {
		log.info("Updating summary for book with id " + updateBook.getId());
		//BookDto dto = bookService.getById(updateBook.getId());
		log.info("New summary = " + updateBook.getSummary());
		//dto.setSummary(updateBook.getSummary());
		return bookService.update(updateBook);

	}

	// Delete by id
	@DeleteMapping(value = "/{id}" )
	public String deleteById(@PathVariable long id) {
		bookService.deleteById(id);
		return "L'id " + id + " est supprimé";
	}
}





