package fr.dawan.bibliotheque;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import fr.dawan.bibliotheque.entities.Author;
import fr.dawan.bibliotheque.entities.Book;
import fr.dawan.bibliotheque.entities.Borrow;
import fr.dawan.bibliotheque.entities.Users;
import fr.dawan.bibliotheque.repositories.AuthorRepository;
import fr.dawan.bibliotheque.repositories.BorrowRepository;
import fr.dawan.bibliotheque.repositories.UserRepository;
import fr.dawan.bibliotheque.services.BookServiceImpl;


//@Component
//@Order(1)
public class RepositoryRunner implements CommandLineRunner {

	
	//@Autowired
	//private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BorrowRepository borrowRepository;
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n ______ Repository Runner_____ \n");
	/*
		 *	System.out.println(bookRepository);
		
		 		System.out.println(bookRepository.count());
			Book livreOpt = bookRepository.findById(1L).orElse(null);
			System.out.println(livreOpt);
		
	 
		List<Book> books = bookRepository.findAll();
		
		for(var b : books) {
			System.out.println(b.getName());
		}
	 */
		//bookRepository.findByName("Book 2").forEach(b -> System.out.println(b));
		System.out.println("\n ______ User Repository _____ \n");
		System.out.println(userRepository);
		
		List<Users> users = userRepository.findAll();
		for (var u : users) {
			System.out.println(u.getName());
		}

		
		
		System.out.println("\n ______ Borrow Repository _____ \n");
		List<Borrow> borrows = borrowRepository.findAll();
		
		for(var bo : borrows) {
			System.out.println(bo.getBorrowDate() + " , " + bo.getBorrowReturnDate());
		}
		
		
		System.out.println("\\n ______ Author Repository _____ \\n");
		List<Author> authors = authorRepository.findAll();
		
		for(var a : authors) {
			System.out.println(a.getName());
		}
		
		System.out.println("\n ________books runner start_____ \n");
		
		List<Book> books1 = bookServiceImpl.getByName("Book 1");
		for (var b : books1) {
			System.out.println(b.getName());
			
		}
		
		System.out.println("\n ________end book repository______ \n");
	}

}
