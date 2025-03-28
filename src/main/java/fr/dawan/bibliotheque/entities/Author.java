package fr.dawan.bibliotheque.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
@Table(name="author")
public class Author extends BaseEntity {

	
	private static final long serialVersionUID = 1L;
	
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(name = "first_name",nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(nullable = false, length = 50)
	private String nationality;
	
	
	@Column(columnDefinition = "MEDIUMTEXT", nullable = false)
	private String description;
	
	@Column(name = "number_of_books", nullable = false)
	private int bookNumbers;

/*
	@OneToMany(mappedBy = "author")//,  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Book> books;
 */


}
