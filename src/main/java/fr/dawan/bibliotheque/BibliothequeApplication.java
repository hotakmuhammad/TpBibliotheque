package fr.dawan.bibliotheque;

import java.time.LocalDate;
import java.util.List;

import fr.dawan.bibliotheque.repositories.BookRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.dawan.bibliotheque.entities.Author;
import fr.dawan.bibliotheque.entities.Book;
import fr.dawan.bibliotheque.entities.Borrow;
import fr.dawan.bibliotheque.entities.Users;
import fr.dawan.bibliotheque.repositories.AuthorRepository;
import fr.dawan.bibliotheque.repositories.BorrowRepository;
import fr.dawan.bibliotheque.repositories.UserRepository;
import fr.dawan.bibliotheque.services.BookServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication(scanBasePackages = "fr.dawan.bibliotheque")
public class BibliothequeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);


	}
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BorrowRepository borrowRepository;

	@Autowired
	private BookServiceImpl bookServiceImpl;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started with CommandLineRunner!");


		System.out.println("\n ______ User Repository _____ \n");
		System.out.println(userRepository);


		List<Users> users = userRepository.findAll();
		for (var u : users) {
			System.out.println(u.getName());
		}
		System.out.println("\n find user by date of birth \n");
		List<Users> usersByDO = userRepository.findByDateOfBirth(LocalDate.of(2002, 02, 07));
		for(var uba : usersByDO) {
			System.out.println(uba.getName() + " " + uba.getAdress());
		}

		System.out.println("\n ______ Book Repository _____ \n");
		List<Book> books = bookRepository.findAll();

		/*


		for(var b : books) {
			System.out.println(b);
		}
 		*/
		System.out.println("--------book name by id");
		Book book = bookRepository.findById(9L).get();
		System.out.println( book.getName());

		System.out.println("FInd books by Author's name");

		List<Book> booksByAuthor = bookRepository.findByAuthorName("Author 2");
		for (var bba : booksByAuthor) {
			System.out.println(bba.getName());
		}



		System.out.println("\n ______ Borrow Repository _____ \n");
		List<Borrow> borrows = borrowRepository.findAll();

		for(var bo : borrows) {
			System.out.println(bo.getBorrowDate() + " , " + bo.getBorrowReturnDate());
		}


		System.out.println("\n ______ Author Repository _____ \n");
		List<Author> authors = authorRepository.findAll();

		for(var a : authors) {
			System.out.println(a.getName());
		}

		System.out.println("----find author using book name---------");
		Book bookN = bookRepository.findAllByName("ByAuthor");

		System.out.println("Author : " + book.getAuthor().getName());



		System.out.println("\n ________books runner start_____ \n");

		List<Book> books1 = bookServiceImpl.getByName("TEST BOOK");
		for (var b : books1) {
			System.out.println(b.getIsbn());

		}


		System.out.println("-----Pagination - Book");

		Page<Book> b1 = bookRepository.findByPublicationDate(LocalDate.of(2024,02,6), PageRequest.of(0,5));

		System.out.println("Total Element " + b1.getTotalElements());
		System.out.println("Size " + b1.getSize());
		System.out.println("Total number of element " + b1.getNumberOfElements());

		b1.getContent().forEach(b -> System.out.println("Name " + b.getName()));

		System.out.println("-----Pagination - Author");
		Page<Author> a = authorRepository.findByBookNumbers( 15, PageRequest.of(0, 8));
		System.out.println("Total Elements " + a.getTotalElements());
		System.out.println("Total size " + a.getSize());
		System.out.println("Content " + a.getContent());
		a.getContent().forEach(aut -> System.out.println("Author name " + aut.getName()));


		System.out.println("\n----------------- Borrow Repository -------------\n");
		//System.out.println(bookRepository);

		List<Borrow> borrows1 = borrowRepository.findAll();

		borrows1.forEach(borrow -> System.out.println(borrow.getStatus()));

		borrows1.forEach(borrow -> System.out.println(borrow.getBorrowDate()));

//		 borrows1.forEach(borrow -> System.out.println(borrow.getBooks()));

		//System.out.println("TODO : Next going to update borrow entity");

	}




}