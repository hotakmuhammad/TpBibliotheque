package fr.dawan.bibliotheque.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="users")
public class Users extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false, length = 255)
	private String adress;
	
	@Column(name = "phone_number", nullable = false)
	private long phoneNumber;
	
	@Column(columnDefinition = "TINYINT(1)", name = "is_an_adult", nullable = false)
	private boolean isAnAdult;
	/*
		@OneToMany(mappedBy = "user")
	@Exclude
	private Set<Borrow> borrows = new HashSet<>();
	 */

	
	
	
}
























