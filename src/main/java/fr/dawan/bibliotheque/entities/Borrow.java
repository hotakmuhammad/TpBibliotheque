package fr.dawan.bibliotheque.entities;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fr.dawan.bibliotheque.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode.Exclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "borrows")
public class Borrow extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "borrow_date", nullable = false)
	private LocalDate borrowDate;
	
	@Column(name = "borrow_return_date", nullable = false)
	private LocalDate borrowReturnDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private Status status;
	
//	@ManyToMany(mappedBy = "borrows")
//	@Exclude
//	private Set<Book> books = new HashSet<>();
	
	@ManyToOne//(fetch = FetchType.EAGER)
	@Exclude
	private Users user;
	
	
}














