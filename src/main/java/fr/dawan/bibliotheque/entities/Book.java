package fr.dawan.bibliotheque.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "books")
public class Book extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private long isbn;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(name = "publication_date",nullable = false, length = 100)
	private LocalDate publicationDate;
	
	@Column(nullable = false)
	private String summary;
	
	@Column(columnDefinition = "TINYINT(1)", nullable = false)
	private boolean ageRestriction;
	
   
    @Column(columnDefinition = "TINYINT(1)", nullable = false)
	private boolean stock;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@Exclude


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;


	/*
	 @JoinTable(
            name = "book_borrow",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id")
        )
	 */
	@ManyToMany(fetch = FetchType.LAZY)//(mappedBy = "books")
	@JsonIgnore
	@Exclude
	private Set<Borrow> borrows = new HashSet<>();
	
}
