package fr.dawan.bibliotheque.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Builder
public class BookDto {

	
	  @PositiveOrZero(message = "ID must be zero or positive")
	  private long id;



	  @NotNull
	  //@Size(max = 500, message = "Summary cannot exceed 500 characters")
	  private String summary;


	  @NotNull(message = "ISBN cannot be null")
	  //@Size(max = 80, message = "ISBN must be a valid number with a maximum length of 80")
	  private long isbn;


	  @NotNull(message = "Book name cannot be null")
	  @Size(max = 80, message = "Book name must have a maximum length of 80")
	  private String name;
	  @PastOrPresent
	  @JsonFormat(pattern = "yyyy-MM-dd")
	  private LocalDate publicationDate;

	  @JsonProperty("ageRestriction")
	  @NotNull
	  private boolean ageRestriction;

	  @JsonProperty("stock")
	  @NotNull
	  private boolean stock;


	  @NotNull
	  //@Size(max=60)
	  private AuthorDto author;

	  @NotNull
	  private BorrowDto borrow;


	
}
