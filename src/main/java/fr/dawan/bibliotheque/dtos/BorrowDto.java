package fr.dawan.bibliotheque.dtos;

import fr.dawan.bibliotheque.entities.Book;
import fr.dawan.bibliotheque.entities.Users;
import fr.dawan.bibliotheque.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Builder
public class BorrowDto {

    @NotNull
    private long id;

    @NotNull
    private LocalDate borrowDate;

    @NotNull
    private LocalDate borrowReturnDate;

    @NotNull
    private Status status;

//    @NotNull
//    private List<BookDto> books;

    @NotNull
    private Users user;
}
